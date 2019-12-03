package com.realeigenvalue.jchess.mvc;

import java.util.ArrayList;
import java.util.Stack;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import com.realeigenvalue.jchess.chesslib.ChessGame;
import com.realeigenvalue.jchess.chesslib.Location;
import com.realeigenvalue.jchess.chesslib.Piece;
import com.realeigenvalue.jchess.chesslib.piecetype.Pawn;
import com.realeigenvalue.jchess.mvc.ChessModel.PlayerInfo;

public class ChessApp {
	private ChessModel model;
	private ChessView view;
	private ChessController controller;
	private PlayerInfo player1, player2, currentPlayer, opposingPlayer;
	private Piece selectedPiece;
	private Location moveLocation;
	private Stack<Move> moveStack;
	private class Move {
		public Piece movedPiece;
		public Location oldLocation;
		public Location currentLocation;
		public Piece oldPiece;
		public PlayerInfo currentPlayer;
		public PlayerInfo opposingPlayer;
	}
	public ChessApp() {
		setupGame();
		controller.registerChessApp(this);
		view.setVisible(true);
		gameLoop();
	}
	private void setupGame() {
		JTextField player1Text = new JTextField();
		JTextField player2Text = new JTextField();
		JToggleButton specialPiece = new JToggleButton();
		Object[] message = {
				"Enter Player 1 Name (White):", player1Text,
				"Enter Player 2 Name (Black):", player2Text,
				"Special Pieces:", specialPiece
		};
		Object[] options = {"OK"};	
		int option = JOptionPane.showOptionDialog(null, message, "Chess jchess", 
				                                  JOptionPane.PLAIN_MESSAGE, 
				                                  JOptionPane.QUESTION_MESSAGE, 
				                                  null, options, options[0]);
		if(option == JOptionPane.CLOSED_OPTION) {
			System.exit(0);
		}
		model = new ChessModel(specialPiece.isSelected());
		String p1Name = player1Text.getText();
		String p2Name = player2Text.getText();
		if(p1Name.length() > 8) {
			p1Name = p1Name.substring(0, 8);
		}
		if(p2Name.length() > 8) {
			p2Name = p2Name.substring(0, 8);
		}
		model.getPlayerInfo1().getPlayer().setName(p1Name);
		model.getPlayerInfo2().getPlayer().setName(p2Name);
		view = new ChessView();
		controller = new ChessController(model, view);
		player1 = model.getPlayerInfo1();
		player2 = model.getPlayerInfo2();
		currentPlayer = player1;
		opposingPlayer = player2;
		selectedPiece = null;
		moveLocation = null;
		moveStack = new Stack<Move>();
	}
	private void gameLoop() {
		while(true) {
			selectedPiece = null; moveLocation = null;
			view.updateStatusPanel(model);
			getPlayerMove();
			takeMove();
			if(isGameOver()) {
				playAgainDialog();
				continue;
			}
			switchTurns();
		}
	}
	private void getPlayerMove() {
		do {
			while(true) {
				selectedPiece = controller.getSelectedPiece(); 
				if(selectedPiece != null && model.getPlayerPieces(currentPlayer.getPlayer()).contains(selectedPiece)) {
					ArrayList<Location> highLights = model.getPieceLocations(selectedPiece);
					if(highLights != null) {
						highLights.add(selectedPiece.getLocation());
					}
					view.draw(model, highLights);
					break;
				}
				view.draw(model, null);
			}
			moveLocation = controller.getSelectedLocation();
			ArrayList<Location> possibleMoves = model.getPieceLocations(selectedPiece);
			if(moveLocation != null && possibleMoves != null && possibleMoves.contains(moveLocation)) {
				break;
			}
		} while(true);
	}
	private void takeMove() {
		Move move = new Move();
		move.movedPiece = selectedPiece;
		move.oldLocation = new Location(selectedPiece.getLocation());
		if(selectedPiece instanceof Pawn) {
			((Pawn) selectedPiece).incrementMoveCounter();
		}
		move.currentLocation = new Location(moveLocation);
		Piece oldPiece = model.getChessBoard().movePiece(selectedPiece, moveLocation);
		move.oldPiece = oldPiece;
		if(oldPiece != null) {
			currentPlayer.getPlayer().addCapturedPiece(oldPiece);
		}
		move.currentPlayer = currentPlayer;
		move.opposingPlayer = opposingPlayer;
		moveStack.add(move);
		view.draw(model, null);
	}
	private boolean isGameOver() {
		boolean result = false;
		if(ChessGame.isCheckMated(model.getChessBoard(), opposingPlayer.getKing())) {
			String message = "Player " + opposingPlayer.getPlayer().getName() + " is checkmate!" + "\n" +
					         "Player " + currentPlayer.getPlayer().getName() + " wins the game!";
			displayDialog(message);
			currentPlayer.getPlayer().setScore(currentPlayer.getPlayer().getScore() + 1);
			result = true;
		} else if(ChessGame.isStaleMate(model.getChessBoard(), currentPlayer.getKing())) {
			String message = "Game over this is a draw";
			displayDialog(message);
			currentPlayer.getPlayer().setScore(currentPlayer.getPlayer().getScore() + 1);
			opposingPlayer.getPlayer().setScore(opposingPlayer.getPlayer().getScore() + 1);
			result = true;
		} else {
			result = false;
		}
		return result;
	}
	private void switchTurns() {
		currentPlayer = (currentPlayer == player1) ? player2 : player1;
		opposingPlayer = (opposingPlayer == player1) ? player2 : player1;
	}
	private void restartChessApp(boolean specialPiece) {
		model.resetModel(specialPiece);
		model.getPlayerInfo1().getPlayer().setCapturedPieces(null);
		model.getPlayerInfo2().getPlayer().setCapturedPieces(null);
		player1 = model.getPlayerInfo1();
		player2 = model.getPlayerInfo2();
		currentPlayer = player1;
		opposingPlayer = player2;
		moveStack = new Stack<Move>();
	}
	public void playAgainDialog() {
		JToggleButton specialPiece = new JToggleButton();
		Object[] message = {
				"Do you want to play another game?",
				"Special Pieces", specialPiece
		};
		Object[] options = {"YES", "NO"};	
		int option = JOptionPane.showOptionDialog(null, message, "jchess", 
				                                  JOptionPane.PLAIN_MESSAGE, 
				                                  JOptionPane.QUESTION_MESSAGE, 
				                                  null, options, options[0]);
		if(option == JOptionPane.YES_OPTION) {
			restartChessApp(specialPiece.isSelected());
			return;
		}
		System.exit(0);
	}
	public void displayDialog(String message) {
		Object[] options = {"OK"};	
		int option = JOptionPane.showOptionDialog(null, message, "jchess", 
				                                  JOptionPane.PLAIN_MESSAGE, 
				                                  JOptionPane.QUESTION_MESSAGE, 
				                                  null, options, options[0]);
	}
	public void newGameDialog() {
		JToggleButton player1Agree = new JToggleButton();
		JToggleButton player2Agree = new JToggleButton();
		JToggleButton specialPiece = new JToggleButton();
		Object[] message = {
				"Player 1 Click to Agree:", player1Agree,
				"Player 2 Click to Agree:", player2Agree,
				"Special Pieces:", specialPiece
		};
		Object[] options = {"OK"};	
		int option = JOptionPane.showOptionDialog(null, message, "jchess", 
				                                  JOptionPane.PLAIN_MESSAGE, 
				                                  JOptionPane.QUESTION_MESSAGE, 
				                                  null, options, options[0]);	
		if(option == JOptionPane.CLOSED_OPTION) {
			return;
		}
		if(player1Agree.isSelected() && player2Agree.isSelected()) {
			currentPlayer.getPlayer().setScore(currentPlayer.getPlayer().getScore() + 1);
			opposingPlayer.getPlayer().setScore(opposingPlayer.getPlayer().getScore() + 1);
			view.updateStatusPanel(model);
			restartChessApp(specialPiece.isSelected());
			return;
		}
	}
	public void forfeitDialog() {
		Object[] message = {
				"Are you sure you want to forfeit?"
		};
		Object[] options = {"YES", "NO"};	
		int option = JOptionPane.showOptionDialog(null, message, "jchess", 
				                                  JOptionPane.PLAIN_MESSAGE, 
				                                  JOptionPane.QUESTION_MESSAGE, 
				                                  null, options, options[0]);
		if(option == JOptionPane.YES_OPTION) {
			opposingPlayer.getPlayer().setScore(opposingPlayer.getPlayer().getScore() + 1);
			view.updateStatusPanel(model);
			playAgainDialog();
			return;
		}
	}
	public void aboutDialog() {
		String message = "jchess\n"
				       + "Written By: realeigenvalue\n"
				       + "Technologies: Java, Java-Swing\n"
				       + "Java Version: JavaSE-1.8.0_144";
		displayDialog(message);
	}
	public void undo() {
 		if(moveStack.isEmpty()) {
			return;
		}
		Move lastMove = moveStack.pop();
		if(lastMove != null) {
			if(lastMove.movedPiece != null) {
				if(lastMove.movedPiece instanceof Pawn) {
					((Pawn) lastMove.movedPiece).decrementMoveCounter();
				}
				model.getChessBoard().movePiece(lastMove.movedPiece, lastMove.oldLocation);
			}
			if(lastMove.oldPiece != null) {
				if(lastMove.oldPiece instanceof Pawn) {
					((Pawn) lastMove.oldPiece).decrementMoveCounter();
				}
				model.getChessBoard().movePiece(lastMove.oldPiece, lastMove.currentLocation);
			}
			this.currentPlayer = lastMove.currentPlayer;
			this.opposingPlayer = lastMove.opposingPlayer;
		}
	}
}
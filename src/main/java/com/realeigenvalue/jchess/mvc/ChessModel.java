package com.realeigenvalue.jchess.mvc;

import java.util.ArrayList;
import com.realeigenvalue.jchess.chesslib.ChessBoard;
import com.realeigenvalue.jchess.chesslib.ChessGame;
import com.realeigenvalue.jchess.chesslib.Location;
import com.realeigenvalue.jchess.chesslib.Piece;
import com.realeigenvalue.jchess.chesslib.PieceColor;
import com.realeigenvalue.jchess.chesslib.Player;
import com.realeigenvalue.jchess.chesslib.piecetype.Bishop;
import com.realeigenvalue.jchess.chesslib.piecetype.King;
import com.realeigenvalue.jchess.chesslib.piecetype.Knight;
import com.realeigenvalue.jchess.chesslib.piecetype.KnightBishop;
import com.realeigenvalue.jchess.chesslib.piecetype.KnightRook;
import com.realeigenvalue.jchess.chesslib.piecetype.Pawn;
import com.realeigenvalue.jchess.chesslib.piecetype.Queen;
import com.realeigenvalue.jchess.chesslib.piecetype.Rook;

public class ChessModel {
	private ArrayList<Piece> pieces;
	private ChessBoard cBoard;
	private King whiteKing, blackKing;
	private Player player1, player2;
	public class PlayerInfo {
		private Player player;
		private Piece king;
		public PlayerInfo(Player player, Piece king) {
			this.player = player;
			this.king = king;
		}
		public Player getPlayer() {
			return player;
		}
		public Piece getKing() {
			return king;
		}
	}
	private PlayerInfo playerInfo1;
	private PlayerInfo playerInfo2;
	public ChessModel(boolean specialPieces) {
		player1 = new Player(null, PieceColor.WHITE);
		player2 = new Player(null, PieceColor.BLACK);
		resetModel(specialPieces);
	}
	public ArrayList<Piece> getAllPieces() {
		return pieces;
	}
	public ChessBoard getChessBoard() {
		return cBoard;
	}
	public PlayerInfo getPlayerInfo1() {
		return playerInfo1;
	}
	public PlayerInfo getPlayerInfo2() {
		return playerInfo2;
	}
	public ArrayList<Piece> getPlayerPieces(Player player) {
		if(player == null) {
			return null;
		}
		ArrayList<Piece> availablePieces = new ArrayList<Piece>();
		for(Piece piece : cBoard.getPieces()) {
			if(piece.getColor() == player.getSide()) {
				availablePieces.add(piece);
			}
		}
		if(availablePieces.size() == 0) {
			return null;
		}
		return availablePieces;
	}
	public ArrayList<Location> getPieceLocations(Piece selectedPiece) {
		if(selectedPiece == null) {
			return null;
		}
		ArrayList<Location> pieceMoveList = selectedPiece.getMoveList(cBoard);
		ArrayList<Location> possibleLocations = new ArrayList<Location>();
		Piece yourKing = (selectedPiece.getColor() == PieceColor.WHITE) ? whiteKing : blackKing;
		for(Location location : pieceMoveList) {
			if(!ChessGame.wouldCheck(cBoard, selectedPiece, location, yourKing)) {
				possibleLocations.add(location);
			}
		}
		if(possibleLocations.size() == 0) {
			return null;
		}
		return possibleLocations;
	}
	public void resetModel(boolean specialPieces) {
		pieces = new ArrayList<Piece>();
		pieces.add(new Rook(PieceColor.WHITE, new Location(7, 0), false));
		pieces.add(new Rook(PieceColor.WHITE, new Location(7, 7), false));
		pieces.add(new Knight(PieceColor.WHITE, new Location(7, 1), false));
		pieces.add(new Knight(PieceColor.WHITE, new Location(7, 6), false));
		pieces.add(new Bishop(PieceColor.WHITE, new Location(7, 2), false));
		pieces.add(new Bishop(PieceColor.WHITE, new Location(7, 5), false));
		pieces.add(new Queen(PieceColor.WHITE, new Location(7, 3), false));
		if(specialPieces) {
			pieces.add(new KnightBishop(PieceColor.WHITE, new Location(5, 2), false));
			pieces.add(new KnightRook(PieceColor.WHITE, new Location(5, 5), false));
		}
		whiteKing = new King(PieceColor.WHITE, new Location(7, 4), false);
		pieces.add(whiteKing);		
		pieces.add(new Rook(PieceColor.BLACK, new Location(0, 0), false));
		pieces.add(new Rook(PieceColor.BLACK, new Location(0, 7), false));
		pieces.add(new Knight(PieceColor.BLACK, new Location(0, 1), false));
		pieces.add(new Knight(PieceColor.BLACK, new Location(0, 6), false));
		pieces.add(new Bishop(PieceColor.BLACK, new Location(0, 2), false));
		pieces.add(new Bishop(PieceColor.BLACK, new Location(0, 5), false));
		pieces.add(new Queen(PieceColor.BLACK, new Location(0, 3), false));
		if(specialPieces) {
			pieces.add(new KnightBishop(PieceColor.BLACK, new Location(2, 5), false));
			pieces.add(new KnightRook(PieceColor.BLACK, new Location(2, 2), false));
		}
		blackKing = new King(PieceColor.BLACK, new Location(0, 4), false);
		pieces.add(blackKing);
		for(int i = 0; i < 8; i++) {
			pieces.add(new Pawn(PieceColor.WHITE, new Location(6, i), false));
			pieces.add(new Pawn(PieceColor.BLACK, new Location(1, i), false));
		}
		cBoard = new ChessBoard(pieces);
		playerInfo1 = new PlayerInfo(player1, whiteKing);
		playerInfo2 = new PlayerInfo(player2, blackKing);
	}
}
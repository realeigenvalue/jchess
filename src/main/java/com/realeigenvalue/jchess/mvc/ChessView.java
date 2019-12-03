package com.realeigenvalue.jchess.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import com.realeigenvalue.jchess.chesslib.Location;
import com.realeigenvalue.jchess.chesslib.Piece;
import com.realeigenvalue.jchess.chesslib.PieceColor;
import com.realeigenvalue.jchess.chesslib.piecetype.Bishop;
import com.realeigenvalue.jchess.chesslib.piecetype.King;
import com.realeigenvalue.jchess.chesslib.piecetype.Knight;
import com.realeigenvalue.jchess.chesslib.piecetype.KnightBishop;
import com.realeigenvalue.jchess.chesslib.piecetype.KnightRook;
import com.realeigenvalue.jchess.chesslib.piecetype.Pawn;
import com.realeigenvalue.jchess.chesslib.piecetype.Queen;
import com.realeigenvalue.jchess.chesslib.piecetype.Rook;

public class ChessView extends JFrame {
	private class Surface extends JPanel {
		private ArrayList<Tile> tiles;
		public Surface(ArrayList<Tile> tiles) {
			this.setPreferredSize(new Dimension(ChessView.PREFERRED_WIDTH, ChessView.PREFERRED_HEIGHT));
			this.tiles = (tiles == null) ? new ArrayList<Tile>() : tiles;
		}
		public ArrayList<Tile> getTiles() {
			return tiles;
		}
		public void setTiles(ArrayList<Tile> tiles) {
			this.tiles = (tiles == null) ? new ArrayList<Tile>() : tiles;
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			for(Tile t : tiles) {
				g.drawImage(t.getImage(), t.getX(), t.getY(), t.getWidth(), t.getHeight(), null);
			}
		}
	}
	private class Tile {
		private BufferedImage image;
		private int x, y, width, height;
		public Tile(BufferedImage image, int x, int y, int width, int height) {
			this.image = image;
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
		}
		public BufferedImage getImage() {
			return image;
		}
		public int getX() {
			return x;
		}
		public int getY() {
			return y;
		}
		public int getWidth() {
			return width;
		}
		public int getHeight() {
			return height;
		}
	}
	private static final int PREFERRED_WIDTH = 480;
	private static final int PREFERRED_HEIGHT = 480;
	private Surface mainSurface;
	private BufferedImage chessBoard, whiteKing, whiteQueen, whiteBishop, whiteKnight, whiteRook, whitePawn, whiteKnightBishop, whiteKnightRook,
	                                  blackKing, blackQueen, blackBishop, blackKnight, blackRook, blackPawn, blackKnightBishop, blackKnightRook;
	private BufferedImage highLight;
	private int surfaceWidth;
	private int surfaceHeight;
	private JMenuItem Exit, NewGame, Forfeit, Undo, About;
	private JPanel statusPanel;
	private JLabel player1Score;
	private JLabel player2Score;
	public ChessView() {
		try {
			chessBoard        = ImageIO.read(this.getClass().getResource("/com/realeigenvalue/jchess/images/empty_chessboard.jpg"));
			whiteKing         = ImageIO.read(this.getClass().getResource("/com/realeigenvalue/jchess/images/white_king.png"));
			whiteQueen        = ImageIO.read(this.getClass().getResource("/com/realeigenvalue/jchess/images/white_queen.png"));
			whiteBishop       = ImageIO.read(this.getClass().getResource("/com/realeigenvalue/jchess/images/white_bishop.png"));
			whiteKnight       = ImageIO.read(this.getClass().getResource("/com/realeigenvalue/jchess/images/white_knight.png"));
			whiteRook         = ImageIO.read(this.getClass().getResource("/com/realeigenvalue/jchess/images/white_rook.png"));
			whitePawn         = ImageIO.read(this.getClass().getResource("/com/realeigenvalue/jchess/images/white_pawn.png"));
			whiteKnightBishop = ImageIO.read(this.getClass().getResource("/com/realeigenvalue/jchess/images/white_knight_bishop.png"));
			whiteKnightRook   = ImageIO.read(this.getClass().getResource("/com/realeigenvalue/jchess/images/white_knight_rook.png"));
			blackKing         = ImageIO.read(this.getClass().getResource("/com/realeigenvalue/jchess/images/black_king.png"));
			blackQueen        = ImageIO.read(this.getClass().getResource("/com/realeigenvalue/jchess/images/black_queen.png"));
			blackBishop       = ImageIO.read(this.getClass().getResource("/com/realeigenvalue/jchess/images/black_bishop.png"));
			blackKnight       = ImageIO.read(this.getClass().getResource("/com/realeigenvalue/jchess/images/black_knight.png"));
			blackRook         = ImageIO.read(this.getClass().getResource("/com/realeigenvalue/jchess/images/black_rook.png"));
			blackPawn         = ImageIO.read(this.getClass().getResource("/com/realeigenvalue/jchess/images/black_pawn.png"));
			blackKnightBishop = ImageIO.read(this.getClass().getResource("/com/realeigenvalue/jchess/images/black_knight_bishop.png"));
			blackKnightRook   = ImageIO.read(this.getClass().getResource("/com/realeigenvalue/jchess/images/black_knight_rook.png"));
			highLight   = ImageIO.read(this.getClass().getResource("/com/realeigenvalue/jchess/images/highlight.png"));
		} catch(Exception e) {
			System.out.println("Image loading problem!");
		}
		mainSurface = new Surface(null);
		surfaceWidth = mainSurface.getWidth();
		surfaceHeight = mainSurface.getHeight();
		setupMenu();
		statusPanel = new JPanel();
		player1Score = new JLabel("Player 1 Score:");
		player2Score = new JLabel("Player 2 Score:");
		statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.Y_AXIS));
		statusPanel.add(player1Score);
		statusPanel.add(player2Score);
		this.setLayout(new BorderLayout());
		this.add(statusPanel, BorderLayout.LINE_END);
		this.add(mainSurface, BorderLayout.CENTER);
		this.pack();
		this.setResizable(true);
		this.setTitle("jchess");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(false);
	}
	public int getSurfaceWidth() {
		return surfaceWidth;
	}
	public int getSurfaceHeight() {
		return surfaceHeight;
	}
	private void setupMenu() {
		JMenuBar MenuBar = new JMenuBar();
		JMenu File = new JMenu("File");
		Exit = new JMenuItem("Exit");
		File.add(Exit);
		JMenu Game = new JMenu("Game");
		NewGame = new JMenuItem("New Game");
		Forfeit = new JMenuItem("Forfeit");
		Undo = new JMenuItem("Undo");
		Game.add(NewGame);
		Game.add(Forfeit);
		Game.add(Undo);
		JMenu Help = new JMenu("Help");
		About = new JMenuItem("About");
		Help.add(About);
		MenuBar.add(File); MenuBar.add(Game); MenuBar.add(Help);
		this.setJMenuBar(MenuBar);
	}
	public void draw(ChessModel chessModel, ArrayList<Location> highLights) {
		surfaceWidth = mainSurface.getWidth();
		surfaceHeight = mainSurface.getHeight();
		int tileWidth = (surfaceWidth / 8);
		int tileHeight = (surfaceHeight / 8);
		ArrayList<Tile> tilesToDraw = new ArrayList<Tile>();
		tilesToDraw.add(new Tile(chessBoard, 0, 0, surfaceWidth, surfaceHeight));
		if(highLights != null) {
			for(Location location : highLights) {
				tilesToDraw.add(new Tile(highLight,
						        tileWidth * location.getColumn(),
						        tileHeight * location.getRow(),
						        tileWidth, tileHeight));
			}
		}
		if(chessModel != null) {
			for(Piece piece : chessModel.getChessBoard().getPieces()) {
				tilesToDraw.add(new Tile(parsePiece(piece), 
						        tileWidth * piece.getLocation().getColumn(), 
						        tileHeight * piece.getLocation().getRow(), 
						        tileWidth, tileHeight));
				
			}
		}
		mainSurface.setTiles(tilesToDraw);
		mainSurface.repaint();
	}
	public BufferedImage parsePiece(Piece piece) {
		if(piece == null) {
			return null;
		}
		BufferedImage result = null;
		if(piece.getColor() == PieceColor.WHITE) {
			if(piece instanceof King) {
				result = whiteKing;
			} else if(piece instanceof Queen) {
				result = whiteQueen;
			} else if(piece instanceof Bishop) {
				result = whiteBishop;
			} else if(piece instanceof Knight) {
				result = whiteKnight;
			} else if(piece instanceof Rook) {
				result = whiteRook;
			} else if(piece instanceof Pawn) {
				result = whitePawn;
			} else if(piece instanceof KnightBishop) {
				result = whiteKnightBishop;
			} else if(piece instanceof KnightRook) {
				result = whiteKnightRook;
			}
		} else if(piece.getColor() == PieceColor.BLACK) {
			if(piece instanceof King) {
				result = blackKing;
			} else if(piece instanceof Queen) {
				result = blackQueen;
			} else if(piece instanceof Bishop) {
				result = blackBishop;
			} else if(piece instanceof Knight) {
				result = blackKnight;
			} else if(piece instanceof Rook) {
				result = blackRook;
			} else if(piece instanceof Pawn) {
				result = blackPawn;
			} else if(piece instanceof KnightBishop) {
				result = blackKnightBishop;
			} else if(piece instanceof KnightRook) {
				result = blackKnightRook;
			}
		}
		return result;
	}
	public void addMenuItemExitListener(ActionListener listener) {
		Exit.addActionListener(listener);
	}
	public void addMenuItemNewGameListener(ActionListener listener) {
		NewGame.addActionListener(listener);
	}
	public void addMenuItemForfeitListener(ActionListener listener) {
		Forfeit.addActionListener(listener);
	}
	public void addMenuItemUndoListener(ActionListener listener) {
		Undo.addActionListener(listener);
	}
	public void addMenuItemAboutListener(ActionListener listener) {
		About.addActionListener(listener);
	}
	public void addMouseListener(MouseListener listener) {
		mainSurface.addMouseListener(listener);
	}
	public void updateStatusPanel(ChessModel chessModel) {
		player1Score.setText(chessModel.getPlayerInfo1().getPlayer().getName() + " Score: " + chessModel.getPlayerInfo1().getPlayer().getScore());
		player2Score.setText(chessModel.getPlayerInfo2().getPlayer().getName() + " Score: " + chessModel.getPlayerInfo2().getPlayer().getScore());
	}
}
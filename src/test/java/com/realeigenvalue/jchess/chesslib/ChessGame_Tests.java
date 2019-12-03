package com.realeigenvalue.jchess.chesslib;

import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import org.junit.Test;
import com.realeigenvalue.jchess.chesslib.ChessBoard;
import com.realeigenvalue.jchess.chesslib.ChessGame;
import com.realeigenvalue.jchess.chesslib.Location;
import com.realeigenvalue.jchess.chesslib.Piece;
import com.realeigenvalue.jchess.chesslib.PieceColor;
import com.realeigenvalue.jchess.chesslib.piecetype.King;
import com.realeigenvalue.jchess.chesslib.piecetype.Queen;
import com.realeigenvalue.jchess.chesslib.piecetype.Rook;

public class ChessGame_Tests {
	@Test
	public void testIsStaleMate() {
		ArrayList<Piece> pieces = new ArrayList<Piece>();
		pieces.add(new King(PieceColor.WHITE, new Location(1, 5), false));
		pieces.add(new Queen(PieceColor.WHITE, new Location(2, 6), false));
		King blackKing = new King(PieceColor.BLACK, new Location(0, 7), false);
		pieces.add(blackKing);
		ChessBoard cb = new ChessBoard(pieces);
		assertTrue(ChessGame.isStaleMate(cb, blackKing));
	}
	@Test
	public void testIsCheckMated() {
		ArrayList<Piece> pieces = new ArrayList<Piece>();
		pieces.add(new King(PieceColor.WHITE, new Location(3, 5), false));
		pieces.add(new Rook(PieceColor.WHITE, new Location(7, 7), false));
		King blackKing = new King(PieceColor.BLACK, new Location(3, 7), false);
		pieces.add(blackKing);
		ChessBoard cb = new ChessBoard(pieces);
		assertTrue(ChessGame.isCheckMated(cb, blackKing));	
	}
	@Test
	public void testFindLegalMove() {
		ArrayList<Piece> pieces = new ArrayList<Piece>();
		pieces.add(new King(PieceColor.WHITE, new Location(7, 4), false));
		pieces.add(new Rook(PieceColor.WHITE, new Location(6, 2), false));
		King blackKing = new King(PieceColor.BLACK, new Location(2, 2), false);
		pieces.add(blackKing);
		ChessBoard cb = new ChessBoard(pieces);
		assertTrue(ChessGame.findLegalMove(cb, blackKing));		
	}
	@Test
	public void testIsCheck() {
		ArrayList<Piece> pieces = new ArrayList<Piece>();
		pieces.add(new Queen(PieceColor.WHITE, new Location(3, 5), false));
		King blackKing = new King(PieceColor.BLACK, new Location(3, 7), false);
		pieces.add(blackKing);
		ChessBoard cb = new ChessBoard(pieces);
		assertTrue(ChessGame.isCheck(cb, blackKing));		
	}
	@Test
	public void testWouldCheck() {
		ArrayList<Piece> pieces = new ArrayList<Piece>();
		pieces.add(new Queen(PieceColor.WHITE, new Location(3, 5), false));
		King blackKing = new King(PieceColor.BLACK, new Location(3, 7), false);
		pieces.add(blackKing);
		ChessBoard cb = new ChessBoard(pieces);
		assertTrue(ChessGame.wouldCheck(cb, blackKing, new Location(3, 6), blackKing));	
	}
}
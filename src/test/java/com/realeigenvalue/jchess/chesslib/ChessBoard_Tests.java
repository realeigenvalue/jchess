package com.realeigenvalue.jchess.chesslib;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import org.junit.Test;
import com.realeigenvalue.jchess.chesslib.ChessBoard;
import com.realeigenvalue.jchess.chesslib.Location;
import com.realeigenvalue.jchess.chesslib.Piece;
import com.realeigenvalue.jchess.chesslib.PieceColor;
import com.realeigenvalue.jchess.chesslib.piecetype.Rook;

public class ChessBoard_Tests {
	@Test
	public void testChessBoardArrayListOfPiece() {
		ArrayList<Piece> pieces = new ArrayList<Piece>();
		pieces.add(new Rook(PieceColor.WHITE, new Location(3, 6), false));
		ChessBoard cb = new ChessBoard(pieces);
		assertNotNull(cb);
		assertTrue(pieces.size() == cb.getPieces().size());
		for(Piece piece : pieces) {
			assertTrue(cb.getPieces().contains(piece));
		}
	}
	@Test
	public void testChessBoardChessBoard() {
		ArrayList<Piece> pieces = new ArrayList<Piece>();
		pieces.add(new Rook(PieceColor.WHITE, new Location(3, 6), false));
		ChessBoard cb1 = new ChessBoard(pieces);
		ChessBoard cb2 = new ChessBoard(cb1);
		assertNotNull(cb2);
		assertTrue(cb1.getPieces().size() == cb2.getPieces().size());
		for(Piece piece : cb1.getPieces()) {
			assertTrue(cb2.getPieces().contains(piece));
		}
	}
	@Test
	public void testGetPiece() {
		ArrayList<Piece> pieces = new ArrayList<Piece>();
		Rook r = new Rook(PieceColor.WHITE, new Location(3, 6), false);
		pieces.add(r);
		ChessBoard cb1 = new ChessBoard(pieces);
		assertEquals(r, cb1.getPiece(new Location(3, 6)));
	}
	@Test
	public void testGetPieces() {
		ArrayList<Piece> pieces = new ArrayList<Piece>();
		Rook r = new Rook(PieceColor.WHITE, new Location(3, 6), false);
		pieces.add(r);
		ChessBoard cb1 = new ChessBoard(pieces);
		assertTrue(pieces.size() == cb1.getPieces().size());
		for(Piece piece : pieces) {
			cb1.getPieces().contains(piece);
		}
	}
	@Test
	public void testMovePiece() {
		ArrayList<Piece> pieces = new ArrayList<Piece>();
		Rook r = new Rook(PieceColor.WHITE, new Location(3, 6), false);
		pieces.add(r);
		ChessBoard cb1 = new ChessBoard(pieces);
		assertEquals(new Location(3, 6), r.getLocation());
		cb1.movePiece(r, new Location(7, 3));
		assertEquals(new Location(7, 3), r.getLocation());
	}
}
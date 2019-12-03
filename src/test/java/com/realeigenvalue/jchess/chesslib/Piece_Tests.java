package com.realeigenvalue.jchess.chesslib;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import com.realeigenvalue.jchess.chesslib.Location;
import com.realeigenvalue.jchess.chesslib.Piece;
import com.realeigenvalue.jchess.chesslib.PieceColor;
import com.realeigenvalue.jchess.chesslib.piecetype.Rook;

public class Piece_Tests {
	@Test
	public void testPiece() {
		Piece piece = new Rook(PieceColor.WHITE, new Location(), false);
		assertNotNull(piece);
	}
	@Test
	public void testGetColor() {
		Piece piece = new Rook(PieceColor.WHITE, new Location(), false);
		assertEquals(PieceColor.WHITE, piece.getColor());
	}
	@Test
	public void testSetColor() {
		Piece piece = new Rook(PieceColor.WHITE, new Location(), false);
		assertEquals(PieceColor.WHITE, piece.getColor());
		piece.setColor(PieceColor.BLACK);
		assertEquals(PieceColor.BLACK, piece.getColor());
	}
	@Test
	public void testGetLocation() {
		Piece piece = new Rook(PieceColor.WHITE, new Location(3, 5), false);
		assertEquals(new Location(3, 5), piece.getLocation());
	}
	@Test
	public void testSetLocation() {
		Piece piece = new Rook(PieceColor.WHITE, new Location(3, 5), false);
		assertEquals(new Location(3, 5), piece.getLocation());
		piece.setLocation(new Location(6, 7));
		assertEquals(new Location(6, 7), piece.getLocation());
	}
	@Test
	public void testIsTaken() {
		Piece piece = new Rook(PieceColor.WHITE, new Location(), true);
		assertEquals(true, piece.isTaken());
		piece.setTaken(false);
		assertEquals(false, piece.isTaken());
	}
	@Test
	public void testSetTaken() {
		Piece piece = new Rook(PieceColor.WHITE, new Location(), true);
		assertEquals(true, piece.isTaken());
		piece.setTaken(false);
		assertEquals(false, piece.isTaken());
	}
}
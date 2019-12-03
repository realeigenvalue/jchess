package com.realeigenvalue.jchess.chesslib;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.util.ArrayList;
import org.junit.Test;
import com.realeigenvalue.jchess.chesslib.Location;
import com.realeigenvalue.jchess.chesslib.Piece;
import com.realeigenvalue.jchess.chesslib.PieceColor;
import com.realeigenvalue.jchess.chesslib.Player;
import com.realeigenvalue.jchess.chesslib.piecetype.Rook;

public class Player_Tests {
	@Test
	public void testPlayer() {
		Player actualResult = new Player("testPlayer", PieceColor.NULL);
		assertNotNull(actualResult);
		assertEquals("testPlayer", actualResult.getName());
		assertEquals(PieceColor.NULL, actualResult.getSide());
	}
	@Test
	public void testGetName() {
		Player actualResult = new Player("testPlayer", PieceColor.NULL);
		assertEquals("testPlayer", actualResult.getName());
	}
	@Test
	public void testSetName() {
		Player player1 = new Player("test", PieceColor.NULL);
		assertEquals("test", player1.getName());
		player1.setName("change");
		assertEquals("change", player1.getName());
	}
	@Test
	public void testGetSide() {
		Player player1 = new Player("test", PieceColor.NULL);
		assertEquals(PieceColor.NULL, player1.getSide());
	}
	@Test
	public void testSetSide() {
		Player player1 = new Player("test", PieceColor.NULL);
		assertEquals(PieceColor.NULL, player1.getSide());
		player1.setSide(PieceColor.WHITE);
		assertEquals(PieceColor.WHITE, player1.getSide());
	}
	@Test
	public void testGetCapturedPieces() {
		Player player1 = new Player("test", PieceColor.NULL);
		Rook r = new Rook(PieceColor.WHITE, new Location(), false);
		player1.addCapturedPiece(r);
		ArrayList<Piece> pieces = new ArrayList<Piece>();
		pieces.add(r);
		assertEquals(pieces, player1.getCapturedPieces());
	}
	@Test
	public void testSetCapturedPieces() {
		Rook r = new Rook(PieceColor.WHITE, new Location(), false);
		ArrayList<Piece> pieces = new ArrayList<Piece>();
		pieces.add(r);
		Player player1 = new Player("test", PieceColor.NULL);
		player1.setCapturedPieces(pieces);
		assertEquals(pieces, player1.getCapturedPieces());
	}
	@Test
	public void testAddCapturedPiece() {
		Rook r = new Rook(PieceColor.WHITE, new Location(), false);
		Player player1 = new Player("test", PieceColor.NULL);
		player1.addCapturedPiece(r);
		assertEquals(r, player1.getCapturedPieces().get(0));
	}
}
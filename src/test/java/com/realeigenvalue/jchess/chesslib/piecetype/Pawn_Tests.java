package com.realeigenvalue.jchess.chesslib.piecetype;

import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import org.junit.Test;
import com.realeigenvalue.jchess.chesslib.ChessBoard;
import com.realeigenvalue.jchess.chesslib.Location;
import com.realeigenvalue.jchess.chesslib.Piece;
import com.realeigenvalue.jchess.chesslib.PieceColor;
import com.realeigenvalue.jchess.chesslib.piecetype.Pawn;

public class Pawn_Tests {
	@Test
	public void testGetMoveList() {
		ChessBoard cb1 = new ChessBoard(new ArrayList<Piece>());
		Pawn p1 = new Pawn(PieceColor.WHITE, new Location(6, 3), false);
		ArrayList<Location> p1Locs = new ArrayList<Location>();
		p1Locs.add(new Location(5, 3));
		p1Locs.add(new Location(4, 3));
		ArrayList<Location> moveList = p1.getMoveList(cb1);
		assertTrue(p1Locs.size() == moveList.size());
		for(Location loc : p1Locs) {
			assertTrue(moveList.contains(loc));
		}
		Pawn p2 = new Pawn(PieceColor.BLACK, new Location(1, 5), false);
		Pawn p2Enemy = new Pawn(PieceColor.WHITE, new Location(2, 4), false);
		cb1.movePiece(p2, p2.getLocation());
		cb1.movePiece(p2Enemy, p2Enemy.getLocation());
		ArrayList<Location> p2MoveList = p2.getMoveList(cb1);
		ArrayList<Location> p2Locs = new ArrayList<Location>();
		p2Locs.add(new Location(2, 5));
		p2Locs.add(new Location(3, 5));
		p2Locs.add(new Location(2, 4));
		assertTrue(p2Locs.size() == p2MoveList.size());
		for(Location loc : p2Locs) {
			assertTrue(p2MoveList.contains(loc));
		}
	}
}
package com.realeigenvalue.jchess.chesslib.piecetype;

import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import org.junit.Test;
import com.realeigenvalue.jchess.chesslib.ChessBoard;
import com.realeigenvalue.jchess.chesslib.Location;
import com.realeigenvalue.jchess.chesslib.Piece;
import com.realeigenvalue.jchess.chesslib.PieceColor;
import com.realeigenvalue.jchess.chesslib.piecetype.KnightBishop;

public class KnightBishop_Tests {
	@Test
	public void testGetMoveList() {
		ArrayList<Location> locations = new ArrayList<Location>();
		locations.add(new Location(1, 2));
		locations.add(new Location(1, 4));
		locations.add(new Location(2, 1));
		locations.add(new Location(4, 1));
		locations.add(new Location(5, 2));
		locations.add(new Location(5, 4));
		locations.add(new Location(4, 5));
		locations.add(new Location(2, 5));
		locations.add(new Location(2, 2));
		locations.add(new Location(2, 4));
		locations.add(new Location(4, 2));
		locations.add(new Location(4, 4));
		ChessBoard cb1 = new ChessBoard(new ArrayList<Piece>());
		KnightBishop kb = new KnightBishop(PieceColor.WHITE, new Location(3, 3), false);
		ArrayList<Location> moveList = kb.getMoveList(cb1);
		assertTrue(locations.size() == moveList.size());
		for(Location loc : locations) {
			assertTrue(moveList.contains(loc));
		}	
	}
}
package com.realeigenvalue.jchess.chesslib.piecetype;

import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import org.junit.Test;
import com.realeigenvalue.jchess.chesslib.ChessBoard;
import com.realeigenvalue.jchess.chesslib.Location;
import com.realeigenvalue.jchess.chesslib.Piece;
import com.realeigenvalue.jchess.chesslib.PieceColor;
import com.realeigenvalue.jchess.chesslib.piecetype.Bishop;

public class Bishop_Tests {
	@Test
	public void testGetMoveList() {
		ArrayList<Location> locations = new ArrayList<Location>();
		locations.add(new Location(0, 0));
		locations.add(new Location(1, 1));
		locations.add(new Location(2, 2));
		locations.add(new Location(2, 4));
		locations.add(new Location(1, 5));
		locations.add(new Location(0, 6));
		locations.add(new Location(4, 2));
		locations.add(new Location(5, 1));
		locations.add(new Location(6, 0));
		locations.add(new Location(4, 4));
		locations.add(new Location(5, 5));
		locations.add(new Location(6, 6));
		locations.add(new Location(7, 7));
		ChessBoard cb1 = new ChessBoard(new ArrayList<Piece>());
		Bishop b = new Bishop(PieceColor.WHITE, new Location(3, 3), false);
		ArrayList<Location> moveList = b.getMoveList(cb1);
		assertTrue(locations.size() == moveList.size());
		for(Location loc : locations) {
			assertTrue(moveList.contains(loc));
		}	
	}
}
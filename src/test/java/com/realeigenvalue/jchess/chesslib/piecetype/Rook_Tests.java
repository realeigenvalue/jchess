package com.realeigenvalue.jchess.chesslib.piecetype;

import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import org.junit.Test;
import com.realeigenvalue.jchess.chesslib.ChessBoard;
import com.realeigenvalue.jchess.chesslib.Location;
import com.realeigenvalue.jchess.chesslib.Piece;
import com.realeigenvalue.jchess.chesslib.PieceColor;
import com.realeigenvalue.jchess.chesslib.piecetype.Rook;

public class Rook_Tests {
	@Test
	public void testGetMoveList() {
		ArrayList<Location> locations = new ArrayList<Location>();
		locations.add(new Location(2, 3));
		locations.add(new Location(1, 3));
		locations.add(new Location(0, 3));
		locations.add(new Location(3, 0));
		locations.add(new Location(3, 1));
		locations.add(new Location(3, 2));
		locations.add(new Location(3, 4));
		locations.add(new Location(3, 5));
		locations.add(new Location(3, 6));
		locations.add(new Location(3, 7));
		locations.add(new Location(4, 3));
		locations.add(new Location(5, 3));
		locations.add(new Location(6, 3));
		locations.add(new Location(7, 3));
		ChessBoard cb1 = new ChessBoard(new ArrayList<Piece>());
		Rook r = new Rook(PieceColor.WHITE, new Location(3, 3), false);
		ArrayList<Location> moveList = r.getMoveList(cb1);
		assertTrue(locations.size() == moveList.size());
		for(Location loc : locations) {
			assertTrue(moveList.contains(loc));
		}
	}
}
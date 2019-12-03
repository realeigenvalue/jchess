package com.realeigenvalue.jchess.chesslib.piecetype;

import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import org.junit.Test;
import com.realeigenvalue.jchess.chesslib.ChessBoard;
import com.realeigenvalue.jchess.chesslib.Location;
import com.realeigenvalue.jchess.chesslib.Piece;
import com.realeigenvalue.jchess.chesslib.PieceColor;
import com.realeigenvalue.jchess.chesslib.piecetype.King;

public class King_Tests {
	@Test
	public void testGetMoveList() {
		ArrayList<Location> locations = new ArrayList<Location>();
		locations.add(new Location(2, 2));
		locations.add(new Location(2, 3));
		locations.add(new Location(2, 4));
		locations.add(new Location(4, 2));
		locations.add(new Location(4, 3));
		locations.add(new Location(4, 4));
		locations.add(new Location(3, 2));
		locations.add(new Location(3, 4));
		ChessBoard cb1 = new ChessBoard(new ArrayList<Piece>());
		King k = new King(PieceColor.WHITE, new Location(3, 3), false);
		ArrayList<Location> moveList = k.getMoveList(cb1);
		assertTrue(locations.size() == moveList.size());
		for(Location loc : locations) {
			assertTrue(moveList.contains(loc));
		}	
	}
}
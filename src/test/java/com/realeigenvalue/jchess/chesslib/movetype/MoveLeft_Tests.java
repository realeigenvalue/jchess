package com.realeigenvalue.jchess.chesslib.movetype;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.realeigenvalue.jchess.chesslib.Location;
import com.realeigenvalue.jchess.chesslib.movetype.MoveLeft;

public class MoveLeft_Tests {
	@Test
	public void testMove() {
		Location location = new Location();
		Location locationLeft = new Location(0, -1);
		Location expectedResult = Location.add(location, locationLeft);
		Location actualResult = new MoveLeft().move(location);
		assertEquals(expectedResult, actualResult);
	}
}
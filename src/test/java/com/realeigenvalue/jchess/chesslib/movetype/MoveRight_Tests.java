package com.realeigenvalue.jchess.chesslib.movetype;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.realeigenvalue.jchess.chesslib.Location;
import com.realeigenvalue.jchess.chesslib.movetype.MoveRight;

public class MoveRight_Tests {
	@Test
	public void testMove() {
		Location location = new Location();
		Location locationRight = new Location(0, 1);
		Location expectedResult = Location.add(location, locationRight);
		Location actualResult = new MoveRight().move(location);
		assertEquals(expectedResult, actualResult);
	}
}
package com.realeigenvalue.jchess.chesslib.movetype;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.realeigenvalue.jchess.chesslib.Location;
import com.realeigenvalue.jchess.chesslib.movetype.MoveDown;

public class MoveDown_Tests {
	@Test
	public void testMove() {
		Location location = new Location();
		Location locationDown = new Location(-1, 0);
		Location expectedResult = Location.add(location, locationDown);
		Location actualResult = new MoveDown().move(location);
		assertEquals(expectedResult, actualResult);
	}
}
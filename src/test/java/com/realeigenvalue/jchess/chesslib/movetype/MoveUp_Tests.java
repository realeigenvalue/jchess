package com.realeigenvalue.jchess.chesslib.movetype;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.realeigenvalue.jchess.chesslib.Location;
import com.realeigenvalue.jchess.chesslib.movetype.MoveUp;

public class MoveUp_Tests {
	@Test
	public void testMove() {
		Location location = new Location();
		Location locationUp = new Location(1, 0);
		Location expectedResult = Location.add(location, locationUp);
		Location actualResult = new MoveUp().move(location);
		assertEquals(expectedResult, actualResult);
	}
}
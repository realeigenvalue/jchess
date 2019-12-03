package com.realeigenvalue.jchess.chesslib.movetype;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.realeigenvalue.jchess.chesslib.Location;
import com.realeigenvalue.jchess.chesslib.movetype.MoveDiagNW;

public class MoveDiagNW_Tests {
	@Test
	public void testMove() {
		Location location = new Location();
		Location locationNW = new Location(1, -1);
		Location expectedResult = Location.add(location, locationNW);
		Location actualResult = new MoveDiagNW().move(location);
		assertEquals(expectedResult, actualResult);
	}
}
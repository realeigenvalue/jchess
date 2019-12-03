package com.realeigenvalue.jchess.chesslib.movetype;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.realeigenvalue.jchess.chesslib.Location;
import com.realeigenvalue.jchess.chesslib.movetype.MoveDiagSW;

public class MoveDiagSW_Tests {
	@Test
	public void testMove() {
		Location location = new Location();
		Location locationSW = new Location(-1, -1);
		Location expectedResult = Location.add(location, locationSW);
		Location actualResult = new MoveDiagSW().move(location);
		assertEquals(expectedResult, actualResult);
	}
}
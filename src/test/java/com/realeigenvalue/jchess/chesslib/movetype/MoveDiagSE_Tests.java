package com.realeigenvalue.jchess.chesslib.movetype;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.realeigenvalue.jchess.chesslib.Location;
import com.realeigenvalue.jchess.chesslib.movetype.MoveDiagSE;

public class MoveDiagSE_Tests {
	@Test
	public void testMove() {
		Location location = new Location();
		Location locationSE = new Location(-1, 1);
		Location expectedResult = Location.add(location, locationSE);
		Location actualResult = new MoveDiagSE().move(location);
		assertEquals(expectedResult, actualResult);
	}
}
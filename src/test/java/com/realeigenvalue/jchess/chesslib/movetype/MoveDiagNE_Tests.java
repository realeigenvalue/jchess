package com.realeigenvalue.jchess.chesslib.movetype;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.realeigenvalue.jchess.chesslib.Location;
import com.realeigenvalue.jchess.chesslib.movetype.MoveDiagNE;

public class MoveDiagNE_Tests {
	@Test
	public void testMove() {
		Location location = new Location();
		Location locationNE = new Location(1, 1);
		Location expectedResult = Location.add(location, locationNE);
		Location actualResult = new MoveDiagNE().move(location);
		assertEquals(expectedResult, actualResult);
	}
}
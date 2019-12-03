package com.realeigenvalue.jchess.chesslib;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import com.realeigenvalue.jchess.chesslib.Location;

public class Location_Tests {
	@Test
	public void testHashCode() {
		Location location = new Location(1, 1);
		int expectedResult = 1 * 32 + 1;
		int actualResult = location.hashCode();
		assertEquals(expectedResult, actualResult);
	}
	@Test
	public void testLocation() {
		Location expectedResult = new Location(0, 0);
		Location actualResult = new Location();
		assertNotNull(actualResult);
		assertEquals(expectedResult, actualResult);
	}
	@Test
	public void testLocationIntInt() {
		Location expectedResult = new Location();
		expectedResult.setLocation(1, 1);
		Location actualResult = new Location(1, 1);
		assertNotNull(actualResult);
		assertEquals(expectedResult, actualResult);
	}
	@Test
	public void testLocationLocation() {
		Location expectedResult = new Location(1, 1);
		Location actualResult = new Location(expectedResult);
		assertNotNull(actualResult);
		assertEquals(expectedResult, actualResult);
	}
	@Test
	public void testAdd() {
		int row1 = -1, column1 = 4;
		int row2 = 4, column2 = 39;
		Location location1 = new Location(row1, column1);
		Location location2 = new Location(row2, column2);
		Location expectedResult = new Location(row1 + row2, column1 + column2);
		Location actualResult = Location.add(location1, location2);
		assertEquals(expectedResult, actualResult);
	}
	@Test
	public void testSetLocation() {
		Location expectedResult = new Location(4, 7);
		Location actualResult = new Location();
		actualResult.setLocation(4, 7);
		assertEquals(expectedResult, actualResult);
	}
	@Test
	public void testOnTheBoard() {
		Location inValidLocation = new Location(-1, 9);
		boolean expectedResult = false;
		boolean actualResult = inValidLocation.onTheBoard();
		assertEquals(expectedResult, actualResult);
	}
	@Test
	public void testEqualsObject() {
		Location location1 = new Location(4, 3);
		Location location2 = new Location(8, 2);
		assertFalse(location1.equals(location2));
		location2.setLocation(4, 3);
		assertTrue(location1.equals(location2));
	}
}
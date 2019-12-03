package com.realeigenvalue.jchess.chesslib.movetype;

import com.realeigenvalue.jchess.chesslib.Location;

public class MoveDiagSE implements MoveMethod {
	@Override
	public Location move(Location location) {
		return Location.add(location, new Location(-1, 1));
	}
}
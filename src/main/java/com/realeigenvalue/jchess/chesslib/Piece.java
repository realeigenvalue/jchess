package com.realeigenvalue.jchess.chesslib;

import java.util.ArrayList;

public abstract class Piece {
	private PieceColor color;
	private Location location;
	private boolean taken;
	public Piece(PieceColor color, Location location, boolean taken) {
		this.color = (color == null) ? PieceColor.NULL : color;
		this.location = (location == null) ? new Location(0, 0) : location;
		this.taken = taken;
	}
	public PieceColor getColor() {
		return color;
	}
	public void setColor(PieceColor color) {
		this.color = (color == null) ? PieceColor.NULL : color;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = (location == null) ? new Location(0, 0) : location;
	}
	public boolean isTaken() {
		return taken;
	}
	public void setTaken(boolean taken) {
		this.taken = taken;
	}
	public abstract ArrayList<Location> getMoveList(ChessBoard board);
}
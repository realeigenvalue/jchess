package com.realeigenvalue.jchess.chesslib;

public class Location {
	private int row; 
	private int column;
	public Location() {
		this.row = 0;
		this.column = 0;
	}
	public Location(int row, int column) {
		this.row = row;
		this.column = column;
	}
	public Location(Location location) {
		this.row = (location == null) ? 0 : location.row;
		this.column = (location == null) ? 0: location.column;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	public static Location add(Location a, Location b) {
		if(a != null && b != null) {
			return new Location(a.row + b.row, a.column + b.column);
		} else if(a != null && b == null) {
			return new Location(a);
		} else if(a == null && b != null) {
			return new Location(b);
		} else {
			return new Location();
		}
	}
	public void setLocation(int row, int column) {
		this.row = row;
		this.column = column;
	}
	public boolean onTheBoard() {
		return (0 <= row && row <= 7) && (0 <= column && column <= 7);
	}
	@Override
	public boolean equals(Object other) {
		if(other == null) {
			return false;
		}
		try {
			Location otherLocation = (Location)other;
			return (this.row == otherLocation.row) && (this.column == otherLocation.column);
		} catch (Exception e) {
			return false;
		}	
	}
	@Override
    public int hashCode() {
        return this.row * 32 + this.column;
    }
}
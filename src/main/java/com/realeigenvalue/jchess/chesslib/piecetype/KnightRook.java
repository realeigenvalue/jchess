package com.realeigenvalue.jchess.chesslib.piecetype;

import java.util.ArrayList;
import com.realeigenvalue.jchess.chesslib.ChessBoard;
import com.realeigenvalue.jchess.chesslib.Location;
import com.realeigenvalue.jchess.chesslib.Piece;
import com.realeigenvalue.jchess.chesslib.PieceColor;

public class KnightRook extends Piece {
	private static final Location[] KNIGHT_ROOK_MOVES = {new Location(2, 1),   new Location(1, 2),   new Location(-1, 2),  new Location(-2, 1),
                                                         new Location(-2, -1), new Location(-1, -2), new Location(1, -2),  new Location(2, -1),
                                                         new Location(0, -1),  new Location(1, 0),   new Location(0, 1),   new Location(-1, 0)};
	public KnightRook(PieceColor color, Location location, boolean taken) {
		super(color, location, taken);
	}
	@Override
	public ArrayList<Location> getMoveList(ChessBoard board) {
		if(board == null) {
			return new ArrayList<Location>();
		}
		ArrayList<Location> moveList = new ArrayList<Location>();
		for(Location loc : KNIGHT_ROOK_MOVES) {
			Location destination = Location.add(getLocation(), loc);
			if(destination.onTheBoard()) {
				Piece otherPiece = board.getPiece(destination);
				if(otherPiece != null && otherPiece.getColor() == this.getColor()) {
					continue;
				} else {
					moveList.add(destination);
					continue;
				}
			}
		}
		return moveList;	
	}
}
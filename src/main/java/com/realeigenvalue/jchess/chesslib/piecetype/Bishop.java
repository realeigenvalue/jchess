package com.realeigenvalue.jchess.chesslib.piecetype;

import java.util.ArrayList;
import com.realeigenvalue.jchess.chesslib.ChessBoard;
import com.realeigenvalue.jchess.chesslib.Location;
import com.realeigenvalue.jchess.chesslib.Piece;
import com.realeigenvalue.jchess.chesslib.PieceColor;
import com.realeigenvalue.jchess.chesslib.movetype.MoveDiagNE;
import com.realeigenvalue.jchess.chesslib.movetype.MoveDiagNW;
import com.realeigenvalue.jchess.chesslib.movetype.MoveDiagSE;
import com.realeigenvalue.jchess.chesslib.movetype.MoveDiagSW;
import com.realeigenvalue.jchess.chesslib.movetype.MoveMethod;

public class Bishop extends Piece {
	private static final MoveMethod[] BISHOP_MOVES = {new MoveDiagNW(), new MoveDiagNE(), new MoveDiagSW(), new MoveDiagSE()};
	public Bishop(PieceColor color, Location location, boolean taken) {
		super(color, location, taken);
	}
	@Override
	public ArrayList<Location> getMoveList(ChessBoard board) {
		if(board == null) {
			return new ArrayList<Location>();
		}
		ArrayList<Location> moveList = new ArrayList<Location>();
		for(MoveMethod mvMethod : BISHOP_MOVES) {
			Location tempLocation = getLocation();
			do {
				tempLocation = mvMethod.move(tempLocation);
				if(tempLocation.onTheBoard()) {
					Piece otherPiece = board.getPiece(tempLocation);
					if(otherPiece == null) {
						moveList.add(tempLocation);
						continue;
					} else if (otherPiece.getColor() == getColor()) {
						break;
					} else {
						moveList.add(tempLocation);
						break;
					}
				}
				break;
			} while (true);
		}
		return moveList;
	}
}
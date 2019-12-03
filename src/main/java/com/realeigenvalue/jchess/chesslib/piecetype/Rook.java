package com.realeigenvalue.jchess.chesslib.piecetype;

import java.util.ArrayList;
import com.realeigenvalue.jchess.chesslib.ChessBoard;
import com.realeigenvalue.jchess.chesslib.Location;
import com.realeigenvalue.jchess.chesslib.Piece;
import com.realeigenvalue.jchess.chesslib.PieceColor;
import com.realeigenvalue.jchess.chesslib.movetype.MoveDown;
import com.realeigenvalue.jchess.chesslib.movetype.MoveLeft;
import com.realeigenvalue.jchess.chesslib.movetype.MoveMethod;
import com.realeigenvalue.jchess.chesslib.movetype.MoveRight;
import com.realeigenvalue.jchess.chesslib.movetype.MoveUp;

public class Rook extends Piece {
	private static final MoveMethod[] ROOK_MOVES = {new MoveUp(), new MoveDown(), new MoveLeft(), new MoveRight()};
	public Rook(PieceColor color, Location location, boolean taken) {
		super(color, location, taken);
	}
	@Override
	public ArrayList<Location> getMoveList(ChessBoard board) {
		if(board == null) {
			return new ArrayList<Location>();
		}
		ArrayList<Location> moveList = new ArrayList<Location>();
		for(MoveMethod mvMethod : ROOK_MOVES) {
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
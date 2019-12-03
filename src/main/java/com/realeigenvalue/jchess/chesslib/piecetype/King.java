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
import com.realeigenvalue.jchess.chesslib.movetype.MoveDown;
import com.realeigenvalue.jchess.chesslib.movetype.MoveLeft;
import com.realeigenvalue.jchess.chesslib.movetype.MoveMethod;
import com.realeigenvalue.jchess.chesslib.movetype.MoveRight;
import com.realeigenvalue.jchess.chesslib.movetype.MoveUp;

public class King extends Piece {
	private static final MoveMethod[] KING_MOVES = {new MoveUp(), new MoveDown(), new MoveLeft(), new MoveRight(),
                                                    new MoveDiagNW(), new MoveDiagNE(), new MoveDiagSW(), new MoveDiagSE()};
	public King(PieceColor color, Location location, boolean taken) {
		super(color, location, taken);
	}
	@Override
	public ArrayList<Location> getMoveList(ChessBoard board) {
		if(board == null) {
			return new ArrayList<Location>();
		}
		ArrayList<Location> moveList = new ArrayList<Location>();
		for(MoveMethod mvMethod : KING_MOVES) {
			Location tempLocation = mvMethod.move(getLocation());
			if(tempLocation.onTheBoard()) {
				Piece otherPiece = board.getPiece(tempLocation);
				if(otherPiece == null) {
					moveList.add(tempLocation);
				} else if (otherPiece.getColor() == getColor()) {
					//do nothing
				} else {
					moveList.add(tempLocation);
				}
			}
		}
		return moveList;
	}
}
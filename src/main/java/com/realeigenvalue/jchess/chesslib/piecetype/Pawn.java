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
import com.realeigenvalue.jchess.chesslib.movetype.MoveMethod;
import com.realeigenvalue.jchess.chesslib.movetype.MoveUp;
 
public class Pawn extends Piece {
	private static final MoveMethod[] BLACK_PAWN_MOVES = {new MoveUp(), new MoveDiagNW(), new MoveDiagNE()};
	private static final MoveMethod[] WHITE_PAWN_MOVES = {new MoveDown(), new MoveDiagSW(), new MoveDiagSE()};
	private int moveCounter;
	public Pawn(PieceColor color, Location location, boolean taken) {
		super(color, location, taken);
		moveCounter = 0;
	}
	public int getMoveCounter() {
		return moveCounter;
	}
	public void incrementMoveCounter() {
		moveCounter++;
	}
	public void decrementMoveCounter() {
		moveCounter--;
	}
	@Override
	public ArrayList<Location> getMoveList(ChessBoard board) {
		if(board == null) {
			return new ArrayList<Location>();
		}
		ArrayList<Location> moveList = new ArrayList<Location>();
		MoveMethod[] pawnMoves = (getColor() == PieceColor.BLACK) ? BLACK_PAWN_MOVES : WHITE_PAWN_MOVES;
		Location forward = pawnMoves[0].move(getLocation());
		Location forward2 = pawnMoves[0].move(forward);
		Location leftDiag = pawnMoves[1].move(getLocation());
		Location rightDiag = pawnMoves[2].move(getLocation());
		Piece forwardPiece = board.getPiece(forward);
		Piece forward2Piece = board.getPiece(forward2);
		Piece leftDiagPiece = board.getPiece(leftDiag);
		Piece rightDiagPiece = board.getPiece(rightDiag);
		if(forwardPiece == null) {
			if(forward.onTheBoard()) moveList.add(forward);
			if(moveCounter == 0 && forward2Piece == null) {
				if(forward2.onTheBoard()) moveList.add(forward2);
			}
		}
		if(leftDiagPiece != null && leftDiagPiece.getColor() != getColor()) {
			if(leftDiag.onTheBoard()) moveList.add(leftDiag);
		}
		if(rightDiagPiece != null && rightDiagPiece.getColor() != getColor()) {
			if(rightDiag.onTheBoard())moveList.add(rightDiag);
		}
		return moveList;
	}
}
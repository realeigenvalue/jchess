package com.realeigenvalue.jchess.chesslib;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

public class ChessBoard {
	private ConcurrentHashMap<Location, Piece> chessBoard;
	public ChessBoard(ArrayList<Piece> pieces) {
		chessBoard = new ConcurrentHashMap<Location, Piece>();
		if(pieces != null) {
			for(Piece piece : pieces) {
				chessBoard.put(piece.getLocation(), piece);
			}
		}
	}
	public ChessBoard(ChessBoard otherBoard) {
		this.chessBoard = (otherBoard == null) ? new ConcurrentHashMap<Location, Piece>() : new ConcurrentHashMap<Location, Piece>(otherBoard.chessBoard);

	}
	public Piece getPiece(Location location) {
		return chessBoard.get(location);
	}
	public Collection<Piece> getPieces() {
		return chessBoard.values();
	}
	public Piece movePiece(Piece piece, Location destination) {
		if(piece == null || destination == null) {
			return null;
		}
		chessBoard.remove(piece.getLocation());
		Piece oldPiece = chessBoard.put(destination, piece);
		piece.setLocation(destination);
		return oldPiece;
	}
}
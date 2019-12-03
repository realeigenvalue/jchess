package com.realeigenvalue.jchess.chesslib;

import java.util.ArrayList;

public final class ChessGame {
	public static boolean isStaleMate(ChessBoard chessBoard, Piece yourKing) {
		if(chessBoard == null || yourKing == null) {
			return false;
		}
		return !isCheck(chessBoard, yourKing) && !findLegalMove(chessBoard, yourKing);
	}
	public static boolean isCheckMated(ChessBoard chessBoard, Piece yourKing) {
		if(chessBoard == null || yourKing == null) {
			return false;
		}
		return isCheck(chessBoard, yourKing) && !findLegalMove(chessBoard, yourKing);
	}
	public static boolean findLegalMove(ChessBoard chessBoard, Piece yourKing) {
		if(chessBoard == null || yourKing == null) {
			return false;
		}
		ChessBoard copyBoard = new ChessBoard(chessBoard);
		for(Piece piece : copyBoard.getPieces()) {
			if(piece.getColor() == yourKing.getColor()) {
				ArrayList<Location> possibleMoves = piece.getMoveList(chessBoard);
				for(Location checkLocation : possibleMoves) {
					if(!wouldCheck(chessBoard, piece, checkLocation, yourKing)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	public static boolean isCheck(ChessBoard chessBoard, Piece yourKing) {
		if(chessBoard == null || yourKing == null) {
			return false;
		}
		for(Piece otherPiece : chessBoard.getPieces()) {
			if(otherPiece.getColor() != yourKing.getColor()) {
				ArrayList<Location> otherPieceMoveList = otherPiece.getMoveList(chessBoard);
				for(Location location : otherPieceMoveList) {
					if(location.equals(yourKing.getLocation())) {
						return true;
					}
				}
			}
		}
		return false;
	}
	public static boolean wouldCheck(ChessBoard chessBoard, Piece piece, Location destination, Piece yourKing) {
		if(chessBoard == null || piece == null || destination == null || yourKing == null) {
			return false;
		}
		Location oldLocation = new Location(piece.getLocation());
		Piece oldPiece = chessBoard.movePiece(piece, destination);
		boolean result = isCheck(chessBoard, yourKing);
		chessBoard.movePiece(piece, oldLocation);
		if(oldPiece != null) {
			chessBoard.movePiece(oldPiece, destination);
		}
		return result;
	}
}
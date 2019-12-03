package com.realeigenvalue.jchess.chesslib;

import java.util.ArrayList;

public class Player {
	private String name;
	private PieceColor side;
	private ArrayList<Piece> capturedPieces;
	private int score;
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = (score < 0) ? 0 : score;
	}
	public Player(String name, PieceColor side) {
		this.name = (name == null) ? "" : name;
		this.side = (side == null) ? PieceColor.NULL : side;
		capturedPieces = new ArrayList<Piece>();
		score = 0;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = (name == null) ? "" : name;
	}
	public PieceColor getSide() {
		return side;
	}
	public void setSide(PieceColor side) {
		this.side = (side == null) ? PieceColor.NULL : side;
	}
	public ArrayList<Piece> getCapturedPieces() {
		return capturedPieces;
	}
	public void setCapturedPieces(ArrayList<Piece> capturedPieces) {
		this.capturedPieces = (capturedPieces == null) ? new ArrayList<Piece>() : capturedPieces;
	}
	public void addCapturedPiece(Piece capturedPiece) {
		if(capturedPiece == null) {
			return;
		}
		capturedPiece.setTaken(true);
		this.capturedPieces.add(capturedPiece);
	}
}
package com.realeigenvalue.jchess.mvc;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;
import com.realeigenvalue.jchess.chesslib.Location;
import com.realeigenvalue.jchess.chesslib.Piece;

public class ChessController {
	private ChessModel chessModel;
	private ChessView chessView;
	private Piece selectedPiece;
	private Location selectedLocation;
	private ChessApp chessApp;
	public void registerChessApp(ChessApp chessApp) {
		this.chessApp = chessApp;
	}
	public Location getSelectedLocation() {
		Location result = new Location(selectedLocation);
		selectedLocation = null;
		return result;
	}
	public Piece getSelectedPiece() {
		return selectedPiece;
	}
	private ActionListener MenuItemExitListener  = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	};
	private ActionListener MenuItemNewGameListener  = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			chessApp.newGameDialog();
		}
	};
	private ActionListener MenuItemForfeitListener  = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			chessApp.forfeitDialog();
		}
	};
	private ActionListener MenuItemUndoListener  = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			chessApp.undo();
		}
	};
	private ActionListener MenuItemAboutListener  = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			chessApp.aboutDialog();
		}
	};
	private MouseAdapter MouseListener = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			Point p = e.getPoint();
			int row = (int) (p.getY() / (chessView.getSurfaceHeight() / 8.0d));
			int column = (int) (p.getX() / (chessView.getSurfaceWidth() / 8.0d));
			if(SwingUtilities.isLeftMouseButton(e)) {
				selectedPiece = chessModel.getChessBoard().getPiece(new Location(row, column));
			} else if(SwingUtilities.isRightMouseButton(e)) {
				selectedLocation = new Location(row, column);
			} else {
				//do nothing
			}
		}
	};
	public ChessController(ChessModel chessModel, ChessView chessView) {
		this.chessModel = chessModel;
		this.chessView = chessView;
		selectedPiece = null;
		selectedLocation = null;
		this.chessView.addMenuItemExitListener(MenuItemExitListener);
		this.chessView.addMenuItemNewGameListener(MenuItemNewGameListener);
		this.chessView.addMenuItemForfeitListener(MenuItemForfeitListener);
		this.chessView.addMenuItemUndoListener(MenuItemUndoListener);
		this.chessView.addMenuItemAboutListener(MenuItemAboutListener);
		this.chessView.addMouseListener(MouseListener);
	}
}
package Controller;

import java.awt.Color;
import java.awt.Image;

import Model.board.Board;

public class BoardController {
	private Board board;
	
	public void generateBoard() {
		board = new Board();
		board.generateBoard();
	}
	
	public void setBoardType(int idspel,int boardType) {
		board.setBoardType(idspel,boardType);
	}
	
	public char getTileResource(int idspel,int x,int y) {
		return board.getTileResource(idspel, x, y);
	}
	
	public char getHarbourResource(int x,int y) {
		return board.getHarbourResource(x, y);
	}
	
	public void finishBoard(int idspel) {
		board.finishBoard(idspel);
	}
	
	public void removeResource(int idspel) {
		board.removeResource(idspel);
	}
	
	public Color getColour(int i, int idspel) {
		return board.getColour(i, idspel);
	}
	
	public Image getImage(int i, int idspel) {
		return board.getImage(i, idspel);
		
	}

	
}

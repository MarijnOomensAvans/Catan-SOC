package Controller;

import java.awt.Color;

import Model.Board;

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
	
	public Color getColour(int i) {
		return board.getColour(i);
	}
	
}

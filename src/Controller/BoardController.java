package Controller;

import Model.Board;

public class BoardController {
	private Board board = new Board();
	
	
	public void setBoardType(int boardType) {
		board.setBoardType(boardType);
	}
	
	public char getTileResource(int idspel,int x,int y) {
		return board.getTileResource(idspel, x, y);
	}
	
	
}

package Controller;

import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import Model.board.Board;
import Model.board.Location;
import Model.board.Tile;

public class BoardController {
	private Board board;
	private LobbyController controller;

	public BoardController() {

	}

	public void generateBoard() {
		board = new Board();
		board.generateBoard();
	}

	public void setBoardType(int idspel, int boardType) {
		board.setBoardType(idspel, boardType);
	}

	public char getTileResource(int idspel, int x, int y) {
		return board.getTileResource(idspel, x, y);
	}

	public char getHarbourResource(int x, int y) {
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

	public ImageIcon getImage(int i, int idspel) {
		return board.getImage(i, idspel);

	}

	public ArrayList<Location> getLocatieKeys() {
		return board.getLocatieKeys();
	}

	public void openLobby() {
		new LobbyController();
	}

	public int getRobberXPosition(int gameid) {
		int position = board.getRobberXPosition(gameid);
		return position;
	}

	public int getRobberYPosition(int gameid) {
		int position = board.getRobberYPosition(gameid);
		return position;
	}

	public void makeCards(int gameid) {
		BankController bc = new BankController(gameid);
	}

	public ArrayList<Tile> getLocationTileKeys() {
		return board.getTileLocationKeys();
	}

	public void setRobberTile(int gameid, int x, int y) {
		board.setRobberTile(gameid, x, y);
	}

}

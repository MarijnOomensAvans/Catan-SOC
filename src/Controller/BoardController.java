package Controller;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import Model.board.Board;
import Model.board.Location;
import Model.board.Tile;

public class BoardController {
	private Board board;

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
		bc.makeCards();
	}

	public ArrayList<Tile> getLocationTileKeys() {
		return board.getTileLocationKeys();
	}

	public void setRobberTile(int gameid, int x, int y) {
		board.setRobberTile(gameid, x, y);
	}
	public int getXTile(int number, int gameid) {
		int i =board.getXTile(number,gameid);
		return i;
	}
	public int getYTile(int number, int gameid) {
		int i =board.getYTile(number,gameid);
		return i;
	}

	public int getBuildingplayer(int x, int y, Integer idspeler) {
		int i =board.getBuildingplayer(x,y,idspeler);
		return i;
	}

	public boolean isVillage(int gameid, int x, int y) {
		boolean b =board.isVillage(gameid,x,y);
		return b;
	}

	public boolean isCity(int playerid, int x, int y) {
		boolean b= board.isCity(playerid,x,y);
		return b;
	}

	public boolean hasRobber(int number,int gameID) {
		return board.hasRobber(number,gameID);
	}

}

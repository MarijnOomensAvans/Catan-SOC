package Model;

import DAL.BoardDal;

public class MainClass {

	public static void main(String[] args) {
		BoardDal boarddal = new BoardDal();
		System.out.println(boarddal.getLocationHarbourResource(6, 10));
	}

}

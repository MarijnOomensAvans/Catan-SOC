package Model.board;

public class City extends PieceModel{
	
	private int victoryPoints = 2;
	
	public City(int keyXFrom,int keyYFrom) {
		this.keyXFrom = keyXFrom;
		this.keyYFrom = keyYFrom;
	}
}

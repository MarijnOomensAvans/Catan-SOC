package Model.board;

public class Village extends PieceModel {
	
	private int victoryPoints = 1;
	
	public Village(int keyXFrom,int keyYFrom) { 
		this.keyXFrom = keyXFrom;
		this.keyYFrom = keyYFrom;
	}
}

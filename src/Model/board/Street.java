package Model.board;

public class Street extends PieceModel{
	private int keyXTo;
	private int keyYTo;
	
	public Street(int keyXFrom,int keyYFrom,int keyXTo,int keyYTo) {
		this.keyXFrom = keyXFrom;
		this.keyYFrom = keyYFrom;
		this.keyXTo = keyXTo;
		this.keyYTo = keyYTo;
	}

	public int getKeyXTo() {
		return keyXTo;
	}

	public void setKeyXTo(int keyXTo) {
		this.keyXTo = keyXTo;
	}

	public int getKeyYTo() {
		return keyYTo;
	}

	public void setKeyYTo(int keyYTo) {
		this.keyYTo = keyYTo;
	}
	
}

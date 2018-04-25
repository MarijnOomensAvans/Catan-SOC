public class NotMainController {
	Dice d = new Dice();
	
	public int[] castDice() {
		d.rollDice();
		return d.getDice();
	}
}
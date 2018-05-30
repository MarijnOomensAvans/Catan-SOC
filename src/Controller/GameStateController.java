package Controller;

import View.gameState.GameStatusFrame;

public class GameStateController {
	
	private GameStatusFrame frame;
	private LobbyController lc;
	
	public GameStateController(LobbyController lc) {
		this.lc = lc;
		frame = new GameStatusFrame(lc);
	}
}

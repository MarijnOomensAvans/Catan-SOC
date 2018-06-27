package Controller;

import View.gameState.GameStatusFrame;

public class GameStateController {
	
	@SuppressWarnings("unused")
	private GameStatusFrame frame;
	@SuppressWarnings("unused")
	private LobbyController lc;
	
	public GameStateController(LobbyController lc) {
		this.lc = lc;
		frame = new GameStatusFrame(lc);
	}
}

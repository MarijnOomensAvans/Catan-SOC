package Controller;

import Model.ingame.GameModel;

public class GameUpdateController implements Runnable {

	private boolean running = false;
	private GameModel model;
	
	public GameUpdateController(GameModel model) {
		this.model = model;
		running = true;
	}
	
	@Override
	public void run() {
		
		while(running) {
			model.update();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}

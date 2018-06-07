package Controller;

import Model.ingame.SpelModel;

public class GameUpdateController implements Runnable {

	private boolean running = false;
	private SpelModel model;
	
	public GameUpdateController(SpelModel model) {
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

package Controller;

import java.util.Observable;

public class LobbyUpdateController extends Observable implements Runnable {
	
	public LobbyUpdateController() {
		Thread thread = new Thread(this);
		thread.start();
	}
	
	@Override
	public void run() {
		while(true) {
			this.setChanged();
			this.notifyObservers();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

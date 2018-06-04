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
			System.out.println("Notified");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

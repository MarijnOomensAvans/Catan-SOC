package Controller;

import Model.InlogModel;
import View.MyFrame;

public class InlogController{

	@SuppressWarnings("unused")
	private MyFrame frame;
	private InlogModel inlogModel;
	
	public InlogController(){
		frame = new MyFrame(this);
		inlogModel = new InlogModel();
	}

	public void buttonPressedRegister() {
		
	}

	public void buttonPressedRegisterCompleet(String username, String password, String passwordVer) {
		if(inlogModel.verifyRegisterInput(username, password, passwordVer)) {
			inlogModel.addAccount(username, password);
		}
	}

	public void buttonPressedCancel() {
		
	}

	public void buttonPressedLogin(String username, String password) {
		inlogModel.login(username, password);
	}
}

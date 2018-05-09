package Controller;

import Model.InlogModel;
import View.InlogFrame;

public class InlogController{

	@SuppressWarnings("unused")
	private InlogFrame frame;
	private InlogModel inlogModel;
	
	public InlogController(){
		frame = new InlogFrame(this);
		inlogModel = new InlogModel(this);
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
	
	public void setWarning(String warning) {
		frame.setWarning(warning);
	}
}

package Controller;

import Model.LoginModel;
import View.LoginFrame;

public class LoginController{

	private LoginFrame frame;
	private LoginModel loginModel;
	
	public LoginController(){
		frame = new LoginFrame(this);
		loginModel = new LoginModel(this);
	}

	public void buttonPressedRegister() {
		
	}

	public void buttonPressedRegisterCompleet(String username, String password, String passwordVer) {
		if(loginModel.verifyRegisterInput(username, password, passwordVer)) {
			loginModel.addAccount(username, password);
		}
	}

	public void buttonPressedCancel() {
		
	}

	public void buttonPressedLogin(String username, String password) {
		loginModel.login(username, password);
	}
	
	public void setWarning(String warning) {
		frame.setWarning(warning);
	}
}

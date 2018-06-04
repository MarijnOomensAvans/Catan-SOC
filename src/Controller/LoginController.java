package Controller;

import Model.LoginModel;
import View.logIn.LoginFrame;

public class LoginController {

	private LoginFrame frame;
	private LoginModel loginModel;
	private static String username;

	public LoginController() {
		frame = new LoginFrame(this);
		loginModel = new LoginModel(this);
	}

	public void buttonPressedRegister() {

	}

	public boolean buttonPressedRegisterCompleet(String username, String password, String passwordVer) {
		if (loginModel.verifyRegisterInput(username, password, passwordVer)) {
			loginModel.addAccount(username, password);
			return true;
		} else {
			return false;
		}
	}


	@SuppressWarnings("static-access")
	public void buttonPressedLogin(String username, String password) {
		if(loginModel.login(username, password)) {
			this.username = username;
			frame.closeScreen();
			new LobbyController();
		}
	}

	public void setWarning(String warning) {
		frame.setWarning(warning);
	}
	
	public static String getUsername() {
		return username;
	}
}

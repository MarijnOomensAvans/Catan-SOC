package Controller;

import Model.LoginModel;
import View.LoginFrame;

public class LoginController {

	@SuppressWarnings("unused")
	private LoginFrame frame;
	private LoginModel loginModel;
	private static String username;

	public LoginController() {
		frame = new LoginFrame(this);
		loginModel = new LoginModel(this);
	}

	public void buttonPressedRegister() {

	}

	public void buttonPressedRegisterCompleet(String username, String password, String passwordVer) {
		if (loginModel.verifyRegisterInput(username, password, passwordVer)) {
			loginModel.addAccount(username, password);
		}
	}

	public void buttonPressedCancel() {

	}

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

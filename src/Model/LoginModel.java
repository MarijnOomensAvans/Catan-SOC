package Model;

import java.util.regex.Pattern;

import Controller.LoginController;
import DAL.LoginDAL;

public class LoginModel {

	private LoginDAL loginDal;
	private LoginController inlogController;

	public LoginModel(LoginController loginController) {
		loginDal = new LoginDAL();
		this.inlogController = loginController;
	}

	public boolean login(String username, String password) {
		if (loginDal.hasUsername(username)) {
			if (loginDal.userHasPassword(username, password)) {
				return true;
			} else {
				System.err.println("Wachtwoord klopt niet");
				inlogController.setWarning("Wachtwoord klopt niet");
				return false;
			}
		} else {
			System.err.println("Username bestaat niet!");
			inlogController.setWarning("Username bestaat niet!");
		}
		return false;
	}

	private boolean verifyPassword(String password, String passwordVer) {
		if (password.equals(passwordVer)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyRegisterInput(String username, String password, String passwordVer) {

		if (Pattern.matches("[a-zA-z0-9]+", username) && Pattern.matches("[a-zA-z0-9]+", password)) { //Check if string only contains allowed characters
			if (username.length() >= 3 && password.length() >= 3) { //Check if username and passwords are of at least length 3
				if (!usernameExists(username)) {
					if (verifyPassword(password, passwordVer)) {
						return true;
					} else {
						System.err.println("Wachtwoorden komen niet overeen");
						inlogController.setWarning("Wachtwoorden komen niet overeen");
					}
				} else {
					System.err.println("Username bestaat al!");
					inlogController.setWarning("Username bestaat al!");
				}
			} else {
				System.err.println("Gebruik minimaal 3 karakters");
				inlogController.setWarning("Gebruik minimaal 3 karakters");
			}
		} else {
			System.err.println("Speciale karakters zijn niet toegestaan.");
			inlogController.setWarning("Speciale karakters zijn niet toegestaan.");
		}
		return false;
	}

	private boolean usernameExists(String username) {
		return loginDal.hasUsername(username);
	}

	public void addAccount(String username, String password) {
		loginDal.addAccount(username, password);
	}

}

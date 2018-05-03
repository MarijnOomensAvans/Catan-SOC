package Model;

import DAL.LoginDAL;

public class InlogModel {

	private LoginDAL loginDal;
	
	public InlogModel() {
		loginDal = new LoginDAL();
	}

	public void login(String username, String password) {
		if(loginDal.hasUsername(username)) {
			if(loginDal.userHasPassword(username, password)) {
				System.out.println("Logged in!");
			} else {
				System.err.println("Wachtwoord klopt niet");
			}
		} else {
			System.err.println("Username bestaat niet!");
		}
	}

	private boolean verifyPassword(String password, String passwordVer) {
		if (password.equals(passwordVer)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyRegisterInput(String username, String password, String passwordVer) {
		
		if(username.length() >= 3 && password.length() >= 3) {
			if(!usernameExists(username)) {
				if(verifyPassword(password, passwordVer)) {
					return true;
				} else {
					System.err.println("Wachtwoorden komen niet overeen");
				}
			} else {
				System.err.println("Username bestaat al!");
			}
		} else {
			System.err.println("Username en wachtwoord moeten minimaal 3 karakters lang zijn");
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

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

	public void buttonPressed() {
		System.out.println("DEBUG");
	}
	
	public void setName(String username) {
		inlogModel.setUsername(username);
	}
	
	public void setPassword (String password) {
		inlogModel.setPassword(password);
	}
}

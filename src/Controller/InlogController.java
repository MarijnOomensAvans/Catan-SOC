package Controller;


import View.MyFrame;

public class InlogController{

	@SuppressWarnings("unused")
	private MyFrame frame;
	
	public InlogController(){
		frame = new MyFrame(this);
	}

	public void buttonPressed() {
		System.out.println("DEBUG");
	}
}

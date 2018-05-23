package View;

import java.awt.Dimension;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class TradeGui extends JFrame {
	
	public TradeGui(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new TradeContentPane());
		setResizable(false);
		setVisible(true);
		this.pack();
		setLocationRelativeTo(null);
	}
		

}

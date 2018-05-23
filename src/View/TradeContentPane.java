package View;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class TradeContentPane extends JPanel {
	
	private BufferedImage myBufferedImage = new BufferedImage(1,1,BufferedImage.TYPE_INT_RGB);
	private File stone;
	private File ore;
	private File wood;
	private File wheat;
	private File wool;
	
	public TradeContentPane() {
		setLayout(new FlowLayout());
		stone = new File("./Images/baksteen.jpg");
		ore = new File("./Images/erts.jpg");
		wood = new File("./Images/hout.jpg");
		wheat = new File("./Images/graan.jpg");
		wool = new File("./Images/schaap.jpg");
		setPreferredSize(new Dimension(500,500));
		setVisible(true);
	}
	
	
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);

	}

}

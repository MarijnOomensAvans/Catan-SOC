package View;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

public class DieContentPane extends JPanel implements ActionListener
{
	private JButton myButton = new JButton("Dobbel");
	private File myFile = new File("./images/one.png");
	private File one;
	private File two;
	private File three;
	private File four;
	private File five;
	private File six;
	private BufferedImage myBufferedImage1 = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
	private BufferedImage myBufferedImage2 = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
	
	public DieContentPane() 
	{
		initFiles();
		this.setLayout(null);
		this.setPreferredSize(new Dimension(400, 300));
		
		myButton.addActionListener(this);
		myButton.setBounds(150, 75, 100, 100);
		
		this.add(myButton);
	}

	public void initFiles()
	{
		one = new File("./images/one.png");
		two = new File("./images/two.png");
		three = new File("./images/three.png");
		four = new File("./images/four.png");
		five = new File("./images/five.png");
		six = new File("./images/six.png");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{		
		// TODO Auto-generated method stub
		int i = (int) (Math.random() * 6) + 1;
		switch (i)
		{
			case 1 :
				setDie1(one);
				break;
			case 2 :
				setDie1(two);
				break;
			case 3 :
				setDie1(three);
				break;
			case 4 :
				setDie1(four);
				break;
			case 5 :
				setDie1(five);
				break;
			case 6 :
				setDie1(six);
				break;
		}
		
		i = (int) (Math.random() * 6) + 1;
		switch (i)
		{
			case 1 :
				setDie2(one);
				break;
			case 2 :
				setDie2(two);
				break;
			case 3 :
				setDie2(three);
				break;
			case 4 :
				setDie2(four);
				break;
			case 5 :
				setDie2(five);
				break;
			case 6 :
				setDie2(six);
				break;
		}
		
	}
	
	public void setDie1(File file)
	{
		myFile = file;
		if(myFile != null)
		{
			try {
				myBufferedImage1 = ImageIO.read(myFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		this.repaint();
	}
	
	public void setDie2(File file)
	{
		myFile = file;
		if(myFile != null)
		{
			try {
				myBufferedImage2 = ImageIO.read(myFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		this.repaint();
	}
	
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(myBufferedImage1, 100, 200, 87, 87, null);
		g.drawImage(myBufferedImage2, 225, 200, 87, 87, null);
	}
}

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

import Controller.DieController;

public class DieContentPane extends JPanel implements ActionListener
{
	private DieController con;
	
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
	
	public DieContentPane(DieController controller) 
	{
		initFiles();
		this.setLayout(null);
		this.setPreferredSize(new Dimension(400, 300));
		
		myButton.addActionListener(this);
		myButton.setBounds(150, 75, 100, 100);
		
		this.add(myButton);
		
		con = controller;
	}

	public void initFiles()
	{	//initialise the die images
		one = new File("./images/one.png");
		two = new File("./images/two.png");
		three = new File("./images/three.png");
		four = new File("./images/four.png");
		five = new File("./images/five.png");
		six = new File("./images/six.png");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{	//roll the dice and tell setDie to change the images
		int i[] = con.rollDice();
		
		for(int itt = 1; itt < 3; itt++) 
		{	//loop for both die
			switch (i[itt - 1])
			{
				case 1 :
					setDie(one, itt);
					break;
				case 2 :
					setDie(two, itt);
					break;
				case 3 :
					setDie(three, itt);
					break;
				case 4 :
					setDie(four, itt);
					break;
				case 5 :
					setDie(five, itt);
					break;
				case 6 :
					setDie(six, itt);
					break;
			}
		}
	}
	
	public void setDie(File file, int img) 
	{	//changes the images of the dice to the new values
		myFile = file;
		if(myFile != null)
		{
			try {
				if (img == 1)
				{
					myBufferedImage1 = ImageIO.read(myFile);
				}
				else if (img == 2)
				{
					myBufferedImage2 = ImageIO.read(myFile);
				}
				}catch (IOException e) {
				System.out.println(e.getMessage());
				}	
		}
		this.repaint();
	}
	
	protected void paintComponent(Graphics g)
	{	//draw the images
		super.paintComponent(g);
		g.drawImage(myBufferedImage1, 100, 200, 87, 87, null);
		g.drawImage(myBufferedImage2, 225, 200, 87, 87, null);
	}
}

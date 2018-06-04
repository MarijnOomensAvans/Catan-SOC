package View.build;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.BuildController;

@SuppressWarnings("serial")
public class BuildContentPane extends JPanel{
	private GridLayout gridLayout = new GridLayout(4,3);
	ImageIcon imageVillage = new ImageIcon("./images/DorpIcon.png");
	ImageIcon imageCity = new ImageIcon("./images/StadIcon.png");
	ImageIcon imageStreet = new ImageIcon("./images/StraatIcon.png");
	ImageIcon imageDevCard = new ImageIcon("./images/OntwikkleingskaartIcon.png");
	private Dimension buttonsize = new Dimension(200,100);
	private BuildController buildcontroller = new BuildController();
	
	
	public BuildContentPane(BuildFrame frame) {
		this.setLayout(gridLayout);
		gridLayout.setVgap(50);
		this.setPreferredSize(new Dimension(500,500));
		//Village
		JLabel villageImage = new JLabel(imageVillage);
		this.add(villageImage);
		JLabel villageResources = new JLabel("H: 1 - B:1 - G:1 - S:1");
		this.add(villageResources);
		JButton villageBuild = new JButton("Build");
		villageBuild.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO punten oplichten
            	frame.closeFrame();
            }
        });
		villageBuild.setPreferredSize(buttonsize);
		this.add(villageBuild);
		//City
		JLabel cityImage = new JLabel(imageCity);
		this.add(cityImage);
		JLabel cityResources = new JLabel("G:2 - E:3");
		this.add(cityResources);
		JButton cityBuild = new JButton("Build");
		cityBuild.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	frame.closeFrame();
            }
        });
		cityBuild.setPreferredSize(buttonsize);
		this.add(cityBuild);
		//Street
		JLabel streetImage = new JLabel(imageStreet);
		this.add(streetImage);
		JLabel streetResources = new JLabel("B:1 - H:1");
		this.add(streetResources);
		JButton streetBuild = new JButton("Build");
		streetBuild.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	frame.closeFrame();
            }
        });
		streetBuild.setPreferredSize(buttonsize);
		this.add(streetBuild);
		//Devcard
		JLabel devCardImage = new JLabel(imageDevCard);
		this.add(devCardImage);
		JLabel devCardResources = new JLabel("G:1 - S:1 - E:1");
		this.add(devCardResources);
		JButton devCardBuild = new JButton("Build");
		devCardBuild.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	frame.closeFrame();
            }
        });
		devCardBuild.setPreferredSize(buttonsize);
		this.add(devCardBuild);

		
	}



}

package View.build;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.BankController;
import Controller.BuildController;
import Controller.PlayerController;
import View.setupGame.DrawingPanel;

@SuppressWarnings("serial")
public class BuildContentPane extends JPanel{
	private GridLayout gridLayout = new GridLayout(4,3);
	ImageIcon imageVillage = new ImageIcon(ClassLoader.getSystemResource("DorpIcon.png"));
	ImageIcon imageCity = new ImageIcon(ClassLoader.getSystemResource("StadIcon.png"));
	ImageIcon imageStreet = new ImageIcon(ClassLoader.getSystemResource("StraatIcon.png"));
	ImageIcon imageDevCard = new ImageIcon(ClassLoader.getSystemResource("OntwikkleingskaartIcon.png"));
	private Dimension buttonsize = new Dimension(200,100);
	@SuppressWarnings("unused")
	private BuildController buildcontroller;
	@SuppressWarnings("unused")
	private PlayerController pc;
	private String buildingType;
		
	
	public BuildContentPane(BuildFrame frame,PlayerController pc, DrawingPanel inGameBoard, BankController bc, int playerid) {
		buildcontroller = new BuildController();
		this.pc = pc;
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
            	buildingType = "Village";
                inGameBoard.setBuild(true, buildingType);
            	frame.closeFrame();

            }
        });
		if(!(pc.hasStoneCards(1) && pc.hasWheatCards(1) && pc.hasWoodCards(1) && pc.hasWoolCards(1))) {
			villageBuild.setEnabled(false);
		}
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
            	buildingType = "City";
                inGameBoard.setBuild(true, buildingType);
            	frame.closeFrame();
            }
        });
		if(!(pc.hasOreCards(3) && pc.hasWheatCards(2))) {
			cityBuild.setEnabled(false);
		}
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
            	buildingType = "Street";
                inGameBoard.setBuild(true, buildingType);
            	frame.closeFrame();
            }
        });
		if(!(pc.hasStoneCards(1) && pc.hasWoodCards(1))) {
			streetBuild.setEnabled(false);
		}
		streetBuild.setPreferredSize(buttonsize);
		this.add(streetBuild);
		//Devcard
		JLabel devCardImage = new JLabel(imageDevCard);
		this.add(devCardImage);
		JLabel devCardResources = new JLabel("G:1 - S:1 - E:1");
		this.add(devCardResources);
		JButton devCardBuild = new JButton("Build");
		if (bc.isOutofcards(pc.getGameid())) {
			devCardBuild.setEnabled(false);
		}
		devCardBuild.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	bc.isOutofcards(pc.getGameid());
            	String iddev = (bc.getDevelopmentCard(pc.getGameid()).getIdDevCard());
            	pc.giveDevCardPlayer(playerid, iddev, pc.getGameid());
            	buildingType = "DevCard";
                inGameBoard.setBuild(true, buildingType);
            	frame.closeFrame();
            }
        });
		if(!(pc.hasWoodCards(1) && pc.hasWheatCards(1) && pc.hasOreCards(1))) {
			devCardBuild.setEnabled(false);
		}
		devCardBuild.setPreferredSize(buttonsize);
		this.add(devCardBuild);

		
	}



}

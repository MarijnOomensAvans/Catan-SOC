package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import javafx.scene.control.ComboBox;

public class InvitePanel extends JPanel {

	private final int WIDTH = 1000;
	private final int HEIGHT = 50;

	private JComboBox box1;
	private JComboBox box2;
	private JComboBox box3;
	
	private String box1Selected;
	private String box2Selected;
	private String box3Selected;


	private ArrayList<String> names;

	public InvitePanel(LobbyContentPane pane) {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setBackground(new Color(200, 200, 200, 255));

		names = pane.getUsernames();

		box1 = new JComboBox(names.toArray());
		box2 = new JComboBox(names.toArray());
		box3 = new JComboBox(names.toArray());
		
		box1.setSelectedIndex(-1);
		box2.setSelectedIndex(-1);
		box3.setSelectedIndex(-1);

		add(box1);
		add(box2);
		add(box3);

		box1.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					
					box1Selected = box1.getSelectedItem().toString();
					System.out.println(box1Selected);
				}

			}
		});
		box2.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					box2Selected = box2.getSelectedItem().toString();
					System.out.println(box2Selected);
				}

			}
		});
		box3.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					box3Selected = box3.getSelectedItem().toString();
					System.out.println(box3Selected);
				}

			}
		});
	}

}

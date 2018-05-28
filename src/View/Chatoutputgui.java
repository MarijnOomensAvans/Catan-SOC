
package View;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;

import Controller.ChatController;



@SuppressWarnings("serial")
public class Chatoutputgui extends JPanel implements Observer {
	
	private JTextArea output;
	 JScrollPane scroll;

	
	public Chatoutputgui(ChatController control, int playerid) {
		output = new JTextArea(21,37);
		scroll = new JScrollPane(output,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		 DefaultCaret caret = (DefaultCaret)output.getCaret();
		 caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

		output.setEditable(false);
		
		add(scroll);
	}
	

	@Override
	public void update(Observable o, Object arg) {
		
		if(arg != null)
		{
			for(int i = 0; i < ((ArrayList<String>) arg).size(); i++)
			{
				output.append(((ArrayList<String>) arg).get(i));
			}
		}
	}

}

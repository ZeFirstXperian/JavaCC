package mez.javacc.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuListener implements ActionListener {
	
	public void actionPerformed(ActionEvent event) {
		
		System.out.println(event.getActionCommand());
		if(event.getActionCommand() == "Exit") System.exit(0);
		
	}
	
}
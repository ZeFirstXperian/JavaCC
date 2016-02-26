package mez.javacc.components;

import javax.swing.JOptionPane;

public class GameReset extends JOptionPane {

	private static final long serialVersionUID = 1L;
	
	public GameReset() {
		
		setMessage("Starting a new game will begin you back at level 1, reset your score to zero, and forget the passwords to any levels you have visited.\nIs this what you want?");
		setMessageType(JOptionPane.QUESTION_MESSAGE);
		setOptionType(JOptionPane.YES_NO_OPTION);
		
	}
	
}
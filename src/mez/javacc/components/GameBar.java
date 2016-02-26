package mez.javacc.components;

import java.awt.Toolkit;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;

import com.sun.glass.events.KeyEvent;

import mez.javacc.listeners.MenuListener;

public class GameBar extends JMenuBar {

	private static final long serialVersionUID = 1L;
	
	private JCheckBoxMenuItem[] optionsI = {new JCheckBoxMenuItem("Background Music"), new JCheckBoxMenuItem("Sound Effects"),
	new JCheckBoxMenuItem("Color")};
	private JMenu game = new JMenu("Game"), options = new JMenu("Options"), level = new JMenu("Level"), help = new JMenu("Help");
	private JMenuItem[] gameI = {new JMenuItem("New Game", 'N'), new JMenuItem("Pause", 'P'), new JMenuItem("Best Times", 'T'),
	new JMenuItem("Exit", 'x')},
	levelI = {new JMenuItem("Restart", 'R'), new JMenuItem("Next", 'N'), new JMenuItem("Previous", 'P'), new JMenuItem("Go To...", 'G')},
	helpI = {new JMenuItem("Contents", 'C'), new JMenuItem("How to Play", 'H'), new JMenuItem("Commands", 'O'), new JMenuItem("How to Use Help", 'U'),
	new JMenuItem("About Chip's Challenge...", 'A')};
	
	public GameBar() {
		
		game.setMnemonic('G');
		gameI[0].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0));
		gameI[0].addActionListener(new MenuListener());
		game.add(gameI[0]);
		gameI[1].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0));
		gameI[1].addActionListener(new MenuListener());
		game.add(gameI[1]);
		gameI[2].addActionListener(new MenuListener());
		gameI[2].setDisplayedMnemonicIndex(5);
		game.add(gameI[2]);
		game.add(new JSeparator());
		gameI[3].addActionListener(new MenuListener());
		game.add(gameI[3]);
		add(game);
		
		options.setMnemonic('O');
		optionsI[0].setMnemonic('B');
		optionsI[0].addActionListener(new MenuListener());
		options.add(optionsI[0]);
		optionsI[1].setMnemonic('S');
		optionsI[1].addActionListener(new MenuListener());
		options.add(optionsI[1]);
		optionsI[2].setMnemonic('C');
		optionsI[2].setSelected(true);
		optionsI[2].addActionListener(new MenuListener());
		options.add(optionsI[2]);
		add(options);
		
		level.setMnemonic('L');
		levelI[0].setAccelerator(KeyStroke.getKeyStroke('R', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
		levelI[0].addActionListener(new MenuListener());
		level.add(levelI[0]);
		levelI[1].addActionListener(new MenuListener());
		levelI[1].setAccelerator(KeyStroke.getKeyStroke('P', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
		level.add(levelI[1]);
		levelI[2].addActionListener(new MenuListener());
		levelI[2].setAccelerator(KeyStroke.getKeyStroke('N', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
		level.add(levelI[2]);
		levelI[3].addActionListener(new MenuListener());
		level.add(levelI[3]);
		add(level);
		
		help.setMnemonic('H');
		helpI[0].setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		helpI[0].addActionListener(new MenuListener());
		help.add(helpI[0]);
		helpI[1].addActionListener(new MenuListener());
		help.add(helpI[1]);
		helpI[2].addActionListener(new MenuListener());
		help.add(helpI[2]);
		helpI[3].addActionListener(new MenuListener());
		help.add(helpI[3]);
		help.add(new JSeparator());
		helpI[4].addActionListener(new MenuListener());
		help.add(helpI[4]);
		add(help);
		
	}
	
	public JMenuItem getGame(int i) { return gameI[i]; }
	
	public JMenuItem getOptions(int i) { return optionsI[i]; }
	
	public JMenuItem getLevel(int i) { return levelI[i]; }
	
	public JMenuItem getHelp(int i) { return helpI[i]; }
	
}
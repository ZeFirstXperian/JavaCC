package mez.javacc;

import java.awt.Dimension;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import mez.javacc.components.GameBar;
import mez.javacc.info.GameInfo;
import nope.javacc.others.TiledImage;

public class Window extends JFrame implements Runnable {
	
	private static final long serialVersionUID = 1L;
	private static final String DEFAULT_GAME_TITLE = "Chip's Challenge";
	
	private boolean running = false;
	private GameInfo info = new GameInfo();
	private JPanel panel;
	private Thread mini = new Thread(this);
	
	public Window(String title, int width, int height) {
		
		super(title);
		try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); }
		catch(ClassNotFoundException clfe) { clfe.printStackTrace(); }
		catch(InstantiationException ie) { ie.printStackTrace(); }
		catch(IllegalAccessException iae) { iae.printStackTrace(); }
		catch(UnsupportedLookAndFeelException ulafe) { ulafe.printStackTrace(); }
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		try {
			
			setIconImage(ImageIO.read(new File("res/icon.png")));
			panel = new TiledImage(ImageIO.read(new File("res/back.png")), true);
			
		}
		
		catch(IOException ioe) { ioe.printStackTrace(); }
		setSize(new Dimension(width, height));
		setContentPane(panel);
		setJMenuBar(new GameBar());
		
		setVisible(true);
		
	}
	
	private void paint() {}

	private void logic() {
		
		info.update();
		
	}
	
	public static void main(String[] args) {
		
		Window window = new Window("Chip's Challenge", 528, 413);
		window.start();
		
	}
	
	public synchronized void start() {
		
		if(running) return;
		running = true;
		mini.start();
		
	}

	public synchronized void stop() {
		
		if(!running) return;
		running = false;
		try { mini.join(); }
		catch (InterruptedException ie) { ie.printStackTrace(); }
		
	}
	
	public String getDefaultTitle() { return DEFAULT_GAME_TITLE; }
	
	public void run() {
		
		while(running) {
			
			logic();
			paint();
			
		}
		
	}
	
}
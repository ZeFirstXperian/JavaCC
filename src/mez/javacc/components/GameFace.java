package mez.javacc.components;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GameFace extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private BufferedImage face;
	private Canvas game = new Canvas();
	
	public GameFace() {
		
		try { face = ImageIO.read(new File("res/bolted.png")); }
		catch(IOException ioe) { ioe.printStackTrace(); }
		setOpaque(false);
		setSize(508, 410);
		setLayout(null);
		
		game.setBounds(30, 30, 290, 290);
		game.setPreferredSize(new Dimension(288, 288));
		game.setBackground(Color.black);
		game.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		add(game);
		
	}
	
	public void paintComponent(Graphics paint) {
		
		super.paintComponent(paint);
		paint.drawImage(face, 26, 26, null);
		
	}
	
}
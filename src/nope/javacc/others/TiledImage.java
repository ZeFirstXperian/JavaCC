package nope.javacc.others;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import mez.javacc.components.GameFace;

/**Anything under nope.javacc is not my code entirely, but is modified (slightly) to work as such.
@see <a href="http://stackoverflow.com/questions/16750709/how-can-i-add-repeat-background-image-in-jframe">How can I add repeat background image in JFrame? - Stack Overflow</a>*/
public class TiledImage extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private boolean canTile;
	private Image tiledImage;
	private static JPanel face = new GameFace();
	
	public TiledImage(Image image, boolean tile) {
		
		tiledImage = image;
		canTile = tile;
		setLayout(new BorderLayout());
		add(new GameFace());
		
	}
	
	public static JPanel getFace() { return face; }
	
	public void paintComponent(Graphics paint) {
		
		super.paintComponent(paint);
		
		if (canTile) {
			
			int iw = tiledImage.getWidth(this),
			ih = tiledImage.getHeight(this);
			
			if (iw > 0 && ih > 0) {
				
				for (int x = 0; x < getWidth(); x += iw) {
					
					for (int y = 0; y < getHeight(); y += ih) paint.drawImage(tiledImage, x, y, iw, ih, this);
					
				}
				
			}
			
		}
		
		else paint.drawImage(tiledImage, 0, 0, getWidth(), getHeight(), this);
    }
	
}
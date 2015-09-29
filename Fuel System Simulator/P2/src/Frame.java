import java.awt.Color;
import java.awt.Graphics;

/**
 * The class has the frame of the system.
 * @author Kevin
 *
 */
public class Frame {
	int positionX = ShapesMotion.positionX;
	int positionY = ShapesMotion.positionY;

	Color newColor;
	
	/**
	 * The constructor create a new frame in a specific position.
	 * 
	 * @param x
	 *            is the position on x axis where the frmae will be
	 *            positioned
	 * @param y
	 *            is the position on y axis where the frame will be
	 *            positioned
	 */
	public Frame(int x, int y){
		this.positionX = x;
		this.positionY = y;
	}
	
	/**
	 * The method draws the frame of the system.
	 * @param g
	 */
	public void frame(Graphics g) {
		int pixel = 0;
		int i = 0;

		g.setColor(Color.white);
		g.fillRect(0, 0, 10000, 10000);

		g.setColor(Color.black);
		for (i = 0, pixel = 0; i < 150; i++) {
			g.fillRect(pixel + positionX, positionY, 3, 3);
			g.fillRect(pixel + positionX, positionY + 500, 3, 3);

			if (i < 100) {
				g.fillRect(positionX, pixel + positionY, 3, 3);
				g.fillRect(positionX + 745, pixel + positionY, 3, 3);
			}
			pixel += 5;
		}
	}
}

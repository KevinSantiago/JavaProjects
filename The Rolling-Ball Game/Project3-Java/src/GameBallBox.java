
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * The class {@link GameBallBox} create the frame where the balls are allocated.
 * 
 * @author Kevin
 *
 */
public class GameBallBox {

	private int x;
	private int y;
	private int length;
	private boolean visibility;

	/**
	 * The {@link GameBallBox} constructor create a baox with the coordinates and  dimensions.
	 * @param x
	 * @param y
	 * @param lenght
	 * @param visibility
	 */
	public GameBallBox(int x, int y, int lenght, boolean visibility) {
		this.x = x;
		this.y = y;
		this.length = lenght;
		this.visibility = visibility;
	}

	/**
	 * The method box draws the box of the game.
	 * @param g
	 */
	public void box(Graphics g) {
		if (visibility) {
			Graphics2D g2 = (Graphics2D) g;
			g2.setColor(Color.white);
			g2.fillRect(-2, -2, 5000, 5000);
			g2.setColor(Color.black);
			g2.drawRect(x - 1, y - 1, length + 2, length + 2);
			g2.drawRect(x, y, length, length);
		}
	}
}
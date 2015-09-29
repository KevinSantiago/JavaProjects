
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * The class {@link ScoreBar} draws the score box that is displayed in the game.
 * 
 * @author Kevin
 *
 */
public class ScoreBar {

	private int x;
	private int y;
	private boolean visibility;

	/**
	 * The {@link ScoreBar} constructor create a new box in a specific position.
	 * 
	 * @param x
	 * @param y
	 * @param visibility
	 */
	public ScoreBar(int x, int y, boolean visibility) {
		this.x = x;
		this.y = y;
		this.visibility = visibility;
	}

	/**
	 * The method scoreBar draws the box with the scores, distances and names.
	 * 
	 * @param g
	 */
	public void scoreBar(Graphics g) {
		if (visibility) {
			Graphics2D g2 = (Graphics2D) g;

			g2.setColor(new Color(205, 133, 63));
			g2.fillRect(x + 800, y + 200, 300, 30);

			g2.setColor(new Color(0, 205, 0));
			g2.fillRect(x + 800, y + 230, 300, 30);

			g2.setColor(new Color(0, 145, 225));
			g2.fillRect(x + 800, y + 260, 300, 30);

			g2.setColor(Color.black);
			g2.setFont(new Font("Arial", Font.BOLD, 14));
			g2.drawString("PLAYER", x + 815, y + 220);
			g2.drawString(Update.getPlayer1(), x + 815, y + 250);
			g2.drawString(Update.getPlayer2(), x + 815, y + 280);

			g2.drawString("SCORE", x + 920, y + 220);
			g2.drawString("" + Update.getScore1(), x + 940, y + 250);
			g2.drawString("" + Update.getScore2(), x + 940, y + 280);

			g2.drawString("DISTANCE", x + 1010, y + 220);
			g2.drawString("" + Update.getDistance1(), x + 1030, y + 250);
			g2.drawString("" + Update.getDistance2(), x + 1030, y + 280);
		}
	}
}

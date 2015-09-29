
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 * The class {@link GameCoverPage} draw the game intro an home page.
 * 
 * @author Kevin
 *
 */
public class GameCoverPage {

	PlayNewGame newGame = new PlayNewGame();
	private int x, y;
	private int width, height;
	private boolean visibility;

	/**
	 * The {@link GameCoverPage} create a new cover with the specifications.
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param visibility
	 */
	public GameCoverPage(int x, int y, int width, int height, boolean visibility) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.visibility = visibility;
	}

	/**
	 * 
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * 
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * 
	 * @param g
	 */
	public void coverPage(Graphics g) {
		if (!visibility) {
			int shadowPosX = (width / 2 - 180) + 7;
			int shadowPosY = (height / 2 - 180) + 7;
			int wordPosX = width / 2 - 180;
			int wordPosY = height / 2 - 150;
			int displace = 0;

			String[] s = { "The", "Rolling-Ball", "Game" };

			// Set Backgroud color
			g.setColor(Color.white);
			g.fillRect(-2, -2, width + 120, height + 120);

			// create works shadow
			g.setColor(new Color(180, 180, 180));
			g.setFont(new Font("Eras Bold ITC", Font.BOLD, 54));

			for (int i = 0; i < s.length; i++, y += 50) {
				if (i == 0)
					displace = 40;
				else if (i == 1)
					displace = 0;
				else
					displace = 60;

				g.drawString(s[i], shadowPosX - x + displace, shadowPosY + y);
			}

			shadowPosX -= 5;
			shadowPosY += 30;

			g.setFont(new Font("Arial", Font.PLAIN, 19));
			g.drawString("by", shadowPosX - x - 60, shadowPosY + 280);

			g.setFont(new Font("Arial", Font.ITALIC, 19));
			g.drawString("Kevin Santiago", shadowPosX - x - 35,
					shadowPosY + 280);

			// create solid words
			y = 0;

			g.setColor(Color.black);
			g.setFont(new Font("Eras Bold ITC", Font.BOLD, 54));

			for (int i = 0; i < s.length; i++, y += 50) {
				if (i == 0)
					displace = 40;
				else if (i == 1)
					displace = 0;
				else
					displace = 60;

				g.drawString(s[i], wordPosX - x + displace, wordPosY + y);
			}

			g.setFont(new Font("Arial", Font.PLAIN, 19));
			g.drawString("by", wordPosX - x - 60, wordPosY + 280);

			g.setFont(new Font("Arial", Font.ITALIC, 19));
			g.drawString("Kevin Santiago", wordPosX - x - 35, wordPosY + 280);
		} else
			g.setColor(Color.WHITE);
		g.drawRect(-2, -2, width + 120, height + 120);
	}
}

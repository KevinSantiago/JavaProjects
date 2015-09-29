
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.IOException;


/**
 * The class {@link GameOver} draws the Game Over String on screen and send the
 * game data to the file.
 * 
 * @author Kevin
 *
 */
public class GameOver {

	public void gameOver(Graphics g) {
		int x = GameWindow.frameXLocation;
		x += GameWindow.width / 2;
		int y = GameWindow.frameYLocation;
		y += GameWindow.height / 2;

		g.setColor(Color.black);
		g.setFont(new Font("Eras Bold ITC", Font.BOLD, 54));

		g.drawString("Game Over", x / 2, y / 2);
	}

	public void report(String player1, String player2, int scorePlayer1,
			int scorePlayer2, String date) throws IOException {
		HistoryFileManager history = new HistoryFileManager();

		String score1 = "" + scorePlayer1;
		String score2 = "" + scorePlayer2;
		history.createFile();
		history.writeFile(player1, player2, score1, score2, date);
	}
}

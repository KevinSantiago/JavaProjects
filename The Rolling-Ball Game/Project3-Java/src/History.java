
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;

/**
 * The class {@link History} create the history to be displayed.
 * 
 * @author Kevin
 *
 */
@SuppressWarnings("serial")
public class History extends JFrame implements ActionListener {

	private HistoryFileManager historyFile;
	private String whichItem;
	private ArrayList<String> player1 = new ArrayList<String>();
	private ArrayList<String> score1 = new ArrayList<String>();
	private ArrayList<String> date = new ArrayList<String>();
	private ArrayList<String> player2 = new ArrayList<String>();
	private ArrayList<String> score2 = new ArrayList<String>();

	/**
	 * The constructor receive a string that determines which table going to use.
	 * @param whichOne
	 */
	public History(String whichOne) {
		this.whichItem = whichOne;
	}

	/**
	 * The method calls the historyFile to display it in the frame.
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		historyFile = new HistoryFileManager();
		try {
			historyFile.createFile();
			historyFile.readFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		player1.clear();
		player2.clear();
		score1.clear();
		score2.clear();
		date.clear();
		player1.addAll(historyFile.getPlayer1());
		player2.addAll(historyFile.getPlayer2());
		score1.addAll(historyFile.getScore1());
		score2.addAll(historyFile.getScore2());
		date.addAll(historyFile.getDates());

		if (whichItem.compareTo("highest") == 0) {
			try {
				String[] columnNames = { "Player", "Date", "High Score",
						"Opponent", "Opponent Score" };
				ScoresTable table = new ScoresTable(player1, score1, date,
						player2, score2);
				table.bestScores();
				table.displayTable(columnNames, true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			;
		} else if (whichItem.compareTo("allgame") == 0 || true) {
			String[] columnNames = { "Player 1", "Score 1", "Player 2",
					"Score 2", "Date" };
			new ScoresTable(player1, score1, date, player2, score2)
					.displayTable(columnNames, false);
		}
	}

}

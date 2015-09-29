
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultRowSorter;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 * Score table show all the history of best score of the players and all games
 * played since the first game until the last one.
 * 
 * @author Kevin
 *
 */
public class ScoresTable extends JFrame {

	private ArrayList<String> playerBest = new ArrayList<String>();
	private ArrayList<String> scoreBest = new ArrayList<String>();
	private ArrayList<String> dateBest = new ArrayList<String>();
	private ArrayList<String> opponent = new ArrayList<String>();
	private ArrayList<String> opponentScore = new ArrayList<String>();

	private ArrayList<String> player1 = new ArrayList<String>();
	private ArrayList<String> score1 = new ArrayList<String>();
	private ArrayList<String> date = new ArrayList<String>();
	private ArrayList<String> player2 = new ArrayList<String>();
	private ArrayList<String> score2 = new ArrayList<String>();

	public ScoresTable(ArrayList<String> player1, ArrayList<String> score1,
			ArrayList<String> date, ArrayList<String> player2,
			ArrayList<String> score2) {
		this.player1 = player1;
		this.score1 = score1;
		this.date = date;
		this.player2 = player2;
		this.score2 = score2;
	}

	/**
	 * The method displayTable display the table on the JFrame and sort the
	 * information as the user wants.
	 * 
	 * @param columnNames
	 * @param isBestScore
	 */
	public void displayTable(String[] columnNames, boolean isBestScore) {
		String[] columns = columnNames;
		int numColumns = columns.length;
		int numRows = player1.size();

		if (!(numRows == 0)) {
			String[][] rows = new String[numRows][];
			for (int i = 0; i < numRows; i++)
				rows[i] = new String[numColumns];

			if (isBestScore) {
				for (int i = 0; i < numRows; i++)
					for (int j = 0; j < numColumns; j++) {
						if (j == 0)
							rows[i][j] = player1.get(i);
						else if (j == 1)
							rows[i][j] = date.get(i);
						else if (j == 2)
							rows[i][j] = score1.get(i);
						else if (j == 3)
							rows[i][j] = player2.get(i);
						else if (j == 4)
							rows[i][j] = score2.get(i);
					}
			} else {
				for (int i = 0; i < numRows; i++)
					for (int j = 0; j < numColumns; j++) {
						if (j == 0)
							rows[i][j] = player1.get(i);
						else if (j == 1)
							rows[i][j] = score1.get(i);
						else if (j == 2)
							rows[i][j] = player2.get(i);
						else if (j == 3)
							rows[i][j] = score2.get(i);
						else if (j == 4)
							rows[i][j] = date.get(i);
					}
			}
			TableModel model = new DefaultTableModel(rows, columns) {
				public Class getColumnClass(int column) {
					if (column >= 0 && column <= getColumnCount())
						return getValueAt(0, column).getClass();
					else
						return Object.class;
				}
			};
			JTable table = new JTable(model);
			table.setEnabled(false);
			RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
			table.setRowSorter(sorter);
			getContentPane().add(new JScrollPane(table));
			if (isBestScore) {
				DefaultRowSorter sorter1 = ((DefaultRowSorter) table
						.getRowSorter());
				ArrayList list = new ArrayList();
				list.add(new RowSorter.SortKey(2, SortOrder.DESCENDING));
				sorter1.setSortKeys(list);
				sorter1.sort();
			} else {
				DefaultRowSorter sorter1 = ((DefaultRowSorter) table
						.getRowSorter());
				ArrayList list = new ArrayList();
				list.add(new RowSorter.SortKey(4, SortOrder.DESCENDING));
				sorter1.setSortKeys(list);
				sorter1.sort();
			}

			DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
			centerRenderer.setHorizontalAlignment(JLabel.CENTER);
			table.setDefaultRenderer(String.class, centerRenderer);

			if (isBestScore)
				setTitle("Best Score of All Players");
			else
				setTitle("All Game Played");

			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setAlwaysOnTop(true);
			setResizable(false);
			setVisible(true);
			setResizable(false);
			setSize(700, 700);
			setLocationRelativeTo(null);

		}
	}

	/**
	 * The method bastScores search all players register and found the best
	 * score of every player.
	 * 
	 * @throws IOException
	 */
	public void bestScores() throws IOException {
		LoginManager login = new LoginManager();
		login.createFile();
		login.readFile();
		ArrayList<String> user = new ArrayList<String>();
		user.addAll(login.getUsername());

		playerBest.clear();
		scoreBest.clear();
		dateBest.clear();
		opponent.clear();
		opponentScore.clear();

		int indexOfBest1 = -1;
		int indexOfBest2 = -1;
		int maxScore1 = 0;
		int maxScore2 = 0;
		int count = 0;
		for (int i = 0; i < user.size(); i++) {
			for (int j = 0; j < player1.size(); j++) {
				if (user.get(i).compareTo(player1.get(j)) == 0) {
					if (count == 0) {
						indexOfBest1 = j;
						maxScore1 = Integer.parseInt(score1.get(j));
						count++;
					} else if (maxScore1 < Integer.parseInt(score1.get(j)))
						maxScore1 = Integer.parseInt(score1.get(j));
				}
				if (user.get(i).compareTo(player2.get(j)) == 0) {
					if (count == 0) {
						indexOfBest2 = j;
						maxScore2 = Integer.parseInt(score2.get(j));
						count++;
					} else if (maxScore2 < Integer.parseInt(score2.get(j)))
						maxScore2 = Integer.parseInt(score2.get(j));
				}
			}
			if (indexOfBest1 == -1 && indexOfBest2 == -1) {
				playerBest.add(user.get(i));
				scoreBest.add("-");
				dateBest.add("-");
				opponent.add("-");
				opponentScore.add("-");
			} else if (maxScore1 < maxScore2 || maxScore1 == maxScore2) {
				playerBest.add(user.get(i));
				scoreBest.add(score2.get(indexOfBest2));
				dateBest.add(date.get(indexOfBest2));
				opponent.add(player1.get(indexOfBest2));
				opponentScore.add(score1.get(indexOfBest2));
			} else if (maxScore1 > maxScore2) {
				playerBest.add(user.get(i));
				scoreBest.add(score1.get(indexOfBest1));
				dateBest.add(date.get(indexOfBest1));
				opponent.add(player2.get(indexOfBest1));
				opponentScore.add(score2.get(indexOfBest1));
			}
			maxScore1 = 0;
			maxScore2 = 0;
			count = 0;
			indexOfBest1 = -1;
			indexOfBest2 = -1;
		}

		player1 = playerBest;
		score1 = scoreBest;
		date = dateBest;
		player2 = opponent;
		score2 = opponentScore;
	}
}

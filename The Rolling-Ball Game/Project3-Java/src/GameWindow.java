
import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


/**
 * The class {@link GameWindow} is the start of the game, here the Windows is
 * created and the menu is displayed and has the loop that maintain the game
 * running all the time as the delay that the game will have such that the
 * motions could be seen.
 * 
 * @author Kevin
 *
 */
public class GameWindow {

	private JFrame frame;
	private JMenuBar menuBar;
	private JMenu playNewGame;
	private JMenu firstTimePlayers;
	private JMenu history;
	private JMenu help;
	private JMenu exit;
	private JMenuItem currentPlayers;
	private JMenuItem selectNewPlayers;
	private JMenuItem createNewPlayer;
	private JMenuItem highestScores;
	private JMenuItem allGamesPlayed;
	private JMenuItem howToPlay;

	private ShowDraws draws;

	public static int frameXLocation;
	public static int frameYLocation;
	private int y = 31;
	private int x = 31;
	private int lenght = 700;
	public static int width = 1200;
	public static int height = 800;

	/**
	 * This is the main method of the program.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new GameWindow().start();
	}

	/**
	 * The method start calls JFrame to create the game window and the display
	 * the menu.
	 */
	public void start() {

		frame = new JFrame("The Rolling-Ball Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		// create new JMenu with name
		playNewGame = new JMenu("Play-New-Game");
		firstTimePlayers = new JMenu("First-Time-Players");
		history = new JMenu("History");
		help = new JMenu("Help");
		exit = new JMenu("Exit");

		// create new JMenuItem with name
		currentPlayers = new JMenuItem("Current Players");
		selectNewPlayers = new JMenuItem("Select New Players");
		createNewPlayer = new JMenuItem("Create New Player");
		highestScores = new JMenuItem("Best Scores of the Players");
		allGamesPlayed = new JMenuItem("All Games Played");
		howToPlay = new JMenuItem("How To Play");

		// Add the JMenu created to JMenuBar
		menuBar.add(playNewGame);
		menuBar.add(firstTimePlayers);
		menuBar.add(history);
		menuBar.add(help);
		menuBar.add(exit);

		// Add the JMenuItem to JMenu objects
		playNewGame.add(currentPlayers);
		playNewGame.add(selectNewPlayers);
		firstTimePlayers.add(createNewPlayer);
		history.add(highestScores);
		history.add(allGamesPlayed);
		help.add(howToPlay);

		// Add action to objects in JMenuBar
		playNewGame.addMenuListener(new PlayNewGame());
		exit.addMenuListener(new Exit());

		// Add action to JMenuItems
		currentPlayers.addActionListener(new CurrentPlayers());
		selectNewPlayers.addActionListener(new SelectNewPlayers());
		createNewPlayer.addActionListener(new CreateNewPlayer());
		howToPlay.addActionListener(new HowToPlay());
		highestScores.addActionListener(new History("highest"));
		allGamesPlayed.addActionListener(new History("allgames"));

		draws = new ShowDraws(x, y, width, height, lenght);
		setDraws(draws);
		frame.add(draws);
		frame.getContentPane().add(BorderLayout.CENTER, draws);

		frame.setResizable(false);
		frame.setSize(width, height);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		run();
	}

	/**
	 * The method run keep the program running until the user use exit or close.
	 */
	private void run() {
		while (true) {
			try {
				Update.update(draws);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			setFrameXLocation(frame.getX());
			setFrameYLocation(frame.getY());
			frame.repaint();
			try {
				Thread.sleep(8);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 
	 * @param draws
	 */
	public void setDraws(ShowDraws draws) {
		this.draws = draws;
	}

	/**
	 * 
	 * @param frameXLocation
	 */
	public void setFrameXLocation(int frameXLocation) {
		GameWindow.frameXLocation = frameXLocation;
	}

	/**
	 * 
	 * @param frameYLocation
	 */
	public void setFrameYLocation(int frameYLocation) {
		GameWindow.frameYLocation = frameYLocation;
	}

}

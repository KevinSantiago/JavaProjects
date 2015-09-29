
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The class {@link HistoryFileManager} manage all history data and save it to a
 * file.
 * 
 * @author Kevin
 *
 */
public class HistoryFileManager implements FileManagement {

	File inputFile;
	private ArrayList<String> player1 = new ArrayList<String>();
	private ArrayList<String> score1 = new ArrayList<String>();
	private ArrayList<String> dates = new ArrayList<String>();
	private ArrayList<String> player2 = new ArrayList<String>();
	private ArrayList<String> score2 = new ArrayList<String>();

	/**
	 * @param inputFile
	 *            the inputFile to set
	 */
	public void setInputFile(File inputFile) {
		this.inputFile = inputFile;
	}

	/**
	 * @return the player1
	 */
	public ArrayList<String> getPlayer1() {
		return player1;
	}

	/**
	 * @param player1
	 *            the player1 to set
	 */
	public void setPlayer1(ArrayList<String> player1) {
		this.player1 = player1;
	}

	/**
	 * @return the score1
	 */
	public ArrayList<String> getScore1() {
		return score1;
	}

	/**
	 * @param score1
	 *            the score1 to set
	 */
	public void setScore1(ArrayList<String> score1) {
		this.score1 = score1;
	}

	/**
	 * @return the dates
	 */
	public ArrayList<String> getDates() {
		return dates;
	}

	/**
	 * @param dates
	 *            the dates to set
	 */
	public void setDates(ArrayList<String> dates) {
		this.dates = dates;
	}

	/**
	 * @return the player2
	 */
	public ArrayList<String> getPlayer2() {
		return player2;
	}

	/**
	 * @param player2
	 *            the player2 to set
	 */
	public void setPlayer2(ArrayList<String> player2) {
		this.player2 = player2;
	}

	/**
	 * @return the score2
	 */
	public ArrayList<String> getScore2() {
		return score2;
	}

	/**
	 * @param score2
	 *            the score2 to set
	 */
	public void setScore2(ArrayList<String> score2) {
		this.score2 = score2;
	}

	/**
	 * create a new file in the project folder and names the columns of the data
	 * that it will contents
	 *
	 * @throws IOException
	 */
	@Override
	public void createFile() throws IOException {
		File inputFile = new File("history.txt");
		inputFile.createNewFile();
		setInputFile(inputFile);
	}

	/**
	 * the method writeFile write the usernames and passwords to a file
	 * 
	 * @param player1
	 * @param player2
	 * @param scorePlayer1
	 * @param scorePlayer2
	 * @param date
	 * @return true if save the data correctly and false if not.
	 * @throws IOException
	 */
	public boolean writeFile(String player1, String player2,
			String scorePlayer1, String scorePlayer2, String date)
			throws IOException {

		FileWriter fWriter = new FileWriter(inputFile, true);
		BufferedWriter write = new BufferedWriter(fWriter);
		if (scorePlayer1.length() < 5) {
			String temp = scorePlayer1;
			scorePlayer1 = "";
			int n = 9 - temp.length();
			for (int i = 0; i < n; i++)
				scorePlayer1 += "0";
			scorePlayer1 += temp;
		}
		if (scorePlayer2.length() < 5) {
			String temp = scorePlayer1;
			scorePlayer2 = "";
			int n = 9 - temp.length();
			for (int i = 0; i < n; i++)
				scorePlayer2 += "0";
			scorePlayer2 += temp;
		}
		String writeInText;
		writeInText = scorePlayer1 + " " + scorePlayer2 + " " + player1 + " "
				+ player2 + " " + date;
		write.append(writeInText);
		write.newLine();
		write.close();
		fWriter.close();
		return true;
	}

	@Override
	public boolean writeFile(String s1, String s2) throws IOException {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * the method readFile read the usernames and passwords inside a file and
	 * put them on a separate arraylist
	 *
	 * @return true if only if the file has information and false if the file is
	 *         empty
	 * @throws IOException
	 * @return true if can open the file and read it and false if not.
	 */
	@Override
	public boolean readFile() throws IOException {
		FileInputStream input = new FileInputStream(inputFile);
		Scanner in = new Scanner(inputFile);
		player1.clear();
		score1.clear();
		dates.clear();
		player2.clear();
		score2.clear();
		if (input.read() != -1) {
			while (in.hasNext()) {
				score1.add(in.next().trim());
				score2.add(in.next().trim());
				player1.add(in.next().trim());
				player2.add(in.next().trim());
				dates.add(in.nextLine().trim());
			}
			setScore1(score1);
			setScore2(score2);
			setPlayer1(player1);
			setPlayer2(player2);
			setDates(dates);

			in.close();
			input.close();
			return true;
		} else {
			in.close();
			input.close();
		}
		return false;
	}

	@Override
	public boolean compare(String single, String pass) throws IOException {
		// TODO Auto-generated method stub
		return false;
	}

}

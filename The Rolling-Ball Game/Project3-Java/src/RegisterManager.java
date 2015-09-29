
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The class {@link RegisterManager} register the new players in the game and
 * save the user information as username and password in a file.
 * 
 * @author Kevin
 *
 */
public class RegisterManager implements FileManagement {

	protected final int MAX_USERNAME_CHARACTERS = 10;
	protected final int MAX_PASSWORD_CHARACTERS = 4;
	protected File inputFile;
	protected ArrayList<String> username = new ArrayList<String>();
	public ArrayList<String> password = new ArrayList<String>();

	/**
	 * The constructor {@link RegisterManager} create a new one but empty.
	 */
	public RegisterManager() {
	}

	/**
	 * 
	 * @param username
	 */
	private void setUsername(ArrayList<String> username) {
		this.username = username;
	}

	/**
	 * 
	 * @param password
	 */
	private void setPassword(ArrayList<String> password) {
		this.password = password;
	}

	/**
	 * 
	 * @return username
	 */
	public ArrayList<String> getUsername() {
		return username;
	}

	/**
	 * 
	 * @return password
	 */
	public ArrayList<String> getPassword() {
		return password;
	}

	private void setFile(File inputFile) {
		this.inputFile = inputFile;
	}

	/**
	 * create a new file in the project folder and names the columns of the data
	 * that it will contents
	 *
	 * @throws IOException
	 */
	@Override
	public void createFile() throws IOException {
		File inputFile = new File("UsersInfo.txt");
		inputFile.createNewFile();
		setFile(inputFile);
	}

	/**
	 * the method writeFile write the usernames and passwords to a file-+
	 *
	 * @return true if the username is valid and unique and if the password is
	 *         valid too, and false if the information is not valid.
	 * @throws IOException
	 */
	@Override
	public boolean writeFile(String newUsername, String newPassword)
			throws IOException {
		FileWriter fWriter = new FileWriter(inputFile, true);
		BufferedWriter write = new BufferedWriter(fWriter);

		boolean validate = false;
		String strToWriteInText = null;

		if (readFile()) {
			validate = compare(newUsername, newPassword);
		} else
			validate = true;

		if (validate)
			if (!(newUsername.length() > MAX_USERNAME_CHARACTERS)) {
				if (newPassword.length() == MAX_PASSWORD_CHARACTERS) {

					strToWriteInText = newPassword + " " + newUsername;
					write.append(strToWriteInText);
					write.newLine();
					write.close();
					fWriter.close();
					return true;
				}
			} else {
				write.close();
				fWriter.close();
			}
		return false;
	}

	/**
	 * the method readFile read the usernames and passwords inside a file and
	 * put them on a separate arraylist
	 *
	 * @return true if only if the file has information and false if the file is
	 *         empty
	 * @throws IOException
	 */
	@Override
	public boolean readFile() throws IOException {
		FileInputStream input = new FileInputStream(inputFile);
		Scanner in = new Scanner(inputFile);
		username.clear();
		password.clear();
		if (input.read() != -1) {
			while (in.hasNext()) {
				password.add(in.next());
				username.add(in.nextLine().trim());
			}
			setUsername(username);
			setPassword(password);
			in.close();
			input.close();
			return true;
		} else {
			in.close();
			input.close();
		}
		return false;
	}

	/**
	 * the method verify if the new username is a unique one.
	 * 
	 * @param sigle
	 *            is the new username that you want to verify
	 * @param arr
	 *            is an ArryList with all usernames in use
	 * @return true if the username is a unique one and false if que username
	 *         already exist
	 */
	@Override
	public boolean compare(String user, String pass) throws IOException {
		if (readFile())
			for (int i = 0; i < username.size(); i++)
				if (user.compareTo(username.get(i)) == 0)
					return false;
		return true;
	}
}
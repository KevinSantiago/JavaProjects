
import java.io.IOException;

public interface FileManagement {


	/**
	 * create a new file in the project folder and names the columns of the data
	 * that it will contents
	 *
	 * @throws IOException
	 */
	void createFile() throws IOException;

	/**
	 * the method writeFile write the usernames and passwords to a file-+
	 *
	 * @return true if the username is valid and unique and if the password is
	 *         valid too, and false if the information is not valid.
	 * @throws IOException
	 */
	boolean writeFile(String s1, String s2) throws IOException;

	/**
	 * the method readFile read the usernames and passwords inside a file and
	 * put them on a separate arraylist
	 *
	 * @return true if only if the file has information and false if the file is
	 *         empty
	 * @throws IOException
	 */
	boolean readFile() throws IOException;

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
	boolean compare(String single, String pass) throws IOException;
}

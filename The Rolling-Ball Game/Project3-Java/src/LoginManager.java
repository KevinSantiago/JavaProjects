
import java.io.IOException;

/**
 * The class {@link LoginManager} extends the class {@link RegisterManager} to
 * reuse code and override the compare.
 * 
 * @author Kevin
 *
 */
public class LoginManager extends RegisterManager implements FileManagement {

	/**
	 * The {@link LoginManager} constructor runs the {@link RegisterManager}
	 * constructor
	 */
	public LoginManager() {
		super();
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
					if (pass.compareTo(password.get(i)) == 0)
						return true;
		return false;
	}
}

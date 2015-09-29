
import javax.swing.JOptionPane;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

/**
 * The class {@link Exit} teriminates the program.
 * 
 * @author Kevin
 *
 */
public class Exit implements MenuListener {

	@Override
	public void menuCanceled(MenuEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void menuDeselected(MenuEvent arg0) {
		// TODO Auto-generated method stub

	}

	/**
	 * The method before close the program ask the user if want to leave the
	 * progaram.
	 */
	@Override
	public void menuSelected(MenuEvent arg0) {
		String message = "You are closing The Rolling-Ball Game." + "\n\n"
				+ "Are you sure yo want to leave?\n";
		String[] options = { "Yes", "Cancel" };

		int action = JOptionPane.showOptionDialog(null, message, "",
				JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null,
				options, options[1]);
		if (action == JOptionPane.OK_OPTION)
			System.exit(0);
	}
}
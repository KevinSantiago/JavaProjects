
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


/**
 * The class {@link CreateNewPlayer} show the frame where the user can create a
 * new player.
 * 
 * @author Kevin
 *
 */
@SuppressWarnings("serial")
public class CreateNewPlayer extends JFrame implements ActionListener {

	private JLabel userLabel;
	private JLabel passLabel;
	private JButton register;
	private Insets insets;
	private JDesktopPane desk;
	private JTextField userTextField;
	private JPasswordField passTextField;

	private RegisterManager file;

	/**
	 * The method show the frame with labels that permits the new players enter
	 * theirs usernames and passwords and the method verify if the username is
	 * unique and if the password is valid if no ask the user agian.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Font font = new Font("Arial", Font.PLAIN, 12);
		desk = new JDesktopPane();
		userTextField = new JTextField();
		passTextField = new JPasswordField();

		setTitle("Register");
		setResizable(false);
		setVisible(true);
		setSize(350, 250);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setContentPane(desk);
		desk.setBackground(Color.white);

		userLabel = new JLabel("USERNAME");
		passLabel = new JLabel("PASSWORD");

		userTextField
				.setToolTipText("The username is limited to 10 characters.");
		passTextField.setToolTipText("The password must be 4 characters.");

		userLabel.setFont(font);
		passLabel.setFont(font);

		register = new JButton("register");
		register.setFont(new Font("Arial", Font.PLAIN, 12));

		register.addActionListener(new ActionListener() {
			private boolean uniqueUser;
			private boolean invalidUserOrPass;

			@Override
			public void actionPerformed(ActionEvent e) {
				String userTemp = userTextField.getText();
				char[] passTemp = passTextField.getPassword();

				userTextField.setText(null);
				passTextField.setText(null);

				String username = "";
				String password = "";
				int length = userTemp.length();
				for (int i = 0; i < length; i++) {
					if (!(userTemp.charAt(i) == ' '))
						username += userTemp.charAt(i);
				}
				for (char i : passTemp) {
					if (!(i == ' '))
						password += Character.valueOf(i);
				}
				file = new RegisterManager();
				try {
					file.createFile();
					uniqueUser = file.compare(username, password);
					if (uniqueUser)
						invalidUserOrPass = file.writeFile(username, password);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (!uniqueUser) {
					setAlwaysOnTop(false);
					int error = JOptionPane.ERROR_MESSAGE;
					String title = "Message error";
					String message = "The username already exist.";
					JOptionPane.showMessageDialog(null, message, title, error);
				} else if (!invalidUserOrPass) {
					setAlwaysOnTop(false);
					int error = JOptionPane.ERROR_MESSAGE;
					String title = "Invalid username or password.\n\n";
					String message = "The username is limited to 10 characters.\n"
							+ "The password must be 4 characters.";
					JOptionPane.showMessageDialog(null, message, title, error);
				} else {
					dispose();
					String message = "Player is created.";
					JOptionPane.showMessageDialog(null, message, "",
							JOptionPane.PLAIN_MESSAGE);
				}
				setAlwaysOnTop(true);
			}
		});

		Container content = getContentPane();
		content.add(userLabel);
		content.add(passLabel);
		content.add(userTextField);
		content.add(passTextField);
		content.add(register);

		insets = content.getInsets();
		userLabel.setBounds(insets.left + 80, insets.top + 51, 80, 20);
		passLabel.setBounds(insets.left + 80, insets.top + 91, 80, 20);
		userTextField.setBounds(insets.left + 160, insets.top + 50, 100, 25);
		passTextField.setBounds(insets.left + 160, insets.top + 90, 100, 25);
		register.setBounds(insets.left + 135, insets.top + 140, 85, 25);

	}
}

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

/**
 * The class {@link SelectNewPlayers} show a frame where the players can login
 * with their usernames and password.
 * 
 * @author Kevin
 *
 */
@SuppressWarnings("serial")
public class SelectNewPlayers extends JFrame implements ActionListener {

	private JLabel userLabel;
	private JLabel passLabel;
	private JButton login;
	private JDesktopPane desk;
	private ArrayList<String> users = new ArrayList<String>();
	private JComboBox<String> comboBox;
	private JPasswordField passTextField;

	private NumberOfBalls numBall;
	private boolean isPlayer1;
	private Players players;
	private LoginManager loginManager;

	public SelectNewPlayers() {
		isPlayer1 = true;
	}

	/**
	 * The {@link SelectNewPlayers} constructor receive players info
	 * 
	 * @param players
	 * @param isPlayer1
	 */
	public SelectNewPlayers(Players players, boolean isPlayer1) {
		this.players = players;
		this.isPlayer1 = isPlayer1;
	}

	/**
	 * Display the frame where the user can search his/her username and put the
	 * password to validate it.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			loginManager = new LoginManager();
			loginManager.createFile();
			loginManager.readFile();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		if (isPlayer1)
			players = new Players();
		Font font = new Font("Arial", Font.PLAIN, 12);
		desk = new JDesktopPane();
		comboBox = new JComboBox<String>();
		passTextField = new JPasswordField();

		if (isPlayer1 && players.getPlayer1() == null) {
			setTitle("Player 1");
		} else if (players.getPlayer2() == null) {
			setTitle("Player 2");
		} else
			dispose();

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
		userLabel.setFont(font);
		passLabel.setFont(font);

		login = new JButton("login");
		login.setFont(font);

		users.clear();
		users.addAll(sort(loginManager.getUsername()));
		for (int i = 0; i < loginManager.getUsername().size(); i++)
			comboBox.addItem(users.get(i));

		login.addActionListener(new ActionListener() {
			private boolean uniqueUser;

			@Override
			public void actionPerformed(ActionEvent e) {
				String username = (String) comboBox.getSelectedItem();
				char[] temp = passTextField.getPassword();

				passTextField.setText(null);

				String password = "";
				for (char i : temp)
					password += Character.valueOf(i);

				loginManager = new LoginManager();
				try {
					loginManager.createFile();
					uniqueUser = loginManager.compare(username, password);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (!isPlayer1
						&& (username.compareTo(players.getPlayer1()) == 0)) {
					setAlwaysOnTop(false);
					int error = JOptionPane.ERROR_MESSAGE;
					String message = "This username are in use.";
					JOptionPane.showMessageDialog(null, message, "", error);
				} else if (!uniqueUser) {
					setAlwaysOnTop(false);
					int error = JOptionPane.ERROR_MESSAGE;
					String message = "Wrong password or Username.";
					JOptionPane.showMessageDialog(null, message, "", error);
				} else {
					dispose();
					String message = "Login succefully.";
					JOptionPane.showMessageDialog(null, message, "",
							JOptionPane.PLAIN_MESSAGE);
					if (isPlayer1) {
						players.setPlayer1(username);
						new SelectNewPlayers(players, false).actionPerformed(e);
					} else {
						players.setPlayer2(username);
						Update.setPlayers(players);
						numBall = new NumberOfBalls();
						numBall.numberOfBalls();
					}
				}
				setAlwaysOnTop(true);
			}
		});

		Container content = getContentPane();
		content.add(userLabel);
		content.add(passLabel);
		content.add(comboBox);
		content.add(passTextField);
		content.add(login);

		userLabel.setBounds(80, 51, 80, 20);
		passLabel.setBounds(80, 91, 80, 20);
		comboBox.setBounds(160, 50, 100, 25);
		passTextField.setBounds(160, 90, 100, 25);
		login.setBounds(135, 140, 85, 25);
	}

	/**
	 * The method sort put the numbers in alphabetical order.
	 * 
	 * @param s
	 * @return
	 */
	private ArrayList<String> sort(ArrayList<String> s) {
		String[] s1 = new String[s.size()];
		String temp;

		for (int i = 0; i < s.size(); i++)
			s1[i] = s.get(i);

		for (int i = s1.length - 1; i > 0; i--) {
			temp = s1[i];
			for (int j = i - 1; j >= 0; j--) {
				if (temp.compareToIgnoreCase(s1[j]) > 0) {
					String temp1 = temp;
					temp = s1[j];
					s1[j] = temp1;
				}
			}
			s1[i] = temp;
		}
		s.clear();
		for (int i = s1.length - 1; i >= 0; i--)
			s.add(s1[i]);
		return s;
	}
}
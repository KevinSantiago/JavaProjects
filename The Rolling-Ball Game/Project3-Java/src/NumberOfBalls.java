
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * The class {@link NumberOfBalls} show a frame and ask to user to select the
 * number of balls that the game will have.
 * 
 * @author Kevin
 *
 */
@SuppressWarnings("serial")
public class NumberOfBalls extends JFrame {
	private JComboBox<String> options;
	private JDesktopPane desk;
	private JLabel messageLabel;
	private JLabel messageLabel1;
	private JButton button;
	private Random random;

	/**
	 * Ask for the number of ball to play in game.
	 */
	public void numberOfBalls() {
		Font font = new Font("Arial", Font.PLAIN, 14);

		desk = new JDesktopPane();

		String message = "Select the number of balls";
		String message1 = " that every player will have";

		messageLabel = new JLabel(message);
		messageLabel1 = new JLabel(message1);
		messageLabel.setFont(font);
		messageLabel1.setFont(font);

		options = new JComboBox<String>();

		for (int i = 1; i <= 10; i++)
			options.addItem("" + i);

		button = new JButton("done");

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Update.setGameVisibility(true);
				Update.setNumOfBall(Integer.parseInt((String) options
						.getSelectedItem()));
				Update.setFirstTime(true);
				DateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
				Date dateobj = new Date();
				Update.setDate(df.format(dateobj));
			}
		});

		setTitle("Number Of Balls");
		setResizable(false);
		setVisible(true);
		setSize(250, 150);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setContentPane(desk);
		desk.setBackground(Color.white);

		Container content = getContentPane();
		content.add(messageLabel);
		content.add(messageLabel1);
		content.add(options);
		content.add(button);

		messageLabel.setBounds(40, -10, 200, 50);
		messageLabel1.setBounds(38, 10, 200, 50);
		options.setBounds(75, 50, 100, 25);
		button.setBounds(85, 80, 80, 25);
	}
}

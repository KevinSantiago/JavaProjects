
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * The class {@link Players} manage data about the players as theirs names and
 * the distance. Also determines the initial direction and the ball
 * displacement.
 * 
 * @author Kevin
 *
 */
public class Players extends JFrame {

	private String player1 = null;
	private String player2 = null;
	private boolean isPlayer1Turn = true;
	private int distance1 = 1500;
	private int distance2 = 1500;
	private boolean firstTime;
	// private boolean

	private JButton shoot;
	private JDesktopPane desk;
	private JLabel directionLabel;
	private JLabel distanceLabel;
	private JComboBox<Integer> direction;
	private JComboBox<Integer> distance;
	private final int maxAngle = 360;

	private boolean gameOver = false;
	private ArrayList<MovingBall> moving;

	public Players() {
	}

	/**
	 * The method show the JFrame that content all angles and distance that the
	 * player have available.
	 * 
	 * @param firstTime
	 * 
	 * @param frameOneTime
	 */
	public void chooseDirection(boolean firstTime, boolean frameOneTime) {
		this.firstTime = firstTime;
		Font font = new Font("Arial", Font.PLAIN, 12);
		if (frameOneTime) {
			if (distance1 > 0 && distance2 > 0) {
				moving = Update.getBallMoving();
				Update.openFrameOneTime = false;
				desk = new JDesktopPane();
				direction = new JComboBox<Integer>();
				distance = new JComboBox<Integer>();
				directionLabel = new JLabel("Direction Angle");
				distanceLabel = new JLabel("Distance");
				directionLabel.setFont(font);
				distanceLabel.setFont(font);

				Point newLocation = new Point(GameWindow.frameXLocation
						+ (GameWindow.width) - 400, GameWindow.frameYLocation
						+ (GameWindow.height) - 400);
				setLocation(newLocation);
				setResizable(false);
				setVisible(true);
				setSize(350, 250);
				setAlwaysOnTop(true);
				setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				setContentPane(desk);
				desk.setBackground(Color.white);

				distance.removeAllItems();
				direction.removeAllItems();
				for (int i = 0; i < maxAngle; i++)
					direction.addItem(i);
				if (isPlayer1Turn) {
					for (int i = 1; i <= distance1; i++)
						distance.addItem(i);
				} else
					for (int i = 1; i <= distance2; i++)
						distance.addItem(i);

				shoot = new JButton("shoot");
				shoot.setFont(font);

				Container content = getContentPane();
				content.add(directionLabel);
				content.add(distanceLabel);
				content.add(direction);
				content.add(distance);
				content.add(shoot);

				directionLabel.setBounds(40, 51, 100, 20);
				distanceLabel.setBounds(80, 91, 80, 20);
				direction.setBounds(160, 50, 80, 25);
				distance.setBounds(160, 90, 80, 25);
				shoot.setBounds(135, 140, 85, 25);

				shoot.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						dispose();
						for (int i = 0; i < moving.size(); i++) {
							int distanceSelected = (int) distance
									.getSelectedItem();
							if (isPlayer1Turn) {
								distance1 -= distanceSelected;
								Update.setScore1(distance1);
							} else {
								distance2 -= distanceSelected;
								Update.setScore2(distance2);
							}
							moving.get(i).setAngle(
									(int) direction.getSelectedItem());
							moving.get(i).setDistance(distanceSelected);
							if (Players.this.firstTime) {
								Update.askAngle = false;
								double radius = Math.sqrt(2);
								int angle = (int) direction.getSelectedItem();
								double theta = (angle / 180.0) * (Math.PI);
								double x = radius * Math.cos(theta);
								double y = radius * Math.sin(theta);
								if (x > 0) {
									moving.get(i).setRight(true);
									moving.get(i).setLeft(false);
								} else if (x < 0) {
									moving.get(i).setRight(false);
									moving.get(i).setLeft(true);
								} else if (x == 0 && y < 0) {
									moving.get(i).setRight(false);
									moving.get(i).setLeft(false);
									moving.get(i).setUp(false);
									moving.get(i).setDown(true);
								} else {
									moving.get(i).setRight(false);
									moving.get(i).setLeft(false);
									moving.get(i).setUp(true);
									moving.get(i).setDown(false);
								}
								if (y > 0) {
									moving.get(i).setUp(true);
									moving.get(i).setDown(false);
								} else if (y < 0) {
									moving.get(i).setUp(false);
									moving.get(i).setDown(true);
								} else if (y == 0 && x < 0) {
									moving.get(i).setRight(false);
									moving.get(i).setLeft(true);
									moving.get(i).setUp(false);
									moving.get(i).setDown(false);
								} else {
									moving.get(i).setRight(true);
									moving.get(i).setLeft(false);
									moving.get(i).setUp(false);
									moving.get(i).setDown(false);
								}
							}
						}
					}
				});
				Update.setBallMoving(moving);
			} else {
				gameOver = true;
				Update.setGameOver(gameOver);
			}
		}
	}


	/**
	 * The method change the players turns.
	 */
	public void turns() {
		isPlayer1Turn = !isPlayer1Turn;
	}
	
	/**
	 * @return the gameOver
	 */
	public boolean isGameOver() {
		return gameOver;
	}

	/**
	 * @param gameOver
	 *            the gameOver to set
	 */
	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}

	/**
	 * @param moving
	 *            the moving to set
	 */
	public void setMoving(ArrayList<MovingBall> moving) {
		this.moving = moving;
	}

	/**
	 * @return the player1
	 */
	public String getPlayer1() {
		return player1;
	}

	/**
	 * @param player1
	 *            the player1 to set
	 */
	public void setPlayer1(String player1) {
		this.player1 = player1;
	}

	/**
	 * @return the player2
	 */
	public String getPlayer2() {
		return player2;
	}

	/**
	 * @param player2
	 *            the player2 to set
	 */
	public void setPlayer2(String player2) {
		this.player2 = player2;
	}

	/**
	 * 
	 * @return distance1
	 */
	public int getDistance1() {
		return distance1;
	}

	/**
	 * @param distance1
	 *            the distance1 to set
	 */
	public void setDistance1(int distance1) {
		this.distance1 += distance1;
	}

	/**
	 * 
	 * @return distance2
	 */
	public int getDistance2() {
		return distance2;
	}

	/**
	 * @param distance2
	 *            the distance2 to set
	 */
	public void setDistance2(int distance2) {
		this.distance2 += distance2;
	}

	/**
	 * 
	 * @return isPlayer1Turn
	 */
	public boolean isPlayer1Turn() {
		return isPlayer1Turn;
	}
}

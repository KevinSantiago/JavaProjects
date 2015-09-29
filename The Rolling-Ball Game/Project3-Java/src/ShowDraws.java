import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Arc2D;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;


/**
 * The Class {@link ShowDraws} paints every Graphics methods in a same Panel to
 * be displayed in the game.
 * 
 * @author Kevin
 *
 */
@SuppressWarnings("serial")
public class ShowDraws extends JPanel implements MouseListener {

	private Random random;
	private int x, y, lenght;
	private int numOfBall;
	private int numOfHappyFaces;
	private int numOfObstacles;
	private int numOfMine;
	private int width, height;
	public static boolean coverVisibility;
	public static boolean gameVisibility;
	public static boolean firstTime = true;
	public static boolean selected = false;
	public static boolean gameOver = false;
	public static GameOver over;

	private int angle;
	private boolean isShoot1 = false, isShoot2 = false, isAbort = false;
	private Buttons shoot1;
	private Buttons shoot2;
	private Buttons abort;

	private ArrayList<GameObject> allBalls = new ArrayList<GameObject>();
	private ArrayList<MovingBall> ballMoving;
	// private ArrayList<MovingBall> ball2Moving = Update.ball2Moving;
	private ArrayList<MovingBall> player1Balls = new ArrayList<MovingBall>();
	private ArrayList<MovingBall> player2Balls = new ArrayList<MovingBall>();
	private ArrayList<FixedObject> happyFaces = new ArrayList<FixedObject>();
	private ArrayList<FixedObject> obstacle = new ArrayList<FixedObject>();
	private ArrayList<Mine> mine = new ArrayList<Mine>();

	/**
	 * The {@link ShowDraws} constructor create a new one with coordinates,
	 * width, height and length.
	 * 
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param lenght
	 */
	public ShowDraws(int x, int y, int width, int height, int lenght) {
		this.x = x;
		this.y = y;
		this.lenght = lenght;
		this.width = width;
		this.height = height;
		addMouseListener(this);
	}

	/**
	 * The method draws all balls, frames, and so one.
	 */
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		coverVisibility = Update.isCoverVisibility();
		gameVisibility = Update.isGameVisibility();
		over = Update.over;
		numOfBall = Update.getNumOfBall();

		gameOver = Update.gameOver;
		random = new Random();

		GameCoverPage cover = new GameCoverPage(Update.getX(), y, width,
				height, coverVisibility);
		GameBallBox box = new GameBallBox(x, y, lenght, gameVisibility);
		ScoreBar bar = new ScoreBar(x, y, gameVisibility);

		cover.coverPage(g);
		box.box(g);
		bar.scoreBar(g);
		Update.getDate();

		if (gameOver) {
			over.gameOver(g2);
		}
		if (gameVisibility && firstTime) {
			shoot1 = new Buttons(x + 800, y + 400, "Shoot",
					new Color(0, 205, 0), new Color(16, 155, 16));
			shoot2 = new Buttons(x + 925, y + 400, "Shoot", new Color(0, 145,
					225), new Color(14, 117, 176));
			abort = new Buttons(x + 1050, y + 400, "Abort", new Color(245, 226,
					54), new Color(219, 203, 58));

			shoot1.button(g);
			shoot2.button(g);
			abort.button(g);

			if (Update.isPlayer1Turn())
				shoot1.blackBorder(g);
			else
				shoot2.blackBorder(g);

			setShoot1(shoot1);
			setShoot2(shoot2);
			setAbort(abort);

			numOfHappyFaces = random.nextInt(6) + 5;
			numOfObstacles = random.nextInt(6) + 5;
			numOfMine = random.nextInt(5) + 5;

			int index = 0;
			int numberOfElements = 0;
			allBalls.clear();
			for (int i = 0; i < numOfBall; i++) {
				allBalls.add(new MovingBall(new Color(0, 205, 0)));
				setAllBalls(allBalls);
				index = i;
				if (i > 0) {
					checkBallPosition(index);
				}
			}

			numberOfElements = index + 1;
			for (int i = numberOfElements; i < numOfBall + numberOfElements; i++) {
				allBalls.add(new MovingBall(new Color(0, 145, 225)));
				setAllBalls(allBalls);
				index = i;
				checkBallPosition(index);
			}

			numberOfElements = index + 1;
			for (int i = numberOfElements; i < numOfHappyFaces
					+ numberOfElements; i++) {
				allBalls.add(new FixedObject(Color.yellow));
				setAllBalls(allBalls);
				index = i;
				checkBallPosition(index);
			}

			numberOfElements = index + 1;
			for (int i = numberOfElements; i < numOfObstacles
					+ numberOfElements; i++) {
				allBalls.add(new FixedObject(Color.black));
				setAllBalls(allBalls);
				index = i;
				checkBallPosition(index);
			}

			numberOfElements = index + 1;
			for (int i = numberOfElements; i < numOfMine + numberOfElements; i++) {
				allBalls.add(new Mine(Color.red));
				setAllBalls(allBalls);
				index = i;
				checkBallPosition(index);
			}

			for (int i = 0; i < numOfBall; i++) {
				player1Balls.add((MovingBall) allBalls.get(0));
				allBalls.remove(0);
			}
			for (int i = 0; i < numOfBall; i++) {
				player2Balls.add((MovingBall) allBalls.get(0));
				allBalls.remove(0);
			}
			for (int i = 0; i < numOfHappyFaces; i++) {
				happyFaces.add((FixedObject) allBalls.get(0));
				allBalls.remove(0);
			}
			for (int i = 0; i < numOfObstacles; i++) {
				obstacle.add((FixedObject) allBalls.get(0));
				allBalls.remove(0);
			}
			for (int i = 0; i < numOfMine; i++) {
				mine.add((Mine) allBalls.get(0));
				allBalls.remove(0);
			}

			Update.setBall1(player1Balls);
			Update.setBall2(player2Balls);
			Update.setMine(mine);
			Update.setHappyFaces(happyFaces);
			Update.setObstacle(obstacle);

			firstTime = false;
		} else if (!firstTime) {
			shoot1.button(g);
			shoot2.button(g);
			abort.button(g);

			if (Update.isPlayer1Turn())
				shoot1.blackBorder(g);
			else
				shoot2.blackBorder(g);

			ballMoving = Update.getBallMoving();
			player1Balls = Update.getBall1();
			player2Balls = Update.getBall2();
			mine = Update.getMine();
			happyFaces = Update.getHappyFaces();
			obstacle = Update.getObstacle();

			// draw balls
			for (int i = 0; i < player1Balls.size(); i++) {
				player1Balls.get(i).balls(g);
			}

			for (int i = 0; i < player2Balls.size(); i++) {
				player2Balls.get(i).balls(g);
			}

			for (int i = 0; i < happyFaces.size(); i++) {
				happyFaces.get(i).balls(g);
			}

			for (int i = 0; i < mine.size(); i++) {
				mine.get(i).balls(g);
			}

			for (int i = 0; i < obstacle.size(); i++) {
				obstacle.get(i).balls(g);
			}

			for (int i = 0; i < player1Balls.size(); i++) {
				if (player1Balls.get(i).isBallSelected()) {
					player1Balls.get(i).getX();
					player1Balls.get(i).getY();
					g.setColor(Color.black);
				}
			}
			for (int i = 0; i < player2Balls.size(); i++) {
				if (player2Balls.get(i).isBallSelected()) {
					player2Balls.get(i).getX();
					player2Balls.get(i).getY();
					g.setColor(Color.black);
				}
			}
			for (int i = 0; i < ballMoving.size(); i++) {
				ballMoving.get(i).balls(g);
			}
			// for(int i = 0; i < ball2Moving.size(); i++){
			// ball2Moving.get(i).balls(g);
			// }
		}
	}

	/**
	 * The method checkBallPosition make sure that the ball position is not
	 * occupied by another ball.
	 * 
	 * @param index
	 */
	private void checkBallPosition(int index) {
		for (int j = 0; j < allBalls.size(); j++) {
			if (!(index == j))
				if ((allBalls.get(index).getY()) > (allBalls.get(j).getY() - 50))
					if ((allBalls.get(index).getY()) < (allBalls.get(j).getY() + 50))
						if ((allBalls.get(index).getX()) > (allBalls.get(j)
								.getX() - 50))
							if ((allBalls.get(index).getX()) < (allBalls.get(j)
									.getX() + 50)) {
								allBalls.get(index).setX(
										random.nextInt(669) + 31);
								allBalls.get(index).setY(
										random.nextInt(669) + 31);
								j = 0;
							}
		}
	}

	/**
	 * @param angle
	 *            the angle to set
	 */
	public void setAngle(int angle) {
		this.angle = angle;
	}

	/**
	 * @param isShoot1
	 *            the isShoot1 to set
	 */
	public void setShoot1(boolean isShoot1) {
		this.isShoot1 = isShoot1;
	}

	/**
	 * 
	 * @return isShoot1
	 */
	public boolean isShoot1() {
		return isShoot1;
	}

	/**
	 * 
	 * @return isShoot2
	 */
	public boolean isShoot2() {
		return isShoot2;
	}

	/**
	 * @param isShoot2
	 *            the isShoot2 to set
	 */
	public void setShoot2(boolean isShoot2) {
		this.isShoot2 = isShoot2;
	}

	/**
	 * @param isAbort
	 *            the isAbort to set
	 */
	public void setAbort(boolean isAbort) {
		this.isAbort = isAbort;
	}

	/**
	 * @param allBalls
	 *            the allBalls to set
	 */
	public void setAllBalls(ArrayList<GameObject> allBalls) {
		this.allBalls = allBalls;
	}

	/**
	 * @param shoot1
	 *            the shoot1 to set
	 */
	public void setShoot1(Buttons shoot1) {
		this.shoot1 = shoot1;
	}

	/**
	 * @param shoot2
	 *            the shoot2 to set
	 */
	public void setShoot2(Buttons shoot2) {
		this.shoot2 = shoot2;
	}

	/**
	 * @param abort
	 *            the abort to set
	 */
	public void setAbort(Buttons abort) {
		this.abort = abort;
	}

	/**
	 * @return the happyFaces
	 */
	public ArrayList<FixedObject> getHappyFaces() {
		return happyFaces;
	}

	/**
	 * @param happyFaces
	 *            the happyFaces to set
	 */
	public void setHappyFaces(ArrayList<FixedObject> happyFaces) {
		this.happyFaces = happyFaces;
	}

	/**
	 * @return the obstacle
	 */
	public ArrayList<FixedObject> getObstacle() {
		return obstacle;
	}

	/**
	 * @param obstacle
	 *            the obstacle to set
	 */
	public void setObstacle(ArrayList<FixedObject> obstacle) {
		this.obstacle = obstacle;
	}

	/**
	 * @return the mine
	 */
	public ArrayList<Mine> getMine() {
		return mine;
	}

	/**
	 * @param mine
	 *            the mine to set
	 */
	public void setMine(ArrayList<Mine> mine) {
		this.mine = mine;
	}

	/**
	 * 
	 * @return player1Balls
	 */
	public ArrayList<MovingBall> getPlayer1Balls() {
		return player1Balls;
	}

	/**
	 * 
	 * @param player1Balls
	 */
	public void setPlayer1Balls(ArrayList<MovingBall> player1Balls) {
		this.player1Balls.addAll(player1Balls);
	}

	/**
	 * 
	 * @return player2Balls
	 */
	public ArrayList<MovingBall> getPlayer2Balls() {
		return player2Balls;
	}

	/**
	 * 
	 * @param player2Balls
	 */
	public void setPlayer2Balls(ArrayList<MovingBall> player2Balls) {
		this.player2Balls.addAll(player2Balls);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * mousePressed verify that the balls and buttons are selected.
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		float x = 0, y = 0;
		if (Update.isPlayer1Turn()) {
			if (e.getX() > shoot1.getX()
					&& e.getX() < shoot1.getX() + shoot1.getWIDTH())
				if (e.getY() > shoot1.getY()
						&& e.getY() < shoot1.getY() + shoot1.getHEIGHT()) {
					setShoot1(true);
					shoot1.setY(shoot1.getY() + 10);
				}
			for (int i = 0; i < player1Balls.size() && !isShoot1; i++) {
				x = player1Balls.get(i).getX();
				y = player1Balls.get(i).getY();
				if (e.getX() > x && e.getX() < x + 20)
					if (e.getY() > y && e.getY() < y + 20) {
						if (selected) {
							for (int j = 0; j < player1Balls.size(); j++)
								player1Balls.get(j).setBallSelected(false);
							for (int k = 0; k < ballMoving.size(); k++)
								ballMoving.get(k).setBallSelected(false);
						}
						if (!player1Balls.get(i).isBallSelected())
							player1Balls.get(i).setBallSelected(true);
						else
							player1Balls.get(i).setBallSelected(false);
						selected = true;
					}
			}
		} else {
			if (e.getX() > shoot2.getX()
					&& e.getX() < shoot2.getX() + shoot2.getWIDTH())
				if (e.getY() > shoot2.getY()
						&& e.getY() < shoot2.getY() + shoot2.getHEIGHT()) {
					setShoot2(true);
					shoot2.setY(shoot2.getY() + 10);
				}
			for (int i = 0; i < player2Balls.size() && !isShoot2; i++) {
				x = player2Balls.get(i).getX();
				y = player2Balls.get(i).getY();
				if (e.getX() > x && e.getX() < x + 20)
					if (e.getY() > y && e.getY() < y + 20) {
						if (selected) {
							for (int j = 0; j < player2Balls.size(); j++)
								player2Balls.get(j).setBallSelected(false);
							for (int k = 0; k < ballMoving.size(); k++) {
								ballMoving.get(k).setBallSelected(false);
							}
						}
						if (!player2Balls.get(i).isBallSelected())
							player2Balls.get(i).setBallSelected(true);
						else
							player2Balls.get(i).setBallSelected(false);
						selected = true;
					}
			}
		}

		if (e.getX() > abort.getX()
				&& e.getX() < abort.getX() + abort.getWIDTH())
			if (e.getY() > abort.getY()
					&& e.getY() < abort.getY() + abort.getHEIGHT()) {
				setAbort(true);
				abort.setY(abort.getY() + 10);
			}
	}

	/**
	 * mouseReleased return all buttons to their normal state.
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		if (isShoot1) {
			setShoot1(false);
			shoot1.setY(shoot1.getY() - 10);
		} else if (isShoot2) {
			setShoot2(false);
			shoot2.setY(shoot2.getY() - 10);
		} else if (isAbort) {
			setAbort(false);
			abort.setY(abort.getY() - 10);
		}
	}
}
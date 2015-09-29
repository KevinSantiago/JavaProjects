import java.io.IOException;
import java.util.ArrayList;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

/**
 * The class {@link Update} keep updating the data. Distributes the data along
 * the program.
 * 
 * @author Kevin
 *
 */
public class Update {
	private static int x = 1100;
	private static int y = 0;
	private static boolean coverVisibility;
	private static boolean gameVisibility;
	private static Players players;
	private static int numOfBall;
	private static boolean firstTime;
	private static boolean isPlayer1Turn;
	public static boolean askAngle = true;
	public static boolean openFrameOneTime = true;
	public static ArrayList<MovingBall> ballMoving = new ArrayList<MovingBall>();

	public static boolean gameOver = false;
	private static boolean onlyOnTime = true;
	private static int score1;
	private static int score2;
	private static String player1;
	private static String player2;
	private static String date;
	public static GameOver over = new GameOver();

	private static ArrayList<MovingBall> ball1 = new ArrayList<MovingBall>();
	private static ArrayList<MovingBall> ball2 = new ArrayList<MovingBall>();
	private static ArrayList<FixedObject> happyFaces = new ArrayList<FixedObject>();
	private static ArrayList<FixedObject> obstacle = new ArrayList<FixedObject>();
	private static ArrayList<Mine> mine = new ArrayList<Mine>();

	private static boolean changeTurn = true;

	public static MovingBall rebound;
	public static MovingBall hitBall;

	private static ShowDraws draw;

	/*
	 * 
	 */
	public static void update(ShowDraws draw) throws IOException {
		Update.draw = draw;
		if (x > 0)
			x -= 5;
		if (gameVisibility && firstTime) {

			isPlayer1Turn = players.isPlayer1Turn();
			if (isPlayer1Turn) {
				if (ball1.size() == 0 && ballMoving.size() == 0) {
					score1 = players.getDistance1();
					score2 = players.getDistance2();
					gameOver = true;
				} else {
					onlyOnTime = true;
					setBall1(ballMotion(ball1));
					checkMineCollision();
					fixedObjectCollision();
				}

			} else {
				if (ball2.size() == 0 && ballMoving.size() == 0) {
					score1 = players.getDistance1();
					score2 = players.getDistance2();
					gameOver = true;
				} else {
					onlyOnTime = true;
					setBall2(ballMotion(ball2));
					checkMineCollision();
					fixedObjectCollision();
				}

			}
		}
		if (gameOver && onlyOnTime) {

			player1 = players.getPlayer1();
			player2 = players.getPlayer2();
			if (score1 > score2) {
				player1 += "-W";
				player2 += "-L";
			} else if (score1 < score2) {
				player2 += "-W";
				player1 += "-L";
			} else if (score1 == score2) {
				player2 += "-T";
				player1 += "-T";
			}
			onlyOnTime = false;
			gameOver = false;
			over.report(player1, player2, score1, score2, date);
		}
	}

	/**
	 * The method verify if a ball collides with a fixed Object.
	 */
	public static void fixedObjectCollision() {
		if (ballMoving.size() != 0) {
			for (int i = 0; i < obstacle.size(); i++) {
				for (int j = 0; j < ballMoving.size(); j++) {
					if (obstacle.get(i).colisionAction(ballMoving.get(j))) {
						ballMoving.remove(j);
						ballMoving.add(rebound);
					}
				}
			}
			for (int i = 0; i < happyFaces.size(); i++) {
				for (int j = 0; j < ballMoving.size(); j++) {
					if (happyFaces.get(i).colisionAction(ballMoving.get(j))) {
						ballMoving.remove(j);
						ballMoving.add(rebound);
						if (isPlayer1Turn)
							players.setDistance1(happyFaces.get(i)
									.isHappyFace());
						else
							players.setDistance2(happyFaces.get(i)
									.isHappyFace());
					}
				}
			}
		}
	}

	/**
	 * The method verify if a ball collides with a mine and destroy what is
	 * surrounded it.
	 */
	public static void checkMineCollision() {
		boolean isMineExplode = false;
		for (int i = 0; i < mine.size(); i++) {
			for (int j = 0; j < ballMoving.size(); j++)
				if (mine.get(i).colisionAction(ballMoving.get(j))) {
					isMineExplode = true;
					ballMoving.remove(j);
					j--;
				}
			if (isMineExplode) {
				for (int j = 0; j < happyFaces.size(); j++)
					if (mine.get(i).explosionRange(happyFaces.get(j))) {
						happyFaces.remove(j);
						j--;
					}
				for (int j = 0; j < obstacle.size(); j++)
					if (mine.get(i).explosionRange(obstacle.get(j))) {
						obstacle.remove(j);
						j--;
					}
				for (int j = 0; j < ball1.size(); j++)
					if (mine.get(i).explosionRange(ball1.get(j))) {
						ball1.remove(j);
						j--;
					}

				for (int j = 0; j < ball2.size(); j++)
					if (mine.get(i).explosionRange(ball2.get(j))) {
						ball2.remove(j);
						j--;
					}

				for (int j = 0; j < mine.size() && isMineExplode; j++)
					if (mine.get(i).explosionRange(mine.get(j)) && i != j) {
						mine.remove(i);
						checkMineCollision();
						isMineExplode = false;
						i--;
					}
				if (isMineExplode) {
					mine.remove(i);
					i--;
					isMineExplode = false;
				}
				if (ballMoving.size() == 0) {
					players.turns();
					askAngle = true;
					openFrameOneTime = true;
				}
			}
		}
	}

	/**
	 * The method realize everything about the balls motion and collisions with
	 * the same color balls and the opponent.
	 * 
	 * @param ball
	 * @return an ArrayList of MovingBall
	 */
	public static ArrayList<MovingBall> ballMotion(ArrayList<MovingBall> ball) {
		for (int i = 0; i < ball.size(); i++)
			ball.get(i).setPlayerTurn(false);
		for (int i = 0; i < ball.size(); i++)
			ball.get(i).setPlayerTurn(true);
		for (int i = 0; i < ball.size(); i++) {
			if (ball.get(i).isBallSelected()) {
				if (askAngle) {
					ball.get(i).setDistance(-1);
					ballMoving.add(ball.get(i));
					ball.remove(i);
				}
				i = ball.size() - 1;
			}
		}
		for (int i = 0; i < ballMoving.size(); i++) {
			for (int j = 0; j < ball.size(); j++)
				if (ballMoving.get(i).checkCollision(ball.get(j))) {
					hitBall.setBallSelected(true);
					ballMoving.add(hitBall);
					ball.remove(j);
				}
			if (isPlayer1Turn)
				for (int l = ball2.size() - 1; l >= 0; l--) {
					if (ballMoving.get(i).checkOpponentCollision(ball2.get(l))) {
						ball2.remove(l);
						players.setDistance1(100);
					}
				}
			else
				for (int l = ball1.size() - 1; l >= 0; l--) {
					if (ballMoving.get(i).checkOpponentCollision(ball1.get(l))) {
						ball1.remove(l);
						players.setDistance2(100);
					}
				}
		}

		for (int i = ballMoving.size() - 1; i >= 0; i--) {
			if (askAngle && draw.isShoot2()) {
				players.chooseDirection(askAngle, openFrameOneTime);
			}
			if (askAngle && draw.isShoot1()) {
				players.chooseDirection(askAngle, openFrameOneTime);
			}
			if (ballMoving.get(i).isBallSelected()
					&& (ballMoving.get(i).getDistance() > 0)) {
				ballMoving.get(i).move();
			} else if (!ballMoving.get(i).isBallSelected()
					|| (ballMoving.get(i).getDistance() == 0)) {
				ballMoving.get(i).setBallSelected(false);
				ball.add(ballMoving.get(i));
				if (ballMoving.get(i).getDistance() == 0 && changeTurn) {
					changeTurn = false;
					players.turns();
				}
				ballMoving.get(i).setDistance(-1);
				ballMoving.remove(i);
			}
		}
		if (!changeTurn) {
			if (ballMoving.size() > 0) {
				for (int i = 0; i < ballMoving.size();) {
					ballMoving.get(i).setBallSelected(false);
					ball.add(ballMoving.get(i));
					ballMoving.remove(i);
				}
			}
			ballMoving.clear();
			changeTurn = true;
		}
		return ball;
	}

	/**
	 * @param score1
	 *            the score1 to set
	 */
	public static void setScore1(int score1) {
		Update.score1 = score1;
	}

	/**
	 * @param score2
	 *            the score2 to set
	 */
	public static void setScore2(int score2) {
		Update.score2 = score2;
	}

	/**
	 * @return the gameOver
	 */
	public static boolean isGameOver() {
		return gameOver;
	}

	/**
	 * @param gameOver
	 *            the gameOver to set
	 */
	public static void setGameOver(boolean gameOver) {
		Update.gameOver = gameOver;
	}

	/**
	 * @return the ballMoving
	 */
	public static ArrayList<MovingBall> getBallMoving() {
		return ballMoving;
	}

	/**
	 * @param ballMoving
	 *            the ballMoving to set
	 */
	public static void setBallMoving(ArrayList<MovingBall> ballMoving) {
		Update.ballMoving = ballMoving;
	}

	/**
	 * @return the happyFaces
	 */
	public static ArrayList<FixedObject> getHappyFaces() {
		return happyFaces;
	}

	/**
	 * @param happyFaces
	 *            the happyFaces to set
	 */
	public static void setHappyFaces(ArrayList<FixedObject> happyFaces) {
		Update.happyFaces = happyFaces;
	}

	/**
	 * @return the obstacle
	 */
	public static ArrayList<FixedObject> getObstacle() {
		return obstacle;
	}

	/**
	 * @param obstacle
	 *            the obstacle to set
	 */
	public static void setObstacle(ArrayList<FixedObject> obstacle) {
		Update.obstacle = obstacle;
	}

	/**
	 * @return the mine
	 */
	public static ArrayList<Mine> getMine() {
		return mine;
	}

	/**
	 * @param mine
	 *            the mine to set
	 */
	public static void setMine(ArrayList<Mine> mine) {
		Update.mine = mine;
	}

	/**
	 * @return the ball1
	 */
	public static ArrayList<MovingBall> getBall1() {
		return ball1;
	}

	/**
	 * @return the ball2
	 */
	public static ArrayList<MovingBall> getBall2() {
		return ball2;
	}

	/**
	 * @param ball1
	 *            the ball1 to set
	 */
	public static void setBall1(ArrayList<MovingBall> ball1) {
		Update.ball1 = ball1;
	}

	/**
	 * @param ball2
	 *            the ball2 to set
	 */
	public static void setBall2(ArrayList<MovingBall> ball2) {
		Update.ball2 = ball2;
	}

	/**
	 * @return the isPlayer1Turn
	 */
	public static boolean isPlayer1Turn() {
		return isPlayer1Turn;
	}

	/**
	 * 
	 * @return the isFirstTime
	 */
	public static boolean isFirstTime() {
		return firstTime;
	}

	/**
	 * 
	 * @param firstTime 
	 */
	public static void setFirstTime(boolean firstTime) {
		Update.firstTime = firstTime;
	}

	/**
	 * 
	 * @param date
	 */
	public static void setDate(String date) {
		Update.date = date;
	}

	/**
	 * 
	 * @return date
	 */
	public static String getDate() {
		return date;
	}

	/**
	 * 
	 * @return score1
	 */
	public static int getScore1() {
		return score1;
	}

	/**
	 * 
	 * @return score2
	 */
	public static int getScore2() {
		return score2;
	}

	/**
	 * 
	 * @return distance1
	 */
	public static int getDistance1() {
		return players.getDistance1();
	}

	/**
	 * 
	 * @return distance2
	 */
	public static int getDistance2() {
		return players.getDistance2();
	}

	/**
	 * 
	 * @return numOfBall
	 */
	public static int getNumOfBall() {
		return numOfBall;
	}

	/**
	 * 
	 * @param numOfBall
	 */
	public static void setNumOfBall(int numOfBall) {
		Update.numOfBall = numOfBall;
	}

	/**
	 * 
	 * @return player1
	 */
	public static String getPlayer1() {
		return players.getPlayer1();
	}

	/**
	 * 
	 * @return player2
	 */
	public static String getPlayer2() {
		return players.getPlayer2();
	}

	/**
	 * 
	 * @param visible
	 */
	public static void setGameVisibility(boolean visible) {
		Update.gameVisibility = visible;
	}

	/**
	 * 
	 * @return gameVisibility
	 */ 
	public static boolean isGameVisibility() {
		return gameVisibility;
	}

	/**
	 * 
	 * @param visible
	 */
	public static void setCoverVisibility(boolean visible) {
		Update.coverVisibility = visible;
	}

	/**
	 * 
	 * @return coverVisibility
	 */
	public static boolean isCoverVisibility() {
		return coverVisibility;
	}

	/**
	 * 
	 * @param players
	 */
	public static void setPlayers(Players players) {
		Update.players = players;
	}

	/**
	 * 
	 * @return x
	 */
	public static int getX() {
		return x;
	}

	/**
	 * 
	 * @return y
	 */
	public static int getY() {
		return y;
	}
}
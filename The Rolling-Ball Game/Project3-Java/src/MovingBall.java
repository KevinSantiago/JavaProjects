
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;


/**
 * The class {@link MovingBall} contains everything about balls that going to be
 * moved on the game. Also make possible that the balls have motion.
 * 
 * @author Kevin
 *
 */
public class MovingBall extends GameObject implements Balls {

	private Color color;
	private boolean isBallSelected = false;
	private boolean playerTurn = false;
	private double xSpeed = 0;
	private double ySpeed = 0;
	private int distance = -1;
	private double angle = 0;
	private boolean up = false;
	private boolean down = false;
	private boolean left = false;
	private boolean right = false;

	/**
	 * 
	 * @param playerTurn
	 */
	public void setPlayerTurn(boolean playerTurn) {
		this.playerTurn = playerTurn;
	}

	/**
	 * 
	 * @return isBallSelected
	 */
	public boolean isBallSelected() {
		return isBallSelected;
	}

	/**
	 * 
	 * @param isBallSelected
	 */
	public void setBallSelected(boolean isBallSelected) {
		this.isBallSelected = isBallSelected;
	}

	/**
	 * The {@link MovingBall} constructor creates a ball with a specific color
	 * that will represents a player.
	 * 
	 * @param color
	 */
	public MovingBall(Color color) {
		super();
		super.randomDistribution();
		this.color = color;
	}

	/**
	 * The method creates balls to be displayed in a panel.
	 */
	@Override
	public void balls(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(color);
		Ellipse2D.Double circle = new Ellipse2D.Double(x, y, WIDTH, HEIGHT);
		g2.fill(circle);
		if (isBallSelected && playerTurn) {
			g2.setColor(Color.black);
			Ellipse2D.Double out1Circle = new Ellipse2D.Double(x - 1, y - 1,
					WIDTH + 2, HEIGHT + 2);
			Ellipse2D.Double out2Circle = new Ellipse2D.Double(x - 2, y - 2,
					WIDTH + 4, HEIGHT + 4);
			g2.draw(out1Circle);
			g2.draw(out2Circle);

		}
	}

	/**
	 * The method move have the instructions that determines the direction and
	 * displacement that the ball will have.
	 */
	public void move() {
		if (distance > 0) {
			distance--;
			if (distance == 0) {
				setBallSelected(false);
			}
			float changeX = getX();
			float changeY = getY();

			double radius = Math.sqrt(2);
			double theta = (angle / 180.0) * (Math.PI);
			setxSpeed(radius * Math.cos(theta));
			setySpeed(radius * Math.sin(theta));

			// border
			if (changeX >= 710) {
				right = false;
				left = true;
			} else if (changeX <= 31) {
				right = true;
				left = false;
			} else if (changeY >= 710) {
				up = true;
				down = false;
			} else if (changeY <= 31) {
				up = false;
				down = true;
			}

			if (up) {
				changeY -= (float) Math.abs(ySpeed);
			}
			if (down) {
				changeY += (float) Math.abs(ySpeed);
			}
			if (left) {
				changeX -= (float) Math.abs(xSpeed);
			}
			if (right) {
				changeX += (float) Math.abs(xSpeed);
			}
			setX(changeX);
			setY(changeY);
			if (distance == 0) {
				Update.askAngle = true;
				Update.openFrameOneTime = true;
			}
		}
	}

	/**
	 * The method checkOpponentCollision verify if the ball collides with
	 * opponent ball.
	 * 
	 * @param b2
	 * @return true if collides with opponent ball or false if not.
	 */
	public boolean checkOpponentCollision(MovingBall b2) {
		double xCenterball1 = x + 10;
		double yCenterball1 = y + 10;
		double xCenterball2 = b2.getX() + 10;
		double yCenterball2 = b2.getY() + 10;

		double xChange = Math.abs(xCenterball1 - xCenterball2);
		double yChange = Math.abs(yCenterball1 - yCenterball2);

		double distanceBetweenBalls = Math.sqrt(yChange * yChange + xChange
				* xChange);

		if (distanceBetweenBalls < ((WIDTH))) {
			return true;
		}
		return false;
	}

	/**
	 * The method checkCollision verify if the ball collides with ball of the
	 * same player and calculate the direction and displacement that both ball
	 * will have after the collision.
	 * 
	 * @param b2
	 * @return true if the ball collides with another ball and false if not.
	 */
	public boolean checkCollision(MovingBall b2) {

		double xCenterball1 = x + 10;
		double yCenterball1 = y + 10;
		double xCenterball2 = b2.getX() + 10;
		double yCenterball2 = b2.getY() + 10;

		double angle2 = 0;
		double angle1 = 0;
		double xChange = Math.abs(xCenterball1 - xCenterball2);
		double yChange = Math.abs(yCenterball1 - yCenterball2);

		double distanceBetweenBalls = Math.sqrt(yChange * yChange + xChange
				* xChange);

		if (distanceBetweenBalls < ((WIDTH))) {

			double newxSpeed1 = (xSpeed * (0.4 - 0.5) + (2 * 0.5 * 0.1)) / 0.9;

			double newxSpeed2 = (0.1 * (0.5 - 0.4) + (2 * 0.4 * xSpeed)) / 0.9;

			double newySpeed1 = (ySpeed * (0.4 - 0.5) + (2 * 0.5 * 0.1)) / 0.9;

			double newySpeed2 = (0.1 * (0.5 - 0.4) + (2 * 0.4 * ySpeed)) / 0.9;

			angle2 = Math.atan(newySpeed2 / newxSpeed2);
			angle2 = (angle2 * 180) / Math.PI;
			b2.setDistance(distance / 2);
			b2.setxSpeed(newxSpeed2);
			b2.setySpeed(newySpeed2);
			b2.setAngle(angle);

			angle1 = Math.atan(newySpeed1 / newxSpeed1);
			angle1 = (angle1 * 180) / Math.PI;
			setxSpeed(newxSpeed1);
			setAngle(angle1);
			setySpeed(newySpeed1);
			setDistance(distance / 2);

			if (newxSpeed2 > 0) {
				b2.setRight(true);
				b2.setLeft(false);
			} else if (newxSpeed2 < 0) {
				b2.setRight(false);
				b2.setLeft(true);
			} else if (newxSpeed2 == 0 && newySpeed2 < 0) {
				b2.setRight(false);
				b2.setLeft(false);
				b2.setUp(false);
				b2.setDown(true);
			} else {
				b2.setRight(false);
				b2.setLeft(false);
				b2.setUp(true);
				b2.setDown(false);
			}
			if (newySpeed2 > 0) {
				b2.setUp(true);
				b2.setDown(false);
			} else if (newySpeed2 < 0) {
				b2.setUp(false);
				b2.setDown(true);
			} else if (newySpeed2 == 0 && newxSpeed2 < 0) {
				b2.setRight(false);
				b2.setLeft(true);
				b2.setUp(false);
				b2.setDown(false);
			} else {
				b2.setRight(true);
				b2.setLeft(false);
				b2.setUp(false);
				b2.setDown(false);
			}
			Update.hitBall = b2;
			return true;
		}
		return false;
	}

	/**
	 * @return the distance
	 */
	public int getDistance() {
		return distance;
	}

	/**
	 * @param distance
	 *            the distance to set
	 */
	public void setDistance(int distance) {
		this.distance = distance;
	}

	/**
	 * @param angle
	 *            the angle to set
	 */
	public void setAngle(double angle) {
		this.angle = angle;
	}

	/**
	 * @param up
	 *            the up to set
	 */
	public void setUp(boolean up) {
		this.up = up;
	}

	/**
	 * @param down
	 *            the down to set
	 */
	public void setDown(boolean down) {
		this.down = down;
	}

	/**
	 * @param left
	 *            the left to set
	 */
	public void setLeft(boolean left) {
		this.left = left;
	}

	/**
	 * @param right
	 *            the right to set
	 */
	public void setRight(boolean right) {
		this.right = right;
	}

	/**
	 * @return the xSpeed
	 */
	public double getxSpeed() {
		return xSpeed;
	}

	/**
	 * @param xSpeed
	 *            the xSpeed to set
	 */
	public void setxSpeed(double xSpeed) {
		this.xSpeed = xSpeed;
	}

	/**
	 * @return the ySpeed
	 */
	public double getySpeed() {
		return ySpeed;
	}

	/**
	 * @param ySpeed
	 *            the ySpeed to set
	 */
	public void setySpeed(double ySpeed) {
		this.ySpeed = ySpeed;
	}

}

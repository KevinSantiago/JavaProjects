
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;


/**
 * The class {@link FixedObject} creates fixed objects like obstacles and happy
 * faces.
 * 
 * @author Kevin
 *
 */
public class FixedObject extends GameObject implements Balls,
		CollisionSensitive {

	private Color color;
	private boolean isBallSelected = false;

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
	 * The {@link FixedObject} constructor create a new fixed object whit the
	 * specific color and also run the {@link GameObject} constructor.
	 * 
	 * @param color
	 */
	public FixedObject(Color color) {
		super();
		super.randomDistribution();
		this.color = color;
	}

	/**
	 * The method creates balls to be displayed in a panel.
	 */
	@Override
	public void balls(Graphics g) {
		int x1 = (int) x;
		int y1 = (int) y;

		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(color);
		Ellipse2D.Double circle = new Ellipse2D.Double(x1, y1, WIDTH, HEIGHT);
		g2.fill(circle);

		g2.setColor(Color.black);
		Ellipse2D.Double out1Circle = new Ellipse2D.Double(x1, y1, WIDTH,
				HEIGHT);
		g2.draw(out1Circle);
		g2.fillOval(x1 + 5, y1 + 6, 4, 4);
		g2.fillOval(x1 + 13, y1 + 6, 4, 4);
		g2.drawArc(x1 + 4, y1 + 3, 12, 12, 190, 160);
		g2.drawArc(x1 + 4, y1 + 4, 12, 13, 190, 160);
	}

	/**
	 * The colisionAction determines if the ball was hit by an another ball.
	 * @return true if the ball collides with another and false if not.
	 */
	@Override
	public boolean colisionAction(MovingBall balls) {

		double xCenterball1 = x + 10;
		double yCenterball1 = y + 10;
		double xCenterball2 = balls.getX() + 10;
		double yCenterball2 = balls.getY() + 10;

		double xChange = Math.abs(xCenterball1 - xCenterball2);
		double yChange = Math.abs(yCenterball1 - yCenterball2);

		double distance = Math.sqrt(xChange * xChange + yChange * yChange);

		if (distance < ((WIDTH))) {

			double xBound = x + 3.5;
			double yBound = y + 3.5;
			if (balls.getX() >= xBound + 12.5) {
				balls.setRight(true);
				balls.setLeft(false);
			} else if (balls.getX() <= xBound) {
				balls.setRight(false);
				balls.setLeft(true);
			} else if (balls.getY() >= yBound + 12.5) {
				balls.setUp(false);
				balls.setDown(true);
			} else if (balls.getY() <= yBound) {
				balls.setUp(true);
				balls.setDown(false);
			}
			Update.rebound = balls;
			return true;
		}
		return false;
	}

	/**
	 * The method return 50 if the ball is a happy face.
	 * 
	 * @return
	 */
	public int isHappyFace() {
		return 50;
	}
}

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

/**
 * The class {@link Mine} creates everything of the mine object.
 * 
 * @author Kevin
 *
 */
public class Mine extends GameObject implements Balls {

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
	 * The constructor {@link Mine} creates a ball with a color that will
	 * identify a mine.
	 * 
	 * @param color
	 */
	public Mine(Color color) {
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

		g2.setColor(Color.black);
		g2.drawOval((int) x, (int) y, WIDTH, HEIGHT);
	}

	/**
	 * The method explosionRange check an object is closer enough to explode
	 * with the explosion range.
	 * 
	 * @param gameObject
	 * @return
	 */
	public boolean explosionRange(GameObject gameObject) {
		double xCenterball1 = x + 10;
		double yCenterball1 = y + 10;

		if (gameObject instanceof MovingBall) {
			MovingBall object = (MovingBall) gameObject;

			double xCenterball2 = object.getX() + 10;
			double yCenterball2 = object.getY() + 10;

			double deltaX = Math.abs(xCenterball1 - xCenterball2);
			double deltaY = Math.abs(yCenterball1 - yCenterball2);

			if ((deltaX <= (WIDTH + 25) && (deltaY <= (WIDTH + 25)))) {
				return true;
			}

		} else if (gameObject instanceof FixedObject) {
			FixedObject object = (FixedObject) gameObject;

			double xCenterball2 = object.getX() + 10;
			double yCenterball2 = object.getY() + 10;

			double deltaX = Math.abs(xCenterball1 - xCenterball2);
			double deltaY = Math.abs(yCenterball1 - yCenterball2);

			if ((deltaX <= (WIDTH / 2) * 2) && (deltaY <= (WIDTH / 2) * 2)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * The colisionAction determines if the ball was hit by an another ball.
	 */
	public boolean colisionAction(MovingBall balls) {
		double xCenterball1 = x + 10;
		double yCenterball1 = y + 10;
		double xCenterball2 = balls.getX() + 10;
		double yCenterball2 = balls.getY() + 10;

		double deltaX = Math.abs(xCenterball1 - xCenterball2);
		double deltaY = Math.abs(yCenterball1 - yCenterball2);

		if ((deltaX <= (WIDTH / 2) * 2) && (deltaY <= (WIDTH / 2) * 2)) {
			return true;
		}
		return false;
	}

}

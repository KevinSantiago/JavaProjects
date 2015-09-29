
import java.util.Random;

/**
 * The class {@link GameObject} is the most general about balls, it decide the
 * position of the balls on the panel.
 * 
 * @author Kevin
 *
 */
public class GameObject {

	protected Random random;
	protected int playersBalls;

	protected final int WIDTH = 20;
	protected final int HEIGHT = 20;
	protected float x;
	protected float y;

	/**
	 * 
	 * @return x
	 */
	public float getX() {
		return x;
	}

	/**
	 * 
	 * @param x
	 */
	public void setX(float x) {
		this.x = x;
	}

	/**
	 * 
	 * @return y
	 */
	public float getY() {
		return y;
	}

	/**
	 * 
	 * @param y
	 */
	public void setY(float y) {
		this.y = y;
	}

	/**
	 * The method determine the random number to put it on the balls
	 * coordinates.
	 */
	public void randomDistribution() {
		random = new Random();
		x = (random.nextInt(669) + 31);
		y = (random.nextInt(669) + 31);
	}
}

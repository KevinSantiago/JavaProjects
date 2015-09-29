import java.awt.Graphics;

/**
 * The class RotationCounterFrame put every digits of the rotation number in an
 * array.
 * 
 * @author Kevin
 *
 */
public class RotationCounterFrame {
	public static final int NUMBER_OF_DIGITS = 7;
	int x;
	int y;
	int rotation = Update.rotation;

	public static int[] revolutionCounter = new int[NUMBER_OF_DIGITS];
	int[] unity = new int[NUMBER_OF_DIGITS];

	/**
	 * The constructor create new RotationCounterFrame in a specific position.
	 * 
	 * @param x
	 *            is the position on x axis where the RotationCounterFrame will
	 *            be positioned
	 * @param y
	 *            is the position on y axis where the RotationCounterFrame will
	 *            be positioned
	 */
	public RotationCounterFrame(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Separate the roation number in digits in the range between 0 and 9999999
	 * and put every digits in an array.
	 * 
	 * @param g
	 */
	public void rotationCounterFrame(Graphics g) {
		int pixel = 0;

		for (int i = 0; i < NUMBER_OF_DIGITS; i++) {
			g.drawRect(x + pixel, y, 35, 40);
			pixel += 35;
		}

		for (int i = revolutionCounter.length - 1, j = 0; i >= 0; i--, j++)
			unity[j] = (int) Math.pow(10, i);

		if (rotation <= 9999999)
			for (int i = 0; i < revolutionCounter.length; i++) {
				revolutionCounter[i] = rotation / unity[i];
				if (revolutionCounter[i] >= 1)
					rotation -= revolutionCounter[i] * unity[i];
			}

	}
}

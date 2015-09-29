import java.awt.*;

/**
 * Draws almost every letters of the program.
 * 
 * @author Kevin
 *
 */
public class Names {
	int positionX = ShapesMotion.positionX;
	int positionY = ShapesMotion.positionY;
	int rotation = Update.rotation;

	/**
	 * The constructor create new names.
	 * 
	 * @param x
	 *            is the position on x axis
	 * @param y
	 *            is the position on y axis
	 */
	public Names(int x, int y) {
		this.positionX = x;
		this.positionY = y;
	}

	/**
	 * Draws the speedometer name on display.
	 * @param g
	 */
	public void speedmeter(Graphics g) {
		Font font = new Font("Arial", Font.BOLD, 14);
		g.setFont(font);
		String[] temp = { "S", "P", "E", "E", "D", "O", "M", "E", "T", "E", "R" };
		int x = positionX - 10;
		int y = positionY + 60;

		int i = 0;
		int pixel = 0;
		for (i = 0; i < temp.length; i++) {
			if (temp[i].compareTo("M") == 0) {
				g.drawString(temp[i], x + 68, y + 210);
			} else {
				g.drawString(temp[i], x + 70, y + pixel + 120);
			}
			pixel += 15;
		}
	}

	/**
	 * Draws the wheel name on display.
	 * @param g
	 */
	public void wheel(Graphics g) {
		Font font = new Font("Arial", Font.BOLD, 14);
		g.setFont(font);
		g.setColor(Color.black);
		String[] temp = { "W", "H", "E", "E", "L" };
		int x = positionX + 610;
		int y = positionY + 95;

		int i = 0;
		int pixel = 0;
		for (i = 0; i < temp.length; i++) {
			if (temp[i].compareTo("W") == 0) {
				g.drawString(temp[i], x + 68, y + 120);
			} else {
				g.drawString(temp[i], x + 70, y + pixel + 120);
			}
			pixel += 15;
		}
	}

	/**
	 * Draws the fuel tank name on display.
	 * @param g
	 */
	public void fuelTank(Graphics g) {

		int i = 0;
		int pixel = 0;
		String[] temp = { "F", "U", "E", "L", " ", "T", "A", "N", "K" };
		int x = positionX;
		int y = positionY;

		Font font = new Font("Arial", Font.BOLD, 14);
		g.setFont(font);

		g.drawString("Fuel Meter", x + 147, y + 400);
		g.drawString("E", x + 85, y + 400);
		g.drawString("F", x + 280, y + 400);

		font = new Font("Arial", Font.BOLD, 20);
		g.setFont(font);

		for (i = 0; i < temp.length; i++) {

			g.drawString(temp[i], x + 860, y + pixel + 232);
			pixel += 20;
		}
	}

	/**
	 * Draws the rotation digits on display.
	 * @param g
	 */
	public void rotationCounter(Graphics g) {
		int arrayLength = RotationCounterFrame.NUMBER_OF_DIGITS;
		String[] revolutionCounter = new String[arrayLength];

		int x = positionX + 250;
		int y = positionY + 50;

		Font font = new Font("Arial", Font.BOLD, 20);
		g.setFont(font);

		for (int i = 0; i < revolutionCounter.length; i++)
			revolutionCounter[i] = ""
					+ RotationCounterFrame.revolutionCounter[i];

		for (int i = 0, j = x + 13; i < revolutionCounter.length; i++) {
			g.drawString(revolutionCounter[i], j, y + 27);
			if (i % 2 == 0)
				j += 34;
			else
				j += 36;
		}

		font = new Font("Arial", Font.BOLD, 14);
		g.setFont(font);

		g.drawString("Revolution Counter", x + 55, y + 52);
	}

	/**
	 * Draws add gas on display.
	 * @param g
	 */
	public void AddGas(Graphics g) {
		g.drawString("Add Gas", Buttons.xRefillFuel + 50,
				Buttons.yRefillFuel + 30);
	}

	/**
	 * Draws speed control on display.
	 * @param g
	 */
	public void speedControl(Graphics g) {
		g.setColor(Color.black);
		g.setFont(new Font("Arial", Font.BOLD, 15));
		g.drawString("SPEED CONTROLS", Buttons.xSpeedDown - 2,
				Buttons.ySpeed + 85);
	}
}

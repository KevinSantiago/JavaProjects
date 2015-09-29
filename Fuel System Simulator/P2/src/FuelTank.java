import java.awt.Color;
import java.awt.Graphics;

/**
 * The class has everything about the fuel tank as it shape and behavior.
 * 
 * @author Kevin
 *
 */
public class FuelTank {
	public static int height = 400;
	private int positionX;
	private int positionY;
	private int decreaseTank = Update.fuelConsumption;
	private int decreaseFuelMeter = Update.fuelConsumption / 2;

	Color newColor;

	/**
	 * The constructor create a new fuel tank and set a reference position.
	 * 
	 * @param x
	 *            is the position on x axis
	 * @param y
	 *            is the position on y axis
	 */
	public FuelTank(int x, int y) {
		this.positionX = x;
		this.positionY = y;
	}

	/**
	 * Draws fuel tank, as the tank's frame and the gasoline.
	 * 
	 * @param g
	 */
	public void fuelTank(Graphics g) {
		int x1 = positionX + 765;
		int y1 = positionY + 102;

		newColor = new Color(255, 200, 200);// Create new color.
		int width = 75;

		// External fuel tank frame
		g.setColor(Color.black);
		g.drawRect(x1, y1 - 1, width, height + 1);

		// Gas connector
		g.setColor(Color.black);
		g.fillRect(x1 - 20, y1 + 388, 20, 13);

		// Gas rectangle
		g.setColor(newColor);
		g.fillRect(x1 + 1, y1 + decreaseTank, width - 1, height - decreaseTank);
	}

	/**
	 * Draws fuel meter's shape, as the frame, all the division lines, and the
	 * quantity of gasoline in tank.
	 * 
	 * @param g
	 */
	public void fuelMeter(Graphics g) {
		int x = positionX;
		int y = positionY;

		// Draws the fuel meter frame
		g.setColor(Color.black);
		g.drawRect(x + 86, y + 350, height / 2 + 1, 35);

		// Draw fuel meter division lines
		for (int i = 0, j = 136; i < 3; i++, j += 50)
			g.drawLine(x + j, y + 355, x + j, y + 380);

		for (int i = 0, j = 111; i < 4; i++, j += 50)
			g.drawLine(x + j, y + 358, x + j, y + 377);

		for (int i = 1, j = 91; i < 33; i++) {
			g.drawLine(x + j, y + 360, x + j, y + 375);
			if (i % 4 == 0)
				j += 10;
			else
				j += 5;
		}

		// Draws the real time of fuel content
		g.setColor(Color.red);
		g.fillRect(x + 87, y + 365, height / 2 - decreaseFuelMeter, 5);
	}
}

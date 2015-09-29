import java.awt.Color;
import java.awt.Graphics;

/**
 * The class has the button's figures and some decoration.
 * 
 * @author Kevin
 *
 */
public class Buttons {

	// SpeedControlButton's variables
	public static int xSpeedUp = ShapesMotion.positionX + 575;
	public static int xSpeedDown = ShapesMotion.positionX + 490;
	public static int ySpeed = ShapesMotion.positionY + 350;
	public static int buttonWidth = 50;
	public static int buttonHeight = 50;
	int pressSpeedUp = 0;
	int pressSpeedDown = 0;

	// reFillFuelTank's variables
	public static int xRefillFuel = ShapesMotion.positionX + 85;
	public static int yRefillFuel = ShapesMotion.positionY + 430;
	public static int refillWidth = 45;
	public static int refillHeight = 35;
	int pressRefill = 0;

	/**
	 * The method draws the speeds buttons and decorations.
	 * 
	 * @param g
	 */
	public void speedControlButton(Graphics g) {
		int ySpeedUpTriangle = ySpeed - 25;
		int ySpeedUpSquare = ySpeed + 23;
		int ySpeedDownTriangle = ySpeed + 18;
		int ySpeedDownSquare = ySpeed + 5;

		if (DisplayShapes.validateUp)
			pressSpeedUp = 10;
		else
			pressSpeedUp = 0;

		g.setColor(new Color(24, 113, 9));
		g.fillRoundRect(xSpeedUp, ySpeed + 10, buttonWidth, buttonHeight, 12,
				12);
		g.setColor(new Color(38, 180, 14));
		g.fillRoundRect(xSpeedUp, ySpeed + pressSpeedUp, buttonWidth,
				buttonHeight, 12, 12);

		if (DisplayShapes.validateDown)
			pressSpeedDown = 10;
		else
			pressSpeedDown = 0;

		g.setColor(new Color(159, 0, 4));
		g.fillRoundRect(xSpeedDown, ySpeed + 10, buttonWidth, buttonHeight, 12,
				12);
		g.setColor(new Color(255, 4, 11));
		g.fillRoundRect(xSpeedDown, ySpeed + pressSpeedDown, buttonWidth,
				buttonHeight, 12, 12);

		// Draws the an arrow for speed up and speed down
		g.setColor(Color.white);
		g.fillRect(xSpeedUp + 17, ySpeedUpSquare + pressSpeedUp, 15, 20);
		g.fillArc(xSpeedUp - 4, ySpeedUpTriangle + pressSpeedUp, 56, 56, 245,
				50);
		g.fillRect(xSpeedDown + 17, ySpeedDownSquare + pressSpeedDown, 15, 20);
		g.fillArc(xSpeedDown - 4, ySpeedDownTriangle + pressSpeedDown, 56, 56,
				65, 50);
	}

	/**
	 * The method draws the gas buttons and decorations.
	 * 
	 * @param g
	 */
	public void refillFuelTank(Graphics g) {
		if (DisplayShapes.refillButtonPressed) {
			pressRefill = 10;
		} else
			pressRefill = 0;

		int yGasSymbol = yRefillFuel + pressRefill;
		// Draws refillFuelTTank button
		g.setColor(new Color(74, 128, 128));
		g.fillRoundRect(xRefillFuel, yRefillFuel + 10, refillWidth,
				refillHeight, 15, 15);

		g.setColor(new Color(68, 182, 215));
		g.fillRoundRect(xRefillFuel, yRefillFuel + pressRefill, refillWidth,
				refillHeight, 15, 15);

		// Draws fuel symbol
		if (Update.alertGas)
			g.setColor(Color.orange);
		else
			g.setColor(Color.white);

		for (int i = 0, j = 23; i < 12; i++, j--)
			g.fillOval(xRefillFuel + 33, yGasSymbol + j, 3, 3);
		for (int i = 0, j = 17; i < 5; i++, j++)
			g.fillOval(xRefillFuel + 30, yGasSymbol + j, 3, 3);

		g.fillRoundRect(xRefillFuel + 12, yGasSymbol + 5, 18, 25, 3, 3);
		g.fillRect(xRefillFuel + 10, yGasSymbol + 27, 22, 3);
		g.fillOval(xRefillFuel + 27, yGasSymbol + 16, 3, 3);
		g.fillOval(xRefillFuel + 29, yGasSymbol + 16, 3, 3);
		g.fillOval(xRefillFuel + 30, yGasSymbol + 8, 3, 3);
		g.fillOval(xRefillFuel + 31, yGasSymbol + 23, 3, 3);
		g.fillOval(xRefillFuel + 31, yGasSymbol + 9, 3, 3);
		g.fillOval(xRefillFuel + 32, yGasSymbol + 24, 3, 3);
		g.fillOval(xRefillFuel + 32, yGasSymbol + 10, 3, 3);
		g.fillOval(xRefillFuel + 33, yGasSymbol + 11, 3, 3);
		g.fillOval(xRefillFuel + 34, yGasSymbol + 12, 3, 3);

		g.setColor(new Color(68, 182, 215));
		g.fillRect(xRefillFuel + 15, yGasSymbol + 8, 12, 8);
	}
}

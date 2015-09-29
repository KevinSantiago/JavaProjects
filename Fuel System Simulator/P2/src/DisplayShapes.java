import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * The class has to display all the system shapes at the same time and has the
 * mouse behavior to control the gas refill and the speed of the system.
 * 
 * @author Kevin
 *
 */
public class DisplayShapes extends JPanel implements MouseListener {

	private int positionX;
	private int positionY;

	public static boolean validateUp = false;
	public static boolean validateDown = false;
	public static boolean refillButtonPressed = false;
	public static int speed = 0;
	public static int speedUpOrDown = 0;

	SpeedControl speedControl;
	// Speed button's variables
	static int xSpeedUp = Buttons.xSpeedUp;
	static int xSpeedDown = Buttons.xSpeedDown;
	static int ySpeed = Buttons.ySpeed;
	static int speedHeight = Buttons.buttonHeight;
	static int speedWidth = Buttons.buttonWidth;

	// Refill Fuel Tank's variables
	static int xRefillFuel = Buttons.xRefillFuel;
	static int yRefillFuel = Buttons.yRefillFuel;
	static int refillHeight = Buttons.refillHeight;
	static int refillWidth = Buttons.refillWidth;

	/**
	 * The constructor create a DisplayShapes with one coordinate and activate
	 * the MouseListener.
	 * 
	 * @param x
	 *            is the coordinate of x
	 * @param y
	 *            is the coordinate of y
	 */
	public DisplayShapes(int x, int y) {
		addMouseListener(this);
		this.positionX = x;
		this.positionY = y;
	}

	/**
	 * Draws all the figures on the panel.
	 */
	public void paint(Graphics g) {
		Names name = new Names(positionX, positionY);
		Frame frame = new Frame(positionX, positionY);
		FuelTank fuel = new FuelTank(positionX, positionY);
		Speedometer speedmeter = new Speedometer(positionX + 97,
				positionY + 150);
		Wheel wheel = new Wheel(positionX + 460, positionY + 142);
		RotationCounterFrame rotationFrame = new RotationCounterFrame(
				positionX + 250, positionY + 50);
		Buttons buttons = new Buttons();

		frame.frame(g);

		name.fuelTank(g);
		name.speedmeter(g);
		name.wheel(g);
		name.rotationCounter(g);
		name.speedControl(g);
		name.AddGas(g);

		rotationFrame.rotationCounterFrame(g);
		fuel.fuelTank(g);
		fuel.fuelMeter(g);
		speedmeter.speedometer(g);
		wheel.wheel(g);
		buttons.speedControlButton(g);
		buttons.refillFuelTank(g);

	}
	@Override
	public void mouseClicked(MouseEvent e) {
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}
	@Override
	public void mousePressed(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) {
			// Speed buttons
			if (ySpeed <= e.getY() && ySpeed + speedHeight >= e.getY())
				if (xSpeedUp <= e.getX() && xSpeedUp + speedWidth >= e.getX()) {
					if (speed < 60 && Update.fuelTank) {
						speed++;
						speedControl = new SpeedControl(speed);
						speedControl.speedControl();
					}
					validateUp = true;
					speedUpOrDown = 1;
				} else if (xSpeedDown <= e.getX()
						&& xSpeedDown + speedWidth >= e.getX()) {
					if (speed > 0) {
						speed--;
						if (speed == 0)
							ShapesMotion.speedControl = 12;
						else {
							speedControl = new SpeedControl(speed);
							speedControl.speedControl();
						}
					}
					validateDown = true;
					speedUpOrDown = -1;
				}

			// RefillFuel button
			if (yRefillFuel <= e.getY()
					&& yRefillFuel + refillHeight >= e.getY())
				if (xRefillFuel <= e.getX()
						&& xRefillFuel + refillWidth >= e.getX())
					refillButtonPressed = true;
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		validateUp = false;
		validateDown = false;
		refillButtonPressed = false;
	}
}

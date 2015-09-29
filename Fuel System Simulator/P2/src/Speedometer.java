import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 * The class has all figures that form the speedometer as the needle, speed's
 * numbers, digital display, a high speed light, and so on.
 * 
 * @author Kevin
 *
 */
public class Speedometer {
	int x;
	int y;
	int speed = DisplayShapes.speed;
	Color newColor;

	/**
	 * The constructor create new speedometer in a specific position.
	 * 
	 * @param x
	 *            is the position on x axis where the speedometer will be
	 *            positioned
	 * @param y
	 *            is the position on y axis where the speedometer will be
	 *            positioned
	 */
	public Speedometer(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Draws everything about the speedometer.
	 * 
	 * @param g
	 *            is the Graphics constructor
	 */
	public void speedometer(Graphics g) {
		newColor = new Color(225, 0, 5);

		int angleChange = Update.speedmeterAngleChange;
		int diameter = 180;
		int r = diameter / 2;
		int a = diameter / 10;

		// Draws external ring of the speedometer
		newColor = new Color(201, 201, 201);// Create light gray
		g.setColor(newColor);
		g.fillOval(x - 8, y - 8, diameter + 16, diameter + 16);

		g.setColor(Color.gray);
		g.fillOval(x - 6, y - 6, diameter + 12, diameter + 12);

		g.setColor(newColor);
		g.fillOval(x - 4, y - 4, diameter + 8, diameter + 8);

		// Draws the background of the speedometer
		g.setColor(new Color(75, 75, 75));// Set dark gray
		g.fillOval(x, y, diameter, diameter);

		// Draws the colors that represents speeds
		g.setColor(new Color(170, 9, 25));// Set red
		g.fillArc(x + 2, y + 2, diameter - 4, diameter - 4, 315, 44);

		g.setColor(new Color(240, 84, 25));// Set orange
		g.fillArc(x + 2, y + 2, diameter - 4, diameter - 4, 1, 43);

		g.setColor(new Color(242, 177, 57));// Set light orange
		g.fillArc(x + 2, y + 2, diameter - 4, diameter - 4, 46, 43);

		g.setColor(new Color(248, 233, 97));// Set yellow
		g.fillArc(x + 2, y + 2, diameter - 4, diameter - 4, 91, 43);

		g.setColor(new Color(180, 184, 61));// Set light green
		g.fillArc(x + 2, y + 2, diameter - 4, diameter - 4, 136, 43);

		g.setColor(new Color(121, 167, 17));// Set dark Green
		g.fillArc(x + 2, y + 2, diameter - 4, diameter - 4, 182, 43);

		// Erase part of the colors draw above
		g.setColor(new Color(75, 75, 75));// Set dark gray
		g.fillOval(x + 14, y + 14, diameter - 28, diameter - 28);

		// Draws the speedmeter's lines
		g.setColor(Color.white);

		g.drawLine((r + x), (y), r + x, y + r);
		g.drawLine((x), (y + r), (x + 2 * r), (y + r));
		g.drawLine((r + x + (r / 2) + a), (y + (r / 2) - a), (x + a + (a / 2)),
				(y + (r / 2) + r + a));
		g.drawLine((x + a + (a / 2)), (y + (r / 2) - a), (r + x + (r / 2) + a),
				(y + (r / 2) + r + a));

		// Erase the center of the lines draw above
		g.setColor(new Color(75, 75, 75));// Set dark gray
		g.fillOval(x + 18, y + 18, diameter - 36, diameter - 36);

		// Speedometer's numbers
		Font font = new Font("TimesNewRoman", Font.BOLD, 18);
		g.setFont(font);

		g.setColor(Color.white);

		g.drawString("rpm", x + 73, y + 162);

		String temp[] = { "0", "10", "20", "30", "40", "50", "60" };

		g.drawString(temp[0], x + 41, y + 142);
		g.drawString(temp[1], x + 20, y + 96);
		g.drawString(temp[2], x + 41, y + 52);
		g.drawString(temp[3], x + 80, y + 34);
		g.drawString(temp[4], x + 121, y + 52);

		g.setColor(Color.red);
		g.drawString(temp[5], x + 140, y + 96);
		g.drawString(temp[6], x + 121, y + 142);

		// Digital speed
		g.setColor(Color.black);
		g.fillRect(x + 73, y + 113, 35, 30);

		g.setColor(Color.green);
		g.drawString(String.valueOf(speed), x + 81, y + 134);

		// Draws the speedometer's arrow
		g.setColor(Color.yellow);

		g.fillArc(x + 15, y + 15, diameter - 30, diameter - 30,
				225 - angleChange, 1);
		g.fillArc(x + 15, y + 15, diameter - 30, diameter - 30,
				225 - angleChange, -1);

		// Draws circle of the speedometer's center
		g.setColor(Color.gray);
		g.fillOval(x + 75, y + 75, diameter - 150, diameter - 150);

		// Draws an alert when max speed
		if (Update.alertSpeed) {
			g.setColor(Color.red);
			g.fillOval(x + 115, y + 150, diameter - 170, diameter - 170);
		}
	}
}
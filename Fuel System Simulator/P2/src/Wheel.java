import java.awt.Color;
import java.awt.Graphics;

/**
 * The class has a combination of figures to form a wheel, also has the wheel
 * behavior.
 * 
 * @author Kevin
 *
 */
public class Wheel {
	int angle1 = Update.wheelAngle;
	int x;
	int y;

	/**
	 * The constructor create new wheel in a specific position.
	 * 
	 * @param x
	 *            is the position on x axis where the wheel will be positioned
	 * @param y
	 *            is the position on y axis where the wheel will be positioned
	 */
	public Wheel(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Draws everything about the wheel.
	 * 
	 * @param g
	 */
	public void wheel(Graphics g) {
		Color metal = new Color(195, 195, 195);

		int ancho = 197;
		int alto = 197;
		int angle3 = 0;
		int angle4 = 360;

		// Draws a tire
		g.setColor(Color.black);
		g.fillArc(x, y, ancho, alto, angle3, angle4);

		// Draws the rim edge
		g.setColor(metal);
		g.fillArc(x + 10, y + 10, ancho - 20, alto - 20, angle3, angle4);

		// Draws an empty space
		g.setColor(Color.white);
		g.fillArc(x + 15, y + 15, ancho - 30, alto - 30, angle3, angle4);

		// Draws a brakes
		g.setColor(metal);
		g.fillArc(x + 50, y + 50, ancho - 100, alto - 100, angle3, angle4);

		g.setColor(Color.red);
		g.fillArc(x + 40, y + 40, ancho - 80, alto - 80, 115, 90);

		g.setColor(metal);
		g.fillArc(x + 60, y + 60, ancho - 120, alto - 120, angle3, angle4);

		g.setColor(Color.red);
		for (int i = 0; i < 23; i++)
			g.fillRoundRect(x + 68 - i, y + 45 + i * 3, 20, 20, 23, 23);

		// Draws a rim
		g.setColor(Color.gray);
		for (int i = 0, j = -55; i < 7; i++, j += 45)
			g.fillArc(x + 15, y + 15, ancho - 30, alto - 30, angle1 - j,
					angle3 - 20);

		// Draws one rim's spoke as a reference point
		g.setColor(new Color(240, 84, 25));
		g.fillArc(x + 15, y + 15, ancho - 30, alto - 30, angle1 - 260,
				angle3 - 20);

		// Starting point
		g.setColor(new Color(240, 84, 25));
		g.fillArc(x + 70, y - 15, 60, 60, 75, 30);

		// Rim decoration
		g.setColor(Color.gray);
		g.fillArc(x + 75, y + 75, ancho - 150, alto - 150, 0, 360);

		g.setColor(metal);
		g.fillArc(x + 80, y + 80, ancho - 160, alto - 160, 0, 360);

		g.setColor(new Color(75, 75, 75));
		g.fillArc(x + 82, y + 82, ancho - 164, alto - 164, 0, 360);

	}

}

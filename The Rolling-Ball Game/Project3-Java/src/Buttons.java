
import java.awt.Color;
import java.awt.Graphics;

/**
 * The class has the button's figures and some decoration.
 * 
 * @author Kevin
 *
 */
public class Buttons {

	private int x, xShadow;
	private int y, yShadow;
	private Color color;
	private Color shadow;
	private String s;
	private final int WIDTH = 50;
	private final int HEIGHT = 25;
	
	/**
	 * The buttons constructor create buttons with the name, color, coordinates and shadow.
	 * @param x
	 * @param y
	 * @param s
	 * @param color
	 * @param shadow
	 */
	public Buttons(int x, int y, String s, Color color, Color shadow) {
		this.x = x;
		this.y = y;
		this.s = s;
		this.color = color;
		this.shadow = shadow;
		xShadow = x;
		yShadow = y + 10;
	}

	/**
	 * The method button draws the buttons.
	 * 
	 * @param g
	 */
	public void button(Graphics g) {
		g.setColor(shadow);
		g.fillRoundRect(xShadow, yShadow, WIDTH, HEIGHT, 12, 12);
		
		g.setColor(color);
		g.fillRoundRect(x, y, WIDTH, HEIGHT, 12, 12);

		g.setColor(Color.black);
		g.drawString(s, x + 5, y + 17);
	}
	
	public void blackBorder(Graphics g){
		g.setColor(Color.black);
		g.drawRoundRect(x, y, WIDTH, HEIGHT, 12, 12);
	}
	/**
	 * @return the wIDTH
	 */
	public int getWIDTH() {
		return WIDTH;
	}

	/**
	 * @return the hEIGHT
	 */
	public int getHEIGHT() {
		return HEIGHT;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}
	
}

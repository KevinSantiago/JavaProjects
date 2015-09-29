import java.awt.BorderLayout;

import javax.swing.JFrame;

/**
 * The class ShapesMotion is the main class, it start the program, decide the
 * shapes positions and the initial sleep.
 * 
 * @author Kevin
 *
 */
public class ShapesMotion {

	public static int positionX = 80;
	public static int positionY = 90;
	public static int speedControl = 52;

	JFrame frame;
	DisplayShapes shape;

	/**
	 * The main method execute its own constructor to execute the start method.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new ShapesMotion().start();
	}

	/**
	 * The method has the window's specifications as the size, close, and so on,
	 * and execute the JFrame and DisplayShapes constructors.
	 */
	private void start() {
		frame = new JFrame("Fuel System Simulator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		shape = new DisplayShapes(positionX, positionY);
		frame.add(shape);
		frame.getContentPane().add(BorderLayout.CENTER, shape);

		frame.setResizable(false);
		frame.setSize(1000, 750);
		frame.setLocation(100, 80);
		frame.setVisible(true);

		run();
	}

	/**
	 * The method make sure that the program will run until the window were closed.
	 */
	private void run() {
		while (true) {
			while (Update.fuelTank) {
				Update.update();
				frame.repaint();
				try {
					Thread.sleep(speedControl);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			Update.update();
			frame.repaint();
			try {
				Thread.sleep(speedControl);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

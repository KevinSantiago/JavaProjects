/**
 * The class have everything about the program animation, it changes every
 * angle, coordinates and booleans that change the position of figures to get an
 * impression of motion.
 * 
 * @author Kevin
 *
 */
public class Update {
	public static int speedmeterAngleChange = 0;
	public static int wheelAngle = 0;
	public static int fuelConsumption = 400;
	public static int decreaseFuelMeter = 0;
	public static int rotation = 0;

	public static boolean alertGas;
	public static boolean alertSpeed;
	public static boolean fuelTank = true;

	static int countFuelMeter = 0;
	static int flashingSpeedAlert = 0;
	static int flashingGasAlert = 0;
	static int speed = 0;
	static int speedUpOrDown = 0;
	static int frequency = 0;
	static int whenSlowDown = 2;

	/**
	 * The method has every calculation that make possible the motion.
	 */
	public static void update() {
		if (fuelTank) {
			alertGas = false;
			speed = DisplayShapes.speed;
			speedUpOrDown = DisplayShapes.speedUpOrDown;
			flashingSpeedAlert++;

			if (DisplayShapes.refillButtonPressed && fuelConsumption > 0) {
				fuelConsumption--;
			}

			// Makes flashing the high speed light
			if (flashingSpeedAlert >= 90)
				flashingSpeedAlert = 0;
			if (speed >= 50 && flashingSpeedAlert <= 45)
				alertSpeed = true;
			else
				alertSpeed = false;

			// Makes sure that the wheel still stationary while speed is zero
			if (speed != 0) {
				wheelAngle -= SpeedControl.wheelAngleChange;
				if (speedmeterAngleChange < speed * 4.5)
					speedmeterAngleChange += 1;
				else if (speedmeterAngleChange >= 0)
					speedmeterAngleChange -= 1;
			} else if (speedmeterAngleChange >= 0)
				speedmeterAngleChange -= 1;

			// Determine the wheel's rotation and fuel consumption
			if (Math.abs(wheelAngle) >= 360) {
				wheelAngle = 0;
				rotation++;
				fuelConsumption++;
				countFuelMeter++;

				if (countFuelMeter == 2) {
					countFuelMeter = 0;
					decreaseFuelMeter++;
				}
			}

			// Stop the system when tank is empty
			if (fuelConsumption == FuelTank.height)
				fuelTank = false;
		} else {
			// Makes flashing the gasoline light
			flashingGasAlert++;
			if (flashingGasAlert <= 30)
				alertGas = true;
			else if (flashingGasAlert <= 60)
				alertGas = false;
			else
				flashingGasAlert = 0;

			// Reduce the speed slowly
			if (DisplayShapes.speed > 0)
				DisplayShapes.speed--;

			// Makes flashing the high speed light
			if (flashingSpeedAlert >= 90)
				flashingSpeedAlert = 0;
			if (speed >= 50 && flashingSpeedAlert <= 45) {
				flashingSpeedAlert++;
				alertSpeed = true;
			} else
				alertSpeed = false;

			// Determine the wheel's rotation
			if (Math.abs(wheelAngle) >= 360) {
				wheelAngle = 0;
				rotation++;
			}
			
			// Reduce the speedometer needle
			if (speedmeterAngleChange >= 0) {
				frequency++;
				speedmeterAngleChange -= 1;
				wheelAngle -= SpeedControl.wheelAngleChange;
				if (SpeedControl.wheelAngleChange > 1 && frequency % 20 == 0) {
					SpeedControl.wheelAngleChange -= 1;
					whenSlowDown++;
				}
			} else
				frequency = 0;
			
			// Refill the tank when the button is pressed
			if (DisplayShapes.refillButtonPressed && fuelConsumption > 0) {
				fuelConsumption--;
				fuelTank = true;
			}
		}
	}
}

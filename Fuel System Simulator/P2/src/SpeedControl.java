/**
 * The class determines which value of sleep and wheel angle need make to
 * rotates a wheel as real as possible.
 * 
 * @author Kevin
 *
 */
public class SpeedControl {
	private int speed;
	public static int wheelAngleChange;

	/**
	 * The constructor create a new SpeedControl and set a speed.
	 */
	public SpeedControl(int speed) {
		this.speed = speed;
	}

	/**
	 * The method determines the speed at which the wheel will spin, depending
	 * on the speed that the user wants.
	 */
	public void speedControl() {
		if (speed == 0) {
			ShapesMotion.speedControl = 52;
		}
		if (speed == 1) {
			ShapesMotion.speedControl = 165;
			wheelAngleChange = 1;
		}
		if (speed == 2) {
			ShapesMotion.speedControl = 82;
			wheelAngleChange = 1;
		}
		if (speed == 3) {
			ShapesMotion.speedControl = 55;
			wheelAngleChange = 1;
		}
		if (speed == 4) {
			ShapesMotion.speedControl = 41;
			wheelAngleChange = 1;
		}
		if (speed == 5) {
			ShapesMotion.speedControl = 33;
			wheelAngleChange = 1;
		}
		if (speed == 6) {
			ShapesMotion.speedControl = 55;
			wheelAngleChange = 2;
		}
		if (speed == 7) {
			ShapesMotion.speedControl = 47;
			wheelAngleChange = 2;
		}
		if (speed == 8) {
			ShapesMotion.speedControl = 41;
			wheelAngleChange = 2;
		}
		if (speed == 9) {
			ShapesMotion.speedControl = 37;
			wheelAngleChange = 2;
		}
		if (speed == 10) {
			ShapesMotion.speedControl = 33;
			wheelAngleChange = 2;
		}
		if (speed == 11) {
			ShapesMotion.speedControl = 30;
			wheelAngleChange = 2;
		}
		if (speed == 12) {
			ShapesMotion.speedControl = 69;
			wheelAngleChange = 5;
		}
		if (speed == 13) {
			ShapesMotion.speedControl = 64;
			wheelAngleChange = 5;
		}
		if (speed == 14) {
			ShapesMotion.speedControl = 59;
			wheelAngleChange = 5;
		}
		if (speed == 15) {
			ShapesMotion.speedControl = 33;
			wheelAngleChange = 3;
		}
		if (speed == 16) {
			ShapesMotion.speedControl = 31;
			wheelAngleChange = 3;
		}
		if (speed == 17) {
			ShapesMotion.speedControl = 29;
			wheelAngleChange = 3;
		}
		if (speed == 18) {
			ShapesMotion.speedControl = 46;
			wheelAngleChange = 5;
		}
		if (speed == 19) {
			ShapesMotion.speedControl = 43;
			wheelAngleChange = 5;
		}
		if (speed == 20) {
			ShapesMotion.speedControl = 50;
			wheelAngleChange = 6;
		}
		if (speed == 21) {
			ShapesMotion.speedControl = 47;
			wheelAngleChange = 6;
		}
		if (speed == 22) {
			ShapesMotion.speedControl = 45;
			wheelAngleChange = 6;
		}
		if (speed == 23) {
			ShapesMotion.speedControl = 14;
			wheelAngleChange = 2;
		}
		if (speed == 24) {
			ShapesMotion.speedControl = 41;
			wheelAngleChange = 6;
		}
		if (speed == 25) {
			ShapesMotion.speedControl = 39;
			wheelAngleChange = 6;
		}
		if (speed == 26) {
			ShapesMotion.speedControl = 38;
			wheelAngleChange = 6;
		}
		if (speed == 27) {
			ShapesMotion.speedControl = 42;
			wheelAngleChange = 7;
		}
		if (speed == 28) {
			ShapesMotion.speedControl = 29;
			wheelAngleChange = 5;
		}
		if (speed == 29) {
			ShapesMotion.speedControl = 45;
			wheelAngleChange = 8;
		}
		if (speed == 30) {
			ShapesMotion.speedControl = 27;
			wheelAngleChange = 5;
		}
		if (speed == 31) {
			ShapesMotion.speedControl = 53;
			wheelAngleChange = 10;
		}
		if (speed == 32) {
			ShapesMotion.speedControl = 41;
			wheelAngleChange = 8;
		}
		if (speed == 33) {
			ShapesMotion.speedControl = 50;
			wheelAngleChange = 10;
		}
		if (speed == 34) {
			ShapesMotion.speedControl = 38;
			wheelAngleChange = 8;
		}
		if (speed == 35) {
			ShapesMotion.speedControl = 28;
			wheelAngleChange = 6;
		}
		if (speed == 36) {
			ShapesMotion.speedControl = 46;
			wheelAngleChange = 10;
		}
		if (speed == 37) {
			ShapesMotion.speedControl = 22;
			wheelAngleChange = 5;
		}
		if (speed == 38) {
			ShapesMotion.speedControl = 39;
			wheelAngleChange = 9;
		}
		if (speed == 39) {
			ShapesMotion.speedControl = 38;
			wheelAngleChange = 9;
		}
		if (speed == 40) {
			ShapesMotion.speedControl = 12;
			wheelAngleChange = 3;
		}
		if (speed == 41) {
			ShapesMotion.speedControl = 36;
			wheelAngleChange = 9;
		}
		if (speed == 42) {
			ShapesMotion.speedControl = 39;
			wheelAngleChange = 10;
		}
		if (speed == 43) {
			ShapesMotion.speedControl = 38;
			wheelAngleChange = 10;
		}
		if (speed == 44) {
			ShapesMotion.speedControl = 37;
			wheelAngleChange = 10;
		}
		if (speed == 45) {
			ShapesMotion.speedControl = 40;
			wheelAngleChange = 11;
		}
		if (speed == 46) {
			ShapesMotion.speedControl = 39;
			wheelAngleChange = 11;
		}
		if (speed == 47) {
			ShapesMotion.speedControl = 38;
			wheelAngleChange = 11;
		}
		if (speed == 48) {
			ShapesMotion.speedControl = 41;
			wheelAngleChange = 12;
		}
		if (speed == 49) {
			ShapesMotion.speedControl = 30;
			wheelAngleChange = 9;
		}
		if (speed == 50) {
			ShapesMotion.speedControl = 36;
			wheelAngleChange = 11;
		}
		if (speed == 51) {
			ShapesMotion.speedControl = 22;
			wheelAngleChange = 7;
		}
		if (speed == 52) {
			ShapesMotion.speedControl = 41;
			wheelAngleChange = 13;
		}
		if (speed == 53) {
			ShapesMotion.speedControl = 40;
			wheelAngleChange = 13;
		}
		if (speed == 54) {
			ShapesMotion.speedControl = 39;
			wheelAngleChange = 13;
		}
		if (speed == 55) {
			ShapesMotion.speedControl = 36;
			wheelAngleChange = 12;
		}
		if (speed == 56) {
			ShapesMotion.speedControl = 20;
			wheelAngleChange = 7;
		}
		if (speed == 57) {
			ShapesMotion.speedControl = 37;
			wheelAngleChange = 13;
		}
		if (speed == 58) {
			ShapesMotion.speedControl = 11;
			wheelAngleChange = 4;
		}
		if (speed == 59) {
			ShapesMotion.speedControl = 36;
			wheelAngleChange = 13;
		}
		if (speed == 60) {
			ShapesMotion.speedControl = 52;
			wheelAngleChange = 19;
		}
	}
}

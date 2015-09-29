
public interface CollisionSensitive {

	/**
	 * The colisionAction determines if the ball was hit by an another ball.
	 * @return true if the ball collides with another and false if not.
	 */
	boolean colisionAction(MovingBall balls);
}

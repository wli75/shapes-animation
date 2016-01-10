
/**
 * An interface simulating gravity effect
 * @author Li Wing Yee
 */
public interface GravityAffected {
	public static final double GRAVITY = 0.00981; // pixel per loop
	public static final int TERMINAL_VELOCITY = 3; // pixel per loop
	public abstract void changeSpeedYDueToGravity();
}

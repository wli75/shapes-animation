import java.awt.Color;


/**
 * An interface implementing gradual change of color
 * @author Li Wing Yee
 */
public interface ColorAnimation {
	final int CHANGING_SPEED = 5;
	public abstract void setTargetColor(Color c);
	public abstract void updateColor();
}

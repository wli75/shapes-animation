

import geometricPrimitives.Balls;

import java.awt.Color;

/**
 * A class implementing the behavior of an animated ball
 * @author Li Wing Yee
 */
public class AnimatedBalls extends Balls implements ColorAnimation, GravityAffected {
	
	private Color targetColor;
	
	/**
	 * Constructor of an animated ball<br>
	 * speed in x and y directions = 0<br>
	 * target size = initial size<br>
	 * target color = c<br>
	 * initialize other fields as specified in the parameters
	 * @param x x position of the ball
	 * @param y y position of the ball
	 * @param c color of the ball
	 * @param s size of the ball
	 */
	public AnimatedBalls(int x, int y, Color c, int s){
		super(x, y, c, s);
		targetColor = c;
	}

	public void setTargetColor(Color c) {
		targetColor = c;
	}

	public void updateColor() {
		// Change the color
		int[] dColor = new int[3];
		dColor[0] = targetColor.getRed() - color.getRed();
		dColor[1] = targetColor.getGreen() - color.getGreen();
		dColor[2] = targetColor.getBlue() - color.getBlue();
		double denom = 0.0;
		for (int i=0; i<3; i++)
			denom += Math.pow(dColor[i], 2);
		denom = Math.sqrt(denom);
		if (denom != 0.0) {
			if (CHANGING_SPEED < denom) {
				for (int i=0; i<3; i++)
					dColor[i] = (int) Math.round( dColor[i] * CHANGING_SPEED / denom );
			}
		}
		color = new Color( color.getRed() + dColor[0],
						   color.getGreen() + dColor[1],
						   color.getBlue() + dColor[2] );
		
		// Assign a random color as the targetColor
		if( denom <= CHANGING_SPEED ) {
			int red = (int) (Math.random() * 255);
			int green = (int) (Math.random() * 255);
			int blue = (int) (Math.random() * 255);
			setTargetColor( new Color(red, green, blue) );
		}
	}
	
	public void changeSpeedYDueToGravity() {
		if ( dy+GRAVITY >= TERMINAL_VELOCITY )
			dy = TERMINAL_VELOCITY;
		else
			dy += GRAVITY;
	}
	
}

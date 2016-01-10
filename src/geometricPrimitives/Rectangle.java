package geometricPrimitives;


import java.awt.Color;
import java.awt.Graphics2D;

/**
 * A class implementing the behavior of a rectangle
 * @author Li Wing Yee
 */
public class Rectangle extends Shapes {
	/**
	 * Constructor of Rectangle<br>
	 * speed in x and y directions = 0<br>
	 * target size = initial size<br>
	 * initialize other fields as specified in the parameters
	 * @param x x position of the rectangle
	 * @param y y position of the rectangle
	 * @param c color of the rectangle
	 * @param s size of the rectangle in both x and y directions
	 */
	public Rectangle(int x, int y, Color c, int s) {
		super(x, y, c, s);
	}
	
	/**
	 * Constructor of Rectangle<br>
	 * speed in x and y directions = 0<br>
	 * initialize other fields as specified in the parameters
	 * @param x x position of the rectangle
	 * @param y y position of the rectangle
	 * @param c color of the rectangle
	 * @param s size of the rectangle in both x and y directions
	 * @param dsize target size of the rectangle in both x and y directions
	 */
	public Rectangle(int x, int y, Color c, int s, int dsize) {
		super(x, y, c, s);
		resize(dsize);
	}
	
	
	/**
	 * Constructor of Rectangle<br>
	 * target size = initial size<br>
	 * initialize other fields as specified in the parameters
	 * @param x x position of the rectangle
	 * @param y y position of the rectangle
	 * @param c color of the rectangle
	 * @param s size of the rectangle in both x and y directions
	 * @param dx speed in x direction
	 * @param dy speed in y direction
	 */
	public Rectangle(int x, int y, Color c, int s, int dx, int dy) {
		super(x, y, c, s);
		changeSpeed(dx, dy);
	}
	
	/**
	 * Constructor of Rectangle<br>
	 * initialize fields as specified in the parameters
	 * @param x x position of the rectangle
	 * @param y y position of the rectangle
	 * @param c color of the rectangle
	 * @param s size of the rectangle in both x and y directions
	 * @param dx speed in x direction
	 * @param dy speed in y direction
	 * @param dsize change in size of rectangle in both x and y directions
	 */
	public Rectangle(int x, int y, Color c, int s, int dx, int dy, int dsize) {
		super(x, y, c, s);
		resize(dsize + s);
		changeSpeed(dx, dy);
	}

	/**
	 * Constructor of Rectangle<br>
	 * make a copy of an existing rectangle
	 * @param newRectangle rectangle to be copied
	 */
	public Rectangle(Rectangle newRectangle) {
		super( (int) newRectangle.x, (int) newRectangle.y, newRectangle.color, newRectangle.xsize, newRectangle.ysize );
		resize( newRectangle.dxsize, newRectangle.dysize );
		changeSpeed(newRectangle.dx, newRectangle.dy);
	}
	
	/**
	 * Constructor of Rectangle<br>
	 * make a copy of an existing rectangle and position it according to the parameter
	 * @param newRectangle rectangle to be copied
	 * @param x x position of the rectangle
	 * @param y y position of the rectangle
	 */
	public Rectangle(Rectangle newRectangle, int x, int y) {
		super(x, y, newRectangle.color, newRectangle.xsize, newRectangle.ysize);
		resize( newRectangle.dxsize, newRectangle.dysize );
		changeSpeed(newRectangle.dx, newRectangle.dy);
	}
	
	public void paint(Graphics2D g2d) {
		g2d.setColor(color);
		
		x += dx;
		y += dy;
		
		if (dxsize != xsize)
			xsize += (dxsize - xsize) / Math.abs(dxsize - xsize);
		if (dysize != ysize)
			ysize += (dysize - ysize) / Math.abs(dysize - ysize);
		
		if (!hidden)
			g2d.fillRect( (int) Math.round(x), (int) Math.round(y), xsize, ysize );
	}
	
	public double getArea() {
		return xsize * ysize;
	}
	
	public boolean collisionDetection(Shapes b) {
		if (b instanceof Rectangle) {
			double aL = getX();
			double aR = aL + getXSize();
			double aT = getY();
			double aB = aT + getYSize();
			double bL = b.getX();
			double bR = bL + b.getXSize();
			double bT = b.getY();
			double bB = bT + b.getYSize();
			return aL <= bR && aR >= bL && aT <= bB && aB >= bT;
		} else
			return b.collisionDetection(this);
	}
	
}

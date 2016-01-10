package geometricPrimitives;

import java.awt.Color;
import java.awt.Graphics2D;


/**
 * A class implementing the behavior of an ellipse
 * @author Li Wing Yee
 */
public class Ellipse extends Shapes {

	/**
	 * Constructor of Ellipse <br>
	 * speed in x and y directions = 0<br>
	 * target size = initial size<br>
	 * initialize other fields as specified in the parameters
	 * @param x x position of the ellipse
	 * @param y y position of the ellipse
	 * @param c color of the ellipse
	 * @param xsize size of ellipse in the x direction
	 * @param ysize size of ellipse in the y direction
	 */
	public Ellipse(int x, int y, Color c, int xsize, int ysize) {
		super(x, y, c, xsize, ysize);
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
			g2d.fillOval( (int) Math.round(x), (int) Math.round(y), xsize, ysize );
	}
	
	public double getArea() {
		return xsize * ysize * Math.PI / 4.0;
	}

	// Based on the equation of an ellipse
	// (x - x0)^2 / a^2 + (y - y0)^2 / b^2 = 1
	// return (y - y0)^2
	private static double ellipse_y2(double x, double x0, double a, double b) {
		return ( 1 - Math.pow(x-x0, 2) / Math.pow(a, 2) ) * Math.pow(b, 2);
	}
	
	private boolean collisionDetectionRectangle(Shapes b) {
		double aX = getX() + getXSize()/2.0;
		double aY = getY() + getYSize()/2.0;
		double bL = b.getX();
		double bR = bL + b.getXSize();
		double bT = b.getY();
		double bB = bT + b.getYSize();
		
		if ( bL <= aX && aX <= bR && bT <= aY && aY <= bB )
			return true;
		
		double x2 = ellipse_y2(bB, aY, getYSize()/2.0, getXSize()/2.0);
		for (int i=0; i<2; i++) {
			if (x2 >= 0) {
				if ( ( aX - Math.sqrt(x2) <= bR ) && ( aX + Math.sqrt(x2) >= bL ) )
					return true;
			}
			if (i == 0)
				x2 = ellipse_y2(bT, aY, getYSize()/2.0, getXSize()/2.0);
		}
		
		double y2 = ellipse_y2(bL, aX, getXSize()/2.0, getYSize()/2.0);
		for (int i=0; i<2; i++) {
			if ( y2 >= 0 ) {
				if ( ( aY - Math.sqrt(y2) <= bB ) && ( aY + Math.sqrt(y2) >= bT ) )
					return true;
			}
			if (i == 0)
				y2 = ellipse_y2(bR, aX, getXSize()/2.0, getYSize()/2.0);
		}
		
		return false;
	}
	
	private boolean collisionDetectionEllipse(Shapes b) {
		for (double theta=0.0; theta<=2*Math.PI; theta+=0.1) {
			double x = getX() + getXSize()/2.0 * (1 + Math.cos(theta) );
			double y = getY() + getYSize()/2.0 * (1 + Math.sin(theta) );
			double y2 = ellipse_y2( x, b.getX()+b.getXSize()/2.0, b.getXSize()/2.0, b.getYSize()/2.0 );
			if (y2 >= 0) {
				double bY = b.getY()+b.getYSize()/2.0;
				if ( bY-Math.sqrt(y2) <= y && y <= bY+Math.sqrt(y2) )
						return true;
				double aY = getY() + getYSize()/2.0;
				double diff = y - aY;
				if (diff < 0) {
					if ( y <= bY-Math.sqrt(y2) && diff+aY >= bY+Math.sqrt(y2) )
						return true;
				} else { // diff >= 0
					if ( aY-diff <= bY-Math.sqrt(y2) && y >= bY+Math.sqrt(y2) )
						return true;
				}
			}
		}
		return false;
	}
	
	public boolean collisionDetection(Shapes b) {
		if (b instanceof Rectangle)
			return collisionDetectionRectangle(b);
		else // b is an instance of Ellipse
			return collisionDetectionEllipse(b);
	}
}

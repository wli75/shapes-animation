package geometricPrimitives;



import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Base class for moving object used by BasicGUI
 * @author Ernest Cheung
 *
 */
public abstract class Shapes {
	/**
	 * Current X 
	 */
	protected double x;

	/**
	 * Current Y
	 */
	protected double y;
	/**
	 * Speed in X 
	 */
	protected double dx;
	/**
	 * Speed in Y
	 */
	protected double dy;
	
	/**
	 *  size in X dimension
	 */
	protected int xsize;
	
	/**
	 * target size in X dimension
	 */
	protected int dxsize;
	
	/**
	 * size in Y dimension
	 */
	protected int ysize;
	/**
	 * target size in Y dimension
	 */
	protected int dysize;
	/**
	 * Color
	 */
	protected Color color;
	
	/**
	 * whether or not hidden
	 */
	protected boolean hidden;

	/**
	 * Empty constructor
	 */
	protected Shapes(){
		
	}
	
	/**
	 * Constructor of a shape with same dimension in X and Y 
	 * @param x Initial X position
	 * @param y Initial Y position
	 * @param c Initial color 
	 * @param s Initial size
	 */
	protected Shapes(int x, int y, Color c, int s){
		this.x = (double) x;
		this.y = (double) y;
		dx = 0;
		dy = 0;
		color = c;
		xsize = s;
		dxsize = xsize;
		ysize = s;
		dysize = ysize;
		hidden = false;
	}
	
	/**
	 * Constructor of a shape with different dimension in X and Y 
	 * @param x Initial X position
	 * @param y Initial Y position
	 * @param c Initial color 
	 * @param sx Initial X-size
	 * @param sy Initial Y-size
	 */
	protected Shapes(int x, int y, Color c, int sx, int sy){
		this.x = (double) x;
		this.y = (double) y;
		dx = 0;
		dy = 0;
		color = c;
		xsize = sx;
		dxsize = xsize;
		ysize = sy;
		dysize = ysize;
		hidden = false;
		
	}
	
	/**
	 * Hide the object
	 */
	public void hide(){
		hidden = true;
	}
	
	/**
	 * Show the object
	 */
	public void show(){
		hidden = false;
	}

	

	/**
	 * For the BasicGUI to paint the object
	 * @param g2d Graphics2D object
	 */
	public abstract void paint(Graphics2D g2d);
	
	/**
	 * Obtain the current X position of the object
	 * @return x position of the object
	 */
	public double getX(){
		return x;
	}
	
	/**
	 * Obtain the current Y position of the object
	 * @return y position of the object
	 */
	public double getY(){
		return y;
	}
	
	/**
	 * Obtain the current color of the object
	 * @return Color of the object
	 */
	public Color getColor(){
		return color;
	}
	
	/**
	 * Obtain the current x-size of the object
	 * @return Size of the object
	 */
	public int getXSize(){
		return xsize;
	}
	
	/**
	 * Obtain the current y-size of the object
	 * @return Size of the object
	 */
	public int getYSize(){
		return ysize;
	}
	
	/**
	 * Change the size of object in the x direction
	 * @param x new value for size of object in the x direction
	 */
	public void changeXSize(int x) {
		xsize = x;
		dxsize = xsize;
	}
	
	/**
	 * Change the size of object in the y direction
	 * @param y new value for size of object in the y direction
	 */
	public void changeYSize(int y) {
		ysize = y;
		dysize = ysize;
	}
	
	/**
	 * Change the color of the object
	 * @param c New color of the object
	 */
	public void changeColor(Color c){
		color = c;
	}
	
	/**
	 * Change the size of the object
	 * @param size New x-size and y-size of the object
	 */
	public void resize(int size){
		dxsize = size;
		dysize = size;
	}
	

	/**
	 * Change the size of the object
	 * @param xsize New x-size of the object
	 * @param ysize  New y-size of the object
	 */
	public void resize(int xsize, int ysize){
		dxsize = xsize;
		dysize = ysize;
	}
	
	/**
	 * Change the speed
	 * @param dx amount of pixel to be moved in x direction
	 */
	public void changeSpeedX(double dx){
		this.dx = dx;
	}
	
	/**
	 * Change the speed
	 * @param dy amount of pixel to be moved in y direction
	 */
	public void changeSpeedY(double dy){
		this.dy = dy;
	}
	
	/**
	 * Obtain the current x-speed of the object
	 * @return x-speed of the object
	 */
	public double getSpeedX(){
		return this.dx;
	}
	
	/**
	 * Obtain the current y-speed of the object
	 * @return y-speed of the object
	 */
	public double getSpeedY(){
		return this.dy;
	}
	
	/**
	 * Change the speed
	 * @param dx amount of pixel to be moved in x direction
	 * @param dy amount of pixel to be moved in y direction
	 */
	public void changeSpeed(double dx, double dy){
		this.dx = dx;
		this.dy = dy;
	}

	/**
	 * Obtain the area of object
	 * @return area of object
	 */
	public abstract double getArea();
	
	/**
	 * Check if there is a collision with another shape
	 * @param b another shape
	 * @return true if the 2 shapes collide; false otherwise
	 */
	public abstract boolean collisionDetection(Shapes b);

}
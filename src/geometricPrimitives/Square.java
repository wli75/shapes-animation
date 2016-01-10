package geometricPrimitives;


import java.awt.Color;

/**
 * A class implementing the behavior of a square
 * @author Li Wing Yee
 */
public class Square extends Rectangle {
	/**
	 * Constructor of Square<br>
	 * speed in x and y directions = 0<br>
	 * target size = initial size<br>
	 * initialize other fields as specified in the parameters
	 * @param x x position of the square
	 * @param y y position of the square
	 * @param c color of the square
	 * @param s size of the square
	 */
	public Square(int x, int y, Color c, int s) {
		super(x, y, c, s);
	}
	
	/**
	 * Constructor of Square<br>
	 * speed in x and y directions = 0<br>
	 * initialize other fields as specified in the parameters
	 * @param x x position of the square
	 * @param y y position of the square
	 * @param c color of the square
	 * @param s size of the square
	 * @param dsize target size of the square
	 */
	public Square(int x, int y, Color c, int s, int dsize) {
		super(x, y, c, s, dsize);
	}
	
	/**
	 * Constructor of Square<br>
	 * target size = initial size<br>
	 * initialize other fields as specified in the parameters
	 * @param x x position of the square
	 * @param y y position of the square
	 * @param c color of the square
	 * @param s size of the square
	 * @param dx speed in x direction
	 * @param dy speed in y direction
	 */
	public Square(int x, int y, Color c, int s, int dx, int dy) {
		super(x, y, c, s, dx, dy);
	}
	
	/**
	 * Constructor of Square<br>
	 * initialize fields as specified in the parameters
	 * @param x x position of the square
	 * @param y y position of the square
	 * @param c color of the square
	 * @param s size of the square
	 * @param dx speed in x direction
	 * @param dy speed in y direction
	 * @param dsize change in size of square
	 */
	public Square(int x, int y, Color c, int s, int dx, int dy, int dsize) {
		super(x, y, c, s, dx, dy, dsize);
	}

	/**
	 * Constructor of Square<br>
	 * make a copy of an existing square
	 * @param newSquare square to be copied
	 */
	public Square(Square newSquare) {
		super(newSquare);
	}
	
	/**
	 * Constructor of Square<br>
	 * make a copy of an existing square and position it according to the parameter
	 * @param newSquare square to be copied
	 * @param x x position of the square
	 * @param y y position of the square
	 */
	public Square(Square newSquare, int x, int y) {
		super(newSquare, x, y);
	}
}

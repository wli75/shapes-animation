package geometricPrimitives;


import java.awt.Color;

/**
 * The Class implementing the behavior of a Ball
 * @author Ernest Cheung
 * 
 */
public class Balls extends Ellipse {
	/**
	 * Constructor of Balls <br>
	 * speed in x and y directions = 0<br>
	 * target size = initial size<br>
	 * initialize other fields as specified in the parameters
	 * @param x x position of the ball
	 * @param y y position of the ball
	 * @param c color of the ball 
	 * @param s size of the ball
	 */
	public Balls(int x, int y, Color c, int s){
		super(x,y,c,s,s);
	}
	
	/**
	 * Constructor of Balls <br>
	 * speed in x and y directions = 0<br>
	 * initialize other fields as specified in the parameters
	 * @param x x position of the ball
	 * @param y y position of the ball
	 * @param c color of the ball 
	 * @param s size of the ball
	 * @param dsize target size of the ball
	 */
	public Balls(int x, int y, Color c, int s, int dsize){
		super(x,y,c,s,s);
		this.resize(dsize);
	}
	
	/**
	 * Constructor of Balls <br>
	 * target size = initial size<br>
	 * initialize other fields as specified in the parameters
	 * @param x x position of the ball
	 * @param y y position of the ball
	 * @param c color of the ball 
	 * @param s size of the ball
	 * @param dx speed of the ball in x direction
	 * @param dy speed of the ball in y direction
	 */
	public Balls(int x, int y, Color c, int s, int dx, int dy){
		super(x,y,c,s,s);
		// You may also assign the values directly
		this.dx = dx;
		this.dy = dy;
	}
	
	/**
	 * Constructor of Balls <br>
	 * initialize other fields as specified in the parameters
	 * @param x x position of the ball
	 * @param y y position of the ball
	 * @param c color of the ball 
	 * @param s size of the ball
	 * @param dx speed of the ball in x direction
	 * @param dy speed of the ball in y direction
	 * @param dsize target size of the ball
	 */
	public Balls(int x, int y, Color c, int s, int dx, int dy, int dsize){
		super(x,y,c,s,s);
		this.resize(dsize + s);
		this.changeSpeed(dx, dy);
	}

	/**
	 * Constructor of Balls<br>
	 * make a copy of an existing ball
	 * @param newBall ball to be copied
	 */
	public Balls(Balls newBall) {
		super((int)newBall.x,(int)newBall.y,newBall.color,newBall.xsize, newBall.ysize);
		resize( newBall.dxsize );
		this.changeSpeed(newBall.dx, newBall.dy);
	}
	
	/**
	 * Constructor of Balls<br>
	 * make a copy of an existing square and position it according to the parameter
	 * @param newBall ball to be copied
	 * @param x x position of the ball
	 * @param y y position of the ball
	 */
	public Balls(Balls newBall, int x, int y ) {
		super(x,y,newBall.color,newBall.xsize, newBall.ysize);
		resize( newBall.dxsize );
		changeSpeed(newBall.dx, newBall.dy);
	}
	
}

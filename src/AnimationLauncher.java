
import geometricPrimitives.Ellipse;
import geometricPrimitives.Rectangle;
import geometricPrimitives.Shapes;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

/**
 * A class implementing the main logic
 * @author Li Wing Yee
 */
public class AnimationLauncher  {

	private static BasicGUI screen = new BasicGUI();
	private static ArrayList<Shapes> shapesArray = new ArrayList<Shapes>();
	
	/**
	 * Initialize the screen by randomly creating different shapes
	 */
	public static void init(){

		Random r = new Random();
		
		// Add animated balls, animated squares, rectangles, ellipse
		int num = 0;
		Shapes shape = null;
		for (int i=0; i<4; i++) {
			num = 3;
			while (num > 0) {
				switch (i) {
				case 0: shape = new AnimatedBalls(r.nextInt(900), r.nextInt(630), new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256)), r.nextInt(100));
						break;
				case 1: shape = new AnimatedSquares(r.nextInt(900), r.nextInt(630), new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256)), r.nextInt(100));
						break;
				case 2: shape = new Rectangle(r.nextInt(900), r.nextInt(630), new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256)), 0);
						break;
				case 3: shape = new Ellipse(r.nextInt(900), r.nextInt(630), new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256)), r.nextInt(100), r.nextInt(100));
				}
				shape.changeSpeed(Math.pow(-1, r.nextInt(2)) * (r.nextInt(2)+1), r.nextInt(4)-2);
				if ( addSucceeds(shape) ) {
					screen.addShape(shape);
					shapesArray.add(shape);
					num--;
				}
			}
		}
		
	}
	
	/**
	 * A very simple logic to be executed every time the shapes are painted.<br>
	 * It does the following:<br>
	 * - add shapes to the screen<br>
	 * - remove shapes that go out of the screen<br>
	 * - change color of shapes<br>
	 * - change speed of shapes due to gravity<br>
	 * - detect collision of shapes and implement rebound effect
	 */
	public static void simpleLogic(){
		
		// Add animated ball, animated square, rectangle, ellipse
		Random r = new Random();
		Shapes shape = null;
		int rnd = 0;
		for (int i=0; i<4; i++) {
			rnd = r.nextInt(90);
			if (rnd == 0){
				while (true) {
					switch (i) {
					case 0: shape = new AnimatedBalls(r.nextInt(900), r.nextInt(630), new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256)), r.nextInt(100));
							break;
					case 1: shape = new AnimatedSquares(r.nextInt(900),r.nextInt(630),new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256)), r.nextInt(100));
							break;
					case 2: shape = new Rectangle(r.nextInt(900), r.nextInt(630), new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256)), 0);
							break;
					case 3: shape = new Ellipse(r.nextInt(900), r.nextInt(630), new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256)), r.nextInt(100), r.nextInt(100));
					}
					shape.changeSpeed(Math.pow(-1, r.nextInt(2)) * (r.nextInt(2)+1), r.nextInt(4)-2);
					if ( addSucceeds(shape) ) {
						screen.addShape(shape);
						shapesArray.add(shape);
						break;
					}
				}
			}
		}
		
		ArrayList<Shapes> removeArray = new ArrayList<Shapes>();
		for (int i=0; i<shapesArray.size(); i++) {
			
			// Collision Detection
			for (int j=i+1; j<shapesArray.size(); j++) {
				Shapes obj1 = shapesArray.get(i);
				Shapes obj2 = shapesArray.get(j);
				if ( obj1.collisionDetection(obj2) )
					reboundEffect(obj1, obj2);
			}
			
			// Change the color
			if (shapesArray.get(i) instanceof ColorAnimation) {
				ColorAnimation cObj = (ColorAnimation) shapesArray.get(i);
				cObj.updateColor();
			}
			
			// Change the speed in y direction due to gravity
			if (shapesArray.get(i) instanceof GravityAffected) {
				GravityAffected gObj = (GravityAffected) shapesArray.get(i);
				gObj.changeSpeedYDueToGravity();
			}
			
			// When any shape hits the ground at y = 730, it shall bounce back
			Shapes obj = shapesArray.get(i);
			if ( ( obj.getY() + obj.getYSize() ) >= 730 )
				obj.changeSpeedY( -obj.getSpeedY() );
			
			// When any shape leaves the screen completely, it shall be removed from all the ArrayList storing it
			if ( obj.getX()+obj.getXSize() < 0 || obj.getX() > screen.getScreenWidth() || obj.getY()+obj.getYSize() < 0 )
				removeArray.add(obj);
		}
		for (Shapes obj : removeArray) {
			screen.removeShape(obj);
			shapesArray.remove(obj);
		}
		
	}
	
	/**
	 * Main function to launch the animation
	 * @param args Command Line Argument
	 * @throws InterruptedException Happens when the thread is interrupted
	 */
	public static void main(String[] args) throws InterruptedException {
		init();
		
		while (true){
			simpleLogic();
			screen.repaint();
			Thread.sleep(20);
		}
	}
		
	private static boolean addSucceeds(Shapes obj) {
		for (Shapes shape : shapesArray) {
			if ( obj.collisionDetection(shape) )
				return false;
		}
		return true;
	}
	
	private static void reboundEffect(Shapes a, Shapes b) {
		double aSpeedX = a.getSpeedX();
		double aSpeedY = a.getSpeedY();
		a.changeSpeedX( reboundCalculation( aSpeedX, b.getSpeedX(), a.getArea(), b.getArea() ) );
		b.changeSpeedX( reboundCalculation( b.getSpeedX(), aSpeedX, b.getArea(), a.getArea() ) );
		a.changeSpeedY( reboundCalculation( aSpeedY, b.getSpeedY(), a.getArea(), b.getArea() ) );
		b.changeSpeedY( reboundCalculation( b.getSpeedY(), aSpeedY, b.getArea(), a.getArea() ) );
	}
		
	private static double reboundCalculation(double u1, double u2, double m1, double m2) {
		double num = u1 * (m1-m2) + 2 * m2 * u2;
		double denom = m1 + m2;
		return num / denom;
	}

}

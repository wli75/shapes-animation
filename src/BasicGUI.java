



import geometricPrimitives.Shapes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.*;

/**
 * Create a 1000x730 sized screen for simple graphics animations
 * @author Ernest Cheung
 *
 */
public class BasicGUI extends JPanel{
	JFrame parentFrame;
	ArrayList<Shapes> shapes;
	
	/**
	 * Obtain the screen height
	 * @return the fixed screen height
	 */
	public int getScreenHeight(){
		return 730;
	}
	
	/**
	 * Obtain the screen width
	 * @return the fixed screen width
	 */
	public int getScreenWidth(){
		return 1000;
	}
	
	public BasicGUI(){
		super();

		this.setPreferredSize(new Dimension(1000,730));
		parentFrame = new JFrame();
		parentFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		parentFrame.add(this);
		parentFrame.pack();
		parentFrame.setLocationByPlatform(true);
		parentFrame.setResizable( false );
		parentFrame.setVisible( true );
		
		shapes = new ArrayList<Shapes>();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(Color.RED);
		
		for (int i = 0; i < shapes.size(); ++i){
			((Shapes)shapes.get(i)).paint(g2d);
		}
		
	}

	/**
	 * Add a shape to the screen
	 * @param b The shape object to be added
	 */
	public void addShape(Shapes b){
		shapes.add(b);
	}
	
	public void removeShape(Shapes b){
		shapes.remove(b);
		
	}
	
}

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Display {

	public static JFrame frame;
	public static int width;
	public static int height;

	private Canvas canvas;

	public Display() {
		init();
	}

	public Canvas getCanvas() {
		return canvas;
	}

	public void init() {
		frame = new JFrame("Game");

		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		frame.setMaximizedBounds(env.getMaximumWindowBounds());
		frame.setExtendedState(frame.getExtendedState() | frame.MAXIMIZED_BOTH);
		Rectangle bounds = env.getMaximumWindowBounds();
		
		width = (int) bounds.getWidth();
		height = (int) bounds.getHeight();
		
		frame.addComponentListener(new ResizeListener());
		
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width/2, height/2));
		frame.setFocusable(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		canvas = new Canvas();
		canvas.setVisible(true);
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setPreferredSize(new Dimension(width, height));		

		frame.add(canvas);
		frame.setVisible(true);
	}
}

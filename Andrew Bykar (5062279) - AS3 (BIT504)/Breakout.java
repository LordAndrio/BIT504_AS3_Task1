import java.awt.Color;
import javax.swing.JFrame;

public class Breakout extends JFrame{
	
	static final long serialVersionUID = 1L;
	
	private BreakoutPanel panel;
	
	String WINDOW_TITLE = "Breakout";
	Color BACKGROUND_COLOR = Color.WHITE;
	int WINDOW_HEIGHT = Settings.WINDOW_HEIGHT;
	int WINDOW_WIDTH = Settings.WINDOW_WIDTH;
	
	
	// Constructor to create the window and the panel for the program to run in
	public Breakout() {
		// Define window settings
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setTitle(WINDOW_TITLE);
		setBackground(BACKGROUND_COLOR);
		setResizable(false);
		setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        // Add panel to host the game in the window
        panel = new BreakoutPanel(this);
        add(panel);
	}
	
	
	// Run the program
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
	         public void run() {
	        	 new Breakout();	
	         }
		});
	}
}

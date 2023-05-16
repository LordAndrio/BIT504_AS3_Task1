import java.awt.Color;

import javax.swing.JFrame;

public class Breakout extends JFrame{
	
	static final long serialVersionUID = 1L;
	
	private BreakoutPanel panel;
	
	String WINDOW_TITLE = "Breakout";
	Color BACKGROUND_COLOR = Color.WHITE;
	int WINDOW_HEIGHT = Settings.WINDOW_HEIGHT;
	int WINDOW_WIDTH = Settings.WINDOW_WIDTH;
	
	public Breakout() {
		// TODO: Set the size of the screen (use Settings.WINDOW_WIDTH/HEIGHT)
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		// TODO: Set the title
		setTitle(WINDOW_TITLE);
		// TODO: Set the background colour to white
		setBackground(BACKGROUND_COLOR);
		// TODO: Set resizable to false
		setResizable(false);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel = new BreakoutPanel(this);
        add(panel);
		// TODO: Set visible to true
        setVisible(true);
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
	         public void run() {
	        	 new Breakout();	
	         }
		});

	}
}

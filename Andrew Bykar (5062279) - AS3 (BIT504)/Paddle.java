import java.awt.Graphics;

public class Paddle extends Sprite {

	private int xVelocity;
	
	// Constructor
	public Paddle() {
		// Set width of paddle
		this.width = Settings.PADDLE_WIDTH;
		// Set height of paddle
		this.height = Settings.PADDLE_HEIGHT;
		// Call resetPosition
		resetPosition();
	}

	
	public void resetPosition() {
		// Set initial position x and y
		setX(Settings.INITIAL_PADDLE_X);
		setY(Settings.INITIAL_PADDLE_Y);
	}
	
	
	// Method to update paddle to create movement and to stop at edge of panel
	public void update() {
		// Update position based on current velocity
		x += xVelocity;
		
		// Stop when hitting the left edge of the screen
		if(x <= 0) {
			x = 0;
		}
		
		// Stop when hitting the right edge of the screen
		if(x >= Settings.WINDOW_WIDTH - Settings.PADDLE_WIDTH_BUFFER) {
			x = (Settings.WINDOW_WIDTH - Settings.PADDLE_WIDTH_BUFFER);
		}
	}
	
	
	// Paint the paddle as a rectangle according to the dimensions defined in settings
	// Paint the rectangle at the current coordinates
	public void paint(Graphics g) {
		g.fillRect(x, y, Settings.PADDLE_WIDTH, Settings.PADDLE_HEIGHT);
	}
	
	
	// Set the x velocity
	public void setXVelocity(int vel) {
		this.xVelocity = vel;
	}
	
	
	// Get the x velocity
	public int getXVelocity() {
		return xVelocity;
	}
}

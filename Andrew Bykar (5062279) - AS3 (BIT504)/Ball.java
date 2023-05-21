import java.awt.Graphics;

public class Ball extends Sprite {

	private int xVelocity = 1, yVelocity = -1;
	
	// Constructor
	public Ball() {
		// Set width of the ball
		setWidth(Settings.BALL_WIDTH);
		// Set width of the ball
		setHeight(Settings.BALL_HEIGHT);
		// Call resetPosition
		resetPosition();
	}
	
	
	// Resets the ball to the initial position
	public void resetPosition() {
		setX(Settings.INITIAL_BALL_X);
		setY(Settings.INITIAL_BALL_Y);
	}
	
	
	// Method to update ball to create movement and to stop at edge of panel
	public void update() {
		// Increase the x variable by xVelocity
		x += xVelocity;
		// Increase the y variable by yVelocity
		y += yVelocity;
		
		// Bounce off left side of screen
		if(x <= 0) {
			// Stop when hitting the left edge of the screen
			x = 0;
			// Change the x velocity to make the ball go right
			setXVelocity(1);
		}
		
		// Bounce off right side of screen
		if(x >= Settings.WINDOW_WIDTH - Settings.BALL_WIDTH*2) {
			// Stop when hitting the right edge of the screen
			x = (Settings.WINDOW_WIDTH - Settings.BALL_WIDTH*2);
			// Change the x velocity to make the ball go left
			setXVelocity(-1);
		}
		
		// Bounce off top of screen
		if(y <= 0) {
			// Set y to 0 so it does not leave the screen
			y = 0;
			// Change the y velocity to make the ball go downward
			yVelocity = -yVelocity;
		}
	}
	
	
	// Set the x velocity
	public void setXVelocity(int x) {
		this.xVelocity = x;
	}
	
	
	// Set the y velocity
	public void setYVelocity(int y) {
		this.yVelocity = y;
	}
	
	
	// Get the x velocity
	public int getXVelocity() {
		return xVelocity;	// TODO: Return the x velocity
	}
	
	// Get the y velocity
	public int getYVelocity() {
		return yVelocity;	// TODO: Return the y velocity
	}
	
	
	// Paint the ball as an oval according to the dimensions defined in settings
	// Paint the oval at the current coordinates
	public void paint(Graphics g) {
		g.fillOval(x, y, Settings.BALL_WIDTH, Settings.BALL_HEIGHT);
	}
}

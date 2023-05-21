import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class BreakoutPanel extends JPanel implements ActionListener, KeyListener {
	
	static final long serialVersionUID = 2L;

	// Defines variables for the game
	private boolean gameRunning = true;
	private int livesLeft = 3;
	private String screenMessage = "";
	
	// Creates objects for ball, paddle, as well as each brick as per array using Settings.TOTAL_BRICKS
	private Ball ball;
	private Paddle paddle;
	private Brick bricks[];
	
	
	// Constructor using parameter of the Breakout main class
	public BreakoutPanel(Breakout game) {
		//Defines methods for a key listener and set the JPanel as focusable
		addKeyListener(this);
		setFocusable(true);
		
		//Creates timer with a tick rate of 5
		Timer timer = new Timer(5, this);
		timer.start();
		
		// Creates a new ball object
		ball = new Ball();
		// Creates a new paddle object
		paddle = new Paddle();
		// Creates a new bricks array using Settings.TOTAL_BRICKS
		bricks = new Brick[Settings.TOTAL_BRICKS];
		// Calls the createBricks() method
		createBricks();
	}
	
	
	// Method to create each brick
	private void createBricks() {
		// Variables to counter the brick and its location
		int counter = 0;
		int x_space = 0;
		int y_space = 0;
		
		// Loops through each location of a 4 x 5 grid with spaces defined by the brick dimensions + padding as per the Settings
		for(int x = 0; x < 4; x++) {
			for(int y = 0; y < 5; y++) {
				// Creates a new brick in each space of the grid, continuing through the counter with the array limit of Settings.TOTAL_BRICKS
				bricks[counter] = new Brick((x * Settings.BRICK_WIDTH) + Settings.BRICK_HORI_PADDING + x_space, (y * Settings.BRICK_HEIGHT) + Settings.BRICK_VERT_PADDING + y_space);
				counter++;
				y_space++;
			}
			x_space++;
			y_space = 0;
		}
	}
	
	
	// Paints the bricks created in the grid above following the counter
	private void paintBricks(Graphics g) {
		// Loop through the bricks and call the paint() method
		int counter = 0;
		for(int x = 0; x < 4; x++) {
			for(int y = 0; y < 5; y++) {
				// Paints each brick looping through the bricks as created in the createBricks() method as per the counter position
				bricks[counter].paint(g);
				counter++;
			}
		}
	}
	
	
	// Method to update to objects and repaint them as per their movements
	// Checks for collisions after each movement
	private void update() {
		if(gameRunning) {
			// Updates the ball and paddle
			moveObject(ball);
			moveObject(paddle);
			
			// Checks for collisions and repaints the objects
			collisions();
			repaint();
		}
	}
	
	
	// Method to move the ball object along the x & y axis and then update accordingly as per the update() method
	public void moveObject(Ball obj) {
		obj.setX(obj.getX() + obj.getXVelocity());
		obj.setY(obj.getY() + obj.getYVelocity());
		ball.update();
	}
	
	
	// Method to move the paddle object along the x  axis and then update accordingly as per the update() method
	public void moveObject(Paddle obj) {
		obj.setX(obj.getX() + obj.getXVelocity());
		paddle.update();
	}
	
	
	// Game over stops the game and prints "Game Over!"
	private void gameOver() {
		// TODO: Set screen message
		screenMessage = "Game Over!";
		stopGame();
	}
	
	
	// Game over stops the game and prints "You Win!"
	private void gameWon() {
		// TODO: Set screen message
		screenMessage = "You Win!";
		stopGame();
	}
	
	
	// Stops the game by changing the gameRunning boolean to false
	private void stopGame() {
		gameRunning = false;
	}
	
	
	// Checks for collisions and acts accordingly
	private void collisions() {
		// Check for loss - ball has fallen below the paddle and the bottom of the window
		if(ball.y > 450) {
			// Removes a life
			livesLeft--;
			
			// Lose state
			if(livesLeft <= 0) {
				gameOver();
				return;
			}
			
			// Else resets ball position and velocity to continue play
			else {
				ball.resetPosition();
				ball.setYVelocity(-1);
			}
		}
		
		// Check for win
		boolean bricksLeft = false;
		
		// Loop to check if any bricks remain
		for(int i = 0; i < bricks.length; i++) {
			// Check if there are any bricks left
			if(!bricks[i].isBroken()) {
				// Brick was found, close loop
				bricksLeft = true;
				break;
			}
		}
		
		// If no no more bricks are left the game is won
		if(!bricksLeft) {
			gameWon();
			return;
		}
		
		// Check collisions
		if(ball.getRectangle().intersects(paddle.getRectangle())) {
			// Reverse y velocity of ball to simulate bounce
			ball.setYVelocity(-1);
		}
		
		// Loops to check how ball intersects with the bricks to determine how it should bounce off
		for(int i = 0; i < bricks.length; i++) {
			if (ball.getRectangle().intersects(bricks[i].getRectangle())) {
				// Creates measurements and locations for the ball
				int ballLeft = (int) ball.getRectangle().getMinX();
	            int ballHeight = (int) ball.getRectangle().getHeight();
	            int ballWidth = (int) ball.getRectangle().getWidth();
	            int ballTop = (int) ball.getRectangle().getMinY();
	            
	            // Creates a coordinate point for where the ball could intersect with a brick
	            Point pointRight = new Point(ballLeft + ballWidth + 1, ballTop);
	            Point pointLeft = new Point(ballLeft - 1, ballTop);
	            Point pointTop = new Point(ballLeft, ballTop - 1);
	            Point pointBottom = new Point(ballLeft, ballTop + ballHeight + 1);

	            // Changes ball velocity based on which side of the brick was hit
	            if (!bricks[i].isBroken()) {
	                if (bricks[i].getRectangle().contains(pointRight)) {
	                    ball.setXVelocity(-1);
	                }
	                
	                else if (bricks[i].getRectangle().contains(pointLeft)) {
	                    ball.setXVelocity(1);
	                }

	                if (bricks[i].getRectangle().contains(pointTop)) {
	                    ball.setYVelocity(1);
	                }
	                
	                else if (bricks[i].getRectangle().contains(pointBottom)) {
	                    ball.setYVelocity(-1);
	                }
	                
	                // Breaks the brick that was hit
	                bricks[i].setBroken(true);
	            }
			}
		}
	}
	
	
	// Method to paint everything onto the game window
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Paints the ball and the paddle
        ball.paint(g);
        paddle.paint(g);
        
        // Calls the paintBricks(g) method to paint all the required bricks
        paintBricks(g);
        
        // String to show the remaining lives left
        String livesLeftString = Integer.toString(livesLeft);
        
        // Draw lives left
        if(livesLeftString != null) {
        	g.setFont(new Font("Arial", Font.BOLD, 20));
        	g.drawString(livesLeftString, Settings.LIVES_POSITION_X, Settings.LIVES_POSITION_Y);
        }
        
        // Draw screen message (for win/lose state)
        if(screenMessage != null) {
        	g.setFont(new Font("Arial", Font.BOLD, 15));
        	int messageWidthScreen = g.getFontMetrics().stringWidth(screenMessage);
        	g.drawString(screenMessage, (Settings.WINDOW_WIDTH / 2) - (messageWidthScreen / 2), Settings.MESSAGE_POSITION);
        }
    }

	
	// Event for when keys are pressed
	@Override
	public void keyPressed(KeyEvent e) {
		// Set the velocity of the paddle depending on whether the player is pressing the left or right directional keys
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			paddle.setXVelocity(-Settings.PADDLE_VELOCITY);
		}
		
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			paddle.setXVelocity(Settings.PADDLE_VELOCITY);
		}
	}

	
	// Event for when keys are released
	@Override
	public void keyReleased(KeyEvent e) {
		// Set the velocity of the paddle to 0 after the player has released the directional keys
		if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT) {
			paddle.setXVelocity(0);
		}
	}

	
	// Automatically generated - not used
	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}

	
	// Automatically generated - not used
	@Override
	public void actionPerformed(ActionEvent arg0) {
		update();
	}
}

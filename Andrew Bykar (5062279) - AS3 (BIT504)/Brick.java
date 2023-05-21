import java.awt.Graphics;

public class Brick extends Sprite {
	
	private boolean broken = false;
	
	// Constructor using parameters integer x & integer y
	// Define all the attributes for brick creation
	public Brick(int x, int y) {
		this.x = x;
		this.y = y;
		this.width = Settings.BRICK_WIDTH;
		this.height = Settings.BRICK_HEIGHT;
	}

	
	// Returns whether a brick is broken or not so that it can be removed from play
	public boolean isBroken() {
		boolean checkBroken;
		
		if (broken) {
			checkBroken = true;
		}
		
		else {
			checkBroken = false;
		}
		
		return checkBroken;
	}
	
	
	// Defines a brick as broken
	public void setBroken(boolean b) {
		this.broken = b;
	}
	
	
	// Paints the brick unless it has been broken
	public void paint(Graphics g) {
		if(!broken) {
			g.fillRect(x, y, Settings.BRICK_WIDTH, Settings.BRICK_HEIGHT);
		}
	}
}

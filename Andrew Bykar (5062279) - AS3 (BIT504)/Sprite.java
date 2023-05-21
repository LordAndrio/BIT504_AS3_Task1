import java.awt.Rectangle;

public class Sprite {
	
	protected int x,y,width,height;
	
	
	// Set x coordinate
	public void setX(int x) {
		// TODO setX
		this.x = x;
	}
	
	
	// Set y coordinate
	public void setY(int y) { 
		// TODO setY
		this.y = y;
	}
	
	
	// Set width
	public void setWidth(int width) {
		this.width = width;
	}
	
	
	// Set height
	public void setHeight(int height) {
		this.height = height;
	}
	
	
	// Get x coordinate
	public int getX() { 
		return x;
	}
	
	
	// Get y coordinate
	public int getY() { 
		return y;
	}
	
	
	// Get width
	public int getWidth() { 
		return width;
	}
	
	
	// Get height
	public int getHeight() { 
		return height;
	}
	
	
	// Get rectangle
	Rectangle getRectangle() {
		return new Rectangle(x, y, width, height);
	}
}

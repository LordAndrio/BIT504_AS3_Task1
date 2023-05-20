import java.awt.Rectangle;

public class Sprite {
	
	protected int x,y,width,height;
	
	// Note: This should only set a single value, they can be done in a single statement
	public void setX(int x) {
		// TODO setX
		this.x = x;
	}
	public void setY(int y) { 
		// TODO setY
		this.y = y;
	}
	public void setWidth(int width) { 
		// TODO setWidth
		this.width = width;
	}
	public void setHeight(int height) { 
		// TODO setHeight
		this.height = height;
	}
	
	// Note: Change the "0" to the correct variable
	public int getX() { 
		return x;	// TODO: Return correct value getX
	}
	public int getY() { 
		return y;	// TODO: Return correct value getY
	}
	public int getWidth() { 
		return width;	// TODO: Return correct value getWidth
	}
	public int getHeight() { 
		return height;	// TODO: Return correct value getHeight
	}
	
	Rectangle getRectangle() {
		return new Rectangle(x, y, width, height);
	}
}

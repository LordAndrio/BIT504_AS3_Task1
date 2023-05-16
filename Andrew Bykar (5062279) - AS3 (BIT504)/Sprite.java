import java.awt.Rectangle;

public class Sprite {
	
	protected int x,y,width,height;
	
	// Note: This should only set a single value, they can be done in a single statement
	public void setX(int x) {
		// TODO setX
	}
	public void setY(int y) { 
		// TODO setY
	}
	public void setWidth(int width) { 
		// TODO setWidth
	}
	public void setHeight(int height) { 
		// TODO setHeight
	}
	
	// Note: Change the "0" to the correct variable
	public int getX() { 
		return 0;	// TODO: Return correct value getX
	}
	public int getY() { 
		return 0;	// TODO: Return correct value getY
	}
	public int getWidth() { 
		return 0;	// TODO: Return correct value getWidth
	}
	public int getHeight() { 
		return 0;	// TODO: Return correct value getHeight
	}
	
	Rectangle getRectangle() {
		return new Rectangle(x, y, width, height);
	}
}

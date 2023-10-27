package it.unibs.pajc;

public class Rectangle implements Shape2D {

	protected final int height;
	protected final int width;
	
	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}

	
	@Override
	public int perimeter() {
		return 2*(height + width);
	}

	@Override
	public int area() {
		return height * width;
	}

	
	@Override
	public String toString() {
		return String.format("RETTANGOLO %dx%d [p=%d, a=%d]", 
				width, height, perimeter(), area()); 
	}
}

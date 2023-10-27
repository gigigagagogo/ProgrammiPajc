package it.unibs.pajc;

public class Square extends Rectangle {
	public Square(int size) {
		super(size, size);
	}
	
	public int getSize() { return width; }
	
	@Override
	public String toString() {
		return String.format("QUADRATO %d [p=%d, a=%d]", 
				getSize(), perimeter(), area()); 
	}
}

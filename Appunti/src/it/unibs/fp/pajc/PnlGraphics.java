package it.unibs.fp.pajc;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class PnlGraphics extends JPanel implements MouseMotionListener{

	public PnlGraphics(){
		this.addMouseMotionListener(this);
	}
	
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);		
		
		int w= getWidth();
		int h= getHeight();
		
		g.drawLine(0,0,w,h);
		g.drawLine(w,0,0,h);
		g.drawLine(w/2, 0, w/2, h);
		g.drawLine(0, h/2, w, h/2);
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		System.out.printf("Mouse Move %d x %d\n", e.getX(), e.getY());
	}
	
	
	
}

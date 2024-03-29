package it.unibs.pahc;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Timer;

import javax.swing.JPanel;

public class PnlAnim extends JPanel  {

	private int xpos;
	public PnlAnim() {
		
		//Timer t = new Timer(10, e -> stepNext());
		javax.swing.Timer t= new javax.swing.Timer(10, e -> stepNext());
		t.start();

	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);		
		Graphics2D g2= (Graphics2D) g;
	
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		int w=getWidth();
		int h=getHeight();
		
		g2.setStroke(new BasicStroke(3f));
		g2.setColor(Color.blue);
		g2.drawLine(0,h/2,w,h/2);
		g2.setColor(Color.red);
		
		g2.drawRect(xpos, h/2-20, 50, 20);
		
		//System.out.println(Thread.currentThread().getName());
		
	}
	private int dx=10;
	public void stepNext() {
		xpos+=dx;
		
		if(xpos+50>getWidth()) {
			dx=-10;
		}
		if(xpos<=0) {
			dx=10;
		}
		repaint();
		
		
	}
}

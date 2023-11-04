package it.unibs.pajc;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.font.TextAttribute;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.sql.Time;
import javax.swing.Timer;

import javax.swing.JPanel;

public class PnlForceField extends JPanel  implements MouseMotionListener {

	/**
	 * Create the panel.
	 */
	private double ang;
	
	public PnlForceField() {
		addMouseMotionListener(this);
		//Timer timer= new Timer(100, (e) -> stepNext());
		//timer.start();
	}
	
	public void stepNext() {
		ang += 0.05;
		repaint();
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2= (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		int w=getWidth();
		int h=getHeight();
		for(int x=25;x<=w;x += 25) {
			for(int y=25;y<=h;y += 25) {
				double angoloMouse = Math.atan2(mousePos.y - y, mousePos.x - x);
				fillArrow(g2, x, y, 20, angoloMouse);
			}
		}
		
	}
	
	
	
	protected void fillArrow(Graphics2D g2,int x,int y,int size,double ang) {
		Path2D path2d= new Path2D.Double();
		
		path2d.moveTo(0,0);
		path2d.lineTo(-size, size/3);
		path2d.lineTo(-size, -size/3);
		path2d.closePath();
		
		AffineTransform t = new AffineTransform();
		t.translate(x, y);
		t.rotate(ang);
		
		g2.fill(t.createTransformedShape(path2d));
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	private Point mousePos= new Point(0,0);
	@Override
	public void mouseMoved(MouseEvent e) {
		mousePos= e.getPoint();
		repaint();
	}
	
	

}

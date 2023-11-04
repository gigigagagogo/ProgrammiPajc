package it.unibs.pajc;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;

import javax.swing.JPanel;

public class Pnl extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Pnl() {

	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2=(Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		int w=getWidth();
		int h=getHeight();
		
		g2.translate(w/2, h/2);
		g2.scale(w/20., -h/4.);
		setStrokeSize(g2, 1);
		g2.drawLine(-w/2, 0, w/2, 0);
		g2.drawLine(0,-h/2,0,h/2);
		double dx=0.0005;
		Path2D p=new Path2D.Double();
		p.moveTo(-w/2, 0);
		
		for(double x=-w/2;x<= w/2;x+= dx) {
			p.lineTo(x, Math.sin(2*x)+Math.cos(x));
		}
		
		g2.draw(p);
	
	}
	//Bohh
	protected void setStrokeSize(Graphics2D g2,int sizeInPixel) {
		AffineTransform t=g2.getTransform();
		
		//dimensione del pixel;
		float pixelSize=(float)(1./(Math.sqrt(Math.abs(t.getScaleX() * t.getScaleY()))));
		g2.setStroke(new BasicStroke(sizeInPixel * pixelSize));
	}

}

package it.unibs.pajc;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.util.Iterator;
import java.util.function.DoubleFunction;
import java.util.function.Function;

import javax.management.modelmbean.ModelMBean;
import javax.swing.JPanel;

public class PnlPlotFunction extends JPanel implements MouseMotionListener {
	
	private double xmouse;
	private double ymouse;
	
	public PnlPlotFunction() {
		addMouseMotionListener(this);
	}

	private static final long serialVersionUID = 1L;
	
	
	
	
	protected void paintComponent__(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2= (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		
		int w = getWidth();
		int h = getHeight();
		
		g2.translate(w/2, h/2);
		
		g2.scale(w/20., -h/4.);
		setStrokeSize(g2, 1);
		g2.drawLine(-10, 0, 10, 0);
		g2.drawLine(0, -2, 0, 2);
			
		Path2D path = new Path2D.Double();
		path.moveTo(-10.,Math.sin(-10));
		double dx=0.0005;
		
		for(double x=-10;x<=10;x += dx) {
			path.lineTo(x, Math.sin(x));
		}

		g2.draw(path);
		
		drawFunction(g2, -10, 10,0.05, Math::sin);
		g2.setColor(Color.red);
		drawFunction(g2, -10, 10,0.05, x -> Math.sin(2*x)+Math.cos(x)+Math.tanh(x));
		
		
	}
	
	protected void setStrokeSize(Graphics2D g2,int sizeInPixel) {
		AffineTransform t=g2.getTransform();
		
		//dimensione del pixel;
		float pixelSize=(float)(1./(Math.sqrt(Math.abs(t.getScaleX() * t.getScaleY()))));
		g2.setStroke(new BasicStroke(sizeInPixel * pixelSize));
	}
	
	protected void drawFunction(Graphics2D g2, double xmin,double xmax, double dx, Function<Double, Double>f) {
		Path2D path2d= new Path2D.Double();
		
		path2d.moveTo(xmin,f.apply(xmin));
		
		for(double x=xmin+dx; x<=xmax; x+=dx) {
			path2d.lineTo(x, f.apply(x));
		}
		g2.draw(path2d);
	}
	
	protected void paintComponent_(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		
		int w = getWidth();
		int h = getHeight();
		
		g2.fillOval(-50, -50, 100, 100);
		
		g2.setColor(Color.blue);
		g2.translate(w/2, h/2);
		g2.fillOval(-50, -50, 100, 100);
		
		int s = Math.min(w, h);
		g2.scale(s/1000., s/1000.);
		g2.setColor(Color.red);
		g2.fillOval(-500, -500, 1000, 1000);

	}

	protected void paintComponent___(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		
		int w = getWidth();
		int h = getHeight();
		
		double xw =  0f;
		double dxw = 0.005f;
		
		for(xw = 0; xw < Math.PI*2; xw += dxw) {
			double yw = Math.sin(xw);
			double xfw = xw + dxw;
			double yfw = Math.sin(xfw);
			
			int x1s = (int)(w / (2*Math.PI)*xw);
			int x2s = (int)(w / (2*Math.PI)*xfw);
			int y1s = (int)(h / 2.2*yw)+h/2;
			int y2s = (int)(h / 2.2*yw)+h/2;
			
			g2.drawLine(x1s, y1s, x2s, y2s);
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		System.out.printf("%d", e.getX());
		xmouse=e.getX();
		ymouse=e.getY();
		repaint();
	}

}

package it.unibs.pajc;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

public class PnlMandelbrot extends JPanel implements MouseMotionListener,MouseListener {

	
	public PnlMandelbrot() {
		addMouseListener(this);
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		MandelbrotModel m = new MandelbrotModel();
		int res = 500;
		
		m.eval(new Complex(viewport.getMinX(),viewport.getMinY()),
				new Complex (viewport.getMaxX(),  viewport.getMaxY()),res);
		
		double[][] data = m.getData();

		int dx= getWidth()/res;
		int dy= getHeight()/res;
		
		for(int i=0;i<res;i++) {
			for(int j=0;j<res;j++) {
				double v = data[i][j];
				int c= (int)(v * 255);
				if (c==0){
					g.setColor(Color.black);
				}else {
					g.setColor(new Color(Color.HSBtoRGB((float) v*2, 1, 1)));
				}
				g.fillRect(dx*j,dy*i , dx, dy);
			}
		}
	
	}
	protected Rectangle2D viewport = new Rectangle2D.Double(-2.,-1., 3, 2);
	
	public void setViewport(Rectangle2D newViewport) {
		viewport=newViewport;
		repaint();
		
	}
	
	public void zoomIn(Point2D.Double p,double zoom) {
		double finalWidth=viewport.getWidth()/zoom;
		double finalHeight=viewport.getHeight()/zoom;
		
		double rx=(p.x-viewport.getMinX())/viewport.getWidth();
		double ry=(p.y-viewport.getMinY())/viewport.getWidth();
		
		Rectangle2D newViewPort= new Rectangle2D.Double(p.x-finalWidth * rx, p.y-finalHeight * ry, finalWidth,finalHeight);
		
		setViewport(newViewPort);
		
		
	}
	
	public void zoomOut(Point2D.Double p, double zoom) {
		zoomIn(p,1./zoom);
	}
	
	protected Point2D.Double getViewPortPoint(Point pixel) {
		double x= viewport.getWidth()/getWidth() * pixel.x + viewport.getMinX();
		double y= -viewport.getWidth()/getHeight() * pixel.y + viewport.getMaxY();
		
		return new Point2D.Double(x,y);
	}
	
	protected Point getScreenPoint(Point2D viewportPoint) {
		return null;
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Point2D.Double p= getViewPortPoint(e.getPoint());
		if(e.isShiftDown()) {
			zoomOut(p, 1.1);
		}else {			
			zoomIn(p, 1.1);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
				
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}

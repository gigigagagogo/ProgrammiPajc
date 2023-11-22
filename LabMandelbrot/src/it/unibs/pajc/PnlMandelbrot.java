package it.unibs.pajc;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class PnlMandelbrot extends JPanel implements MouseMotionListener,MouseListener {

	private int res = 500;
	private MandelbrotModel m = new MandelbrotModel();
	Image mandelbrotImage = null;
	
	private void evaluateMandelbrot() {
		m.eval(new Complex(viewport.getMinX(),viewport.getMinY()),
				new Complex (viewport.getMaxX(),  viewport.getMaxY()),res);
		mandelbrotImage=createImageFromData(m.getData());
		
		repaint();
	}
	
	private Image createImageFromData(double [][] data) {
		if(data==null) {
			return null;
		}
		
		int xsize=data.length;
		int ysize=data[0].length;
		
		Image img = new BufferedImage(xsize, ysize, BufferedImage.TYPE_INT_ARGB);
		//img restitutisce un componente tipo Graphics
		Graphics2D g2 = (Graphics2D) img.getGraphics();
		
		
		
		for(int i=0;i<ysize;i++) {
			for(int j=0;j<xsize;j++) {
				double v = data[i][j];
				int c= (int)(v * 255);
				if (c==0){
					g2.setColor(Color.black);
				}else {
					g2.setColor(new Color(Color.HSBtoRGB((float) v*2, 1, 1)));
				}
				g2.fillRect(j,i ,1, 1);
			}
		}
		
		return img;
	}
	
	
	public int getResolution() {
		return res;
	}
	
	public void setResolution(int value) {
		res = value;
		evaluateMandelbrot();
	}
	public PnlMandelbrot() {
		evaluateMandelbrot();
		addMouseListener(this);
		addMouseMotionListener(this);
		
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if(mandelbrotImage == null) {
			return;
		}
		
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(mandelbrotImage, 0, 0, getWidth(), getHeight(), Color.white, null);
		
		
	}
	
	//Gestione ViewPort
	protected Rectangle2D.Double viewport = new Rectangle2D.Double(-2.,-1., 3, 2);
	
	public Rectangle2D.Double getViewPort(){
		return viewport;
	}
	
	public void setViewport(Rectangle2D.Double newViewport) {
		viewport=newViewport;
		evaluateMandelbrot();
	}
	
	public void zoomIn(Point2D.Double p,double zoom) {
		double finalWidth=viewport.getWidth()/zoom;
		double finalHeight=viewport.getHeight()/zoom;
		
		double rx=(p.x-viewport.getMinX())/viewport.getWidth();
		double ry=(p.y-viewport.getMinY())/viewport.getWidth();
		
		Rectangle2D.Double newViewPort= new Rectangle2D.Double(p.x-finalWidth * rx, p.y-finalHeight * ry, finalWidth,finalHeight);
		
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
	public void mouseClicked(MouseEvent e) {
		Point2D.Double p= getViewPortPoint(e.getPoint());
		if(e.isShiftDown()) {
			zoomOut(p, 1.1);
		}else {			
			zoomIn(p, 1.1);
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		double dx= (e.getX() -panStarMousePosition.x)* panStartViewport.getWidth()/getWidth();
		
		double dy= (e.getY() -panStarMousePosition.y)* panStartViewport.getHeight()/getHeight();
		
		setViewport(new Rectangle2D.Double(panStartViewport.x - dx,panStartViewport.y -dy
				,panStartViewport.width,panStartViewport.height));
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	Point panStarMousePosition;
	Rectangle2D.Double panStartViewport;
	@Override
	public void mousePressed(MouseEvent e) {
		if(panStarMousePosition ==null)	{
			panStarMousePosition = e.getPoint();
			panStartViewport = getViewPort();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		panStarMousePosition = null;
		panStartViewport = null;	
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

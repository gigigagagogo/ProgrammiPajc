package it.unibs.pajc;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Path2D;

import javax.swing.JPanel;

public class PnlPlotFunction extends JPanel {
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PnlPlotFunction(){

	}
	protected void paintComponent_(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2= (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		Path2D p2d= new Path2D.Double();
		int w=getWidth();
		int h=getHeight();
		g2.translate(0, h/2);
		g2.setStroke(new BasicStroke(2f));
		g2.drawLine(0, 0, w, 0);		
		for(double x=0; x<Math.PI*2; x+= 0.0005) {
			
		}
		
	}
	protected void paintComponent__(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2= (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		//Path2D path=new Path2D();
		int w=getWidth();
		int h=getHeight();
		
		/*
		g2.fillOval(-50,-50,100,100);
		//Metto il . dopo il 2 perche il translate lavora con floating point
		//Con translate andiamo a cambiare il sistema di riferimento
		g2.translate(w/2.,h/2.);
		g2.setColor(Color.BLUE);
		g2.fillOval(-50,-50,100,100);
		int s=Math.min(w, h);
		
		g2.scale(s/1000., s/1000.);
		g2.setColor(Color.magenta);
		g2.fillOval(-500,-500,1000,1000);
		*/
		
		g2.fillOval(0, 0, 50, 50);
		g2.setColor(Color.yellow);
		g2.fillOval(0, 0, -50, -50);
		
	}
	/*
	 * rifare questo algoritmo in modo che non devi convertire tu a mano tutte le coordinate ma ci deve pensare il sistema
	 */
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2= (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		
		int w=getWidth();
		int h=getHeight();
		//g2.setStroke(new BasicStroke(3f));
		g2.drawLine(0, h/2, w, h/2);
		//x iniziale in coordinate mondo
		double xw=0f;
		//spostamento che facciamo sulle x
		double dxw= 0.0005;
		
		for(xw=0;xw<Math.PI*2; xw += dxw) {
			//coordinate iniziali di y
			double yw= Math.sin(xw) ;
			//coordinate finali in coordinate mondo
			double xfw= xw + dxw;
			double yfw=Math.sin(xfw);
			
			int x1s=(int) (w/(2*Math.PI) * xw);
			int x2s=(int) (w/(2*Math.PI) * xfw);
			int y1s=(int) (h/2.2 * yw) + h/2;
			int y2s=(int) (h/2.2 * yfw) + h/2;
			
			g2.drawLine(x1s, y1s, x2s, y2s);
			
		}
		
	}

}

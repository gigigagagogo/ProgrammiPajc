package it.unibf.pajc;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class PanelDraw extends JPanel implements MouseMotionListener{

	public PanelDraw(){
		this.addMouseMotionListener(this);
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);		
		Graphics2D g2= (Graphics2D) g;
		
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
				RenderingHints.VALUE_ANTIALIAS_ON);
		int w= getWidth();
		int h= getHeight();
		int d=20;
		//g.drawLine(0,0,w,h);
		//g.drawLine(w,0,0,h);
		//g.setColor(Color.blue);
		//g.fillOval((w-d)/2, (h-d)/2, d, d);
		/*
		for(int xc=d;xc<w+d;xc+=2*d) {
			for(int yc=d; yc<=h+d; yc += 2*d) {
				if(xc==0) {
					g.setColor(Color.blue);
				}else {
					g.setColor(Color.red);
				}
				fillCircle(xc,yc,d,g2);				
			}
			c++;
		}
		*/
		
		//Scrivo su ognuno dei cerchi l'indice di righe e colonne 
		for(int i=0; i<=(w/(2*d))+1; i++) {
			for(int j=0; j<=(h/(2*d))+1;j++) {
				if((i+j)%2==0) {
					g.setColor(Color.blue);
				}else {
					g.setColor(Color.red);
				}
				
				fillCircle(i*2*d+d, j*2*d+d, d, g2);
			
			}
			
		}
		g2.setColor(Color.yellow);
		if(mousePosition!=null) {			
			fillCircle(mousePosition.x,mousePosition.y,10,g2);
			
			int wx= mousePosition.x/(2*d);
			int wy= mousePosition.y/(2*d);
			
			
			g2.setColor(Color.black);
			g2.drawString(String.format("[%3d]-%d-%d",c++, wx,wy),10,24);
			
			int cx = wx * (2*d) + d;
			
		
			
			int cy = wy * (2*d) + d;
			g2.setColor(Color.green);
			//Guarda cosa si puo fare con setStroke
			g2.setStroke(new BasicStroke(5f));
			drawCircle(cx,cy,d,g2);
		}
		
	}

	protected void fillCircle(int xc, int yc, int d,Graphics2D g) {
		g.fillOval(xc-d, yc-d, d*2, d*2);
	}

	protected void drawCircle(int xc, int yc, int d,Graphics2D g) {
		g.drawOval(xc-d, yc-d, d*2, d*2);
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	private int c;
	private Point mousePosition=null;
	
	@Override
	public void mouseMoved(MouseEvent e) {
		//System.out.printf("X:%d-Y:%d-N:%3d\n",e.getX(),e.getY(),c++);
		mousePosition=e.getPoint();
		this.repaint();
	
	}
	
}

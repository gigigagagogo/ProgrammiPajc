package it.unibs.pajc;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class PnlBoards extends JPanel implements MouseMotionListener{
	private int x=0;
	private Color lightBlue = new Color(173, 216, 230, 76);  // 30% di opacità
	
	public PnlBoards() {
		addMouseMotionListener(this);
	}
	
	protected void paintComponent(Graphics g, int xpos) {
		super.paintComponent(g);
		Graphics2D g2= (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
				RenderingHints.VALUE_ANTIALIAS_ON);
		int w=getWidth();
		int h=getHeight()-20;
		designBoard(g2,w,h);
	}
	
	public void designBoard(Graphics2D g2,int w,int h) {
		g2.setStroke(new BasicStroke(2f));
		g2.setColor(lightBlue);
		g2.drawLine(0, h, w,h );
		g2.setStroke(new BasicStroke(4f));
		g2.fillRect(x, h-32, 40, 10);
		//repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		System.out.printf("X:%d\n", e.getX());
		x=e.getX();
		repaint();
	}
	
	
	
	

}
package it.unibs.pajc;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.Timer;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PnlBoards extends JPanel implements MouseMotionListener, MouseListener{
	private int x=0;
	private boolean pressed=false;
	//private int w=getWidth();
	//private int h=getHeight();
	private double speedBall=0.01;
	private double xball=x;
	private Color lightBlue = new Color(173, 216, 230, 76);  // 30% di opacità
	
	public PnlBoards() {
		addMouseMotionListener(this);
		
		
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		drawBound(g2);
		drawBoard(g2);
		if(pressed) {	
			drawBallUpdate(g2);
		}else {
			System.out.println("prova");
			drawBallStart(g2);
		}
		//repaint();
		
	}
	
	
	public void setPressed(boolean pressed) {
		this.pressed = pressed;
	}

	public void drawBound(Graphics2D g) {
		g.setStroke(new BasicStroke(4f));
		g.drawLine(0, 0, getWidth(), 0);
		g.drawLine(0, 0, 0, getHeight());
		g.drawLine(getWidth(), 0, getWidth(), getHeight());
		g.setColor(Color.red);
		g.drawLine(0, getHeight(), getWidth(), getHeight());
	}
	
	public void drawBoard(Graphics2D g) {
		g.setStroke(new BasicStroke(2f));
		g.setColor(Color.blue);
		if(x >= getWidth()-40) {
			x=getWidth()-40;
		}
		g.fillRect(x, getHeight()-40, 40, 10);
		
	}
	
	public void drawBallStart(Graphics2D g) {
		g.setColor(Color.orange);
		g.fillOval(x+10, updatePositionBall(), 20, 20);
		
	}
	
	public int updatePositionBall() {
		int yballIniziale=getHeight()-60;
		yballIniziale += speedBall;
		return yballIniziale;
        
	}
	
	public void drawBallUpdate(Graphics2D g) {
		g.setColor(Color.orange);
        g.fillOval((int) getWidth()/2, getHeight()-60, 20, 20);
        repaint();
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		x=e.getX();
		repaint();
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {

	}
	
	@Override
	public void mousePressed(MouseEvent e) {
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

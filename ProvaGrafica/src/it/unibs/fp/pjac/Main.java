package it.unibs.fp.pjac;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
	public static void main(String [] args) {
		JFrame frame= new JFrame("Prima prova");
		JPanel pannello = new JPanel();
		JButton bottone1= new JButton("Click");
		frame.add(pannello);
		bottone1.setBounds(70,100, 70, 30);
		Toolkit t = Toolkit.getDefaultToolkit();
	    Image i = new BufferedImage(1, 1, BufferedImage.TRANSLUCENT);
	    Cursor noCursor = t.createCustomCursor(i, new Point(30,20), "none");
		bottone1.setCursor(noCursor);
		pannello.add(bottone1);
		pannello.setBackground(Color.CYAN);
		frame.setSize(200,200);
		frame.setVisible(true);
	}
}

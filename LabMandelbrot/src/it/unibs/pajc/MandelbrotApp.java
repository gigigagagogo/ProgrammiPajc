package it.unibs.pajc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;

import java.awt.BorderLayout;

public class MandelbrotApp {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MandelbrotApp window = new MandelbrotApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MandelbrotApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		PnlMandelbrot pnlMandelbrot =  new PnlMandelbrot();
		frame.getContentPane().add(pnlMandelbrot, BorderLayout.CENTER);
		
		JPanel pnlBottom = new JPanel();
		frame.getContentPane().add(pnlBottom,BorderLayout.SOUTH);
		
		JSlider slResolution = new JSlider();
		slResolution.setMinimum(200);
		slResolution.setMaximum(2000);
		pnlBottom.add(slResolution);
		slResolution.addChangeListener(e -> pnlMandelbrot.setResolution(slResolution.getValue()));
				
	}

}

package it.unibs.pahc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;

public class AnimApp {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnimApp window = new AnimApp();
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
	public AnimApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Perfavore vai");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		PnlAnim pnlAnim = new PnlAnim();
		frame.getContentPane().add(pnlAnim, BorderLayout.CENTER);
		
		JPanel panelComands = new JPanel();
		frame.getContentPane().add(panelComands, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("step Next");
		panelComands.add(btnNewButton);
		
		btnNewButton.addActionListener(e-> pnlAnim.stepNext());
	
	}

}

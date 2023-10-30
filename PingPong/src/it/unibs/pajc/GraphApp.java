package it.unibs.pajc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class GraphApp {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GraphApp window = new GraphApp();
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
	public GraphApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		PnlBoards pnlBoards = new PnlBoards();
		frame.getContentPane().add(pnlBoards, BorderLayout.CENTER);
		pnlBoards.setLayout(null);
		
		JButton btnStart = new JButton("Start");
		btnStart.setBounds(170, 238, 89, 23);
		pnlBoards.add(btnStart);
		btnStart.addActionListener((e) -> {
			pnlBoards.setPressed(true);
			btnStart.setEnabled(false);
			btnStart.setVisible(false);
			});
		
	}

}

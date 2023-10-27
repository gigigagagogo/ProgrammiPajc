package it.unibs.fp.pajc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

public class SecondGui {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SecondGui window = new SecondGui();
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
	public SecondGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 629, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 436, 263);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		PnlDueBottoni pnlDueBottoni = new PnlDueBottoni();
		pnlDueBottoni.setBounds(176, 127, 1, 1);
		panel.add(pnlDueBottoni);
		
		PnlDueBottoni pnlDueBottoni_1 = new PnlDueBottoni();
		pnlDueBottoni_1.setBounds(275, 147, 1, 1);
		panel.add(pnlDueBottoni_1);
		
		PnlDueBottoni pnlDueBottoni_2 = new PnlDueBottoni();
		pnlDueBottoni_2.setBounds(10, 10, 349, 192);
		panel.add(pnlDueBottoni_2);
	}
}

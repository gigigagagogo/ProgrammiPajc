package it.unibs.fp.pajc;

import javax.swing.JPanel;
import javax.swing.JButton;

public class PnlDueBottoni extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PnlDueBottoni() {
		setLayout(null);
		
		JButton eticchetta1 = new JButton("Amica di Giulio(negra)");
		eticchetta1.setBounds(56, 27, 156, 21);
		add(eticchetta1);
		
		JButton eticchetta2 = new JButton("Vincenzo\r\n");
		eticchetta2.setBounds(241, 27, 85, 21);
		add(eticchetta2);

	}
}

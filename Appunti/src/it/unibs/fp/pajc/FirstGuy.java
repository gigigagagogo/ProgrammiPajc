package it.unibs.fp.pajc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FirstGuy {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//Runnable è una interfaccia void void 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstGuy window = new FirstGuy();
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
	
	public FirstGuy() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Ciao bello");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Il testo della label è specificato nel suo costruttore 
		JLabel labelAffamoc = new JLabel("Step 1\r\n");
				
		labelAffamoc.setFont(new Font("Tahoma", Font.ITALIC, 20));
		frame.getContentPane().add(labelAffamoc, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("Premimi\r\n");
		btnNewButton.addActionListener((e) -> labelAffamoc.setText("Step 2"));
		/*
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				labelAffamoc.setText("Step 2");
			}
		});
		*/
		
		frame.getContentPane().add(btnNewButton, BorderLayout.WEST);
		
	}

}

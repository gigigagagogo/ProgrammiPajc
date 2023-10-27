package it.unibs.fp.pajc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;

public class FirstGuiApp {

	private JFrame frame;
	private JTextField fieldText;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstGuiApp window = new FirstGuiApp();
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
	public FirstGuiApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setAlwaysOnTop(true);
		frame.setBounds(100, 100, 665, 419);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel firstLabel = new JLabel("Completami\r\n");
		firstLabel.setBounds(0, 0, 74, 17);
		firstLabel.setHorizontalAlignment(SwingConstants.CENTER);
		firstLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(firstLabel);
		
		JButton firstButton = new JButton("Cliccami");
		firstButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		firstButton.setBounds(0, 32, 83, 25);
		firstButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(firstButton);
		
		JLabel secondLabel = new JLabel("Completami");
		secondLabel.setBounds(362, 0, 74, 17);
		secondLabel.setHorizontalAlignment(SwingConstants.CENTER);
		secondLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(secondLabel);
		
		JButton secondButton = new JButton("Cliccami");
		secondButton.setBounds(353, 32, 83, 25);
		secondButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(secondButton);
		
		fieldText = new JTextField();
		fieldText.setBounds(259, 163, 147, 40);
		fieldText.setHorizontalAlignment(SwingConstants.CENTER);
		fieldText.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(fieldText);
		fieldText.setColumns(10);
		String [] lista= {"prova1","prova2","prova3"};
		JComboBox comboBox = new JComboBox(lista);
		comboBox.setToolTipText("");
		comboBox.setBounds(595, 1, 56, 19);
		comboBox.setSelectedIndex(-1);
		frame.getContentPane().add(comboBox);
		
		//firstButton.addActionListener((e) -> firstLabel.setText("Mi hai cliccato"));
		//secondButton.addActionListener((e) -> secondLabel.setText(fieldText.getText()));
		ActionListener listener= (e) -> firstLabel.setText(e.getSource().toString());
		//firstButton.addActionListener(listener);
	
		secondButton.addActionListener(listener);
	}
}
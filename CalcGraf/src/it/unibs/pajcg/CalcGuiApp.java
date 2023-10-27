package it.unibs.pajcg;

import java.awt.EventQueue;

import javax.swing.*;

import it.unibs.pajc.model.CalcModel;

import java.awt.*;
import it.unibs.pajcg.PnlDigits;

public class CalcGuiApp {

	private JFrame frame;
	private final CalcModel model = new CalcModel();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalcGuiApp window = new CalcGuiApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CalcGuiApp() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Calcolatrice");
		frame.setBounds(100, 100, 794, 385);
		ImageIcon icon = new ImageIcon("./src/it/unibs/pajc/CalcGui/iconaCalc.jpeg");
		frame.setIconImage(icon.getImage());
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		PnlDigits pnlDigits = new PnlDigits();
		pnlDigits.setBounds(10, 72, 172, 142);
		panel.add(pnlDigits);
		pnlDigits.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 286, 42);
		panel.add(lblNewLabel);
		
		
		
		PnlDigits pnlDigits_1 = new PnlDigits();
		pnlDigits_1.setBounds(272, 164, 191, 130);
		panel.add(pnlDigits_1);
		
		JLabel lblDebug = new JLabel("debugger");
		frame.getContentPane().add(lblDebug, BorderLayout.SOUTH);
		
		pnlDigits.addActionListener(e -> lblDebug.setText(e.getActionCommand()));
	}
}
package it.unibs.pajcg;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PnlDigits extends JPanel {

	private ArrayList<ActionListener> listenerList = new ArrayList<ActionListener>();

	public PnlDigits() {
		JButton btnPiu = new JButton("+");
		btnPiu.addActionListener(this::fireActionPerformed);
		btnPiu.setPreferredSize(new Dimension(45,30));
		add(btnPiu);
		
		JButton btnMeno = new JButton("-");
		btnMeno.addActionListener(this::fireActionPerformed);
		btnMeno.setPreferredSize(new Dimension(45,30));
		add(btnMeno);
		
		JButton btnPer = new JButton("*");
		btnPer.addActionListener(this::fireActionPerformed);
		btnPer.setPreferredSize(new Dimension(45,30));
		add(btnPer);
		
		JButton btnDiviso = new JButton("/");
		btnDiviso.addActionListener(this::fireActionPerformed);
		btnDiviso.setPreferredSize(new Dimension(45,30));
		add(btnDiviso);
	}

	public void addActionListener(ActionListener l) {
		listenerList.add(l);
	}

	public void removeActionListener(ActionListener l) {
		listenerList.remove(l);
	}

	private void fireActionPerformed(ActionEvent e) {
		ActionEvent newEvent = new ActionEvent(this, e.getID(), e.getActionCommand());
		for (ActionListener l : listenerList)
			l.actionPerformed(newEvent);
	}

}
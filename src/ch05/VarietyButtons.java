package ch05;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VarietyButtons extends JFrame implements ActionListener {
	private JPanel panel1;
	private JPanel panel2;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;

	public VarietyButtons() {
		initData();
		setInitLayout();
		addEventListener();
		setVisible(true);
	}

	private void initData() {
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel1 = new JPanel();
		panel1.setSize(500, 500);
		panel2 = new JPanel();
		panel2.setSize(500, 500);
		
		button1 = new JButton("click1");
		button2 = new JButton("click2");
		button3 = new JButton("click3");
	}

	private void setInitLayout() {
		add(panel1, BorderLayout.CENTER);
		add(panel2, BorderLayout.SOUTH);
		panel2.add(button1);
		panel2.add(button2);
		panel2.add(button3);
	}

	private void addEventListener() {
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);

		panel2.setBackground(Color.WHITE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getSource().toString());
		Object object = e.getSource();
		if (object == button1) {
			panel1.setBackground(Color.RED);
		} else if (object == button2) {
			panel1.setBackground(Color.PINK);
		} else if (object == button3) {
			panel1.setBackground(Color.yellow);
		}
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		new VarietyButtons();
	} // end of main

}

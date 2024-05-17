package ch02;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFramePannel extends JFrame {
	
	private JButton button1;
	private JButton button2;
	
	// 패널 추가하기
	private JPanel panel1;
	private JPanel panel2;
	
	public MyFramePannel() {
		initData();
		setInitLayout();
	}
	
	private void initData() {
		setTitle("패널 추가 연습");
		setSize(600,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel1=new JPanel();
		panel1.setBackground(Color.cyan);
		panel2=new JPanel();
		panel2.setBackground(Color.DARK_GRAY);
		
		button1 =new JButton("button1");
		button2 =new JButton("button2");
	}
	private void setInitLayout() {
		super.add(panel1,BorderLayout.CENTER);
		super.add(panel2,BorderLayout.SOUTH);
				
		// 루트 패널 --> BorderLayout
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MyFramePannel();
	}
	

}

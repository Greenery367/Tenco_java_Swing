package ch01;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutEx2 extends JFrame {

	JButton[] buttons;
	String[] directions = { BorderLayout.EAST, BorderLayout.WEST, BorderLayout.SOUTH, BorderLayout.NORTH,
			BorderLayout.CENTER };

	public BorderLayoutEx2() {
		initData();
		setInitLayout();
	}

	public void initData() {
		setTitle("borderLayout 연습");
		setSize(600, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buttons = new JButton[directions.length];
	}

	public void setInitLayout() {
		// 배치 관리자 선정(컨테이너)
		// borderLayout은 컴포넌트들을 동서남북가운데로 정렬/배치시켜주는 레이아웃이다.
		setLayout(new BorderLayout());
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton(directions[i]);
			add(buttons[i], directions[i]);
		}
	}

	public static void main(String[] args) {
		new BorderLayoutEx2();
	} // end of main
} // end of class

package ch01;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutEx1 extends JFrame {
	
	public BorderLayoutEx1() {
		initData();
		setInitLayout();
	}
	
	public void initData() {
		setTitle("borderLayout 연습");
		setSize(600,600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 프로그램 종료
	}
	
	public void setInitLayout() {
		// 배치 관리자 선정(컨테이너)
		// borderLayout은 컴포넌트들을 동서남북가운데로 정렬/배치시켜주는 레이아웃이다.
		setLayout(new BorderLayout());
		add(new JButton("동"), BorderLayout.EAST); // EAST=상수
		add(new JButton("서"), BorderLayout.WEST); 
		add(new JButton("남"), BorderLayout.SOUTH); 
		add(new JButton("북"), BorderLayout.NORTH);
		add(new JButton("중앙"), BorderLayout.CENTER); 
	}
	
	public static void main(String[] args) {
		new BorderLayoutEx1();
	} // end of main
} // end of class

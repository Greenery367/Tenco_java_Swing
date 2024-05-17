package ch02;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 패널에 그림을 그리는 방법 자바 문법 - 중첩 클래스(=클래스 안의 클래스를 만드는 것) -> 내부 클래스 . 외부 클래스
 * (outer/inner)
 */
public class MyDrawFrame extends JFrame {

	// 내부 클래스를 외부 클래스에서 사용하려면
	// 멤버로 가지고 있어야 한다.
	MyDrawPanel myDrawPanel;

	public MyDrawFrame() {
		initData();
		setInitLayout();
	}

	private void initData() {
		setTitle("내부 클래스를 활용한 그림 연습");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		myDrawPanel = new MyDrawPanel();
	}

	private void setInitLayout() {
		add(myDrawPanel);
		setVisible(true);

	}

	// 내부 클래스 만들어 보기
	// 가독성을 높이기 위해 사용
	// paint -> 좌표값으로 x = 0, y = 0
	// JPanel 에 있는 기능을 확장해보자.
	class MyDrawPanel extends JPanel {
		
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.drawRect(200, 200, 50, 100);
			g.drawRect(300, 300, 300, 300);
			g.drawOval(100, 150, 200, 300);
			g.drawString("반가워", 400, 500);
			g.drawString("⭐", 500, 500);
		}
	

	} // end of inner class

}

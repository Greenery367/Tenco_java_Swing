package ch01;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

// Swing-> 배치 관리자: FlowLayout
// 컴포넌트들을 (버튼, 라벨) 수평, 수직으로 배치해주는 클래스이다.
public class FlowLayoutEx extends JFrame {

	private JButton button1; // 참조 타입
	private JButton button2;
	private JButton button3; // 참조 타입
	private JButton button4;
	private JButton button5; // 참조 타입
	private JButton button6;

	// 생성자
	public FlowLayoutEx() {
		super.setTitle("FlowLayout 연습");
		super.setSize(500, 500);
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 생성자에서 메서드 호출이 가능하다.
		initData();
		setInitLayout();
	}

	// 멤버 변수를 초기화하는 기능 (값 넣기)
	public void initData() {
		button1 = new JButton("버튼 1");
		button2 = new JButton("버튼 2");
		button3 = new JButton("버튼 3");
		button4 = new JButton("버튼 4");
		button5 = new JButton("버튼 5");
		button6 = new JButton("버튼 6");
	}

	// 컴포넌트들을 배치하는 기능
	public void setInitLayout() {
		// 배치 관리자 --> BorderLayout 이라는 배치관리자가 기본으로 활용된다.
		FlowLayout flowLayout = new FlowLayout(FlowLayout.LEADING,50,50);
		super.setLayout(flowLayout);
		// 컴포넌트들을 붙이다.
		super.add(button1);
		super.add(button2);
		super.add(button3);
		super.add(button4);
		super.add(button5);
		super.add(button6);
	}

	// 코드 테스트
	public static void main(String[] args) {
		// FlowLayoutEX f1 = new FlowLayoutEx(); <-- 부를 수 있는 이름이 있는 클래스
		new FlowLayoutEx(); // <--익명 클래스(변수명 x)
		// 다시 접근해서 사용할 일이 없으면 new라고 선언만 해도 Okay

	}
}

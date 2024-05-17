package ch01;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

// Swing-> 배치 관리자: FlowLayout
// 컴포넌트들을 (버튼, 라벨) 수평, 수직으로 배치해주는 클래스이다.
public class FlowLayoutEx2 extends JFrame {

	// 배열을 사용해 코드 리팩토링
	// 배열 활용- 하나의 변수로 여러개를 통으로 관리하고 싶다면 배열을 써보자.
	private JButton[] buttons;
	
	// 생성자
	public FlowLayoutEx2() {
		super.setTitle("FlowLayout 연습");
		super.setSize(500, 500);
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton[] jButtons=new JButton[6];

		// 생성자에서 메서드 호출이 가능하다.
		initData();
		setInitLayout();
	}

	// 반복문 활용
	// 멤버 변수를 초기화하는 기능 (값 넣기)
	public void initData() {
		buttons=new JButton[6];
		for(int i=0; i<buttons.length; i++) {
			buttons[i]=new JButton("button"+(i+1));
		}
	}

	// 컴포넌트들을 배치하는 기능
	public void setInitLayout() {
		// 배치 관리자 --> BorderLayout 이라는 배치관리자가 기본으로 활용된다.
		FlowLayout flowLayout = new FlowLayout(FlowLayout.LEADING,50,50);
		super.setLayout(flowLayout);
		// 컴포넌트들을 붙이다.
		// 반복문 활용
		for(int i=0; i<buttons.length; i++) {
			super.add(buttons[i]);
		}
	}

	// 코드 테스트
	public static void main(String[] args) {
		// FlowLayoutEX f1 = new FlowLayoutEx(); <-- 부를 수 있는 이름이 있는 클래스
		new FlowLayoutEx2(); // <--익명 클래스(변수명 x)
		// 다시 접근해서 사용할 일이 없으면 new라고 선언만 해도 Okay

	}
}

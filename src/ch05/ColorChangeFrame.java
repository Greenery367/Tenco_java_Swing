package ch05;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
// 이벤트 리스너를 사용하는 방법
// 1. implements ActionListener를 사용하는 방법
// ActionListener: 운영 체제가 제어하는 이벤트를 등록할 수 있다.
public class ColorChangeFrame extends JFrame implements ActionListener {
	
	// 이벤트 리스너에 대한 개념을 이해하자.
	private JButton button1;
	
	public ColorChangeFrame() {
		initData();
		setInitLayout();
		addEventListener();
	}
	
	private void initData() {
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button1=new JButton("button1");
	}
	private void setInitLayout() {
		setLayout(new FlowLayout());
		add(button1);
		setVisible(true);
	}
	private void addEventListener() {
		// button1이 눌러지는지 계속 이벤트를 지켜보고 있어.
		// 이벤트 등록
		//addActionListener는 actionListener를 파라미터 값으로 받는다.
		button1.addActionListener((ActionListener) this);
	}
	
	public static void main(String[] args) {
		new ColorChangeFrame();
	}
	
	public void actionPerformed(ActionEvent e) {
		System.out.println("actionPerformed 메서드 호출()");
		System.out.println(e.toString());
		setBackground(Color.BLACK);
	}
	// 약속되어있던 추상 메서드를 오버라이드했다.

}

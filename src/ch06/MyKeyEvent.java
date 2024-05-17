package ch06;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;

/*
 * 키 이벤트 리스너 사용해보기
 */
public class MyKeyEvent extends JFrame implements KeyListener{

	private JTextArea textArea;

	public MyKeyEvent() {
		initDate();
		setInitLayout();
		addEventListener();
	}

	private void initDate() {
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setResizable(false); // 프레임 사이즈 조절 불가
		textArea = new JTextArea();

	}

	private void setInitLayout() {
		// 좌표 기준으로 셋팅하고 싶다면 null을 넣자.
		setLayout(new BorderLayout());
		add(textArea);
		setVisible(true);
	}

	private void addEventListener() {
		// textArea 위에서 사용자기 키보드를 누르면 감지해서
		// 나에게 (코드 기준) 알려줘
		textArea.addKeyListener(this);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// 응답 받고 싶다면 1
		//System.out.println(e.toString());
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// 응답 받고 싶다면 2
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		final int LEFT=37;
		final int UP=38;
		final int RIGHT=39;
		final int DOWN=40;
		
		if(e.getKeyCode()==LEFT) {
			System.out.println("좌");
		} else if (e.getKeyCode()==UP) {
			System.out.println("상");
		} else if (e.getKeyCode()==RIGHT) {
			System.out.println("우");
		} else if (e.getKeyCode()==DOWN) {
			System.out.println("하");
		} else {
			System.out.println("keyPressed : "+e.getKeyCode());
		}
		// 응답 받고 싶다면 3
		// 문제 1.
		// 제어문을 활용해서, 방향키 위 아래 왼쪽 오른쪽이 눌렀다가 떼면,
		// 콘솔창에 한글로 위 아래 왼쪽 오른쪽 글자를 표기하시오.
		
	}

}

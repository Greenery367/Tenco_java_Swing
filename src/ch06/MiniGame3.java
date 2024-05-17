package ch06;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MiniGame3 extends JFrame implements KeyListener {

	private JLabel jPlayer;
	// 변수=변하는 수
	private int jPlayerX = 100;
	private int jPlayerY = 100;
	private final int MOVE_INSTANCE = 5;
	private final int FRAME_WIDTH = 500;
	private final int FRAME_HEIGHT = 500;
	private final String PLAYER_NAME = "야스오";
	private final int PLAYER_WIDTH = 100;
	private final int PLAYER_HEIGHT = 100;

	public MiniGame3() {
		initData();
		setInitLayout();
		addEventListener();
		setVisible(true);
	}

	private void initData() {
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jPlayer = new JLabel(PLAYER_NAME);
		jPlayer.setSize(jPlayerX, jPlayerY);
	}

	private void setInitLayout() {
		// 좌표 기반의 배치 관리자
		setLayout(null);
		add(jPlayer);
		jPlayer.setLocation(PLAYER_WIDTH, PLAYER_HEIGHT);
	}

	private void addEventListener() {
		// jPlayer 객체에게서만 keyListener 동작을 시키고자 한다면
		// 익명 구현클래스로 KeyListener 인터페이스를 재정의할 수 있다.

		this.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					jPlayerY -= MOVE_INSTANCE;
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					jPlayerX -= MOVE_INSTANCE;
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					jPlayerX += MOVE_INSTANCE;
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					jPlayerY += MOVE_INSTANCE;
				}
				jPlayer.setLocation(jPlayerX, jPlayerY);
			}
		});

	}

	public static void main(String[] args) {
		new MiniGame3();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}

package BubblePractice.ex03;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class BubbleFrame extends JFrame {

	private JLabel backgroundMap;
	// 포함관계 - 컴포지션
	private Player player;

	public BubbleFrame() {
		initData();
		setInitLayout();
		addEventListener();

		// Player 백그라운드 서비스 시작
		new Thread(new BackgroundPlayerService(player)).start();
	}

	private void initData() {
		// todo 이미지 변경
		backgroundMap = new JLabel(new ImageIcon("img/backgroundMapService.png"));
		// backgroundMap = new JLabel(new ImageIcon("img/test.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Frame -> root Panel
		setContentPane(backgroundMap); // add 처리
		setSize(1000, 640);

		player = new Player();
	}

	private void setInitLayout() {
		// 좌표값으로 배치
		setLayout(null);
		setResizable(false); // 프레임 크기 조절 불가
		setLocationRelativeTo(null); // JFrame을 모니터 한가운데에 배치
		setVisible(true);

		add(player);
	}

	private void addEventListener() {
		this.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e) {
				System.out.println("key code : "+e.getKeyCode());
				// 눌린 키보드 키의 값을 출력
				
				switch(e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					if(!player.isLeft() && !player.isLeftWallCrash()) {
						player.left();
					}
					break;
				case KeyEvent.VK_RIGHT:
					if(!player.isRight() && !player.isRightWallCrash()) {
						player.right();
					}
					break;
				case KeyEvent.VK_UP:
					player.up();
					break;
				default:
					break;
				}
			} // end of keyPressed
			
			public void keyReleased(KeyEvent e) {
				switch(e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					player.setLeft(false);
					break;
				case KeyEvent.VK_RIGHT:
					player.setRight(false);
					break;
				default:
					break;
				}
			} // end of keyReleased
		});
	}

	public static void main(String[] args) {
		new BubbleFrame();
	}
}

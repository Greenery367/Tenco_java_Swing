package BubbleBubble.test.ex09;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BubbleFrame extends JFrame {
	
	// 컨텍스트를 생성하는 방법 (셀프 참조)
	BubbleFrame mContext = this;
	
	private JLabel backgroundMap;
	private Player player;

	public BubbleFrame() {
		initData();
		setInitLayout();
		addEventListener();
		
		// Player 백그라운드 서비스 시작
		new Thread(new BackgroundPlayerService(player)).start();
	}

	private void initData() {
		// todo-이미지 변경
		backgroundMap = new JLabel(new ImageIcon("img/backgroundMap.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Frame --> root Panel
		setContentPane(backgroundMap);
		setSize(1000, 640);

		// mContext --> 참조 타입() --> 주소값의 크기는 기본 4Byte이다.
		player = new Player(mContext);
	}

	private void setInitLayout() {
		// 좌표값으로 배치
		setLayout(null);
		setResizable(false); // 프레임 조절 불가
		setLocationRelativeTo(null); // JFrame을 여러분 모니터 가운데에 자동 배치
		setVisible(true);

		add(player);
	}  

	private void addEventListener() {
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("key code : " + e.getKeyCode());

				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					// 왼쪽으로 방향키를 누르고 있다면,
					// 키보드 이벤트가 계속 왼쪽으로 간다. <- <- <-
					// 왼쪽 상태가 아니라면,?
					if(!player.isLeft() && !player.isLeftWallCrash()) {
						player.left();
					}
					// 왼쪽 벽에 충돌한 게 아니라면,?
					break;
				case KeyEvent.VK_RIGHT:
					if(!player.isRight() && !player.isRightWallCrash()) {
						player.right();
					}
					
					break;
				case KeyEvent.VK_UP:
					player.up();
					
					break;
				case KeyEvent.VK_SPACE:
					player.attack();
					// 프레임에 컴포넌트를 add 하는 동작은 누구?
					// -> JFrame의 add() 메서드
					// 버블 실행 시에 끊김 현상이 발생하는 이유는 왜일까?
					
				default:
					break;
				}
			} // end of key pressed
			
			@Override
			public void keyReleased(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					// 왼쪽으로 가는 거 멈춰!
					player.setLeft(false);
					break;
				case KeyEvent.VK_RIGHT:
					// 오른쪽으로 가는 거 멈춰!
					player.setRight(false);
					break;
				case KeyEvent.VK_UP:
					player.setUp(false);
					break;
				default:
					break;
				}
			} // end of keyReleased
			
		}); // end of keyAdapter
	}
	
	// getter 메서드
	public Player getPlayer() {
		return this.player;
	}
	
	// 코드 테스트
	public static void main(String[] args) {
		// main 함수를 가지고 있는 클래스는 하위에 생성된 모든 객체들의 주소값을 알고 있다!!
		new BubbleFrame();
	}

}

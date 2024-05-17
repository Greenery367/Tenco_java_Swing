package BubblePractice.ex01;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class BubbleFrame extends JFrame {
	private JLabel backgroundMap;
	private Player player;
	
	public BubbleFrame() {
		initData();
		setInitLayout();
		addEventListener();
	}
	
	private void initData() {
		backgroundMap = new JLabel(new ImageIcon("img/backgroundMap.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(backgroundMap);
		setSize(1000,640);
		player=new Player();
	}
	
	private void setInitLayout() {
		//좌표값으로 배치
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
					player.left();
					break;
				case KeyEvent.VK_RIGHT:
					player.right();
					break;
				case KeyEvent.VK_UP:
					player.up();
					break;
				}
			}
		});
	}
	
	public static void main(String[] args) {
		new BubbleFrame();
	}
}

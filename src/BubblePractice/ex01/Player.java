package BubblePractice.ex01;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Player extends JLabel implements Moveable{

	private int x;
	private int y;
	private ImageIcon playerR,playerL;
	
	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;
	
	private final int SPEED = 4;
	private final int JUMPSPEED = 2;
	
	public void setLeft(boolean left) {
		this.left=left;
	}
	
	public void setRight(boolean right) {
		this.right = right;
	}
	
	public Player() {
		initData();
		setInitLayout();
	}
	
	public void initData(){
		playerR=new ImageIcon("img/playerR.png");
		playerL =new ImageIcon("img/playerL.png");
		
		// 처음 실행 시 초기 값 셋팅
		x=55;
		y=535;
		
		//플레이어가 가만히 멈춘 상태
		left=false;
		right=false;
		up=false;
		down=false;
		
		
		setIcon(playerR);
		setSize(50,50);
		setLocation(x,y);
	};
	private void setInitLayout(){
		
	}

	@Override
	public void right() {
		right=true;
		setIcon(playerR);
		new Thread(new Runnable() {
			public void run() {
				while(right) {
					x=x+SPEED;
					setLocation(x,y);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void left() {
		left=true;
		setIcon(playerL);
		new Thread(new Runnable() {
			public void run() {
				while(left) {
					x=x-SPEED;
				setLocation(x,y);
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
			}
		}).start();
		// TODO Auto-generated method stub
		
	}

	@Override
	public void up() {
		System.out.println("점프");
		up=true;
		new Thread(new Runnable() {
			public void run() {
				for(int i=0; i<130 / JUMPSPEED; i++) {
					y=y-JUMPSPEED;
					setLocation(x,y);
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				// 객체의 상태 값을 잘 조절해야 한다.
				up=false;
				down();
			}
		}).start();
		// TODO Auto-generated method stub
		
	}

	@Override
	public void down() {
		System.out.println("다운");
		down=true;
		new Thread(new Runnable() {
			public void run() {
				for(int i=0; i<130/JUMPSPEED; i++) {
					y=y+JUMPSPEED;
					setLocation(x,y);
					try {
						Thread.sleep(3);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();
		// TODO Auto-generated method stub
		down=false;
	};

}

package BubbleBubble.test.ex06;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Player extends JLabel implements Moveable {

	private int x;
	private int y;
	private ImageIcon playerR, playerL;

	// 움직임의 상태
	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;
	
	// 벽에 충돌한 상태
	private boolean leftWallCrash;
	private boolean rightWallCrash;

	// 플레이어 속도 상태
	private final int SPEED = 4;
	private final int JUMPSPEED = 2;
	
	// get, set 
	
	
	// setter 메서드
	
	public void setLeft(boolean left) {
		this.left=left;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public ImageIcon getPlayerR() {
		return playerR;
	}
	public void setPlayerR(ImageIcon playerR) {
		this.playerR = playerR;
	}
	public ImageIcon getPlayerL() {
		return playerL;
	}
	public void setPlayerL(ImageIcon playerL) {
		this.playerL = playerL;
	}
	public boolean isDown() {
		return down;
	}
	public void setDown(boolean down) {
		this.down = down;
	}
	public boolean isLeftWallCrash() {
		return leftWallCrash;
	}
	public void setLeftWallCrash(boolean leftWallCrash) {
		this.leftWallCrash = leftWallCrash;
	}
	public boolean isRightWallCrash() {
		return rightWallCrash;
	}
	public void setRightWallCrash(boolean rightWallCrash) {
		this.rightWallCrash = rightWallCrash;
	}
	public boolean isLeft() {
		return left;
	}
	public boolean isRight() {
		return right;
	}
	public boolean isUp() {
		return up;
	}
	public int getSPEED() {
		return SPEED;
	}
	public int getJUMPSPEED() {
		return JUMPSPEED;
	}
	public void setRight(boolean right) {
		this.right=right;
	}
	public void setUp(boolean up) {
		this.up=up;
	}

	public Player() {
		initData();
		setInitLayout();

	}

	private void initData() {
		playerR = new ImageIcon("img/playerR.png");
		playerL = new ImageIcon("img/playerL.png");

		// 처음 실행 시 초기 값 셋팅
		x = 450;
		y = 540;
		
		leftWallCrash=false;
		rightWallCrash=false;
		
		// 플레이어가 가만히 멈춘 상태
		left=false;
		right=false;
		up=false;
		down=false;
		
		setIcon(playerR);
		this.setSize(50, 50);
		setLocation(x, y);
	}

	private void setInitLayout() {

	}

	@Override
	public void left() {
		left=true;
		setIcon(playerL);
		
		new Thread(new Runnable() {

			@Override
			public void run() {
				while(left) {
					x = x - SPEED;
					setLocation(x, y);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} // end of while
			} // end of run
			
		}).start(); // end of Thread
		
	}

	@Override
	public void right() {
		right=true;
		setIcon(playerR);
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				
				while(right) {
					x = x + SPEED;
					setLocation(x, y);
					
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} // end of while
			} // end of run
		}).start(); // end of Rannable

	} // end of right

	@Override
	public void up() {
		System.out.println("점프");
		up=true;
		setIcon(playerR);
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				for(int i=0; i<130/JUMPSPEED; i++) {
					y=y-JUMPSPEED;
					setLocation(x,y);
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} // end of for
				
				up=false;
				
				} // end of run
		}).start();
		//객체의 상태값을 잘 조절해야 한다.
	}

	@Override
	public void down() {
		System.out.println("다운");
		down=true;

		new Thread(new Runnable() {
			public void run() {
				
				while(down) {
					y=y+SPEED;
					setLocation(x,y);
					try {
						Thread.sleep(3);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					down=false;
				}
				
			}
		}).start();

	}

}

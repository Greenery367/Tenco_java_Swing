package BubbleBubble.test.ex10;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Enemy extends JLabel implements Moveable {

	BubbleFrame mContext;
	// 살아있는 상태 0, 물방울에 갇힌 상태 1
	private int state;

	// 적군의 좌표값, 위치 상태
	private int x;
	private int y;
	private ImageIcon enemyR, enemyL;

	// 움직임의 상태
	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;

	// 벽에 충돌한 상태
	private boolean leftWallCrash;
	private boolean rightWallCrash;

	// 적군 속도 상태
	private final int SPEED = 3;
	private final int JUMPSPEED = 1;

	// 적군 방향 상태
	private EnemyWay enemyWay;

	public Enemy(BubbleFrame mContext) { // 부모 메서드가 들어온다.
		this.mContext = mContext;
		initData();
		setInitLayout();
		left();
	}
	
	public int getState() {
		return state;
	}
	
	public void setState(int state) {
		this.state=state;
	}

	private void initData() {
		enemyR = new ImageIcon("img/enemyR.png");
		enemyL = new ImageIcon("img/enemyL.png");

		state = 0;

		// 처음 실행 시 초기 값 셋팅
		x = 720;
		y = 175;

		leftWallCrash = false;
		rightWallCrash = false;

		// 적군 방향 상태
		left = false;
		right = false;
		up = false;
		down = false;

		enemyWay = EnemyWay.LEFT;
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

	private void setInitLayout() {

		setIcon(enemyL);
		this.setSize(50, 50);
		setLocation(x, y);
	}

	@Override
	public void left() {
		enemyWay = EnemyWay.LEFT;
		left = true;
		setIcon(enemyL);

		new Thread(new Runnable() {
			@Override
			public void run() {
				while (left) {
					x = x - SPEED;
					setLocation(x, y);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

	@Override
	public void right() {
		enemyWay = EnemyWay.RIGHT;
		right = true;
		setIcon(enemyR);

		new Thread(new Runnable() {
			@Override
			public void run() {
				while (right) {
					x = x + SPEED;
					setLocation(x, y);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	} // end of right

	@Override
	public void up() {
		System.out.println("점프");
		up = true;
		new Thread(new Runnable() {
			@Override
			public void run() {

				for (int i = 0; i < 130 / JUMPSPEED; i++) {
					y = y - JUMPSPEED;
					setLocation(x, y);
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				// 객체의 상태값을 잘 조절해야 한다.
				up = false;
				down();

			}
		}).start();

	}

	@Override
	public void down() {
		System.out.println("다운");
		down = true;
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (down) {
					y = y + SPEED;
					setLocation(x, y);
					try {
						Thread.sleep(3);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				down = false;
			}
		}).start();}
}
	

package BubbleBubble.test.ex01;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel implements Moveable {

	private int x;
	private int y;
	private ImageIcon playerR, playerL;

	public Player() {
		initData();
		setInitLayout();

	}

	private void initData() {
		playerR = new ImageIcon("img/playerR.png");
		playerL = new ImageIcon("img/playerL.png");

		// 처음 실행 시 초기 값 셋팅
		x = 55;
		y = 535;
		setIcon(playerR);
		this.setSize(50, 50);
		setLocation(x, y);
	}

	private void setInitLayout() {

	}

	@Override
	public void left() {
		setIcon(playerL);
		x = x - 10;
		setLocation(x, y);
	}

	@Override
	public void right() {
		setIcon(playerR);
		x = x + 10;
		setLocation(x, y);

	}

	@Override
	public void up() {
		System.out.println("점프");
		setIcon(playerR);
		y = y - 10;
		setLocation(x, y);

	}

	@Override
	public void down() {
		System.out.println("다운");
		// TODO Auto-generated method stub

	}

}

package ch06;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class MiniGame2 extends JFrame implements KeyListener {
	private JLabel jPlayer;
	private JLabel backgroundMap;

	private int jPlayerY = 50;
	private int jPlayerX = 50;
	private final int MOVE_INSTANCE = 10;

	public MiniGame2() {
		initData();
		setInitLayout();
		addEventListener();
		setVisible(true);
	}

	private void initData() {
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jPlayer = new JLabel(new ImageIcon("playerL.png"));
		jPlayer.setSize(50, 50);

		backgroundMap = new JLabel(new ImageIcon("backgroundMap.png"));
		Icon icon = new ImageIcon("backgroundMap.png");
		backgroundMap = new JLabel(icon);
		backgroundMap.setSize(500, 500);
		backgroundMap.setLocation(0, 0);
	}

	private void setInitLayout() {
		setLayout(null);
		add(backgroundMap);
		backgroundMap.add(jPlayer);
		jPlayer.setLocation(250, 340);
	}

	private void addEventListener() {
		this.addKeyListener(new KeyListener() {
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

	public static void main(String[] args) {
		new MiniGame2();
	}

}

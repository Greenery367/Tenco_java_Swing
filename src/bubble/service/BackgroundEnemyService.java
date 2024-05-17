package bubble.service;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import bubble.components.Enemy;

/*o
 * 현재 메인 쓰레드는 너~무 바빠!
 * 그래서, 백그라운드에서 계속 플레이어의 움직임을 관찰할 예정.
 */
public class BackgroundEnemyService implements Runnable {

	private BufferedImage image;
	private Enemy enemy;

	// 생성자 의존 설계 (Dependency Injection)
	public BackgroundEnemyService(Enemy enemy) {
		this.enemy = enemy;
		try {
			image = ImageIO.read(new File("img/backgroundMapService.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public void run() {
		// 색상 확인 todo(보정값 필요)
		while (true) {
			Color leftColor = new Color(image.getRGB(enemy.getX() + 10+5, enemy.getY() + 25));
			Color rightColor = new Color(image.getRGB(enemy.getX() + 50 +10, enemy.getY() + 25));

			// Color bottomColor = new Color(image.getRGB(player.getX(), player.getY()));
			// 흰색이면 바닥 RGB 값이 == 255, 255, 255
			// 바닥인 경우는 --> 255, 0, 0 (=바닥)
			// 바닥인 경우는 --> 0, 0, 255 (=바닥)

			int bottomColorLeft = image.getRGB(enemy.getX() + 20, enemy.getY() + 55);
			int bottomColorRight = image.getRGB(enemy.getX() -40, enemy.getY() + 55);
			
			if ((bottomColorLeft + bottomColorRight) != -2) {
				// 여기는 멈춰야 한다. (즉, 빨간 바닥 혹은 파란 바닥)
				enemy.setDown(false);
			} else {
				// 점프하는 순간에는 다운되면 안 된다.
				// 플레이어가 올라가는 상황이 아니라면,
				// 플레이어가 내려가는 상황이 아니라면, --> Down 호출
				if (!enemy.isUp() && !enemy.isDown()) {
					enemy.down();
				}
			}
			
			// 왼쪽에 충돌함
			if (leftColor.getRed() == 255 && leftColor.getGreen() == 0 && leftColor.getBlue() == 0) {
				System.out.println("왼쪽 벽에 충돌함.");
				enemy.setLeftWallCrash(true);
				enemy.setLeft(false);
				enemy.right();
			} else if (rightColor.getRed() == 255 && rightColor.getGreen() == 0 && rightColor.getBlue() == 0) {
				System.out.println("오른쪽 벽에 충돌함.");
				enemy.setRightWallCrash(true);
				enemy.setRight(false);
				enemy.left();
			} else {
				enemy.setLeftWallCrash(false);
				enemy.setRightWallCrash(false);
			}
			// 위 두 조건이 아니면 player 마음대로 움직일 수 있다.
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}

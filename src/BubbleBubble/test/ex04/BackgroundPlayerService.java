package BubbleBubble.test.ex04;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/*
 * 현재 메인 쓰레드는 너~무 바빠!
 * 그래서, 백그라운드에서 계속 플레이어의 움직임을 관찰할 예정.
 */
public class BackgroundPlayerService implements Runnable {

	private BufferedImage image;
	private Player player;
	
	// 생성자 의존 설계 (Dependency Injection)
	public BackgroundPlayerService(Player player) {
		this.player=player;
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
		while(true) {
			Color leftColor=new Color(image.getRGB(player.getX()+10, player.getY()+25));
			Color rightColor =new Color(image.getRGB(player.getX()+50+10, player.getY()+25));
			
			// 왼쪽에 충돌함
			if(leftColor.getRed()==255 && leftColor.getGreen()==0 && leftColor.getBlue()==0) {
				System.out.println("왼쪽 벽에 충돌함.");
				player.setLeftWallCrash(true);
				player.setLeft(false);
			} else if(rightColor.getRed()==255 && rightColor.getGreen()==0 && rightColor.getBlue()==0) {
				System.out.println("오른쪽 벽에 충돌함.");
				player.setRightWallCrash(true);
				player.setRight(false);
			} else {
				player.setLeftWallCrash(false);
				player.setRightWallCrash(false);				
			}
			// 위 두 조건이 아니면 player 마음대로 움직일 수 있다.
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}

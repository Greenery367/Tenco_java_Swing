package BubblePractice.ex05;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BackgroundPlayerService implements Runnable {

	private BufferedImage image;
	private Player player;
	
	public BackgroundPlayerService(Player player) {
		this.player=player;
		try {
			image=ImageIO.read(new File("img/backgroundMapService.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		while(true) {
			Color leftColor = new Color(image.getRGB(player.getX()+10,player.getY()+25));
			Color rightColor = new Color(image.getRGB(player.getX()+50+10,player.getY()+25));
			
			// Color bottomColor = new Color(image.getRGB(player.getX(), player.getY()));
			
			// 흰색이면 바닥 RGB   => 255 255 255 
			// 바닥인 경우 --> 255 0 0   (바닥이라고 판단 가능)
			// 바닥인 경우 --> 0   0 255 (바닥이라고 판단 가능)
			int bottomColorLeft = image.getRGB(player.getX() + 20, player.getY() + 50 + 5);
			int bottomColorRight = image.getRGB(player.getX() + 50 - 10, player.getY() + 50 + 5);
						
			// 하얀색 ------> int 값이 - 2 
			if(bottomColorLeft + bottomColorRight  != -2) {
				// 여기는 멈추야 한다. ( 빨간 바닥 또는 파란색 바닥) 
				player.setDown(false);
			}
				
			// 왼쪽 벽에 충돌함
			if(leftColor.getRed()==255 && leftColor.getGreen() ==0 && leftColor.getBlue()==0) {
				System.out.println("왼쪽 벽에 충돌 함.");
				player.setLeftWallCrash(true);
				player.setLeft(false);
			} else if (rightColor.getRed()==255 && rightColor.getGreen() ==0 && rightColor.getBlue()==0) {
				System.out.println("오른쪽 벽에 충돌 함.");
				player.setRightWallCrash(true);
				player.setRight(false);
			}else {
				player.setLeftWallCrash(false);
				player.setRightWallCrash(false);
			}
			// 위 두 조건이 아니면, player 마음대로 움직일 수 있다.
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// TODO Auto-generated method stub
		
	}

}

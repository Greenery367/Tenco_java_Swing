package BubblePractice.ex02;

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
			
			if(leftColor.getRed()==255 && leftColor.getGreen() ==0 && leftColor.getBlue()==0) {
				System.out.println("왼쪽 벽에 충돌 함.");
			} else if (rightColor.getRed()==255 && rightColor.getGreen() ==0 && rightColor.getBlue()==0) {
				System.out.println("오른쪽 벽에 충돌 함.");
			} else {
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
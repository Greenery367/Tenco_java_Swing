package BubbleBubble.test.ex10;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BackgroundBubbleService {
	
	private BufferedImage image;
	private Bubble bubble; // 연관 관계(생성자 의존 주입)
	
	// 생성자
	public BackgroundBubbleService(Bubble bubble) {
		this.bubble = bubble;
		try {
			image = ImageIO.read(new File("img/backgroundMapService.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// 왼쪽 벽에 부딪혔는지
	
	public boolean leftWall() {
		Color leftColor = new Color(image.getRGB(bubble.getX()+10, bubble.getY()+25));
		// 255 0 0 <--- 빨간색 (왼쪽 벽 확인)
		if(leftColor.getRed()==255 && leftColor.getGreen()==0 && leftColor.getBlue()==0) {
			return true;
		}
		return false;
	}
	
	// 오른쪽 벽에 부딪혔는지
	public boolean rightWall() {
		Color rightColor = new Color(image.getRGB(bubble.getX()+50+10,bubble.getY()+25));
		if(rightColor.getRed()==255 && rightColor.getGreen()==0 && rightColor.getBlue()==0) {
			return true;
		}
		return false;
	}
	
	// 천장 벽에 부딪혔는지
	public boolean topWall() {
		Color topColor = new Color(image.getRGB(bubble.getX(), bubble.getY()));
		if(topColor.getRed()==255 && topColor.getGreen()==0 && topColor.getBlue()==0) {
			return true;
		}
		return false;
	}

}

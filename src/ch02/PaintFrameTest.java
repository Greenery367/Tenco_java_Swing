package ch02;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ch02.MyDrawFrame.MyDrawPanel;

public class PaintFrameTest extends JFrame {

	PaintFrame paintFrame;

	public PaintFrameTest() {
		initData();
		setInitLayout();
	}

	private void initData() {
		setTitle("내부 클래스를 활용한 그림 연습");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		paintFrame = new PaintFrame();

	}

	
	private void setInitLayout() {
		add(paintFrame);
		setVisible(true);
	}
	
	class PaintFrame extends JPanel{
		public void paint(Graphics g) {
			super.paint(g);

			g.drawRect(0, 350, 2000, 250);
			g.drawRect(210, 300, 10, 50);
			g.drawRect(170, 300, 15, 60);
			g.drawRect(130, 350, 18, 80);
			g.drawRect(100, 400, 20, 100);
			
			g.drawRect(340, 300, 10, 50);
			g.drawRect(380, 300, 15, 60);
			g.drawRect(420, 350, 18, 80);
			g.drawRect(450, 400, 20, 100);
			
			g.drawRect(260, 270, 20, 25);
			g.drawRect(260, 295, 20, 25);
			g.drawRect(280, 270, 20, 25);
			g.drawRect(260, 270, 40, 50);
			g.drawRect(240, 250, 80, 100);
			int x[] = { 230, 280, 330 };
			int y[] = { 250, 180, 250 };
			g.drawPolygon( x, y, 3 );
			g.drawString("⭐", 500, 200);
			g.drawString("⭐", 130, 150);
			g.drawString("⭐", 120, 200);
			g.drawString("⭐", 450, 200);
			g.drawString("⭐", 150, 150);
			g.drawString("⭐", 120, 200);
			g.drawString("⭐", 500, 200);
			g.drawString("⭐", 130, 150);
			g.drawString("⭐", 120, 200);
			g.drawString("⭐", 450, 200);
			g.drawString("⭐", 150, 150);
			g.drawString("⭐", 120, 200);
		}
	}

}

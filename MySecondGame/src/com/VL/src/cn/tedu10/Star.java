package cn.tedu10;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Star {
	int x, y;
	int state = 0;
	int speed = 0;
	static Image starImg;
	Image starImg0, starImg1, starImg2, starImg3, starImg4, starImg5, starImg6, starImg7;
	static Image[] starArry = new Image[9];
	static {
		starImg = new ImageIcon("Img/qq00.png").getImage();
		for (int i = 0; i < starArry.length; i++) {
			starArry[i] = new ImageIcon("Img/qq0" + i + ".png").getImage();
		}
	}

	public Star() {
		x = (int) (Math.random() * (PlaneFrame.WIDTH - starImg.getWidth(null)));
		y = -starImg.getHeight(null);
		speed = (int) (Math.random() * 4 + 1);

	}
	int index = 0;
	public void step() {

		starImg = starArry[index % 9];
		index++;
	}

}

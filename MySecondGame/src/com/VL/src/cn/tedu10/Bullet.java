package cn.tedu10;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Bullet {
	int x=0, y=0;
	Image bulletImg = new ImageIcon("Img/bullets.png").getImage();

	public Bullet(int x,int y) {
		this.x=x;
		this.y=y;
	}
	public void move(){
		y-=50;
	}

}

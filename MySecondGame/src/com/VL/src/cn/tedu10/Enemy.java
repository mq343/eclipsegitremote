package cn.tedu10;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Enemy {
	int x, y;
	int speed;
	int state=1;
	static Image enemyImg;
	static Image[] enemyImgs = new Image[6];
	static{
		enemyImg=new ImageIcon("Img/flys.png").getImage();
		for(int i=0;i<enemyImgs.length;i++){
			enemyImgs[i]=new ImageIcon("Img/flys"+i+".png").getImage();
		}
	}
	public Enemy(){
		x=(int)(Math.random()*(PlaneFrame.WIDTH-enemyImg.getWidth(null)));
		y=-enemyImg.getHeight(null);
		speed=(int)(Math.random()*4+1);
	}
	int index = 0;
	public void step() {

		enemyImg = enemyImgs[index % 6];
		index++;
	}

}

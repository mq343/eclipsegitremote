package cn.tedu10;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Hero {
	int x = 250, y = 500;//坐标
	Image heroImg1, heroImg2, heroImg3, heroImg4, heroImg5, heroImg6, heroImg7, heroImg8, heroImg9;
	public static Image heroImg;
	int life = 100;//生命值
	public static int fire = 1;//火力
	int score = 0;//分数
	int money = 0;//金币
	int fireX = 0, fireY = 0;
	Image[] imgArry = new Image[10];

	public Hero() {
		heroImg = new ImageIcon("Img/ws00.png").getImage();

		for (int i = 0; i < 10; i++) {

			imgArry[i] = new ImageIcon("Img/ws0" + i + ".png").getImage();
		}

	}

	int index = 0;

	public void step() {

		heroImg = imgArry[index % 10];
		index++;
	}

	public ArrayList<Bullet> shoot() {
		ArrayList<Bullet> list = new ArrayList<Bullet>();

		if (fire == 1) {
			list.add(new Bullet(x + 50, y + 30));
		}
		if (fire == 2) {
			list.add(new Bullet(x + 30, y + 30));
			list.add(new Bullet(x + 60, y + 30));
			
		}
		if(fire==3){
			list.add(new Bullet(x + 30, y + 30));
			list.add(new Bullet(x + 60, y + 30));
			list.add(new Bullet(x + 50, y + 30));
			
		}
		return list;

	}
}

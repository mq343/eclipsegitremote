package cn.tedu10;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
/*
 * 这是一个病态的社会
 * 扭曲的三观、病态的追求
 * 没有人想着改变这一切
 * 这是理想主义者的炼狱
 * 如果有一天我不需要为别人而活，我会选择离去
 */

public class BossBullet {
	int x=0,y=0;
	int speed=0;
	static Image bulletImg = new ImageIcon("Img/bossbu.png").getImage();
	static{
		Image []bossbu=new Image[2];
		 bossbu[0]=new ImageIcon("Img/bossbu0.png").getImage();
		 bossbu[1]=new ImageIcon("Img/bossbu.png").getImage();
	}

	public BossBullet(int x,int y) {
		this.x=x;
		this.y=y;
	}
	public void move(){
		y+=50;
	}
	public ArrayList<BossBullet> shoot() {
		ArrayList<BossBullet> list = new ArrayList<BossBullet>();

	
			list.add(new BossBullet(x -40, y + 30));
			list.add(new BossBullet(x + 60, y + 30));
			
	
		return list;

	}

}

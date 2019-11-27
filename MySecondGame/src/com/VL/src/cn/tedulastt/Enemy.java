package cn.tedulastt;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Enemy {
	int x,y,speed;
	Image enemyImg=new ImageIcon("LastImg/Right.jpg").getImage();
	static Image enemys[]=new 	Image[4];
	static{
		enemys[0]=new ImageIcon("LastImg/Right.jpg").getImage();
		enemys[1]=new ImageIcon("LastImg/Down.jpg").getImage();
		enemys[2]=new ImageIcon("LastImg/Left.jpg").getImage();
		enemys[3]=new ImageIcon("LastImg/Up.jpg").getImage();
	}
	int state=0;
	public Enemy(){
		x=10;
		y=850;
		speed=(int)(Math.random()*10)+10;
		state=0;
		
	}
	
	
	
	
	
	

}

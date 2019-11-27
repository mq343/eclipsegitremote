package com.VL;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Ban {
	//属性
	int x,y;
	int speedx=5;//设置挡板的横向移动速度
	int speedy=2;//设置挡板的纵向移动速度
	int touch;//触碰时计数
	Qiu qiu = new Qiu();
	Image banImg;
	Image[] banImgs= new Image[2];
	//构造
	public Ban(int i){
		banImg = new ImageIcon("gaming/db1.png").getImage();
		banImgs[0] = new ImageIcon("gaming/db1.png").getImage();
		banImgs[1] = new ImageIcon("gaming/db2.png").getImage();
		//云板初始x坐标为随机数
		x = (int) (Math.random()*(GameFrame.WIDTH-banImg.getWidth(null)));
		y = GameFrame.HEIGHT;
		//当传入参数为0时生成云板图片1
		//当传入参数为1时生成云板图片2
		if(i==0){banImg=banImgs[0];}
		if(i==1){banImg=banImgs[1];}
	}
	//方法
	public void move(){
			y-=speedy;		
	}
}

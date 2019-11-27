package com.VL;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Qiu {
	//属性
	int x,y;
	int speedx=20;	//设置横向移动速度（每按一次按键）
	int g = 1;		//模仿重力加速度
	int time = 0;	//运动时间
	int speedy;		//纵向速度
	int score=0;	//分数
	int life = 3;	//初始为三条命
	static Image qiuImg;
	static{
		qiuImg = new ImageIcon("gaming/cute.png").getImage();
	}
	//构造
	public Qiu(){
		x = (int) (Math.random()*(GameFrame.WIDTH-qiuImg.getWidth(null))/2);
		y = 200;
		
	}
	//方法
	//移动
	public void move(){
		//实现仿重力运动
		time++;
		speedy=g*time/5;
		y+=speedy;
	}
}

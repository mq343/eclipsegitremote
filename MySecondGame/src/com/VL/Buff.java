package com.VL;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Buff {
	//属性
	int x,y;	//横纵坐标
	int speedx;	//横向速度
	int speedy;	//纵向速度
	int state;	//开始运动状态
	static Image doubao;
	//静态代码段
	static{
		doubao = new ImageIcon("gaming/doubao.png").getImage();
	}
	//构造
	public Buff(){
		x = (int) (Math.random()*(GameFrame.WIDTH-doubao.getWidth(null)));
		y = GameFrame.HEIGHT;
		speedx = 3;
		speedy = 5;
		state = (int) (Math.random()*2);
	}
	//方法
	//不同状态的运动方式
	public void move(){
		if(state==0){
			x+=speedx;
			y-=speedy;
		}
		if(state==1){
			x-=speedx;
			y-=speedy;
		}
	}

}

package com.VL;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Buff {
	//����
	int x,y;	//��������
	int speedx;	//�����ٶ�
	int speedy;	//�����ٶ�
	int state;	//��ʼ�˶�״̬
	static Image doubao;
	//��̬�����
	static{
		doubao = new ImageIcon("gaming/doubao.png").getImage();
	}
	//����
	public Buff(){
		x = (int) (Math.random()*(GameFrame.WIDTH-doubao.getWidth(null)));
		y = GameFrame.HEIGHT;
		speedx = 3;
		speedy = 5;
		state = (int) (Math.random()*2);
	}
	//����
	//��ͬ״̬���˶���ʽ
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

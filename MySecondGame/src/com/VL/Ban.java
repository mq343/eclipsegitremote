package com.VL;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Ban {
	//����
	int x,y;
	int speedx=5;//���õ���ĺ����ƶ��ٶ�
	int speedy=2;//���õ���������ƶ��ٶ�
	int touch;//����ʱ����
	Qiu qiu = new Qiu();
	Image banImg;
	Image[] banImgs= new Image[2];
	//����
	public Ban(int i){
		banImg = new ImageIcon("gaming/db1.png").getImage();
		banImgs[0] = new ImageIcon("gaming/db1.png").getImage();
		banImgs[1] = new ImageIcon("gaming/db2.png").getImage();
		//�ư��ʼx����Ϊ�����
		x = (int) (Math.random()*(GameFrame.WIDTH-banImg.getWidth(null)));
		y = GameFrame.HEIGHT;
		//���������Ϊ0ʱ�����ư�ͼƬ1
		//���������Ϊ1ʱ�����ư�ͼƬ2
		if(i==0){banImg=banImgs[0];}
		if(i==1){banImg=banImgs[1];}
	}
	//����
	public void move(){
			y-=speedy;		
	}
}

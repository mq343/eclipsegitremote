package com.VL;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Qiu {
	//����
	int x,y;
	int speedx=20;	//���ú����ƶ��ٶȣ�ÿ��һ�ΰ�����
	int g = 1;		//ģ���������ٶ�
	int time = 0;	//�˶�ʱ��
	int speedy;		//�����ٶ�
	int score=0;	//����
	int life = 3;	//��ʼΪ������
	static Image qiuImg;
	static{
		qiuImg = new ImageIcon("gaming/cute.png").getImage();
	}
	//����
	public Qiu(){
		x = (int) (Math.random()*(GameFrame.WIDTH-qiuImg.getWidth(null))/2);
		y = 200;
		
	}
	//����
	//�ƶ�
	public void move(){
		//ʵ�ַ������˶�
		time++;
		speedy=g*time/5;
		y+=speedy;
	}
}

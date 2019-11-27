package cn.tedu10;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Boss {
int x=0,y=0;
int state=0;
int life=100;
/*
 * 最近老是在想应该怎样定义自己的人生
 * 应该以什么为乐，以什么为悲
 * 以什么为价值，以什么为垃圾
 */

static Image[] bosssImgs = new Image[2];//出现时的图片
static Image bossImg=new ImageIcon("Img/bosss0.PNG").getImage();//出现时的图片
static Image[] bossImgs = new Image[2];
static{
	bosssImgs[0]=new ImageIcon("Img/bosss0.PNG").getImage();
	bossImgs[0]=new ImageIcon("Img/boss0.png").getImage();
	bosssImgs[1]=new ImageIcon("Img/bosss1.png").getImage();
	bossImgs[1]=new ImageIcon("Img/boss1.png").getImage();
}
public Boss(){
	x=PlaneFrame.WIDTH/2-bossImg.getWidth(null)+40;
	y=PlaneFrame.HEIGHT-bossImg.getHeight(null);
}
int index1=0;
public void step1() {

	bossImg = bosssImgs[index1 % 2];
	index1++;
}

int index2=0;
public void step2() {


	bossImg = bossImgs[index2 % 2];
	index2++;
}
}

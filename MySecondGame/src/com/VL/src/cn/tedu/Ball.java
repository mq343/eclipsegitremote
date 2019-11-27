package cn.tedu;

import java.awt.Color;

/*
 * 球类型
 */
public class Ball {
	//球属性
    int x,y;                 //坐标
    int length;            //直径
	public  int state;                        //状态
	int speed;                    //速度
    Color c;                       //球颜色
	
	//构造方法（函数）
	public Ball() {
		//构造方法：对即将创建的对象进行初始化
		x=(int)(Math.random()*800);
		y=(int)(Math.random()*600);
		length=(int)(Math.random()*50)+10;//产生随机小球的位置坐标，直径，并让直径不等于0
		state = (int)(Math.random()*4);
		speed = (int)(Math.random()*4+1);
		c = new Color((int)(Math.random()*256),
				      (int)(Math.random()*256),
				      (int)(Math.random()*256));
		
		
	}
	public void move() {
		//根据状态改变目标
	
		if(state==0) {x+=speed;y-=speed;}
		if(state==1) {x+=speed;y+=speed;}
		if(state==2) {x-=speed;y+=speed;}
		if(state==3) {x-=speed;y-=speed;}
		//碰到墙的处理
		//碰到右边墙
		if(x+length+20>BallFrame.WIDTH) {
			if(state==0) {state=3;}
			if(state==1) {state=2;}
			
		}
//		碰到左边界
		if(x<0) {
			if(state==3) {state=0;}
			if(state==2) {state=1;}
		}
//		碰到上边界
		if(y<0) {
			if(state==0) {state=1;}
			if(state==3) {state=2;}
		}
//		碰到下边界
		if(y+length+25>BallFrame.HEIGHT) {
			if(state==1) {state=0;}
			if(state==2) {state=3;}
			
		}
     }
}

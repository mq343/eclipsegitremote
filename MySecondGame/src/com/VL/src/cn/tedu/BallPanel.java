package cn.tedu;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

/*
 * 面板类
 */
public class BallPanel extends JPanel implements MouseMotionListener {
	//属性
	
	Ball [] balls = new Ball[10];//声明一个数组并分配长度为5，而且这个数组只能用于储存Ball的对象
	//构造方法
	int dx=250,dy=100,dwidth=300,dheight=300;
	public BallPanel() {
		//对于ball数组进行初始化，也就是创建5个球放到数组的每一个位置上
		for(int i=0;i<balls.length;i++) 
			balls[i] = new Ball();
			addMouseMotionListener(this);
			
		
		
	}
	public void paint(Graphics g) {
		super.paint(g);//调用父类的方法
		g.fillRect(dx, dy, dwidth, dheight);
	//	g.setColor(Color.BLACK);
		//画出数组中所有的球
		for (int i=0;i<balls.length;i++) {
			//设置画笔颜色
			g.setColor(balls[i].c);
			//画出球
			g.fillOval(balls[i].x,balls[i].y,balls[i].length,balls[i].length );
		}
		
		
	}
	public void Action() {
		
		Timer timer=new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO 自动生成的方法存根
				for(int i=0;i<balls.length;i++)
					balls[i].move();
				//上面撞
				for(int i=0;i<balls.length;i++){
					if(balls[i].x+balls[i].length/2<dx+dwidth&&balls[i].x+balls[i].length/2>dx&&balls[i].y+balls[i].length>dy&&balls[i].y+balls[i].length<dy+dheight){
						if(balls[i].state==1) {balls[i].state=0;}
						if(balls[i].state==2) {balls[i].state=3;}
						balls[i].speed+=1;
						
						dwidth--;
					}
				}
				//下面撞
				for(int i=0;i<balls.length;i++){
					if(balls[i].x<dx+dwidth&&balls[i].x+balls[i].length/2>dx&&balls[i].y>dy&&balls[i].y<dy+dheight){
						if(balls[i].state==0) {balls[i].state=1;}
						if(balls[i].state==3) {balls[i].state=2;}
						balls[i].speed+=1;
						dheight--;
					}
				}
				repaint();
				
			}
		}, 5, 10);
		
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO 自动生成的方法存根
		 dx=e.getX()-dwidth/2;
		if(dx<0){dx=0;}
		if(dx>BallFrame.WIDTH-dwidth){dx=BallFrame.WIDTH-dwidth;}
		
	}
	

}

package com.VL;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements KeyListener{
	//属性
	
	//创建豆子集合
	ArrayList<Qiu> qius = new ArrayList<Qiu>();
	//创建云板集合
	ArrayList<Ban> bans = new ArrayList<Ban>();
	//创建buff集合
	ArrayList<Buff> buffs= new ArrayList<Buff>();
	
	Qiu qiu = new Qiu();
	
	Image bgImg1;   //背景图片  锯齿
	Image bgImg2;   //背景运行图片
	Image bgImg3;	//开始界面豆子图
	Image bgImg4;	//开始界面背景
	Image stopBg;	//暂停界面背景
	Image endBg;	//游戏结束界面背景
	Image winImg;	//游戏胜出界面背景
	Image titImg;	//开始界面标题
	Image sttsImg;	//开始界面提示
	
	int backx1=0;	//锯齿背景横坐标
	int backy1=-5;	//锯齿背景纵坐标
	int backx2=0;	//锯齿背景横坐标2（为实现锯齿滚动显示效果）
	int backy2=0;	//锯齿背景纵坐标2（为实现锯齿滚动显示效果）
	int time=300;	//设置豆子出现倒计时（防止立即出现操作者反应不来）
	
	int state = START;						//设置游戏初始状态
	public static final int START = 0;		//开始界面
    public static final int RUNNING = 1;	//运行（游戏正式开始）  
    public static final int PAUSE = 2;  	//暂停
    public static final int GAME_OVER = 3;	//游戏结束
    public static final int WIN = 4;		//游戏胜出
    
    //构造
	public GamePanel(){
		//给个图片变量赋地址
		bgImg1 = new ImageIcon("gaming/jvchi.png").getImage();
		bgImg2 = new ImageIcon("gaming/1.jpg").getImage();
		bgImg3 = new ImageIcon("gaming/start.png").getImage();
		bgImg4 = new ImageIcon("gaming/sbg.png").getImage();
		stopBg = new ImageIcon("gaming/stop.png").getImage();
		endBg = new ImageIcon("gaming/end.png").getImage();
		winImg = new ImageIcon("gaming/levelup.png").getImage();
		titImg = new ImageIcon("gaming/title.png").getImage();
		sttsImg = new ImageIcon("gaming/startts.png").getImage();
		if(state==START){
			//进入游戏后初始为开始状态
			//播放背景音乐1
			Music.bg1.loop();
		}
	}
	
	//方法
	
	//根据不同状态绘制不同画面
	public void paint(Graphics g){
		super.paint(g);
		g.setFont(new Font("微软雅黑",Font.BOLD,50));
		if(state==START){
			//当状态为START时  画出开始界面各元素
			g.drawImage(bgImg4, 0, 0, null);
			g.drawImage(bgImg3, 155, 280, null);
			g.drawImage(titImg, 20, 40, 500, 230, null);
			g.drawImage(sttsImg, 20, 750, null);
		}
		else if(state==RUNNING){
			//当状态切换为RUNNING时  画出运行背景  滚动锯齿  豆子  云朵等元素
			g.drawImage(bgImg2, backx2, backy2, null);
			qiuPaint(g);
			banPaint(g);
			buffPaint(g);
			xinPaint(g);
			shedingPaint(g);
			g.drawImage(bgImg1, backx1, backy1, null);						//使锯齿图可以循环显示
			g.drawImage(bgImg1, backx1-GameFrame.WIDTH+10, backy1, null);	//第二个锯齿图备用
		}
		else if(state==PAUSE){
			//当状态切换为暂停时  显示暂停界面
			this.setBackground(Color.pink);
			g.drawImage(stopBg, 40, 300, 500, 500, null);
			g.drawString("歇一歇吧 @…@", 100, 250);
		}
		else if(state==GAME_OVER){
			//当三条命用完时切换到gameover状态  画出结束页面
			this.setBackground(Color.yellow);
			g.drawImage(endBg, 40, 300, 500, 500, null);
			g.drawString("  你输了", 170, 200);
			g.drawString("再来一把吗", 170, 270);
		}
		else if(state==WIN){
			//当分数达到预设值时  切换至WIN状态  画出胜利页面  并播放胜利语音
			this.setBackground(Color.PINK);
			g.setColor(Color.CYAN);
			g.drawImage(winImg, 0, 200, null);
			g.drawString("你赢了", 180, 120);
			g.drawString("R键重新玩哟", 130, 200);
		}
	}
	
	//游戏内各属性
	public void shedingPaint(Graphics g){
		//画出各项游戏设定  如分数关卡之类
		g.setColor(Color.PINK);
		g.setFont(new Font ("微软雅黑",Font.BOLD,25));
		g.drawString("分数:"+qiu.score, 40, 60);
		g.drawString("关卡:"+(qiu.score/30+1), 420, 60);
	}
	
	//action方法
	public void action(){
		//设置定时器
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask(){
			public void run(){
				//只有当状态为RUNNING的时候  
				//run方法才运行
				if(state==RUNNING){
					//锯齿滚动
					backx1++;
					//当第一张锯齿图移动到屏幕以外时  为其横坐标赋初值实现滚动
					if(backx1==540){backx1-=GameFrame.WIDTH+10;}
					banAction();	//生成云朵挡板
					qiuAction();	//生成豆子
					buffAction();	//生成豆包
					banMove();		//云朵挡板运动
					buffMove();		//豆包移动
					touch();		//判断豆子和云朵是否接触
					outOfBounds();  //越界处理
				}
				repaint();			//刷新显示
			}
		}, 0, 20);
	}
	
	//生成云板
	int banIndex = 0;
	public void banAction(){
		banIndex++;
		//设置固定间隔生成一块云朵挡板
		//且云朵挡板通过传值至挡板类进行不同状态的切换
		if(banIndex%400==0){
			//传0值生成挡板1
			Ban b = new Ban(0);
			bans.add(b);
		}
		if(banIndex%400==200){
			//传1值生成挡板2
			Ban b = new Ban(1);
			bans.add(b);
		}
		if(banIndex==Integer.MAX_VALUE){
			//循环计数
			banIndex=0;
		}
	}
	
	//生成豆子
	public void qiuAction(){
		//倒计时变量
		time--;
		//当计时变量为0 且豆子生命值大于0且豆子集合大小为0（同一屏幕内只有一个豆子）生成豆子
		if(time<=0&&qiu.life>0&&qius.size()==0){
			qius.add(new Qiu());
		}
	}
	
	//生成豆包
	int buffIndex = 0;
	public void buffAction(){
		buffIndex++;
		if(buffIndex%500==0){
			Buff b = new Buff();
			buffs.add(b);
		}
	}
	
	//云板的运动
 	public void banMove(){
		//对每一个云板都向上运动
		for(int i = 0;i<bans.size();i++){
			Ban b = bans.get(i);
			b.move();
		}
	}
	
 	//豆包运动
 	public void buffMove(){
 		for(int i=0;i<buffs.size();i++){
 			Buff b = buffs.get(i);
 			//当豆包碰到左右边界时  改变横向方向
 			if((b.x+b.doubao.getWidth(null))>GameFrame.WIDTH||b.x<0){
 				b.speedx=-b.speedx;
 			}
 			b.move();
 		}
 	}
 	
	//画豆子
	public void qiuPaint(Graphics g){
		for(int i=0;i<qius.size();i++){
			Qiu q = qius.get(i);
			g.drawImage(q.qiuImg, q.x, q.y, null);
			//豆子向下运动
			q.move();
		}
	}
	
	//画云板
	public void banPaint(Graphics g){
		for(int i = 0;i<bans.size();i++){
			Ban b = bans.get(i);
			g.drawImage(b.banImg, b.x, b.y, null);
		}
	}
	
	//画豆包
	public void buffPaint(Graphics g){
		for(int i = 0; i<buffs.size();i++){
			Buff b = buffs.get(i);
			g.drawImage(b.doubao, b.x, b.y, null);
		}
	}
	
	//画出代表生命的爱心
	//上限为6颗
	public void xinPaint(Graphics g){
		if(qiu.life==1){
			g.drawImage(Xin.heartImg, 40, 900, null);
		}
		if(qiu.life==2){
			g.drawImage(Xin.heartImg, 40, 900, null);
			g.drawImage(Xin.heartImg, 120, 900, null);
		}
		if(qiu.life==3){
			g.drawImage(Xin.heartImg, 40, 900, null);
			g.drawImage(Xin.heartImg, 120, 900, null);
			g.drawImage(Xin.heartImg, 200, 900, null);
		}
		if(qiu.life==4){
			g.drawImage(Xin.heartImg, 40, 900, null);
			g.drawImage(Xin.heartImg, 120, 900, null);
			g.drawImage(Xin.heartImg, 200, 900, null);
			g.drawImage(Xin.heartImg, 280, 900, null);
		}
		if(qiu.life==5){
			g.drawImage(Xin.heartImg, 40, 900, null);
			g.drawImage(Xin.heartImg, 120, 900, null);
			g.drawImage(Xin.heartImg, 200, 900, null);
			g.drawImage(Xin.heartImg, 280, 900, null);
			g.drawImage(Xin.heartImg, 360, 900, null);
		}
		if(qiu.life==6){
			g.drawImage(Xin.heartImg, 40, 900, null);
			g.drawImage(Xin.heartImg, 120, 900, null);
			g.drawImage(Xin.heartImg, 200, 900, null);
			g.drawImage(Xin.heartImg, 280, 900, null);
			g.drawImage(Xin.heartImg, 360, 900, null);
			g.drawImage(Xin.heartImg, 440, 900, null);
		}
	}
	
	//越界的处理
	public void outOfBounds(){
		//云板出上边界后删除
		for(int i = 0;i<bans.size();i++){
			Ban b = bans.get(i);
			if(b.y<0-b.banImg.getHeight(null)){
				bans.remove(i);
			}
		}
		for(int i = 0;i<qius.size();i++){
			Qiu q = qius.get(i);
			//当豆子碰到锯齿或者掉出屏幕后移除集合元素
			if(q.y>GameFrame.HEIGHT||q.y<-30){
				qius.remove(i);
				//设置豆子下一次出现的时间
				time=200;
				//生命值减1
				qiu.life--;
				//播放扣心背景乐
				if(qiu.life>0){
					Music.bg4.play();}
				//当生命值为零时  切换到游戏结束状态并播放结束音乐
				if(qiu.life == 0){
					state=GAME_OVER;
					Music.bg7.play();
					//初始化生命为3  为重新开始做准备
					qiu.life=3;
				}
			}
		}
		//遍历豆包
		for(int i = 0;i<buffs.size();i++){
			Buff b = buffs.get(i);
			//超出屏幕范围时移除集合内该元素
			if(b.y<0-b.doubao.getHeight(null)){
				buffs.remove(i);
			}
		}
	}
	
	//豆子和云板触碰判断方法
	public void touch(){
		//豆子左边坐标  右边坐标  下边界坐标
		int cx1,cx2,cy1,cy2;
		//云板上下左右坐标
		int bx1,bx2,by1,by2;
		int dx,dy;
		for(int j = 0;j<qius.size();j++){
			//遍历豆子（只有一个）
			Qiu c = qius.get(j);
			//赋豆子坐标
			//为游戏体验更好  我们并不以图片的边界作为坐标
			//而是以豆子左右脚边缘作为左右坐标
			cx1=c.x+30;
			cx2=c.x+c.qiuImg.getWidth(null)-30;
			cy1=c.y;
			cy2=c.y+c.qiuImg.getHeight(null);
			for(int i = 0;i<bans.size();i++){
				//遍历云板
				Ban b = bans.get(i);
				//赋云板坐标
				bx1=b.x;
				bx2=b.x+b.banImg.getWidth(null);
				by1=b.y;
				by2=b.y+b.banImg.getHeight(null);
				//判断  当豆子左右脚在云板上时  豆子跟随云板上移
				if(cx1>bx1-c.qiuImg.getWidth(null)+50&&cx1<bx2&&cy2>=by1+15&&cy2<=by2-50){
					//做出豆子陷在云板里的效果  体现云板柔软  增加真实性
					c.y=b.y-c.qiuImg.getHeight(null)+15;
					//当豆子碰到云停下时  让时间为零  
					//离开云朵时重复类自由落体运动
					c.time=0;
					//初始化豆子触碰的计时器（如果不加入一个变量辅助会一直计分）
					b.touch+=1;
					//计分  播放音效
					if(b.touch==1){
						qiu.score+=5;
						Music.bg5.play();
					}
					//当分数达到预设值时   云朵加速
					if(qiu.score>=30){
						b.speedy=3;
					}
					//当分数达到预设值时   云朵加速
					else if(qiu.score>=60){
						b.speedy=4;
					}
					//当分数达到预设值时  胜利
					//初始化分数和生命  为重新开始做准备
					if(qiu.score>=100){
						state=WIN;
						qiu.life=3;
						qiu.score=0;
						//胜利配乐
						Music.bg3.play();
					}
				}
			}
			//遍历豆包
			for(int k = 0;k<buffs.size();k++){
				Buff d = buffs.get(k);
				//获取豆包中心点坐标
				dx=d.x+d.doubao.getWidth(null)/2;
				dy=d.y+d.doubao.getHeight(null)/2;
				//当中心点进入豆子范围内  生命小于六时加生命
				//生命大于6时加分
				if(dx>cx1&&dx<cx2&&dy>cy1&&dy<cy2){
					//吃豆包背景音乐
					Music.bg6.play();
					if(qiu.life<6){
						buffs.remove(k);
						qiu.life++;
					}
					else{
						buffs.remove(k);
						qiu.life=6;
						qiu.score+=10;	
					}
				}
			}
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO 自动生成的方法存根
		//状态的切换
		//空格键功能
		if(e.getKeyCode()==KeyEvent.VK_SPACE){
			//START或者PAUSE状态，单击才会改改为RUNNING状态  
			if(state == START || state == PAUSE){ 	
                state = RUNNING;
                //停止开始界面背景乐
                Music.bg1.stop();
                //播放RUNNING背景乐
                Music.bg2.loop();
            }
			else if(state == RUNNING){
				//游戏点击暂停 
				state = PAUSE;  
			}
		}
		//R键控制重新开始
		if(e.getKeyCode()==KeyEvent.VK_R){
			  if(state == GAME_OVER||state==WIN){
				  state = START;
			  }
		}
		//键盘监听实现人物运动
		for(int i=0;i<qius.size();i++){
			//生成豆子
			Qiu q = qius.get(i);
			//控制豆子
			if(e.getKeyCode()==KeyEvent.VK_A){
				q.x-=q.speedx;
				if(q.x<0){q.x=0;}
			}
			else if(e.getKeyCode()==KeyEvent.VK_D){
				q.x+=q.speedx;
				if(q.x+q.qiuImg.getWidth(null)>GameFrame.WIDTH){
					q.x=GameFrame.WIDTH-q.qiuImg.getWidth(null);
				}
			}
		}	
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO 自动生成的方法存根
		
	}
}

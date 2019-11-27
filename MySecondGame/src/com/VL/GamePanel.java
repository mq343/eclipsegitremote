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
	//����
	
	//�������Ӽ���
	ArrayList<Qiu> qius = new ArrayList<Qiu>();
	//�����ư弯��
	ArrayList<Ban> bans = new ArrayList<Ban>();
	//����buff����
	ArrayList<Buff> buffs= new ArrayList<Buff>();
	
	Qiu qiu = new Qiu();
	
	Image bgImg1;   //����ͼƬ  ���
	Image bgImg2;   //��������ͼƬ
	Image bgImg3;	//��ʼ���涹��ͼ
	Image bgImg4;	//��ʼ���汳��
	Image stopBg;	//��ͣ���汳��
	Image endBg;	//��Ϸ�������汳��
	Image winImg;	//��Ϸʤ�����汳��
	Image titImg;	//��ʼ�������
	Image sttsImg;	//��ʼ������ʾ
	
	int backx1=0;	//��ݱ���������
	int backy1=-5;	//��ݱ���������
	int backx2=0;	//��ݱ���������2��Ϊʵ�־�ݹ�����ʾЧ����
	int backy2=0;	//��ݱ���������2��Ϊʵ�־�ݹ�����ʾЧ����
	int time=300;	//���ö��ӳ��ֵ���ʱ����ֹ�������ֲ����߷�Ӧ������
	
	int state = START;						//������Ϸ��ʼ״̬
	public static final int START = 0;		//��ʼ����
    public static final int RUNNING = 1;	//���У���Ϸ��ʽ��ʼ��  
    public static final int PAUSE = 2;  	//��ͣ
    public static final int GAME_OVER = 3;	//��Ϸ����
    public static final int WIN = 4;		//��Ϸʤ��
    
    //����
	public GamePanel(){
		//����ͼƬ��������ַ
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
			//������Ϸ���ʼΪ��ʼ״̬
			//���ű�������1
			Music.bg1.loop();
		}
	}
	
	//����
	
	//���ݲ�ͬ״̬���Ʋ�ͬ����
	public void paint(Graphics g){
		super.paint(g);
		g.setFont(new Font("΢���ź�",Font.BOLD,50));
		if(state==START){
			//��״̬ΪSTARTʱ  ������ʼ�����Ԫ��
			g.drawImage(bgImg4, 0, 0, null);
			g.drawImage(bgImg3, 155, 280, null);
			g.drawImage(titImg, 20, 40, 500, 230, null);
			g.drawImage(sttsImg, 20, 750, null);
		}
		else if(state==RUNNING){
			//��״̬�л�ΪRUNNINGʱ  �������б���  �������  ����  �ƶ��Ԫ��
			g.drawImage(bgImg2, backx2, backy2, null);
			qiuPaint(g);
			banPaint(g);
			buffPaint(g);
			xinPaint(g);
			shedingPaint(g);
			g.drawImage(bgImg1, backx1, backy1, null);						//ʹ���ͼ����ѭ����ʾ
			g.drawImage(bgImg1, backx1-GameFrame.WIDTH+10, backy1, null);	//�ڶ������ͼ����
		}
		else if(state==PAUSE){
			//��״̬�л�Ϊ��ͣʱ  ��ʾ��ͣ����
			this.setBackground(Color.pink);
			g.drawImage(stopBg, 40, 300, 500, 500, null);
			g.drawString("ЪһЪ�� @��@", 100, 250);
		}
		else if(state==GAME_OVER){
			//������������ʱ�л���gameover״̬  ��������ҳ��
			this.setBackground(Color.yellow);
			g.drawImage(endBg, 40, 300, 500, 500, null);
			g.drawString("  ������", 170, 200);
			g.drawString("����һ����", 170, 270);
		}
		else if(state==WIN){
			//�������ﵽԤ��ֵʱ  �л���WIN״̬  ����ʤ��ҳ��  ������ʤ������
			this.setBackground(Color.PINK);
			g.setColor(Color.CYAN);
			g.drawImage(winImg, 0, 200, null);
			g.drawString("��Ӯ��", 180, 120);
			g.drawString("R��������Ӵ", 130, 200);
		}
	}
	
	//��Ϸ�ڸ�����
	public void shedingPaint(Graphics g){
		//����������Ϸ�趨  ������ؿ�֮��
		g.setColor(Color.PINK);
		g.setFont(new Font ("΢���ź�",Font.BOLD,25));
		g.drawString("����:"+qiu.score, 40, 60);
		g.drawString("�ؿ�:"+(qiu.score/30+1), 420, 60);
	}
	
	//action����
	public void action(){
		//���ö�ʱ��
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask(){
			public void run(){
				//ֻ�е�״̬ΪRUNNING��ʱ��  
				//run����������
				if(state==RUNNING){
					//��ݹ���
					backx1++;
					//����һ�ž��ͼ�ƶ�����Ļ����ʱ  Ϊ������긳��ֵʵ�ֹ���
					if(backx1==540){backx1-=GameFrame.WIDTH+10;}
					banAction();	//�����ƶ䵲��
					qiuAction();	//���ɶ���
					buffAction();	//���ɶ���
					banMove();		//�ƶ䵲���˶�
					buffMove();		//�����ƶ�
					touch();		//�ж϶��Ӻ��ƶ��Ƿ�Ӵ�
					outOfBounds();  //Խ�紦��
				}
				repaint();			//ˢ����ʾ
			}
		}, 0, 20);
	}
	
	//�����ư�
	int banIndex = 0;
	public void banAction(){
		banIndex++;
		//���ù̶��������һ���ƶ䵲��
		//���ƶ䵲��ͨ����ֵ����������в�ͬ״̬���л�
		if(banIndex%400==0){
			//��0ֵ���ɵ���1
			Ban b = new Ban(0);
			bans.add(b);
		}
		if(banIndex%400==200){
			//��1ֵ���ɵ���2
			Ban b = new Ban(1);
			bans.add(b);
		}
		if(banIndex==Integer.MAX_VALUE){
			//ѭ������
			banIndex=0;
		}
	}
	
	//���ɶ���
	public void qiuAction(){
		//����ʱ����
		time--;
		//����ʱ����Ϊ0 �Ҷ�������ֵ����0�Ҷ��Ӽ��ϴ�СΪ0��ͬһ��Ļ��ֻ��һ�����ӣ����ɶ���
		if(time<=0&&qiu.life>0&&qius.size()==0){
			qius.add(new Qiu());
		}
	}
	
	//���ɶ���
	int buffIndex = 0;
	public void buffAction(){
		buffIndex++;
		if(buffIndex%500==0){
			Buff b = new Buff();
			buffs.add(b);
		}
	}
	
	//�ư���˶�
 	public void banMove(){
		//��ÿһ���ư嶼�����˶�
		for(int i = 0;i<bans.size();i++){
			Ban b = bans.get(i);
			b.move();
		}
	}
	
 	//�����˶�
 	public void buffMove(){
 		for(int i=0;i<buffs.size();i++){
 			Buff b = buffs.get(i);
 			//�������������ұ߽�ʱ  �ı������
 			if((b.x+b.doubao.getWidth(null))>GameFrame.WIDTH||b.x<0){
 				b.speedx=-b.speedx;
 			}
 			b.move();
 		}
 	}
 	
	//������
	public void qiuPaint(Graphics g){
		for(int i=0;i<qius.size();i++){
			Qiu q = qius.get(i);
			g.drawImage(q.qiuImg, q.x, q.y, null);
			//���������˶�
			q.move();
		}
	}
	
	//���ư�
	public void banPaint(Graphics g){
		for(int i = 0;i<bans.size();i++){
			Ban b = bans.get(i);
			g.drawImage(b.banImg, b.x, b.y, null);
		}
	}
	
	//������
	public void buffPaint(Graphics g){
		for(int i = 0; i<buffs.size();i++){
			Buff b = buffs.get(i);
			g.drawImage(b.doubao, b.x, b.y, null);
		}
	}
	
	//�������������İ���
	//����Ϊ6��
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
	
	//Խ��Ĵ���
	public void outOfBounds(){
		//�ư���ϱ߽��ɾ��
		for(int i = 0;i<bans.size();i++){
			Ban b = bans.get(i);
			if(b.y<0-b.banImg.getHeight(null)){
				bans.remove(i);
			}
		}
		for(int i = 0;i<qius.size();i++){
			Qiu q = qius.get(i);
			//������������ݻ��ߵ�����Ļ���Ƴ�����Ԫ��
			if(q.y>GameFrame.HEIGHT||q.y<-30){
				qius.remove(i);
				//���ö�����һ�γ��ֵ�ʱ��
				time=200;
				//����ֵ��1
				qiu.life--;
				//���ſ��ı�����
				if(qiu.life>0){
					Music.bg4.play();}
				//������ֵΪ��ʱ  �л�����Ϸ����״̬�����Ž�������
				if(qiu.life == 0){
					state=GAME_OVER;
					Music.bg7.play();
					//��ʼ������Ϊ3  Ϊ���¿�ʼ��׼��
					qiu.life=3;
				}
			}
		}
		//��������
		for(int i = 0;i<buffs.size();i++){
			Buff b = buffs.get(i);
			//������Ļ��Χʱ�Ƴ������ڸ�Ԫ��
			if(b.y<0-b.doubao.getHeight(null)){
				buffs.remove(i);
			}
		}
	}
	
	//���Ӻ��ư崥���жϷ���
	public void touch(){
		//�����������  �ұ�����  �±߽�����
		int cx1,cx2,cy1,cy2;
		//�ư�������������
		int bx1,bx2,by1,by2;
		int dx,dy;
		for(int j = 0;j<qius.size();j++){
			//�������ӣ�ֻ��һ����
			Qiu c = qius.get(j);
			//����������
			//Ϊ��Ϸ�������  ���ǲ�����ͼƬ�ı߽���Ϊ����
			//�����Զ������ҽű�Ե��Ϊ��������
			cx1=c.x+30;
			cx2=c.x+c.qiuImg.getWidth(null)-30;
			cy1=c.y;
			cy2=c.y+c.qiuImg.getHeight(null);
			for(int i = 0;i<bans.size();i++){
				//�����ư�
				Ban b = bans.get(i);
				//���ư�����
				bx1=b.x;
				bx2=b.x+b.banImg.getWidth(null);
				by1=b.y;
				by2=b.y+b.banImg.getHeight(null);
				//�ж�  ���������ҽ����ư���ʱ  ���Ӹ����ư�����
				if(cx1>bx1-c.qiuImg.getWidth(null)+50&&cx1<bx2&&cy2>=by1+15&&cy2<=by2-50){
					//�������������ư����Ч��  �����ư�����  ������ʵ��
					c.y=b.y-c.qiuImg.getHeight(null)+15;
					//������������ͣ��ʱ  ��ʱ��Ϊ��  
					//�뿪�ƶ�ʱ�ظ������������˶�
					c.time=0;
					//��ʼ�����Ӵ����ļ�ʱ�������������һ������������һֱ�Ʒ֣�
					b.touch+=1;
					//�Ʒ�  ������Ч
					if(b.touch==1){
						qiu.score+=5;
						Music.bg5.play();
					}
					//�������ﵽԤ��ֵʱ   �ƶ����
					if(qiu.score>=30){
						b.speedy=3;
					}
					//�������ﵽԤ��ֵʱ   �ƶ����
					else if(qiu.score>=60){
						b.speedy=4;
					}
					//�������ﵽԤ��ֵʱ  ʤ��
					//��ʼ������������  Ϊ���¿�ʼ��׼��
					if(qiu.score>=100){
						state=WIN;
						qiu.life=3;
						qiu.score=0;
						//ʤ������
						Music.bg3.play();
					}
				}
			}
			//��������
			for(int k = 0;k<buffs.size();k++){
				Buff d = buffs.get(k);
				//��ȡ�������ĵ�����
				dx=d.x+d.doubao.getWidth(null)/2;
				dy=d.y+d.doubao.getHeight(null)/2;
				//�����ĵ���붹�ӷ�Χ��  ����С����ʱ������
				//��������6ʱ�ӷ�
				if(dx>cx1&&dx<cx2&&dy>cy1&&dy<cy2){
					//�Զ�����������
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
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO �Զ����ɵķ������
		//״̬���л�
		//�ո������
		if(e.getKeyCode()==KeyEvent.VK_SPACE){
			//START����PAUSE״̬�������Ż�ĸ�ΪRUNNING״̬  
			if(state == START || state == PAUSE){ 	
                state = RUNNING;
                //ֹͣ��ʼ���汳����
                Music.bg1.stop();
                //����RUNNING������
                Music.bg2.loop();
            }
			else if(state == RUNNING){
				//��Ϸ�����ͣ 
				state = PAUSE;  
			}
		}
		//R���������¿�ʼ
		if(e.getKeyCode()==KeyEvent.VK_R){
			  if(state == GAME_OVER||state==WIN){
				  state = START;
			  }
		}
		//���̼���ʵ�������˶�
		for(int i=0;i<qius.size();i++){
			//���ɶ���
			Qiu q = qius.get(i);
			//���ƶ���
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
		// TODO �Զ����ɵķ������
		
	}
}

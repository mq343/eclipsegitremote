package cn.tedulastt;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cn.tedu10.Bullet;
import cn.tedu10.Star;
import cn.tedulastt.Enemy;
import cn.tedulastt.Town;

public class MyPanel extends JPanel implements MouseListener {
	ArrayList<Enemy> enemys = new ArrayList<Enemy>();
	ArrayList<Bu> bus1 = new ArrayList<Bu>();
	ArrayList<Bu> bus2 = new ArrayList<Bu>();
	ArrayList<Town> towns1 = new ArrayList<Town>();
	ArrayList<Town> towns2 = new ArrayList<Town>();
	public static int dongex=0,dongey=0,dongbx=0,dongby=0;
	int index3=0;
	int index1 = 0, index2 = 0;
	int index4=0;
	double speedx,speedy;
	int[] town1x = new int[100];
	int[] town1y = new int[100];
	int[] town2x = new int[100];
	int[] town2y = new int[100];
	Image bkImg = new ImageIcon("LastImg/bk.jpg").getImage();
	int mx, my;
	boolean Istown1 = false, Istown2 = false;
	boolean Isstack1 = false, Isstack2 = false;

	public MyPanel() {
		
		this.addMouseListener(this);

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(bkImg, 0, 0, null);
		g.drawImage(Town.town1, 0, 0, null);
		g.drawImage(Town.town2, 0, 250, null);
		if (bus1.size()>0) {
			for (int i = 0; i < bus1.size(); i++) {
				Bu b = bus1.get(i);
				g.drawImage(Bu.bulletImg, b.x, b.y, null);
			}
		}
		if (bus2.size()>0) {
			for (int i = 0; i < bus2.size(); i++) {
				Bu b = bus2.get(i);
				g.drawImage(Bu.bulletImg, b.x, b.y, null);
			}
		}
		
		if (!enemys.isEmpty()) {
			for (int i = 0; i < enemys.size(); i++) {
				Enemy e = enemys.get(i);
				g.drawImage(e.enemyImg, e.x, e.y, null);
			}
		}

		if (Isstack1) {
			for (int i = 0; i < town1x.length; i++) {
				if (town1x[i] != 0) {
					g.drawImage(Town.town1, town1x[i], town1y[i], null);
					if(index4++%100==0){
						Bu b=new Bu(town1x[i]+40, town1y[i]);
						bus1.add(b);
						//g.drawImage(Bu.bulletImg, town1x[i]+40, town1y[i], null);
						if(index4==Integer.MAX_VALUE)
							index4=0;
					}
					
				}
			}
		}
		if (Isstack2) {
			for (int i = 0; i < town2x.length; i++) {
				if (town2x[i] != 0) {
					g.drawImage(Town.town2, town2x[i], town2y[i], null);
					if(index4++%100==0){
					Bu b=new Bu(town2x[i]+40, town2y[i]);
					bus2.add(b);
					//g.drawImage(Bu.bulletImg, town2x[i]+40, town2y[i], null);
					if(index4==Integer.MAX_VALUE)
						index4=0;
				}
				}
			}
		}

	}

	public void action() {

		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {

				move();
				bomb();
				repaint();
				//塔抖动
				if (towns1.size() > 0) {
					for (int i = 0; i < towns1.size(); i++) {
						Town t = towns1.get(i);
						t.step();
					}
				}
				if (towns2.size() > 0) {
					for (int i = 0; i < towns2.size(); i++) {
						Town t = towns2.get(i);
						t.step();
					}
				}
				if (index1++ % 100 == 0) {
					Enemy e = new Enemy();
					enemys.add(e);
					if (index1 == Integer.MAX_VALUE)
						index1 = 0;
				}
				//子弹移动
				if (bus1.size()>0) {
					for (int i = 0; i < bus1.size(); i++) {
						Bu b = bus1.get(i);
						b.move();
					}
				}
//				if (bus2.size()>0) {
//					for (int i = 0; i < bus2.size(); i++) {
//						Bu b = bus2.get(i);
//						b.move();
//					}
//				}
				if (bus2.size()>0) {
					for (int i = 0; i < bus2.size(); i++) {
						Bu b = bus2.get(i);
						for(int j=0;j<enemys.size();j++){
							Enemy e=enemys.get(j);
							if(Math.abs(b.x-e.x)*Math.abs(b.x-e.x)+Math.abs(b.y-e.y)*Math.abs(b.y-e.y)<250000){
								dongex=e.x;
								dongey=e.y;
								dongbx=b.x;
								dongby=b.y;
								speedx=Math.abs(dongex-dongbx)/10;
								speedy=Math.abs(dongey-dongby)/10;
								b.x+=speedx;
								b.y+=speedy;
							}
					}
					
				}
				}
		}
		}, 0, 30);
	}

	public void move() {
		for (int i = 0; i < enemys.size(); i++) {
			Enemy e = enemys.get(i);
			if (e.state == 0) {
				e.enemyImg = Enemy.enemys[0];
				e.x += e.speed;
				if (Math.abs(e.x - 1100) < 20 && Math.abs(e.y - 850) < 30)
					e.state = 3;
				if (Math.abs(e.x - 1500) < 20 && Math.abs(e.y - 130) < 30)
					e.state = 1;
			}
			if (e.state == 1) {
				e.enemyImg = Enemy.enemys[1];
				e.y += e.speed;
			}
			if (e.state == 2) {
				e.enemyImg = Enemy.enemys[2];
				e.x -= e.speed;
				if (Math.abs(e.x - 300) < 20 && Math.abs(e.y - 660) < 30)
					e.state = 3;
			}
			if (e.state == 3) {
				e.enemyImg = Enemy.enemys[3];
				e.y -= e.speed;
				if (Math.abs(e.x - 1090) < 20 && Math.abs(e.y - 652) < 30)
					e.state = 2;
				if (Math.abs(e.x - 320) < 20 && Math.abs(e.y - 130) < 30)
					e.state = 0;
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO 自动生成的方法存根
		if (e.getButton() == MouseEvent.BUTTON1) {
			click(e.getX(), e.getY());
		}
		if (e.getButton() == MouseEvent.BUTTON3) {
			if (Istown1) {
				for (int i = 0; i < town1x.length; i++) {
					if (town1x[i] == 0) {
						town1x[i] = e.getX();
						town1y[i] = e.getY();
						Town t = new Town();
						towns1.add(t);
						//appBu(e.getX() + 50, e.getY());
						Isstack1 = true;
						Istown1 = false;
						break;
					}
				}

			}
			if (Istown2) {

				for (int i = 0; i < town1x.length; i++) {
					if (town2x[i] == 0) {
						town2x[i] = e.getX();
						town2y[i] = e.getY();
						Town t = new Town();
						towns2.add(t);
					//	appBu(e.getX() + 50, e.getY());
						Isstack2 = true;
						Istown2 = false;
						break;
					}
				}

			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO 自动生成的方法存根

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO 自动生成的方法存根

	}

	public void click(int x, int y) {
		if (Town.town1.getWidth(null) - x < 100 && Town.town1.getHeight(null) - y < 200) {
			Istown1 = true;
		}
		if (x < 100 && 450 - y < 200) {
			Istown2 = true;
		}

	}

	public int getx(int x) {
		return x;
	}
	public int gety(int x) {
		return x;
	}

	public void bomb() {
		for (int i = 0; i < bus1.size(); i++) {
			Bu e = bus1.get(i);
				for (int k = 0; k < enemys.size(); k++) {
					Enemy ee = enemys.get(k);
					if (e.x < ee.x + 40 && e.x > ee.x - 40 && e.y < ee.y + 40 && e.y > ee.y - 40) {
						enemys.remove(k);
						
						bus1.remove(i);
						break;
					}
				}
			}
		}
	

}

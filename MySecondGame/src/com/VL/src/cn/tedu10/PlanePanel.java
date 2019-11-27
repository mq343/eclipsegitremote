package cn.tedu10;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PlanePanel extends JPanel implements MouseMotionListener {
	/**
	 * 我在恶心的世界里
	 * 寻找一个像你的人
	 * 在每个想你的夏天里
	 * 等另一种感情
	 * 我在失败的生活里
	 * 寻找一个爱我的人
	 * 我的悲伤，浪漫和幻想不对她说起
	 * 我再也不会把自己
	 * 愚蠢的交给过去
	 * 我的生活和我的想法
	 * 从此相隔了万里
	 * 我整夜整夜的失眠
	 * 不是为了和谁再相见
	 * 曾经爱你的每一条街
	 * 是我新鲜生活的起点
	 * 我在陌生的感动里
	 * 寻找一个像你的人
	 * 就算过去一样被误解
	 * 不快乐又如何
	 * 我在干裂的冬天里
	 * 寻找一个平凡的人
	 * 她的善良，甜蜜和阳光陪伴我自己
	 * 我再也不会把自己彻底的交给一个人
	 * 我的理想就像这黑夜一分一秒的断裂
	 * 我一天一天的发呆
	 * 不是为了酝酿些什么
	 * 真情已经被他们毁灭
	 * 还有什么不能去拒绝
	 */
	Image bkImg;
	int time = 0;
	int time2 = 0;
	int time3 = 0;//boss下蛋
	int backX = 0, backY = 0;
	boolean app = false;
	Hero hero = new Hero();
	Boss boss;
	ArrayList<Enemy> enemys = new ArrayList<Enemy>();
	ArrayList<Star> stars = new ArrayList<Star>();
	ArrayList<Boss> bossArr = new ArrayList<Boss>();
	ArrayList<ArrayList<Bullet>> bullets = new ArrayList<ArrayList<Bullet>>();
	ArrayList<ArrayList<BossBullet>> bossBullets = new ArrayList<ArrayList<BossBullet>>();
	public PlanePanel() {
		bkImg = new ImageIcon("Img/background.jpg").getImage();
		addMouseMotionListener(this);
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(bkImg, backX, backY - 768, null);
		g.drawImage(bkImg, backX, backY, null);
		g.drawImage(Hero.heroImg, hero.x, hero.y, null);
		enemPaint(g);
		starPaint(g);
		bulletPaint(g);
		scorePaint(g);
		for (int i = 0; i < bossArr.size(); i++) {
			boss = bossArr.get(i);
			g.drawImage(boss.bossImg, boss.x, boss.y, null);
		}
		if (hero.score >= 50) {
			boosPaint(g);
			bossBulletPaint(g);
		}

	}

	public void action() {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				hero.step();
				backY += 5;
				if (backY > 768) {
					backY = 0;
				}
				enemy_starAction();
				enemyMove();
				start();
				outofBoubds();
				fire();
				bullets.add(hero.shoot());
				bomb();
				bulletMove();
				//boss出现
				if (hero.score <= 50 && hero.score >= 45) {
					boss = new Boss();
					app = true;
					if (bossArr.size() == 0)
						bossArr.add(boss);

				}
				if (app) {
					bossMove();
					//boss转向
					if (boss.y > 50)
						boss.step1();
					else {
						boss.step2();
						if (time++ % 10 == 0) {
							bossBullets.add(new BossBullet(boss.x + boss.bossImg.getWidth(null) / 2,
									boss.y + boss.bossImg.getHeight(null)).shoot());
							if (enemyIndex == Integer.MAX_VALUE) {
								enemyIndex = 0;
							}
						}
						for (int i = 0; i < bossBullets.size(); i++) {
							ArrayList<BossBullet> bb = bossBullets.get(i);
							for (int j = 0; j < bb.size(); j++) {
								BossBullet b = bb.get(j);
								b.move();
							}
						}
					}
				}
				for (int i = 0; i < enemys.size(); i++) {
					Enemy e = enemys.get(i);
					e.step();
				}
				for (int i = 0; i < stars.size(); i++) {
					Star e = stars.get(i);
					e.step();
				}
				repaint();

			}
		}, 0, 100);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO 自动生成的方法存根
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO 自动生成的方法存根
		hero.x = e.getX() - hero.heroImg.getWidth(null) / 2;
		hero.y = e.getY() - hero.heroImg.getHeight(null) / 2;
		if (hero.x < 0) {
			hero.x = 0;
		}
		if (hero.y < 0) {
			hero.y = 0;
		}
		if (hero.x + hero.heroImg.getWidth(null) > PlaneFrame.WIDTH - 10) {
			hero.x = PlaneFrame.WIDTH - hero.heroImg.getWidth(null) - 10;
		}
		if (hero.x + hero.heroImg.getHeight(null) > PlaneFrame.HEIGHT - 35) {
			hero.x = PlaneFrame.HEIGHT - hero.heroImg.getWidth(null) - 35;
		}

	}

	int enemyIndex = 0;

	public void enemy_starAction() {

		if (enemyIndex++ % 2 == 0) {
			Enemy e2 = new Enemy();
			enemys.add(e2);
		}
		if (enemyIndex++ % 5 == 0) {
			Star e1 = new Star();
			stars.add(e1);
		}
		if (enemyIndex == Integer.MAX_VALUE) {
			enemyIndex = 0;
		}
	}

	public void enemyMove() {
		for (int i = 0; i < enemys.size(); i++) {
			Enemy e = enemys.get(i);
			if (e.state == 0) {
				e.x += e.speed;
				e.y += e.speed;
			}
			if (e.state == 1) {
				e.x -= e.speed;
				e.y += e.speed;
			}
			if (e.state == 0 && e.x > PlaneFrame.WIDTH - 50) {
				e.state = 1;
			}
			if (e.state == 1 && e.x < 0) {
				e.state = 0;
			}
		}

	}

	public void bulletMove() {
		for (int i = 0; i < bullets.size(); i++) {
			ArrayList<Bullet> bb = bullets.get(i);
			for (int j = 0; j < bb.size(); j++) {
				Bullet b = bb.get(j);
				b.move();
			}

		}

	}

	public void start() {
		for (int i = 0; i < stars.size(); i++) {
			Star e = stars.get(i);
			if (e.state == 0) {
				e.x += e.speed;
				e.y += e.speed;
			}
			if (e.state == 1) {
				e.x -= e.speed;
				e.y += e.speed;
			}
			if (e.state == 0 && e.x > PlaneFrame.WIDTH - 50) {
				e.state = 1;
			}
			if (e.state == 1 && e.x < 0) {
				e.state = 0;
			}
		}
	}

	public void outofBoubds() {
		for (int i = 0; i < enemys.size(); i++) {
			Enemy e = enemys.get(i);
			if (e.y + e.enemyImg.getHeight(null) > PlaneFrame.HEIGHT) {
				enemys.remove(i);
			}

		}
		for (int i = 0; i < stars.size(); i++) {
			Star e = stars.get(i);
			if (e.y + e.starImg.getHeight(null) > PlaneFrame.HEIGHT) {
				stars.remove(i);
			}
		}
	}

	//火力调控
	public void fire() {

		for (int i = 0; i < stars.size(); i++) {
			Star e = stars.get(i);
			if (hero.x < e.x + 30 && hero.x > e.x - 30 && hero.y < e.y + 30 && hero.y > e.y - 30) {
				stars.remove(i);
				Hero.fire += 1;
				if (Hero.fire > 3) {
					hero.fire = 3;
				}

			}

		}

		if (Hero.fire == 2) {
			time++;
			if (time % 50 == 1) {
				Hero.fire = 1;
				if (enemyIndex == Integer.MAX_VALUE) {
					enemyIndex = 0;

				}

			}
		}
		if (Hero.fire == 3) {

			time2++;
			if (time2 % 50 == 1) {
				Hero.fire = 2;
				if (enemyIndex == Integer.MAX_VALUE) {
					enemyIndex = 0;

				}

			}

		}

	}

	//子弹撞到敌机
	public void bomb() {
		for (int i = 0; i < bullets.size(); i++) {
			ArrayList<Bullet> bb = bullets.get(i);
			for (int j = 0; j < bb.size(); j++) {
				Bullet e = bb.get(j);
				for (int k = 0; k < enemys.size(); k++) {
					Enemy ee = enemys.get(k);
					if (e.x < ee.x + 40 && e.x > ee.x - 40 && e.y < ee.y + 40 && e.y > ee.y - 40) {
						enemys.remove(k);
						hero.score++;
						bb.remove(j);
						break;
					}
				}
				//减少boss的生命值
				if (app) {
					if (e.x < boss.x + 100 && e.x > boss.x && e.y < boss.y + 100 && e.y > boss.y) {
						boss.life--;
					}

				}
			}
		}

		if (app && bossArr.size() == 1 && boss.life < 0) {
			bossArr.remove(0);
			bossBullets.removeAll(bossBullets);
		}

	}

	public void bossMove() {
		if (boss.y > 50) {
			boss.y -= 4;
		} else {
			if (boss.state == 0 && boss.x < 10) {
				boss.state = 1;
			}
			if (boss.state == 1 && boss.x > PlaneFrame.WIDTH - 340) {
				boss.state = 0;
			}
			if (boss.state == 0) {
				boss.x -= 3;
			}
			if (boss.state == 1) {
				boss.x += 3;
			}
		}

	}

	public void enemPaint(Graphics g) {
		for (int i = 0; i < enemys.size(); i++) {
			Enemy e = enemys.get(i);
			g.drawImage(e.enemyImg, e.x, e.y, null);
		}
	}

	public void starPaint(Graphics g) {
		for (int i = 0; i < stars.size(); i++) {
			Star e = stars.get(i);
			g.drawImage(e.starImg, e.x, e.y, null);
		}
	}

	public void bulletPaint(Graphics g) {

		for (int i = 0; i < bullets.size(); i++) {
			ArrayList<Bullet> bb = bullets.get(i);

			for (int j = 0; j < bb.size(); j++) {
				Bullet e = bb.get(j);
				g.drawImage(e.bulletImg, e.x, e.y - 20, null);
			}
		}
	}

	public void bossBulletPaint(Graphics g) {

		for (int i = 0; i < bossBullets.size(); i++) {
			ArrayList<BossBullet> bb = bossBullets.get(i);
			for (int j = 0; j < bb.size(); j++) {
				BossBullet e = bb.get(j);

				g.drawImage(e.bulletImg, e.x, e.y - 20, null);
			}
		}
	}

	public void scorePaint(Graphics g) {
		g.setColor(Color.RED);
		g.setFont(new Font("宋体", Font.BOLD, 30));
		g.drawString("得分" + hero.score, 350, 700);

	}

	public void boosPaint(Graphics g) {
		if(boss.life<0)
			g.drawString("生命值0" , 350, 30);
		else
			g.drawString("生命值" + boss.life, 350, 30);
	}
}

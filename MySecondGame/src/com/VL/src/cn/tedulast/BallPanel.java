package cn.tedulast;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

/*
 * 面板类
 */
public class BallPanel extends JPanel {
	Ball[] balls = new Ball[10];//声明一个数组并分配长度为5，而且这个数组只能用于储存Ball的对象
	Zhu[] zhus = new Zhu[3];
	int mx = 0, my = 0;
	int index = 0;
	boolean Isclick = false;

	public BallPanel() {
		zhus[0] = new Zhu(0, 900);
		zhus[1] = new Zhu(400, 900);
		zhus[2] = new Zhu(730, 900);
		for (int i = 0; i < balls.length; i++)
			balls[i] = new Ball();
		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				if (e.getButton() == MouseEvent.BUTTON1)
					;
				mx = e.getX();
				my = e.getY();
				Isclick = true;
			}
		});
	}

	public void paint(Graphics g) {
		super.paint(g);//调用父类的方法
		g.fillRect(zhus[1].x, zhus[1].y, zhus[1].width, zhus[1].height);
		g.fillRect(zhus[2].x, zhus[2].y, zhus[2].width, zhus[2].height);
		g.fillRect(zhus[0].x, zhus[0].y, zhus[0].width, zhus[0].height);
		for (int i = 0; i < balls.length; i++) {
			g.setColor(balls[i].c);
			g.fillOval(balls[i].x, balls[i].y, balls[i].length, balls[i].length);
		}

	}

	public void action() {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				// TODO 自动生成的方法存根
				if (index++ % 10 == 0) {
					for (int i = 0; i < 3; i++) {
						zhus[i].action();
					}
					if (index == Integer.MAX_VALUE) {
						index = 0;
					}
				}
				repaint();
				if (Isclick) {
					start();
					for (int i = 0; i < balls.length; i++) {
						balls[i].move();
					}

				}
			}
		}, 0, 10);
	}

	public boolean isStop() {
		for (int i = 0; i < 3; i++) {
			if (zhus[i].height > 500)
				return true;

		}
		return false;

	}

	public void start() {
		for (int i = 0; i < balls.length; i++) {
			if (mx - balls[1].x > 0) {
				balls[i].state = 1;
			} else {
				balls[i].state = 2;
			}
			balls[i].speedx = (int) ((Math.abs((int) mx - balls[i].x)) * Math.random()) / 50;
			balls[i].speedy = (int) ((Math.abs((int) my - balls[i].y)) * Math.random()) / 50;
		}

	}

}

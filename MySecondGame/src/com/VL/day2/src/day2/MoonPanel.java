package day2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public class MoonPanel extends JPanel implements Runnable {
	// 保存星星的x,y轴坐标
	private int[] xx;
	private int[] yy;
	// 黑色月亮的起始坐标
	private int x = 810;
	private int y = 170;
	public MoonPanel() {
		// 初始化x,y轴的数组
		xx = new int[300];
		yy = new int[300];
		// 随机数对象
		Random ran = new Random();
		// for (int i = 0; i < 300; i++) {
		for (int i = 0; i < xx.length; i++) {
			/*
			 * 生产一个范围在[0-1024]之内的随机整数， 赋值给XX[i]
			 */
			xx[i] = ran.nextInt(1024);
			/*
			 * 生产一个范围在[0-768]之内的随机整数， 赋值给yy[i]
			 */
			yy[i] = ran.nextInt(768);
		}
	}
	public void paint(Graphics g) {
		// 调用父类，初始化画板
		super.paint(g);
		this.setBackground(Color.BLACK);
		Font f = new Font("宋体", Font.BOLD, 12);
		g.setFont(f);
		g.setColor(Color.white);
		// 白色月亮
		g.fillOval(860, 120, 50, 50);
		// for (int i = 0; i < 300; i++) {
		for (int i = 0; i < xx.length; i++) {
			g.drawString("*", xx[i], yy[i]);
			int red,blue,green;
			red=(int)(Math.random()*256);
			blue=(int)(Math.random()*256);
			green=(int)(Math.random()*256);
			Color c = new Color(red,blue,green);
			g.setColor(c);
	
		}
	
		g.setColor(Color.BLACK);
		// 黑月亮
		
		g.fillOval(x, y, 50, 50);
	}
	@Override
	public void run() {
		while (true) {
			x++;
			y--;
			if (x >= 910 || y <= 70){
				x = 810;
				y = 170;
			}
			for(int i=0;i<300;i++) {
				yy[i]++;
				if (yy[i]>768)
					yy[i]=0;
				
				
			}
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			repaint();
		}
	}
}

package day2;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

/**
 * 满天星的画板
 * @author AlexRomeo
 */

public class MyStarPanel extends JPanel {
	public void paint(Graphics g) {
		//	调用父类方法，清除画板的内容，初始化画板
		super.paint(g);
		//	设置画板的背景
		this.setBackground(Color.BLACK);
		//	字体对象，自定义字体
		Font f = new Font("宋体", Font.BOLD, 16);
		//	使用字体
		g.setFont(f);
		g.setColor(Color.WHITE);
		int x = 0;
		int y = 0;
		for (int i = 0; i < 100; i++) {
//			x = new Random().nextInt(1920);
//			y = new Random().nextInt(1080);
			//n = (int) m;
			x = (int) (Math.random() * 1920);
			y = (int) (Math.random() * 1080);
	    	
			g.drawString("*", x, y);
		}
	}
}

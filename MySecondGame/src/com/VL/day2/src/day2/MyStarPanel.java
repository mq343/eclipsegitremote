package day2;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

/**
 * �����ǵĻ���
 * @author AlexRomeo
 */

public class MyStarPanel extends JPanel {
	public void paint(Graphics g) {
		//	���ø��෽���������������ݣ���ʼ������
		super.paint(g);
		//	���û���ı���
		this.setBackground(Color.BLACK);
		//	��������Զ�������
		Font f = new Font("����", Font.BOLD, 16);
		//	ʹ������
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

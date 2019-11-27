package day2;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;
/**
 * 画板
 * @author AlexRomeo
 *
 */
public class MyPanel extends JPanel{
	public void paint(Graphics g) {
		//	调用父类的paint方法，先画出一个空的画板
		super.paint(g);
		// 	设置一个画板的背景颜色
		this.setBackground(Color.black);
		//	设置画笔颜色
		g.setColor(Color.WHITE);
		//	设置一个自定义的字体
		Font f = new Font("宋体",Font.BOLD,18);
		//	设置画笔使用该字体
		g.setFont(f);
		//	通过字符来绘制一颗星星
		g.drawString("*", 100, 100);
	}
}


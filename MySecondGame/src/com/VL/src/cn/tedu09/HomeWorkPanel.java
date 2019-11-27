package cn.tedu09;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Stroke;

import javax.swing.JPanel;
public class HomeWorkPanel extends JPanel{
	//构造
	public HomeWorkPanel(){
		//设置背景颜色
		setBackground(Color.white);
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
//		//画一条直线
//		g.drawLine(arg0, arg1, arg2, arg3);
//		//画实心的圆
//		g.fillOval(arg0, arg1, arg2, arg3);
//		//画空心的圆
//		g.drawOval(arg0, arg1, arg2, arg3);
//		//画实心的矩形
//		g.fillRect(arg0, arg1, arg2, arg3);
//		//画空心的矩形
//		g.drawRect(arg0, arg1, arg2, arg3);		
//		int[] x = {100,200,300};
//		int[] y = {200,300,400};
//		g.fillPolygon(x, y, 3);//画实心三角形
//		//画笔加粗
//		Graphics2D g2 = (Graphics2D)g;
//		g2.setStroke(new BasicStroke(10.0f));
//		g2.drawLine(100, 100, 300, 300);
//		
		
		g.fillRect(100,100, 1000, 600);
		g.setColor(Color.white);
		g.fillOval(500, 200, 150, 120);
		g.setColor(Color.black);
		g.fillOval(525, 220, 50, 40);
		g.setColor(Color.BLACK);
		g.fillOval(575, 220, 50, 40);
		int []x={570,630,525};
		int []y={270,220,220};
		g.setColor(Color.WHITE);
	g.fillPolygon(x, y, 3);
	int []xx={575,560,590};
int []yy={260,275,275};
	g.setColor(Color.black);
g.fillPolygon(xx, yy, 3);
g.setColor(Color.white);
g.fillRect(566, 318, 8, 10);
g.fillRect(578, 318, 8, 10);
g.fillRect(590, 318, 8, 10);
g.fillRect(566, 332, 8, 10);
g.fillRect(578, 332, 8, 10);
g.fillRect(590, 332, 8, 10);
g.fillRect(554, 318, 8, 10);
g.fillRect(554, 332, 8, 10);
g.setColor(Color.white);
g.fillRoundRect(536, 340, 80, 40, 10, 10);
g.fillRect(330, 280, 500, 25);
g.fillRect(560, 120, 25, 100);//
g.fillRect(560, 370, 25, 100);
g.fillOval(826, 273, 20, 20);
g.fillOval(826, 297, 20, 20);
g.fillOval(320, 273, 20, 20);
g.fillOval(320, 297, 20, 20);
g.fillOval(553,105, 20, 20);
g.fillOval(577,105, 20, 20);
g.fillOval(577,465, 20, 20);
g.fillOval(555,465, 20, 20);
g.setFont(new Font("宋体", Font.BOLD, 120));
g.drawString("正义", 470, 600);
int []xxx={710,720,440,430};
int []yyy={590,605,555,530};
int []xxxx={710,720,440,430};
int []yyyy={555,530,596,610};
g.setColor(Color.red);
g.fillPolygon(xxx, yyy, 4);
g.fillPolygon(xxxx, yyyy, 4);
//g.fillOval(arg0, arg1, arg2, arg3);
//g.fillOval(arg0, arg1, arg2, arg3);
//g.fillOval(arg0, arg1, arg2, arg3);
//g.fillOval(arg0, arg1, arg2, arg3);
//g.fillOval(arg0, arg1, arg2, arg3);
//g.fillOval(arg0, arg1, arg2, arg3);
//g.fillOval(arg0, arg1, arg2, arg3);
		
	}
}

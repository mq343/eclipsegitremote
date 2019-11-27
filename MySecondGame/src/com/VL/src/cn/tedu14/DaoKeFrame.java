package cn.tedu14;

import javax.swing.JFrame;

public class DaoKeFrame extends JFrame {
	/*
	 * 14   15   16   17   18   19  20   21  22  23  24   25  26  27  28  29  30  31  1  2  3  4  5  6  7  8  9  10
	 * 
	 */
	public static final int WEIGHT = 1920;
	public static final int HEIGHT = 1080;

	public DaoKeFrame() {
		this.setTitle("刀客传奇");
		this.setSize(WEIGHT, HEIGHT);
		DaoKePanel d = new DaoKePanel();
		this.add(d);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new DaoKeFrame();
	}
}

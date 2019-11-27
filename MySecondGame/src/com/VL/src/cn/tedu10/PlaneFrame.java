package cn.tedu10;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class PlaneFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5198731738037791180L;
	public static final int HEIGHT = 768;
	public static final int WIDTH = 512;

	public PlaneFrame() {
		this.setTitle("打飞机");
		this.setBounds(100, 0, WIDTH, HEIGHT);
		PlanePanel p = new PlanePanel();
		this.add(p);
		p.action();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		PlaneFrame p=new PlaneFrame();
	}
}

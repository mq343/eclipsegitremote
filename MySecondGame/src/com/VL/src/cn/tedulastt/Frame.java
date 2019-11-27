package cn.tedulastt;

import javax.swing.JFrame;

public class Frame extends JFrame{
	int WIDHT=1920;
	int HEIGHT=1080;
public Frame(){
	this.setTitle("刀塔");
	this.setBounds(0, 0, WIDHT, HEIGHT);
	MyPanel p=new MyPanel();
	this.add(p);
	p.action();
	this.setVisible(true);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
public static void main(String[] args) {
	new Frame();
}
}

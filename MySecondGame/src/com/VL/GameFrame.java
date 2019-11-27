package com.VL;

import javax.swing.JFrame;

public class GameFrame extends JFrame{
	//属性
	public static final int WIDTH=540;
	public static final int HEIGHT=960;
	//构造
	public GameFrame(){
		//设置标题
		setTitle("Falling Cute");
		//设置大小
		setBounds(100,0,WIDTH+18,HEIGHT+47);
		GamePanel boli = new GamePanel();
		add(boli);
		boli.action();			//调用action方法
		addKeyListener(boli);	//键盘监听
		setVisible(true);		//设置可视
		//退出程序结束进程
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		GameFrame chuangti = new GameFrame();
	}
}
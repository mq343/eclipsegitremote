package com.VL;

import javax.swing.JFrame;

public class GameFrame extends JFrame{
	//����
	public static final int WIDTH=540;
	public static final int HEIGHT=960;
	//����
	public GameFrame(){
		//���ñ���
		setTitle("Falling Cute");
		//���ô�С
		setBounds(100,0,WIDTH+18,HEIGHT+47);
		GamePanel boli = new GamePanel();
		add(boli);
		boli.action();			//����action����
		addKeyListener(boli);	//���̼���
		setVisible(true);		//���ÿ���
		//�˳������������
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		GameFrame chuangti = new GameFrame();
	}
}
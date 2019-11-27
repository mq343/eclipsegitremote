package cn.tedulastt;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Bu {
	int x=0, y=0;
	int index=0;
	static Image bulletImg = new ImageIcon("LastImg/30.png").getImage();

	public Bu(int x,int y) {
		this.x=x;
		this.y=y;
	}
	public void move(){
		
		y-=6;
		
	}

}

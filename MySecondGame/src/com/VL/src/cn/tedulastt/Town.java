package cn.tedulastt;

import java.awt.Image;

import javax.swing.ImageIcon;

  public class Town{
	int x,y;
	static Image town1 = new ImageIcon("LastImg/town1-1.jpg").getImage();
	static Image town2 = new ImageIcon("LastImg/town2-1.jpg").getImage();
	static Image towns1[] = new Image[15];
	static Image towns2[] = new Image[15];
	static {
		for (int i = 0; i < towns1.length ; i++) {
			towns1[i] = new ImageIcon("LastImg/town1-" + (i+1) + ".jpg").getImage();
			towns2[i] = new ImageIcon("LastImg/town2-" + (i+1) + ".jpg").getImage();
		}
	}
	
	public Town(){
	
	}
	
	
	
	int index = 0;
	public void step() {

		town1 = towns1[index % 15];
		town2 = towns2[index % 15];
		index++;
	}
}

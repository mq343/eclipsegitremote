package cn.tedu14;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class DaoKePanel extends JPanel{
	Image bkImg1;
	public DaoKePanel(){
		bkImg1=new ImageIcon("Image/bg1.png").getImage();

		
	}
	public void paint(Graphics g){
		super.paint(g);
		g.drawImage(bkImg1, 0, 0, DaoKeFrame.WEIGHT,DaoKeFrame.HEIGHT,null);
	}
	

}

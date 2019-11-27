package cn.tedu;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ui extends JPanel implements Runnable,MouseMotionListener{

	//	public static JFrame frame;
public static JFrame frame;
  private int x;
  private int y;
  private  Image hero;

  public Ui() {
	// TODO 自动生成的构造函数存根

	  this.x = 50;
	  this.y = 50;
	  hero = Toolkit.getDefaultToolkit().getImage(Ui.class.getResource("diji1.jpg"));
	 this.addMouseMotionListener(this);

}
  
@Override
public void paint(Graphics g) {
	     super.paint(g);
	   g.drawImage(hero, x, y,50,50,this );
}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO 自动生成的方法存根

         
	}

	@Override
	public void run() {
		// TODO 自动生成的方法存根
		while(true){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
				
		}
	}

}

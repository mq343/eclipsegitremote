package cn.tedulast;

import javax.swing.JFrame;

/*
 * 小球窗体类
 */
public class BallFrame extends JFrame{
	
	//属性
	public static final int WIDTH=800;
	public static final int HEIGHT=1080;
//	public static BallPanel boli;
	//构造方法
	public BallFrame() {
		//对一个窗口的基本信息进行设置（初始化）
		setTitle("弹球");
		setBounds(100,10,WIDTH,HEIGHT);
		//创建一个面板，装载到窗体
		BallPanel boli = new BallPanel();
		boli.action();
		add(boli);
		setVisible(true);//设置当窗口关闭时，后台程序随之关闭
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		
	}
	
	
	//程序的入口
	public static void main(String[] args) {
		//创建小球窗体对象
		BallFrame chuangti = new BallFrame();
//	boli.Action();
		
	}

}

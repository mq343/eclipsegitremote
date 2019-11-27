package day2;

import javax.swing.JFrame;
/**
 * 窗口
 * @author AlexRomeo
 *
 */
public class MyFrame {
	private JFrame frame;
	private MyPanel mp;
	public void showMe() {
		frame = new JFrame();
		mp = new MyPanel();
		frame.add(mp);
		frame.setVisible(true);
		frame.setSize(800, 600);
		frame.setTitle("bbbbbbbbb");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		MyFrame mf = new MyFrame();
		mf.showMe();
		
		
//		//	窗口对象
//		JFrame jf = new JFrame();
//		//	画板对象
//		MyPanel mp = new MyPanel();
//		//	添加画板到窗口
//		jf.add(mp);
//		//	设置窗口的基本属性
//		jf.setSize(800, 600);
//		jf.setTitle("aaaaaaaaa");
//		jf.setVisible(true);
//		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}


package day2;

import javax.swing.JFrame;
/**
 * ����
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
		
		
//		//	���ڶ���
//		JFrame jf = new JFrame();
//		//	�������
//		MyPanel mp = new MyPanel();
//		//	��ӻ��嵽����
//		jf.add(mp);
//		//	���ô��ڵĻ�������
//		jf.setSize(800, 600);
//		jf.setTitle("aaaaaaaaa");
//		jf.setVisible(true);
//		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}


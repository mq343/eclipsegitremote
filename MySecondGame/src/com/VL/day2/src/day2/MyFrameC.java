package day2;


import javax.swing.JFrame;

public class MyFrameC extends JFrame{
//	JFrame famre = new JFrame();
//	public void showMe(MyFrameC mf) {
//		mf.setVisible(true);
//		mf.setSize(800,600);
//		mf.setTitle("��ѧ��ĵ����ִ��ڵĴ���");
//		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	}
	public void showMe() {
		this.setSize(800,600);
		this.setVisible(true);
		this.setTitle("�Ҵ����ĵ���������");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		MyFrameC mfc = new MyFrameC();
		mfc.showMe();
	}
}

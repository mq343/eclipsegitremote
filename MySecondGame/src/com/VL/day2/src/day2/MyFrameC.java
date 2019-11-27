package day2;


import javax.swing.JFrame;

public class MyFrameC extends JFrame{
//	JFrame famre = new JFrame();
//	public void showMe(MyFrameC mf) {
//		mf.setVisible(true);
//		mf.setSize(800,600);
//		mf.setTitle("我学会的第三种窗口的创建");
//		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	}
	public void showMe() {
		this.setSize(800,600);
		this.setVisible(true);
		this.setTitle("我创建的第三个窗口");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		MyFrameC mfc = new MyFrameC();
		mfc.showMe();
	}
}

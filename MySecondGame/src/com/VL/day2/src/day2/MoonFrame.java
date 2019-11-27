package day2;


import javax.swing.JFrame;
import javax.swing.JPanel;

public class MoonFrame extends JFrame{
	private MoonPanel mp;
	public MoonFrame() {
		mp = new MoonPanel();
		Thread t = new Thread(mp);
		t.start();
		this.add(mp);
		
	}
	public void showMe() {
		/*
		 * 窗口的大小，标题，关闭操作，显示窗口
		 */
		this.setSize(1024,768);
		this.setTitle("月食");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		// 当一个对象我们只需要调用一次的时候使用下面的方式即可。
		new MoonFrame().showMe();
	}
	
/*	private JFrame frame;
	private MoonPanel mp;
	
	public void showMe() {
		frame = new JFrame();
		mp = new MoonPanel();
		frame.add(mp);
		frame.setSize(1024,600);
		frame.setTitle("月食");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		MoonFrame mf = new MoonFrame();
		mf.showMe();
	}
*/
}
	
	//另一种方法
	/*
	private JFrame frame;
	private MoonPanel mp;
	
	public void showMe() {
		frame = new JFrame();
		mp = new MoonPanel();
		frame.add(mp);
		frame.setSize(1024,600);
		frame.setTitle("MoonPanel");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		
	}
	public static void main(String[] args) {
		MoonFrame mf = new MoonFrame();
		mf.showMe();
		
	}
	

}
*/
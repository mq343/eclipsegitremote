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
		 * ���ڵĴ�С�����⣬�رղ�������ʾ����
		 */
		this.setSize(1024,768);
		this.setTitle("��ʳ");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		// ��һ����������ֻ��Ҫ����һ�ε�ʱ��ʹ������ķ�ʽ���ɡ�
		new MoonFrame().showMe();
	}
	
/*	private JFrame frame;
	private MoonPanel mp;
	
	public void showMe() {
		frame = new JFrame();
		mp = new MoonPanel();
		frame.add(mp);
		frame.setSize(1024,600);
		frame.setTitle("��ʳ");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		MoonFrame mf = new MoonFrame();
		mf.showMe();
	}
*/
}
	
	//��һ�ַ���
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
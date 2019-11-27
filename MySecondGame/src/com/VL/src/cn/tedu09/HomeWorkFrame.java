package cn.tedu09;
import javax.swing.JFrame;
/**
 * 窗体类
 * @author 1
 */
public class HomeWorkFrame extends JFrame{
	//构造
	public HomeWorkFrame(){
		setTitle("7月9日实训作业");//设置标题
		setSize(1200,1200);//设置窗体大小
		//创建面板，并装载到窗体上
		HomeWorkPanel boli = new HomeWorkPanel();
		add(boli);
		setVisible(true);//设置窗体可见
		//窗体关闭时，后台程序随之关闭
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	//程序的入口
	public static void main(String[] args) {
		HomeWorkFrame chuangti = new HomeWorkFrame();
	}
}

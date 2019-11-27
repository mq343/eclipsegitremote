package day2;

import javax.swing.JFrame;
/**
 * 满天星窗口
 * 案例总结：
 * math随机数，它生成的[0,1]之间的随机双精度小数(DOUBLE)，
 * Math.random()*n  (n为整数)，就会[0,N]之间的随机双精度小数。
 * 如果想Math.random的结果是一个整数，那么就需要强制类型转换。(int)
 * 例如：由大范围数M（DOUBLE）转换成小范围数N（int），转换方式n = (int) m;
 * for循环格式：
 * 		for (int i = 0 ; i < 300 ; i++) {}
 * 表达式int i = 0(初始化变量);i <300(表示变量取值范围);表达式i++(表示修改变量的值)
 * @author AlexRomeo
 */
public class StarSkyFrame {
	//	私有化窗口的对象
	private JFrame frame;
	private MyStarPanel msp;
	//	showMe方法 并设置窗口的基本属性、操作
	public void showMe() {
		//	窗口和画板
		frame = new JFrame();
		msp = new MyStarPanel();
		// 	窗口的属性和添加画板
		frame.setVisible(true);
		frame.add(msp);
		frame.setSize(800, 600); 
		frame.setTitle("满天星");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		StarSkyFrame ssf = new StarSkyFrame();
		ssf.showMe();
	}
}

package day2;

import javax.swing.JFrame;
/**
 * �����Ǵ���
 * �����ܽ᣺
 * math������������ɵ�[0,1]֮������˫����С��(DOUBLE)��
 * Math.random()*n  (nΪ����)���ͻ�[0,N]֮������˫����С����
 * �����Math.random�Ľ����һ����������ô����Ҫǿ������ת����(int)
 * ���磺�ɴ�Χ��M��DOUBLE��ת����С��Χ��N��int����ת����ʽn = (int) m;
 * forѭ����ʽ��
 * 		for (int i = 0 ; i < 300 ; i++) {}
 * ���ʽint i = 0(��ʼ������);i <300(��ʾ����ȡֵ��Χ);���ʽi++(��ʾ�޸ı�����ֵ)
 * @author AlexRomeo
 */
public class StarSkyFrame {
	//	˽�л����ڵĶ���
	private JFrame frame;
	private MyStarPanel msp;
	//	showMe���� �����ô��ڵĻ������ԡ�����
	public void showMe() {
		//	���ںͻ���
		frame = new JFrame();
		msp = new MyStarPanel();
		// 	���ڵ����Ժ���ӻ���
		frame.setVisible(true);
		frame.add(msp);
		frame.setSize(800, 600); 
		frame.setTitle("������");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		StarSkyFrame ssf = new StarSkyFrame();
		ssf.showMe();
	}
}

package day2;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;
/**
 * ����
 * @author AlexRomeo
 *
 */
public class MyPanel extends JPanel{
	public void paint(Graphics g) {
		//	���ø����paint�������Ȼ���һ���յĻ���
		super.paint(g);
		// 	����һ������ı�����ɫ
		this.setBackground(Color.black);
		//	���û�����ɫ
		g.setColor(Color.WHITE);
		//	����һ���Զ��������
		Font f = new Font("����",Font.BOLD,18);
		//	���û���ʹ�ø�����
		g.setFont(f);
		//	ͨ���ַ�������һ������
		g.drawString("*", 100, 100);
	}
}


package cn.tedu;

import javax.swing.JFrame;

public class 	huaBan{

     
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setSize(600, 800);
        jf.setResizable(false);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Ui ui = new Ui();
        Thread t = new Thread(ui);
        t.start();
        jf.add(ui);
        jf.setVisible(true);
}

	
}

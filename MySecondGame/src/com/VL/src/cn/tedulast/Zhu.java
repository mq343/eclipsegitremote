package cn.tedulast;

public class Zhu {
	int height ;
	int width ;
	int x, y;
int speed=10;

	public Zhu(int x, int y) {
		this.x = x;
		this.y = y;
		height=100;
		width=30;

	}
	public void action(){
		y-=1;
		height+=1;
		
	}

}

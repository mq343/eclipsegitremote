package divideGroups;

public class Adress {
	int part1,part2,part3,part4;
	String IP;
	public void setIP(){	
		IP=String.valueOf(part1)+"."+String.valueOf(part2)+"."+String.valueOf(part3)+"."+String.valueOf(part4);
	}
	
	public void resetIP(){
		String[] strings=IP.split("\\.");
		part1=Integer.parseInt(strings[0]);
		part2=Integer.parseInt(strings[1]);
		part3=Integer.parseInt(strings[2]);
		part4=Integer.parseInt(strings[3]);
	}
	public void set(String IP){
		this.IP=IP;
	}
	
	public boolean equals(Adress b) {
		return IP.equals(b.IP);
	}
	public String toString(){
		return IP;
	}
}
//123

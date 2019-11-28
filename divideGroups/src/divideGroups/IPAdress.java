package divideGroups;

import java.util.Scanner;

public class IPAdress extends Adress{
	public void input(){
		System.out.println("在此输入IP地址");
		Scanner scanner=new Scanner(System.in);
		IP=scanner.next();
		String[] strings=IP.split("\\.");
		part1=Integer.parseInt(strings[0]);
		part2=Integer.parseInt(strings[1]);
		part3=Integer.parseInt(strings[2]);
		part4=Integer.parseInt(strings[3]);
	}


}

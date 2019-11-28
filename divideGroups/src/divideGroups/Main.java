package divideGroups;

public class Main {
	public static void main(String[] args) {
		IPAdress h1=new IPAdress();
		h1.input();									
		RoutingTable routing=new RoutingTable();	
		routing.match(h1);							
	}



}

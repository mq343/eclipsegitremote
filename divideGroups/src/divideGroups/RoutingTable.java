package divideGroups;

public class RoutingTable {
	Tuple[] tuples=new Tuple[4];
	public RoutingTable() {
		tuples[0]=new Tuple();
		tuples[1]=new Tuple();
		tuples[2]=new Tuple();
		tuples[3]=new Tuple();
		tuples[0].DEST.set("128.0.2.0");
		tuples[0].SUBNET.set("255.255.255.0");
		tuples[0].NEXT="直接交付";
		tuples[1].DEST.set("128.0.3.0");
		tuples[1].SUBNET.set("255.255.255.0");
		tuples[1].NEXT="接口1";
		tuples[2].DEST.set("202.2.0.0");
		tuples[2].SUBNET.set("255.255.0.0");
		tuples[2].NEXT="R2";
		tuples[3].DEST.set("19.0.0.0");
		tuples[3].SUBNET.set("255.0.0.0");
		tuples[3].NEXT="R1";
	}
	public int AND(IPAdress IP){
		Adress result = new Adress();	
		for(int i=0;i<4;i++){
			Adress SUB=tuples[i].SUBNET;
			SUB.resetIP();
			result.part1=IP.part1&SUB.part1;
			result.part2=IP.part2&SUB.part2;
			result.part3=IP.part3&SUB.part3;
			result.part4=IP.part4&SUB.part4;
			result.setIP();	
System.out.println("检查匹配中："+result+"--"+tuples[i].DEST);
			if(result.equals(tuples[i].DEST)){
				return i;
			}
		}
		return -1;
	}
	public void match(IPAdress h1) {
		int A=AND(h1);
		switch (A) {
		case 0:
			System.out.println(tuples[A].NEXT);
			break;
		case 1:
			System.out.println(tuples[A].NEXT);
			break;
		case 2: 
			System.out.println(tuples[A].NEXT);
			break;
		default:
			System.out.println("转发分组出错");
			break;
		}
	}
	class Tuple{	
		Adress DEST;			
		Adress SUBNET;	
		String NEXT;			
		public Tuple() {
			DEST=new Adress();
			SUBNET=new Adress();
		}
	}


}

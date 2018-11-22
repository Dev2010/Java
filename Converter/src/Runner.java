public class Runner{

	public static void main (String [] args){
		Converter c=new Converter();

		System.out.println(c.decToBin("37"));
		System.out.println(c.decToHex("37"));
		System.out.println(c.binToDec("100"));
		System.out.println(c.binToHex("1001"));
		System.out.println(c.hexToBin("3E"));
		System.out.println(c.hexToDec("3E"));
	}
}
import java.util.ArrayList;
public class Converter{

	public String decToBin(String deca){
		int mcla=Integer.parseInt(deca); //converts stribg to int
		ArrayList<Integer> physc=new ArrayList<Integer>();
		int temp;
		int y=0;

		do{
			physc.add(mcla%2);
			mcla=mcla/2;
			y++;
		} while (mcla>0); //phils physc

		deca="";
		for (int x=physc.size()-1;x>=0;x--){
			deca+=physc.get(x);
		}
		return deca;
	}

	public String decToHex(String phil){

		binToDec(phil);
		int pj=Integer.parseInt(phil);
		ArrayList<Integer> dan=new ArrayList<Integer>();

		do{
			dan.add(pj%16);
			pj=pj/16;
		} while (pj>0);

		phil="";
		for (int x=dan.size()-1;x>=0;x--){
			if (dan.get(x)==10){
				phil+="A";
			} else if (dan.get(x)==11){
				phil+="B";
			}
			else if (dan.get(x)==12){
				phil+="C";
			}
			else if (dan.get(x)==13){
				phil+="D";
			}
			else if (dan.get(x)==14){
				phil+="E";
			}
			else if (dan.get(x)==15){
				phil+="F";
			} else{
				phil+=dan.get(x);
			}
		}
		return phil;
	}

	public String binToHex(String deca){
		String mcla=new String();
		mcla=decToHex(binToDec(deca));
		return mcla;
	}

	public String binToDec(String phil){
		int dan=0;
		for (int x=phil.length()-1;x>=0;x--){
			dan+=Integer.parseInt(Character.toString(phil.charAt(x)))*(Math.pow(2, phil.length()-1-x));
		}
		return Integer.toString(dan); //converts integer to string
	}


	public String hexToBin(String draco){
		return decToBin(hexToDec(draco));
	}

	public String hexToDec(String draco){
		int harry=0;
		int snape;
		for (int x=draco.length()-1;x>=0;x--){
			if (draco.charAt(x)==65){
				snape=10;
			} else if (draco.charAt(x)==66){
				snape=11;
			} else if (draco.charAt(x)==67){
				snape=12;
			} else if (draco.charAt(x)==68){
				snape=13;
			} else if (draco.charAt(x)==69){
				snape=14;
			} else if (draco.charAt(x)==70){
				snape=15;
			} else snape= Integer.parseInt(Character.toString(draco.charAt(x)));
			harry+=snape * (Math.pow(16,draco.length()-1-x));
		}
		return Integer.toString(harry);
	}
}
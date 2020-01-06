import java.util.LinkedHashMap;
import java.util.Scanner;

public class NumberToRoman {

	static LinkedHashMap<Integer, String> romanValues = new LinkedHashMap<Integer,String>();
	
	public static void main(String[] args) {
		NumberToRoman ntr = new NumberToRoman();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number:");
		int number = sc.nextInt();
		
		romanValues.put(1,"I");
		romanValues.put(5,"V");
		romanValues.put(10,"X");
		romanValues.put(50,"L");
		romanValues.put(100,"C");
		romanValues.put(500,"D");
		romanValues.put(1000,"M");
		romanValues.put(4,"IV");
		romanValues.put(9,"IX");
		romanValues.put(40,"XL");
		romanValues.put(90,"XC");
		romanValues.put(400,"CD");
		romanValues.put(900,"CM");
		
		ntr.convert(number);
	}
	
	public void convert(int number) {
		int[] numArray = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
		int index = 0;
		while(number!=0) {
			if(number >= numArray[index]) {
				number = number - numArray[index];
				System.out.print(romanValues.get(numArray[index]));
			}else {
				index++;
			}
		}
	}

}


/*
 * input = 1547
 * output = MDXLVII
 * 
 * input = 76
 * output = LXXVI
 */




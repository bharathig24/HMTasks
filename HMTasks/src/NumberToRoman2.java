import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class NumberToRoman2 {

	static LinkedHashMap<Integer, String> romanValues = new LinkedHashMap<Integer,String>();
	
	public static void main(String[] args) {
		
		NumberToRoman2 ntr = new NumberToRoman2();
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
		
		ArrayList<Integer> numArray = new ArrayList<Integer>(Arrays.asList(100,400,100,300));
		int subtract = 1000, position = 0;
		
		while(number!=0) {
			if(number >= subtract) {
				number = number - subtract;
				System.out.print(romanValues.get(subtract));
			}else {
				if(position > 3) {
					for(int i=0; i<4; i++) {
						numArray.set(i, numArray.get(i)/10);
					}
					position = 0;
				}
				subtract = subtract - numArray.get(position);
				position++;
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

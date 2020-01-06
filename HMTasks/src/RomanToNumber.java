import java.util.*;
import java.util.regex.Pattern;

public class RomanToNumber {
	
	static HashMap<String,Integer> romanValues = new HashMap<String,Integer>();
	
	public static void main(String[] args) {
		RomanToNumber rtn = new RomanToNumber();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the roman result:");
		String roman = sc.nextLine();
		
		romanValues.put("I",1);
		romanValues.put("V",5);
		romanValues.put("X",10);
		romanValues.put("L",50);
		romanValues.put("C",100);
		romanValues.put("D",500);
		romanValues.put("M",1000);
		romanValues.put("IV",4);
		romanValues.put("IX",9);
		romanValues.put("XL",40);
		romanValues.put("XC",90);
		romanValues.put("CD",400);
		romanValues.put("CM",900);
				
		rtn.convert(roman);
		
	}
		public void convert(String roman) {
			
			//Validating
			if(Pattern.matches("[IVXLCDM]+", roman) == false) {
				System.out.print("Entered roman result was invalid!");
				return;
			}
			
			int result = 0;
			String current, next = null;
			
			//Converting
			for(int i=0; i<roman.length(); i++) {
				current = roman.substring(i,i+1);
				try {
					next = roman.substring(i+1,i+2);
				}catch(Exception e) {
					next = current;
				}
				
				if(romanValues.get(current) >= romanValues.get(next)) {
					result = result + romanValues.get(current);
				}else {
					try {
					result = result + romanValues.get(roman.substring(i,i+2));
					}catch(Exception e) {
						System.out.print("Entered roman result was invalid!");
						return;
					}
					i++;
				}
			}
			
			//output
			System.out.println(result);
		
	}
}

/* input = XXIV
 * output = 24
 * 
 * input = XXVI
 * output = 26
 * 
 * input = MMIL
 * output = Entered roman result was invalid
 * 
 * input = MMAL
 * output = Entered roman result was invalid
 *
 */



















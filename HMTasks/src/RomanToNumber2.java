import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class RomanToNumber2 {

	static LinkedHashMap<String,Integer> romanValues = new LinkedHashMap<String,Integer>();
	
	public static void main(String[] args) {
		RomanToNumber2 rtn = new RomanToNumber2();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the roman result:");
		StringBuilder roman = new StringBuilder(sc.nextLine());
		
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

	private void convert(StringBuilder roman) {
		
		//Validating
		if(Pattern.matches("[IVXLCDM]+", roman) == false) {
			System.out.print("Entered roman result was invalid!");
			return;
		}
		
		//converting
		int count = 0, result = 0;
		for(String s : romanValues.keySet()) {
			if(count >= 7) {
				if(roman.indexOf(s)>=0) {
					result = result + romanValues.get(s);
					roman.replace(roman.indexOf(s), roman.indexOf(s)+2, "");
				}
			}
			count++;
		}
		
		String current, next = null;
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
				System.out.print("Entered roman result was invalid!");
				return;
					
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
















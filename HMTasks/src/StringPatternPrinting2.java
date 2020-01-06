import java.util.ArrayList;
import java.util.Scanner;

public class StringPatternPrinting2 {
	
	ArrayList<String> stringArray = new ArrayList<String>();
	ArrayList<Integer> numberArray = new ArrayList<Integer>();

	public static void main(String[] args) {
		StringPatternPrinting2 spp = new StringPatternPrinting2();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the value:");
		String input = sc.nextLine();
		spp.split(input);
		spp.print();
	}
	
	public void split(String input) {
		
		String tempString = "",tempNumber="";
		
		for(int i=0; i<input.length(); i++) {
			
			if(Character.isAlphabetic(input.charAt(i))) {
				if(tempNumber.length() > 0) {
					numberArray.add(Integer.parseInt(tempNumber));
				}
				tempString = tempString + input.charAt(i);
				tempNumber = "";
			}
			
			if(Character.isDigit(input.charAt(i))) {
				if(tempString.length() > 0) {
					stringArray.add(tempString);
				}
				tempNumber = tempNumber + input.charAt(i);
				tempString = "";
			}
		}
		numberArray.add(Integer.parseInt(tempNumber));		
	}
	
	public void print() {
		for(int i=0; i<stringArray.size(); i++) {
			for(int j=0; j<numberArray.get(i); j++) {
				System.out.print(stringArray.get(i));
			}
		}
	}

}

/*
 * input = d5as10er4
 * output = dddddasasasasasasasasasaserererer
 * 
 * input = a2b10cf4
 * output = aabbbbbbbbbbcfcfcfcf
 */ 
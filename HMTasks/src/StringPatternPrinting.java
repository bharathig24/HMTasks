import java.util.Scanner;

public class StringPatternPrinting {

	public static void main(String[] args) {
		StringPatternPrinting spp = new StringPatternPrinting();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the value:");
		String input = sc.nextLine();
		spp.print(input);
	}
	
	public void print(String input) {
		
		String tempString = "";
		int tempNumber = 0;
		
		for(int i=0; i<input.length(); i++) {
			if(Character.isAlphabetic(input.charAt(i))) {
				tempString = tempString + input.substring(i,i+1);
			}else {
				for(int j=i; j<input.length(); j++) {
					if(Character.isAlphabetic(input.charAt(j)) == false) {
						tempNumber = Integer.parseInt(input.substring(i,j+1));
					}else {
						for(int k=0; k<tempNumber; k++) {
							System.out.print(tempString);
						}
						i = j-1;
						tempString = "";
						break;
					}
				}
				for(int k=0; k<tempNumber; k++) {
					System.out.print(tempString);
				}
			}
		}
	}

}
/*
 * input = d5ads10er4
 * output = dddddadsadsadsadsadsadsadsadsadsadserererer
 * 
 * input = a2b10cf4
 * output = aabbbbbbbbbbcfcfcfcf
 */ 

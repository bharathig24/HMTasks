import java.util.Scanner;

public class NumberPatternPrinting2 {

	public static void main(String[] args) {
		NumberPatternPrinting2 npp = new NumberPatternPrinting2();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number:");
		String number = sc.nextLine();
		npp.output(number);
	}
	
	public void output(String number) {
		String output = "";
		for(int i=0; i<number.length(); i++) {
			if(i==0) {
				output = output + number.charAt(i) + "^" ; 
			}else {
				for(int j=0; j<2; j++) {
					if(j==0) {
						output = output + number.charAt(i) + "+";
					}else {
						output = output + number.charAt(i) + "^";
					}
				}
			}
		}
		output = output + number.charAt(0);
		System.out.println(output);
	}

}
/*
 * input = 1234
 * output = 1^2+2^3+3^4+4^1
 * 
 * input = 45682
 * output = 4^5+5^6+6^8+8^2+2^4
 */

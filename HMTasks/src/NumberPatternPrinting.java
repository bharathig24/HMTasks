import java.util.Scanner;

public class NumberPatternPrinting {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String number = sc.nextLine();
		sc.close();
		for(int i=0; i<number.length(); i++) {
			if(i==0) {
				System.out.print(number.charAt(i) + "^");
			}else {
				System.out.print(number.charAt(i) + "+" + number.charAt(i) + "^");
			}
		}
		System.out.print(number.charAt(0));

	}

}

/*
 * input = 3456
 * output = 3^4+4^5+5^6+6^3
 * 
 * input = 279486
 * output = 2^7+7^9+9^4+4^8+8^6+6^2
 */

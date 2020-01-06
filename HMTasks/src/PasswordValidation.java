import java.util.Scanner;
import java.util.regex.Pattern;

public class PasswordValidation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter password: ");
		String pWord = sc.nextLine();
		sc.close();
		PasswordValidation pv = new PasswordValidation();
		pv.validate(pWord);
	}

	private void validate(String pWord) {
		int count = 0, pWordLength = pWord.length();
		if(pWordLength > 4 && pWordLength < 15) {
			count++;
		}
		if(Pattern.matches(".*[a-z].*", pWord)) {
			count++;
		}
		if(Pattern.matches(".*[A-Z].*", pWord)) {
			count++;
		}
		if(Pattern.matches(".*[0-9].*", pWord)) {
			count++;
		}
		if(Pattern.matches(".*\\W.*",pWord)) {
			count++;
		}
		output(count);
	}

	private void output(int count) {
		if(count<3) {
			System.out.println("Weak password!");
		}else if(count == 3) {
			System.out.println("Average password!");
		}else if(count == 4) {
			System.out.println("Strong password!");
		}else if(count == 5) {
			System.out.println("Very strong password!");
		}
	}

}

/*
 	input = 12wyrhT.3e&
 	
 	output = Very strong password!
 	
 	
 	input = asdfgh0
 	
 	output = Average password!
 */



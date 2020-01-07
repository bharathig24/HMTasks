import java.util.Scanner;
import java.util.regex.Pattern;

public class PasswordValidation2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter password: ");
		String pWord = sc.nextLine();
		sc.close();
		PasswordValidation2 pv = new PasswordValidation2();
		pv.validate(pWord);

	}

	private void validate(String pWord) {
		if(Pattern.matches("(?=.*\\d.*)(?=.*[a-z].*)(?=.*[A-Z].*)(?=.*[\\W_&&[^\\s]]).{8,}", pWord)){
			System.out.println("Valid password");
		}else {
			System.out.println("npt valid");
		}
		
	}

}

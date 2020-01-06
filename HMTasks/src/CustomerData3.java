import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerData3 {

	public static void main(String[] args) {
		CustomerData3 cd = new CustomerData3();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the data as pharagraph:");
		String inputData = sc.nextLine();
		sc.close();
		cd.extract(inputData);
	}

	private void extract(String inputData) {
		String[] field = {"Name", "Phone", "Address", "Date", "Total amount", "Tax"};
		String[] regex = {"[a-zA-Z]+[ ]", "[\\d]{10}[ ]", ".+[-]\\s(\\d{6}|\\d{2})[ ]", 
				"\\d{2}-\\d{2}-\\d{4}[ ]", "\\d+.\\d{2}[ ]", "\\d+.\\d{2}[ ]"};
		for(int i=0; i<6; i++) {
			Pattern pattern = Pattern.compile(field[i]+"[:]\\s");
			Matcher matcher = pattern.matcher(inputData);
//			matcher.find();
			Pattern pattern2 = Pattern.compile(regex[i]);
			Matcher matcher2 = pattern2.matcher(inputData);
			matcher2.find(matcher.end());
			System.out.println(field[i] + ": " + matcher2.group());
		}
	}

}

/*
 * input = Name: Bharathi Date: 24-11-1997 Address: no.7, Raja street, adambakkam, chennai, pin - 600088 Phone: 8248216179 Total amount: 15000.00 Tax: 1000.00 
 * 
 * output = Name: Bharathi
 *          Phone: 8248216179
 *          Address: no.7, Raja street, adambakkam, chennai - 88 
 *          Date: 24-11-1997
 *          Total amount: 15000.00
 *          Tax: 1000.00
 */

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerData2 {

	public static void main(String[] args) {
		CustomerData2 cd = new CustomerData2();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the data as pharagraph:");
		String inputData = sc.nextLine();
		sc.close();
		cd.findName(inputData);
		cd.findPhone(inputData);
		cd.findAddress(inputData);
		cd.findDate(inputData);
		cd.findAmount(inputData);
		cd.findTax(inputData);

	}

	private void findTax(String inputData) {
		Pattern pattern = Pattern.compile("Tax[:]\\s");
		Matcher matcher = pattern.matcher(inputData);
		matcher.find();
		Pattern pattern2 = Pattern.compile("\\d+.\\d{2}[ ]");
		Matcher matcher2 = pattern2.matcher(inputData);
		matcher2.find(matcher.end());
		System.out.println("Tax: " + matcher2.group());
	}

	private void findAmount(String inputData) {
		Pattern pattern = Pattern.compile("Total amount[:]\\s");
		Matcher matcher = pattern.matcher(inputData);
		matcher.find();
		Pattern pattern2 = Pattern.compile("\\d+.\\d{2}[ ]");
		Matcher matcher2 = pattern2.matcher(inputData);
		matcher2.find(matcher.end());
		System.out.println("Total amount: " + matcher2.group());
	}

	private void findDate(String inputData) {
		Pattern pattern = Pattern.compile("Date[:]\\s");
		Matcher matcher = pattern.matcher(inputData);
		matcher.find();
		Pattern pattern2 = Pattern.compile("\\d{2}-\\d{2}-\\d{4}[ ]");
		Matcher matcher2 = pattern2.matcher(inputData);
		matcher2.find(matcher.end());
		System.out.println("Date: " + matcher2.group());
	}

	private void findAddress(String inputData) {
		Pattern pattern = Pattern.compile("Address[:]\\s");
		Matcher matcher = pattern.matcher(inputData);
		matcher.find();
		Pattern pattern2 = Pattern.compile(".+[-]\\s(\\d{6}|\\d{2})[ ]");
		Matcher matcher2 = pattern2.matcher(inputData);
		matcher2.find(matcher.end());
		System.out.println("Address: " + matcher2.group());
	}

	private void findPhone(String inputData) {
		Pattern pattern = Pattern.compile("Phone[:]\\s");
		Matcher matcher = pattern.matcher(inputData);
		matcher.find();
		Pattern pattern2 = Pattern.compile("[\\d]{10}[ ]");
		Matcher matcher2 = pattern2.matcher(inputData);
		matcher2.find(matcher.end());
		System.out.println("Phone: " + matcher2.group());
	}

	private void findName(String inputData) {
		Pattern pattern = Pattern.compile("Name[:]\\s");
		Matcher matcher = pattern.matcher(inputData);
		matcher.find();
		Pattern pattern2 = Pattern.compile("[a-zA-Z]+[ ]");
		Matcher matcher2 = pattern2.matcher(inputData);
		matcher2.find(matcher.end());
		System.out.println("Name: " + matcher2.group());
	}

}
 
/*
 * input = Name: Bharathi Date: 24-11-1997 Address: no.7, Raja street, adambakkam, chennai, pin - 600088 Phone: 8248216179 Total amount: 15000.00 Tax: 1000.00 
 * 
 * output = Name: Bharathi
 *          Phone: 8248216179
 *          Adress: no.7, Raja street, adambakkam, chennai - 88 
 *          Date: 24-11-1997
 *          Total amount: 15000.00
 *          Tax: 1000.00
 */

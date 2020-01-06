import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerData {
	
	public static void main(String[] args) {
		CustomerData cd = new CustomerData();
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

	private void findAddress(String inputData) {
		Pattern pattern = Pattern.compile("Address: ");
		Matcher matcher = pattern.matcher(inputData);
		matcher.find();
		int startIndex = matcher.end(),endIndex = 0;
		while(Pattern.matches(":", inputData.substring(startIndex + endIndex, startIndex + endIndex + 1)) != true) {
			endIndex++;
		}
		while(Pattern.matches("\\s", inputData.substring(startIndex + endIndex-1, startIndex + endIndex)) != true) {
			endIndex--;
		}
		System.out.println("Adress: " + inputData.substring(startIndex, startIndex+endIndex));
	}

	private void findTax(String inputData) {
		Pattern pattern = Pattern.compile("Tax: ");
		Matcher matcher = pattern.matcher(inputData);
		matcher.find();
		int startIndex = matcher.end(),endIndex = 0;
		while(Pattern.matches("[0-9[.]]",inputData.substring(startIndex + endIndex, startIndex + endIndex + 1))) {
			endIndex++;
		}
		if(Pattern.matches("[0-9]{1,}[.][0-9]{2}", inputData.substring(startIndex, startIndex + endIndex))) {
			System.out.println("Tax: " + inputData.substring(startIndex, startIndex + endIndex));
		}
	}

	private void findAmount(String inputData) {
		Pattern pattern = Pattern.compile("Total amount: ");
		Matcher matcher = pattern.matcher(inputData);
		matcher.find();
		int startIndex = matcher.end(),endIndex = 0;
		while(Pattern.matches("[0-9[.]]",inputData.substring(startIndex + endIndex, startIndex + endIndex + 1))) {
			endIndex++;
		}
		if(Pattern.matches("[0-9]{1,}[.][0-9]{2}", inputData.substring(startIndex, startIndex + endIndex))) {
			System.out.println("Total amount: " + inputData.substring(startIndex, startIndex + endIndex));
		}
	}

	private void findPhone(String inputData) {
		Pattern pattern = Pattern.compile("Phone: ");
		Matcher matcher = pattern.matcher(inputData);
		matcher.find();
		int startIndex = matcher.end();
		if(Pattern.matches("[0-9]{10}", inputData.substring(startIndex, startIndex + 10))) {
			System.out.println("Phone: " + inputData.substring(startIndex, startIndex + 10));
		}
	}

	private void findDate(String inputData) {
		Pattern pattern = Pattern.compile("Date: ");
		Matcher matcher = pattern.matcher(inputData);
		matcher.find();
		int startIndex = matcher.end();
		if(Pattern.matches("[0-9]{2}.[0-9]{2}.[0-9]{4}", inputData.substring(startIndex, startIndex + 10))) {
			System.out.println("Date: " + inputData.substring(startIndex, startIndex + 10));
		}
	}

	private void findName(String inputData) {
		
		Pattern pattern = Pattern.compile("Name: ");
		Matcher matcher = pattern.matcher(inputData);
		matcher.find();
		int startIndex = matcher.end(), endIndex = 0;
		while(Pattern.matches("[a-zA-Z]",inputData.substring(startIndex + endIndex, startIndex + endIndex + 1))) {
			endIndex++;
		}
		
		System.out.println("Name: " + inputData.substring(startIndex, startIndex+endIndex));
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
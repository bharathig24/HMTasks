import java.util.Arrays;
import java.util.Scanner;

public class FindSubString2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String:");
		String input1 = sc.nextLine();
		System.out.println("Enter the Substring to search:");
		String input2 = sc.nextLine();
		sc.close();
		FindSubString2 fs = new FindSubString2();
		fs.findZarray(input2+"$"+input1, input2);
	}

	private void findZarray(String string, String subString) {
		int[] Zarray = new int[string.length()];
		Zarray[0] = 0;
		int index = 0, count = 0, i = 1;
		while(i<string.length()-1) {
			for(int j=i; j<string.length(); j++) {
				if(string.charAt(index) == string.charAt(j)) {
					index++;
					count++;
				}else {
					Zarray[i] = count;
					i++;
					index = 0;
					count = 0;
					break;
				}
			}
		}
		if(string.charAt(0) == string.charAt(string.length()-1)) {
			Zarray[i] = 1;
		}
		Arrays.sort(Zarray);
		if(Zarray[string.length()-1]==subString.length()) {
			System.out.print("Yes");
		}else {
			System.out.print("No");
		}
	}
}

/*
 
 input1 = I am Bharathi from chennai
 input2 = am Bharathi
 
 output = Yes
 
 */



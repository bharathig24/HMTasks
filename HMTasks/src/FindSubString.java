import java.util.Scanner;

public class FindSubString {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String:");
		String input1 = sc.nextLine();
		System.out.println("Enter the Substring to search:");
		String input2 = sc.nextLine();
		sc.close();
		FindSubString fs = new FindSubString();
		fs.search(input1, input2);
	}

	private void search(String input1, String input2) {
		if(input1.length()<input2.length()) {
			System.out.println("No");
			return;
		}
		for(int i=0; i<=input1.length()-input2.length(); i++) {
			int index = i;
			for(int j=0; j<input2.length(); j++) {
				
				if(input1.charAt(index) == input2.charAt(j)) {
					if(j == input2.length()-1) {
						System.out.println("Yes");
						return;
					}
					if(index <input1.length()-1) {
						index++;
					}
					
				}else {
					
					break;
				}
			}
		}
		System.out.println("No");
	}

}

/*

input1 = I am Bharathi from chennai
input2 = am Bharathi

output = Yes

*/

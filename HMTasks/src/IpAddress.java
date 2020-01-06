import java.util.Scanner;

public class IpAddress {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter IP address:");
		String[] ipArray = sc.nextLine().split("\\.");
		sc.close();
		IpAddress ip = new IpAddress();
		ip.validating(ipArray);

	}

	private void validating(String[] ipArray) {
		if(ipArray.length > 4) {
			System.out.println("Invalid IP!");
			return;
		}
		for(int i=0; i<4; i++) {
			try {
				int temp = Integer.parseInt(ipArray[i]);
				if(temp<0 || temp>255) {
					System.out.println("Invalid IP!");
					return;
				}
			}catch(Exception e) {
				System.out.println("Invalid IP!");
				return;
			}
		}
		System.out.println("Valid IP!");
	}

}
/*
 * input = 106.51.1.63
 * output = Valid IP!
 * 
 * input = 106.51.1.263
 * output = invalid IP!
 * 
 */ 

import java.util.Scanner;

public class FindingSubArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the length of an array:");
		int arrLength = sc.nextInt();
		System.out.println("Enter the array elements:");
		int[] inputArray = new int[arrLength];
		for(int i=0; i<arrLength; i++) {
			inputArray[i] = sc.nextInt();
		}
		System.out.println("Enter the number to check:");
		int numberToCheck = sc.nextInt();
		sc.close();
		FindingSubArray fs = new FindingSubArray();
		fs.finding(inputArray, numberToCheck);
	}

	private void finding(int[] inputArray, int numberToCheck) {
		int check = 0;
		for(int i=0; i<inputArray.length; i++) {
			int sum = inputArray[i];
			if(sum == numberToCheck) {
				System.out.print(inputArray[i]);
				break;
			}else if(sum > numberToCheck) {
				continue;
			}
			for(int j=i+1; j<inputArray.length; j++) {
				sum = sum + inputArray[j];
				if(sum == numberToCheck) {
					check = 1;
					System.out.println("The sub array is: ");
					for(int k=i; k<=j; k++) {
						System.out.print(inputArray[k] + " ");
					}
					return;
				}else if(sum > numberToCheck) {
					break;
				}
			}
		}
		if(check == 0) {
			System.out.println("Can't find subarray!");
		}
	}

}

/*
 * input = 4 5 8 9 23 6 8 2 1
 * 		   11
 * output = 8 2 1
 * 
 * input = 6 8 2 1
 * 		   9
 * output = Can't find subarray!
 */

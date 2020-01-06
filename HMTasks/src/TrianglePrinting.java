import java.util.Scanner;

public class TrianglePrinting {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number: ");
		int num = sc.nextInt();
		TrianglePrinting tp = new TrianglePrinting();
		tp.print(num);
	}

	private void print(int num) {
		System.out.println("Output: \n");
		for(int i=num; i>=0; i--) {
			for(int j=i; j>0; j--) {
				System.out.print("  ");
			}
			for(int j=i; j<num; j++) {
				System.out.print(j + " ");
			}
			for(int j=num; j>=i; j--) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}

}

/*
   input = 9
   
   output = 
			                  9 
			                8 9 8 
			              7 8 9 8 7 
			            6 7 8 9 8 7 6 
			          5 6 7 8 9 8 7 6 5 
			        4 5 6 7 8 9 8 7 6 5 4 
			      3 4 5 6 7 8 9 8 7 6 5 4 3 
			    2 3 4 5 6 7 8 9 8 7 6 5 4 3 2 
			  1 2 3 4 5 6 7 8 9 8 7 6 5 4 3 2 1 
			0 1 2 3 4 5 6 7 8 9 8 7 6 5 4 3 2 1 0
 */


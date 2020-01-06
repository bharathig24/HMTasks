package studentRecord;

import java.util.Scanner;

public class StudentsData {

	public static void main(String[] args) {
		
	}
	
	public void getInput() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the details");
		System.out.println("Name: ");
		String name = sc.nextLine();
		System.out.println("Department: ");
		String dept = sc.nextLine();
//		System.out.println("Number of subjects:");
//		int subCount = sc.nextInt();
		System.out.println("Enter all subjects with space:");
//		for(int i=0; i<subCount; i++) {
//			
//		}
		String[] subjects = sc.nextLine().split(" ");
		int[] marks = new int[subjects.length];
		System.out.println("Enter the marks: ");
		for(int i=0; i<subjects.length; i++) {
			marks[i] = sc.nextInt();
		}
		calculation(marks, subjects.length);
	}
	
	public void calculation(int[] marks, int totalSub) {
		//total 
		int total = 0;
		double percent;
		for(int i=0; i<marks.length; i++) {
			total += marks[i];
		}
		
		//percentage
		percent = total/(100*totalSub);
	}

}

import java.util.ArrayList;
import java.util.Scanner;

public class MagicSquare2 {
	
	static int[][] matrix;
	ArrayList<String> position = new ArrayList<String>();
	static int num;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MagicSquare2 ms = new MagicSquare2();
		System.out.println("Enter the row of the box:");
		num = sc.nextInt();
		sc.close();
		matrix = new int[num][num];
		
		if(num < 3) {
			System.out.println("\nOutput:\n\nWe can't make magic square for " + num + " x " + num);
		}else {
			if(num%2 == 1) {
				ms.forOdd(0, num-1, 0, num-1, num/2, num-1, 1, num*num, (num/4)-1);
			}else if(num%4 == 0) {
				ms.forDoublyEven(num/4);
			}else {
				ms.forSinglyEven((num/4)-1);
			}
			ms.output(num);
		}

	}

	private void forOdd(int rowStart, int rowEnd, int colStart, int colEnd, int row, int col, int startNum, int endNum, int swapCol) {
		for(int i=startNum; i<=endNum; i++) {
			
			if(position.contains(row+" "+col)) {
				if(rowEnd == num-1) {
					matrix[row++ - (num/2)][col++] = i;
				}else {
					matrix[row++ + (num/2)][col++] = i;
				}
			}else {
				matrix[row++][col++] = i;
			}
			
			if((row > rowEnd  && col > colEnd)) {
				row--;
				col=col-2;
			}else {
				if(row > rowEnd) {
					row = rowStart;
				}else if(col > colEnd) {
					col = colStart;
				}
			}
			
			if(position.contains(row+" "+col)) {
				if(rowEnd == num-1) {
					if(matrix[row-(num/2)][col] != 0) {
						row--;
						col=col-2;
					}
				}else {
					if(matrix[row+(num/2)][col] != 0) {
						row--;
						col=col-2;
					}
				}
				
			}else {
				if(matrix[row][col] != 0) {
					row--;
					col=col-2;
				}
			}
		}
	}

	private void forDoublyEven(int subNum) {
		
		for(int row=0; row<num; row++) {
			for(int col=0; col<num; col++) {
				if((col<subNum && row<subNum) || (col>num-subNum-1 && row>num-subNum-1) || (col<subNum && row>num-subNum-1) || 
						(col>num-subNum-1 && row<subNum) || (col>=subNum && col<=num-subNum-1 && row>=subNum && row<=num-subNum-1)) {
					position.add(row+" "+col);
					System.out.print(row+""+col+ " ");
				}
			}
		}
		
		int row = 0, col = 0;
		for(int i=1; i<=num*num; i++) {
			if(position.contains(row+" "+col)) {
				matrix[row][col] = i;
			}else {
				matrix[row][col] = (num*num)-i+1;
			}
			
			col++;
			if(col == num) {
				col = 0;
				row++;
			}
		}
	}
	private void forSinglyEven(int swapCol) {
		
		for(int i=0; i<num; i++) {
			for(int j=0; j<swapCol+1; j++) {
				if((i==num/4 || i==num-(num/4)-1) && j==0) {
					position.add(i+" "+(j+swapCol+1));
				}else {
					position.add(i+" "+j);
				}
			}
		}
		
		for(int i=0; i<num; i++) {
			for(int j=num-swapCol; j<num; j++) {
				position.add(i+" "+j);
			}
		}
		// rowStart, rowEnd, colStart, colEnd, row, col, startNum, endNum
				
		forOdd(0, (num/2)-1, 0, (num/2)-1, num/4, (num/2)-1, 1, (num*num)/4, swapCol);						//1
		
		forOdd(num/2, num-1, num/2, num-1, num-(num/4)-1, num-1, ((num*num)/4)+1, (num*num)/2, swapCol);		//2
		
		forOdd(0, (num/2)-1, num/2, num-1, num/4, num-1, (num*num)/2+1, (num*num*3)/4, swapCol);				//3
		
		forOdd(num/2, num-1, 0, num/2-1, num-(num/4)-1, num/2-1, (num*num*3)/4+1, num*num, swapCol);			//4
	}

	private void output(int num) {
		System.out.println("\noutput:\n");
		for(int i=0; i<num; i++) {
			for(int j=0; j<num; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println("\n");
		}
	}

}

/*	
input = 2

output = We can't make magic square for 2 x 2


input = 3

output = 4 3 8
 
	     9 5 1 
	     
         2 7 6 
         
         
input = 4

output = 1 15 14 4

	     12 6 7 9 
	     
	     8 10 11 5 
	     
	     13 3 2 16 


input = 6

output = 31 3 8 22 21 26 

	     9 32 1 27 23 19 

	     29 7 6 20 25 24 

		 4 30 35 13 12 17 

		 36 5 28 18 14 10 

		 2 34 33 11 16 15 
*/
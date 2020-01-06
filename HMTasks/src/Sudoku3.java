import java.util.ArrayList;
import java.util.Scanner;

public class Sudoku3 {
	
	ArrayList<ArrayList<Integer>> posibleNum = new ArrayList<ArrayList<Integer>>();
	static int matrix[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		matrix = new int[9][9];
		for(int i=0; i<9; i++) {
//			System.out.println("Enter the elements of row "+ (i+1));
			for(int j=0; j<9; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		sc.close();
		Sudoku3 s = new Sudoku3();
		s.findPosibleNumber();
	}
	private void findPosibleNumber() {
		int num = 0;
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
//				for(int k = 1; k<=9; k++) {
					if(matrix[i][j] != 0) {
						posibleNum.add(new ArrayList<Integer>());
						posibleNum.get(num).add(matrix[i][j]);
						System.out.println(posibleNum);
						num++;
					}else {
						for(int k=1; k<=9; k++) {
							pushPosibleNumber(i,j,k);
						}
					}
//				}	
			}
		}
	}
	private void pushPosibleNumber(int row, int col, int checkNum) {
		int startRow = row - row % 3, startCol = col - col % 3;
		
		//check row
		for(int i=0; i<9; i++) {
			if(matrix[row][i] == checkNum) {
				return;
			}
		}
		
		//check col
		for(int i=0; i<9; i++) {
			if(matrix[i][col] == checkNum) {
				return;
			}
		}
		
		//sub matrix check
		for(int i=startRow; i<startRow+3; i++) {
			for(int j=startCol; j<startCol+3; j++) {
				if(matrix[i][j]==checkNum) {
					return;
				}
			}
		}
		
		
	}

}

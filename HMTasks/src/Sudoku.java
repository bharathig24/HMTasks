import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Sudoku {

	HashMap<Integer, HashMap<String, ArrayList<Integer>>> positionList = new HashMap<Integer, HashMap<String, ArrayList<Integer>>>();
	static int[][] matrix; 
	
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
		Sudoku s = new Sudoku();
		s.pushPos(matrix);
		s.fillNum();
		s.output();
	}

	private void pushPos(int[][] matrix) {
		for(int n=1; n<=9; n++) {
			positionList.put(n, new HashMap());
			positionList.get(n).put("row",new ArrayList());
			positionList.get(n).put("col",new ArrayList());
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					if(matrix[i][j] == n) {
						positionList.get(n).get("row").add(i);
						positionList.get(n).get("col").add(j);
					}
				}
			}
		}
		System.out.println(positionList);
	}
	
	public void fillNum() {
		int row = 2, col = 2, tempRow = 0, tempCol = 0, count = 0, ex = 0;
		boolean check = false;
//		for(int k=0; k<9; k++) {
			for(int n=1; n<=9; n++) {
//				System.out.print(k + " ");
				if(n%3==1 && n!=1) {
					row = row+3;
					col = 2;
				}
	//			System.out.print(row + "" +col + " ");
				for(int l=row-2; l<=row; l++) {
					for(int m=col-2; m<=col; m++) {
						if(matrix[l][m] == n) {
							check = true;
							System.out.println(n+ " " +matrix[l][m]);
						}
					}
				}
				if(check == false) {
					for(int i=row-2; i<=row; i++) {
						for(int j=col-2; j<=col; j++) {
							if(matrix[i][j] == 0 && !positionList.get(n).get("row").contains(i) && !positionList.get(n).get("col").contains(j)) {
								count++;
								tempRow = i;
								tempCol = j;
								System.out.println(n+" "+count + " " + i+j);
							}
						}
					}
				}
				
				System.out.println();
				if(count == 1) {
					matrix[tempRow][tempCol] = n;
					positionList.get(n).get("row").add(tempRow);
					positionList.get(n).get("col").add(tempCol);
				}
				col = col + 3;
				count = 0;
				check=false;
			}
//			row=col=2;
//		}
//		for(int i=0; i<9; i++) {
//			for(int j=0; j<9; j++) {
//				if(matrix[i][j]==0) {
//					fillNum();
//					return;
//				}
//			}
//		}
	}

	private void output() {
		System.out.println();
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}


}

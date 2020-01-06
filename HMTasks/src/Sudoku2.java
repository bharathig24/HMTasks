import java.util.Scanner;

public class Sudoku2 { 
	
	static int[][] matrix;
	public static void main(String args[]) { 
		Scanner sc = new Scanner(System.in);
		matrix = new int[9][9];
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		sc.close();
	    int N = matrix.length;
	    Sudoku2 s = new Sudoku2();
		s.solveSudoku(N);
	    s.print(N); 
	}
	
	public boolean solveSudoku(int N) { 
	    int row = -1; 
	    int col = -1; 
	    boolean isEmpty = true; 
	    for (int i = 0; i < N; i++) { 
	        for (int j = 0; j < N; j++) { 
	            if (matrix[i][j] == 0) { 
	                row = i; 
	                col = j; 
	                isEmpty = false;  
	                break; 
	            } 
	        } 
	        if (!isEmpty) { 
	            break; 
	        } 
	    } 
	  
	    if (isEmpty) { 
	        return true; 
	    } 
	   
	    for (int num = 1; num <= N; num++) { 
	        if (isSafe(row, col, num)) { 
	            matrix[row][col] = num; 
	            if (solveSudoku(N)) { 
	                return true; 
	            } else { 
	                matrix[row][col] = 0; 
	            } 
	        } 
	    } 
	    return false; 
	} 
	
public boolean isSafe(int row, int col, int num) {
	//row check
    for (int i = 0; i < matrix.length; i++) { 
        if (matrix[row][i] == num) { 
            return false; 
        } 
    } 
    //col check
    for (int i = 0; i < matrix.length; i++) { 
        if (matrix[i][col] == num) { 
            return false; 
        } 
    } 
    
    int sqrt = (int) Math.sqrt(matrix.length); 
    int boxRowStart = row - row % sqrt; 
    int boxColStart = col - col % sqrt; 
  //submatrix check
    for (int i = boxRowStart; i < boxRowStart + sqrt; i++) { 
        for (int j = boxColStart; j < boxColStart + sqrt; j++) { 
            if (matrix[i][j] == num) { 
                return false; 
            } 
        } 
    }  
    return true; 
} 
  
public void print(int N) { 
    for (int i = 0; i < N; i++) { 
        for (int j = 0; j < N; j++) { 
            System.out.print(matrix[i][j] + " "); 
        } 
        System.out.println(); 
    } 
} 
 
} 

/*
	input = 
			5 0 2 0 3 0 0 0 0
			9 0 0 0 0 7 1 5 8 
			6 1 0 8 0 0 2 9 3 
			0 5 0 7 8 0 0 0 0 
			0 0 0 4 6 0 3 0 0 
			0 0 3 1 0 9 7 2 6 
			0 0 0 0 1 4 5 0 0 
			0 0 5 0 7 8 9 0 0 
			3 0 0 0 0 0 8 0 7 
			
	output = 
			5 8 2 9 3 1 6 7 4 
			9 3 4 6 2 7 1 5 8 
			6 1 7 8 4 5 2 9 3 
			2 5 6 7 8 3 4 1 9 
			1 7 9 4 6 2 3 8 5 
			8 4 3 1 5 9 7 2 6 
			7 9 8 3 1 4 5 6 2 
			4 6 5 2 7 8 9 3 1 
			3 2 1 5 9 6 8 4 7 
 */

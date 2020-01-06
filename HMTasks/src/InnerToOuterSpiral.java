
import java.util.Scanner;

public class InnerToOuterSpiral {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the row count:");
		int rowCount = sc.nextInt();
		System.out.println("Enter the column count:");
		int columnCount = sc.nextInt();
		int[][] matrix = new int[rowCount][columnCount];
		System.out.println("Enter the elements of the matrix:");
		for(int i=0; i<rowCount; i++) {
			for(int j=0; j<columnCount; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		sc.close();
		InnerToOuterSpiral sp = new InnerToOuterSpiral();
		sp.spiralPrinting(matrix, rowCount, columnCount);

	}

	private void spiralPrinting(int[][] matrix, int rowCount, int columnCount) {
		int[] spiral = new int[rowCount*columnCount];
		int spiralIndex = 0;
		int row = 0, col = 0;
		
		while(rowCount > 0) {
			if(rowCount==1){
                for(int i=0; i<columnCount; i++){
                	spiral[spiralIndex++] = matrix[row][col++];
                }break;
            }else {
            	for(int i=0; i<rowCount-1; i++) {
            		spiral[spiralIndex++] = matrix[row][col++];
            	}
            	for(int i=0; i<columnCount-1; i++) {
            		spiral[spiralIndex++] = matrix[row++][col];
            	}
            	for(int i=0; i<rowCount-1; i++) {
            		spiral[spiralIndex++] = matrix[row][col--];
            	}
            	for(int i=0; i<columnCount-1; i++) {
            		spiral[spiralIndex++] = matrix[row--][col];
            	}
            	row++;
            	col++;
            	rowCount = rowCount -2;
            	columnCount = columnCount -2;
            }
		}
		for(int i=spiral.length-1; i>=0; i--) {
			System.out.print(spiral[i] + " ");
		}
	}

}

/*
 * input = 3
 * 		   3
 * 		   1 2 3
 * 		   4 5 6
 * 		   7 8 9
 * 
 * output = 5 4 7 8 9 6 3 2 1 
 */

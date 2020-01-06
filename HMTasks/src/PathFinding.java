
public class PathFinding {
	
	static int[][] matrixOutput = new int[10][10];
	final int[][] matrixInput = 
		{
				{0,0,0,0,0,0,0,1,0,0},
				{1,1,0,1,1,0,1,1,1,0},
				{0,1,0,1,0,0,1,0,0,0},
				{0,1,1,1,1,1,1,0,1,1},
				{0,1,0,0,0,0,1,0,1,0},
				{0,0,0,1,1,1,1,0,1,0},
				{1,0,0,1,0,0,0,1,1,0},
				{0,1,1,1,1,0,1,1,0,0},
				{0,1,0,0,1,1,1,0,0,0},
				{0,1,1,1,0,0,0,0,0,0}
	};
	static boolean isEnter = true;
	static int check = 1;
	public static void main(String[] args) {
		
		PathFinding pf = new PathFinding();
		pf.findEntrance(10, 10);
		pf.print();
	}
	private void findEntrance(int rowSize, int colSize) {
		for(int i=0; i<8; i++) {
			if(matrixInput[i][0] == 1) {
				matrixOutput[i][0] = 1;
				if(findPath(i, 0, -1, -1)) {
					break;
				}else {
					matrixOutput[i][0] = 0;
				}
			}
		}
	}
	private boolean findPath(int row, int col, int preRow, int preCol) {
		//top
		if(row != 0 && matrixInput[row-1][col] == 1 && row-1 != preRow) {
			matrixOutput[row-1][col] = 1;
			if(findPath(row-1, col, row, col)) {
				return true;
			}else {
				matrixOutput[row-1][col] = 0;
			}
		}
		//right
		if(matrixInput[row][col+1] == 1 && col+1 != preCol) {
			matrixOutput[row][col+1] = 1;
			if(col+1 == 9) {
				return true;
			}else if(findPath(row, col+1,row, col )) {
				return true;
			}else {
				matrixOutput[row][col+1] = 0;
			}
		}
		//down
		if(row != 9 && matrixInput[row+1][col] == 1 && row+1 != preRow) {
			matrixOutput[row+1][col] = 1;
			if(findPath(row+1, col, row, col)) {
				return true;
			}else {
				matrixOutput[row+1][col] = 0;
			}
		}
		//left
		if(col != 0 && matrixInput[row][col-1] == 1 && col-1 != preCol) {
			matrixOutput[row][col-1] = 1;
			if(findPath(row, col-1, row, col)) {
				return true;
			}else {
				matrixOutput[row][col-1] = 0;
			}
		}
		return false;
	}
	
	public void print() {
		System.out.println("Output:\n");
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				System.out.print(matrixOutput[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}

/*
 	input = 	 0 0 0 0 0 0 0 1 0 0
				 1 1 0 1 1 0 1 1 1 0
				 0 1 0 1 0 0 1 0 0 0
				 0 1 1 1 1 1 1 0 1 1
				 0 1 0 0 0 0 1 0 1 0
				 0 1 0 1 1 1 1 0 1 0
				 1 0 0 1 0 0 0 1 1 0
				 0 1 1 1 1 0 1 1 0 0
				 0 1 0 0 1 1 1 0 0 0
				 0 1 1 1 0 0 0 0 0 0
				 
	output =	 0 0 0 0 0 0 0 0 0 0
				 1 1 0 0 0 0 0 0 0 0
				 0 1 0 0 0 0 0 0 0 0
				 0 1 1 1 1 1 1 0 1 1
				 0 0 0 0 0 0 1 0 1 0
				 0 0 0 1 1 1 1 0 1 0
				 0 0 0 1 0 0 0 1 1 0
				 0 0 0 1 1 0 1 1 0 0
				 0 0 0 0 1 1 1 0 0 0
				 0 0 0 0 0 0 0 0 0 0
 */



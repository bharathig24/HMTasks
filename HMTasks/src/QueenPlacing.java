
public class QueenPlacing {

	static int matrix[][] = new int[8][8];
	int count = 0;
	
	public static void main(String[] args) {
		QueenPlacing qp = new QueenPlacing();
		qp.find();
		qp.print();
	}

	private boolean find() {
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				if(matrix[i][j] == 0 && eligibilityCheck(i, j)) {
					matrix[i][j] = 1;
					count++;
					if(count <= 8) {
						if(find()||count == 8) {
							return true;
						}else {
							matrix[i][j] = 0;
							count--;
						}
					}
				}
			}
		}
		
		return false;
	}

	private boolean eligibilityCheck(int row, int col) {
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				if(matrix[i][j] == 1) {
					//row and col check
					if(i == row || j == col) {
						return false;
					}
					//cross check
					else if(Math.abs(i-row) == Math.abs(j-col)) {
						return false;
					}
				}
			}
		}
		
		return true;
	}
	
	private void print() {
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}

/*
    output =
    		1 0 0 0 0 0 0 0
 			0 0 0 0 1 0 0 0 
			0 0 0 0 0 0 0 1 
			0 0 0 0 0 1 0 0 
			0 0 1 0 0 0 0 0 
			0 0 0 0 0 0 1 0 
			0 1 0 0 0 0 0 0 
			0 0 0 1 0 0 0 0 
 */

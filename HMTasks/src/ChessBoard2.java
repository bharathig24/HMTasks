import java.util.Scanner;

public class ChessBoard2 {

	public static void main(String[] args) {
		ChessBoard2 cb = new ChessBoard2();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the position of Queen:");
		String queenPos = sc.nextLine();
		System.out.println("Enter the position of Knight:");
		String knightPos = sc.nextLine();
		sc.close();
		cb.findPosition(queenPos, knightPos);
	}
	
public void findPosition(String queenPos, String knightPos) {
		
		if(queenPos.length() != 2 || knightPos.length() != 2 || queenPos.equals(knightPos)) {
			System.out.println("Invalid positions!");
			return;
		}
		
		char[] columnArray = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
		int queenCol = 0, queenRow = 0, knightCol = 0, knightRow = 0; 
		
		for(int i=0; i<8; i++) {
			if(queenPos.charAt(0) == columnArray[i]) {
				queenCol = i;
			}
			if(knightPos.charAt(0) == columnArray[i]) {
				knightCol = i;
			}
		}
		
		queenRow = Math.abs(Integer.parseInt(queenPos.substring(1)) - 8);
		knightRow = Math.abs(Integer.parseInt(knightPos.substring(1)) - 8);
		if(Math.abs(queenCol - knightCol) != 1 || Math.abs(queenRow - knightRow) != 1) {
			if(checkQueen(queenCol, queenRow, knightCol, knightRow) == false) {
				checkKnight(queenCol, queenRow, knightCol, knightRow);
			}
		}else {
			System.out.println("Queen can cut the Knight!");
		}
	}


private boolean checkQueen(int queenCol, int queenRow, int knightCol, int knightRow) {
	if(queenCol == knightCol || queenRow == knightRow) {
		System.out.println("Queen can cut Knight!");
		return true;
	}
	
	for(int i=0; i<4; i++) {
		int tempCol = queenCol, tempRow = queenRow;
		while(tempCol <= 7 && tempCol >= 0 && tempRow >= 0 && tempRow <= 7) {
			if(i == 0) {
				tempRow--;
				tempCol++;
			}else if(i == 1) {
				tempRow--;
				tempCol--;
			}else if(i == 2) {
				tempRow++;
				tempCol--;
			}else if(i == 3) {
				tempRow++; 
				tempCol++;
			}
			
			if(tempRow == knightRow && tempCol == knightCol) {
				System.out.println("Queen can cut Knight!");
				return true;
			}
		}
	}
	return false;
}

private void checkKnight(int queenCol, int queenRow, int knightCol, int knightRow) {
	if(Math.abs(queenCol - knightCol) > 2 || Math.abs(queenRow - knightRow) > 2) {
		System.out.println("They are not cut each other!");
		return;
	}else {
		System.out.println("Knight can cut Queen!");
	}
}

}

/*
 * input = Enter the position of Queen:
 *         e6
 *		   Enter the position of Knight:
 *		   d4
 *
 * output = Knight can cut Queen!
 *
 * input = Enter the position of Queen:
 *         f8
 *		   Enter the position of Knight:
 *		   d4
 *
 * output = They are not cut each other!
 * 
 * input = Enter the position of Queen:
 *         h8
 *		   Enter the position of Knight:
 *		   d4
 * output = Queen can cut Knight!
 */



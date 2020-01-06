import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class ChessBoard {

	HashSet<String> queenPath = new HashSet<String>();
	ArrayList<String> knightPath = new ArrayList<String>();
	
	public static void main(String[] args) {
		ChessBoard cb = new ChessBoard();
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
		int queenCol = 0, queenRow, knightCol = 0, knightRow; 
		
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
		findQueenPath(queenCol, queenRow);
		findKnightPath(knightCol, knightRow);
		result(queenCol, queenRow, knightCol, knightRow);
	}
	
	public void findQueenPath(int queenCol, int queenRow) {
		
		int tempCol = 0, tempRow = 0;
		
		for(int i=0; i<8; i++) {
			queenPath.add(queenRow + "" + i);
			queenPath.add(i + "" + queenCol);
		}
		
		for(int i=0; i<4; i++) {
			tempCol = queenCol;
			tempRow = queenRow;
			while(tempCol <= 7 && tempCol >= 0 && tempRow >= 0 && tempRow <= 7) {
				if(i == 0) {
					queenPath.add(tempRow-- + "" + tempCol++);
				}
				if(i == 1) {
					queenPath.add(tempRow-- + "" + tempCol--);
				}
				if(i == 2) {
					queenPath.add(tempRow++ + "" + tempCol--);
				}
				if(i == 3) {
					queenPath.add(tempRow++ + "" + tempCol++);
				}
			}
		}
	}

	public void findKnightPath(int knightCol, int knightRow) {
		knightPath.add(knightRow + "" + knightCol);
		knightPath.add((knightRow-2) + "" + (knightCol-1));
		knightPath.add((knightRow-2) + "" + (knightCol+1));
		knightPath.add((knightRow+2) + "" + (knightCol-1));
		knightPath.add((knightRow+2) + "" + (knightCol+1));
		knightPath.add((knightRow-1) + "" + (knightCol-2));
		knightPath.add((knightRow+1) + "" + (knightCol-2));
		knightPath.add((knightRow-1) + "" + (knightCol+2));
		knightPath.add((knightRow+1) + "" + (knightCol+2));
	}

	public void result(int queenCol, int queenRow, int knightCol, int knightRow) {
		for(String s : queenPath) {
			if(s.contentEquals(knightRow + "" + knightCol)) {
				System.out.println("Queen can cut Knight!");
				break;
			}
		}
		for(String s : knightPath) {
			if(s.contentEquals(queenRow + "" + queenCol)) {
				System.out.println("Knight can cut Queen!");
				break;
			}
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


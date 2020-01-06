import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class GroupingAnagram {
	
	static ArrayList<String> inputWords = new ArrayList<String>();
	static HashSet<String> anagramWords = new HashSet<String>();
	
	public static void main(String[] args) {
		GroupingAnagram ga = new GroupingAnagram();
		Scanner sc = new Scanner(System.in);
		Collections.addAll(inputWords, sc.nextLine().toLowerCase().replaceAll("\\s", "A").replaceAll("\\W", "").replaceAll("A", " ").split(" "));
		sc.close();
		ga.removeDuplicates();
		ga.anagramFinding();
	}
	
	private void anagramFinding() {
		
		int check = 0;
		
		while(inputWords.size() != 0) {
			for(int i = 1 ; i < inputWords.size(); i++) {
				
				if(inputWords.get(0).length() != inputWords.get(i).length()) {
					continue;
				}else {
					char[] tempArrayFirst = inputWords.get(0).toCharArray();
					char[] tempArraySecond = inputWords.get(i).toCharArray();
					Arrays.sort(tempArrayFirst);
					Arrays.sort(tempArraySecond);
					
					if(Arrays.equals(tempArrayFirst, tempArraySecond)) {
						anagramWords.add(inputWords.get(0));
						anagramWords.add(inputWords.get(i));
						inputWords.remove(i);
						i--;
					}
				}
			}
			inputWords.remove(0);
			
			if(anagramWords.size() != 0) {
				check = 1;
				System.out.println(anagramWords);
				anagramWords.clear();
			}
		}
		
		if(check == 0) {
			System.out.println("Don't have anagram words");
		}
		
	}

	private void removeDuplicates() {
		for(int i=0; i<inputWords.size(); i++) {
			int tempIndex = inputWords.lastIndexOf(inputWords.get(i));
			if(i != tempIndex) {
				inputWords.remove(tempIndex);
				i--;
			}
		}
	}

}

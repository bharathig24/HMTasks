import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeMap;

public class FrequentWords {
	
	static ArrayList<String> paragraphWords = new ArrayList<String>();
	TreeMap<String, Integer> tmap = new TreeMap<String, Integer>(); 

	public static void main(String[] args) {
		FrequentWords fw = new FrequentWords();
		Scanner sc = new Scanner(System.in);
		Collections.addAll(paragraphWords, sc.nextLine().toLowerCase().replaceAll("\\s", "A").replaceAll("\\W", "").replaceAll("A", " ").split(" "));
		sc.close();
		fw.findingFrequency();
	}

	public void findingFrequency() {
		Collections.sort(paragraphWords);
		int count = 1;
		for(int i=0; i<paragraphWords.size(); i++) {
			for(int j=i+1; j<paragraphWords.size(); j++) {
				if(paragraphWords.get(i).equals(paragraphWords.get(j))) {
					count++;
				}else {
					tmap.put(paragraphWords.get(i), count);
					count = 1;
					i=j-1;
					break;
				}
			}
		}
		System.out.println(tmap);
		topFive();
	}

	public void topFive() {
		int max = Collections.max(tmap.values()), count = 0;
		while(count != 5) {
			for(String s : tmap.keySet()) {
				if(tmap.get(s) == max) {
					System.out.println(s + " ==> " + tmap.get(s));
					count++;
				}
				if(count == 5) {
					break;
				}
			}
			max--;
		}
	}

}

/*
 * input = Apple trees are cultivated worldwide and are the most widely grown species in the genus Malus. 
 *         The tree originated in Central Asia, where its wild ancestor, Malus sieversii, is still found today.
 * output = the ==> 3
 * 			are ==> 2
 * 			in ==> 2
 * 			malus ==> 2
 * 			ancestor ==> 1
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class WaterStorage {
	
	static ArrayList<Integer> pillar = new ArrayList<Integer>();
	static int unitCount = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the total count of inputs:");
		int inputCount = sc.nextInt();
		System.out.println("Enter the values:");
		for(int i=0; i<inputCount; i++) {
			pillar.add(sc.nextInt());
		}
		sc.close();
		WaterStorage ws = new WaterStorage();
		for(int i=0; i<inputCount; i++) {
			if(pillar.get(i) == 0) {
				pillar.remove(i);
			}else {
				ws.findCapacity();
				break;
			}
		}
	}
	private void findCapacity() {
		int maximum = Collections.max(pillar);
		int indexOfMax = pillar.indexOf(maximum);
		
		if(indexOfMax != 0) {
			for(int i=pillar.get(0)+1; i<=maximum; i++) {
				for(int j=1; j<=indexOfMax; j++) {
					if(i == pillar.get(j)) {
						unitCount = unitCount + (pillar.get(0)*(j-1));
						for(int k=1; k<j; k++) {
							unitCount = unitCount - pillar.get(k);
						}
						for(int k=0; k<j; k++) {
							pillar.remove(0);
						}
						findCapacity();
						return;
					}
				}
			}
		}else {
			for(int i=pillar.get(0); i>0; i--) {
				for(int j=1; j<pillar.size(); j++) {
					if(i == pillar.get(j)) {
						unitCount = unitCount + (i*(j-1));
						for(int k=1; k<j; k++) {
							unitCount = unitCount - pillar.get(k);
						}
						for(int k=0; k<j; k++) {
							pillar.remove(0);
						}
						findCapacity();
						return;
					}
				}
			}
		}
		System.out.println(unitCount + " unit water can store!");
	}

}

/*
 * input = 7 0 4 2 5 0 6 4 0 5
 * output = 25 unit water can store!
 * 
 * input = 0 4 2 5 0 6 4 0 5
 * output = 13 unit water can store!
 */


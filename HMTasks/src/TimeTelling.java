
import java.util.Scanner;

public class TimeTelling {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the time:");
		String time = sc.nextLine();
		sc.close();
		TimeTelling t = new TimeTelling();
		t.convert(time);
	}

	private void convert(String time) {
		
		String[] str = {"one", "two", "three", "four","five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve",  
                "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen","twenty", "thirty"};
		
		int hour = Integer.parseInt(time.substring(0, time.indexOf(':'))),
				minute = Integer.parseInt(time.substring(time.indexOf(':')+1));
		
		if(minute == 0) {
			System.out.println(str[hour-1] + " o'clock");
		}else if(minute == 15) {
			System.out.println("Quarter past " + str[hour-1]);
		}else if(minute < 30) {
			
			if(minute <= 20) {
				System.out.println(str[minute-1] + " past " + str[hour-1]);
			}else {
				System.out.println(str[19] + " " + str[minute - 21] + " past " + str[hour-1]);
			}
			
		}else if(minute == 30) {
			System.out.println("Half past " + str[hour-1]);
		}else if(minute == 45) {
			System.out.println("Quarter to " + str[hour]);
		}else {
			
			if(60 - minute <= 20) {
				System.out.println(str[60 - minute - 1] + " to " + str[hour]);
			}else {
				System.out.println(str[19] + " " + str[60 - minute -21] +" to " + str[hour]);
			}
			
		}
	}

}

/*  input = Enter the time: 4:00
    output = four o'clock
    
	input = Enter the time: 4:15
	output = Quarter past four
	
	input = Enter the time: 4:30
	output = Half past four
	
	input = Enter the time: 4:23
	output = twenty three past four
	
	input = Enter the time:	4:14
	output = fourteen past four
	
	input = Enter the time:	4:45
	output = Quarter to five
	
	input = Enter the time:	4:37
	output = twenty three to five
	
	input = Enter the time:	4:58
	output = two to five
*/
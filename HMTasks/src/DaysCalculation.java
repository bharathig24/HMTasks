
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Scanner;

public class DaysCalculation {
	
	static HashMap<Integer, Integer> monthArray = new HashMap<Integer, Integer>();

	public static void main(String[] args) {
		
		LocalDate localDate = LocalDate.now();
		String presentDate = DateTimeFormatter.ofPattern("dd-MM-yyyy").format(localDate);
		DaysCalculation dc = new DaysCalculation();
		System.out.println("Present date: " + presentDate);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the date in the format of \"DD-MM-YYYY\":");
		String userInputDate = sc.nextLine();
		sc.close();
		
		monthArray.put(1, 31);
		monthArray.put(2, 28);
		monthArray.put(3, 31);
		monthArray.put(4, 30);
		monthArray.put(5, 31);
		monthArray.put(6, 30);
		monthArray.put(7, 31);
		monthArray.put(8, 31);
		monthArray.put(9, 30);
		monthArray.put(10, 31);
		monthArray.put(11, 30);
		monthArray.put(12, 31);
		
		dc.validating(userInputDate, presentDate);
	}

	private void validating(String userInputDate, String presentDate) {
		
		if(userInputDate.length() != 10) {
			System.out.println("Format of date is wrong!");
			return;
		}
		int userDate = Integer.parseInt(userInputDate.substring(0,2)),
				userMonth = Integer.parseInt(userInputDate.substring(3,5)),
				userYear = Integer.parseInt(userInputDate.substring(6)),
				currentDate = Integer.parseInt(presentDate.substring(0,2)),
				currentMonth = Integer.parseInt(presentDate.substring(3,5)),
				currentYear = Integer.parseInt(presentDate.substring(6));
		
		if(userMonth > 12 || monthArray.get(userMonth) < userDate) {
			System.out.println("wrong input");
			return;
		}
		countingDays(userDate, userMonth, userYear, currentDate, currentMonth, currentYear);		
	}
	
	public void countingDays(int userDate, int userMonth, int userYear, int currentDate, int currentMonth, int currentYear) {
		
		int daysCount = 0;
		daysCount = daysCount + (365*(userYear - currentYear - 1));
		for(int i=currentMonth+1; i<=12; i++) {
			daysCount = daysCount + monthArray.get(i);
		}
		for(int i=1; i<userMonth; i++) {
			daysCount = daysCount + monthArray.get(i);
		}
		daysCount = daysCount + monthArray.get(currentMonth) - currentDate + userDate;
		for(int i=currentYear; i<=userYear; i++) {
			if(checkLeapYear(i)) {
				if(i == currentYear) {
					if(currentMonth > 1) {
						daysCount++;
					}
				}else if(i == userYear) {
					if(userMonth > 2) {
						daysCount++;
					}
				}else {
					daysCount++;
				}
			}
		}
		System.out.println(daysCount);
	}

	public boolean checkLeapYear(int year) {
		return year%400 == 0 || (year%4 == 0 && year%100 != 0);
	}

}

/*
 * input = 13-02-2020
 * 
 * output = 70
 * 
 * input = 24-13-2020
 * 
 * output = Wrong input
 * 
 * input = 13-2-2020
 * 
 * output = Format of date is wrong!
 */

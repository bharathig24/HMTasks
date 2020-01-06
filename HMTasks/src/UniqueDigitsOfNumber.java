import java.util.HashSet;
import java.util.Scanner;

public class UniqueDigitsOfNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the starting number:");
		int firstNumber = sc.nextInt();
		System.out.println("Enter the ending number:");
		int secondNumber = sc.nextInt();
		sc.close();
		UniqueDigitsOfNumber u = new UniqueDigitsOfNumber();
		u.findNumbers(firstNumber, secondNumber);
	}

	private void findNumbers(int firstNumber, int secondNumber) {
		HashSet<Integer> hset = new HashSet<Integer>();
		for(int i=firstNumber; i<=secondNumber; i++) {
			int num = i, len = Integer.toString(i).length();
			while(num != 0) {
				hset.add(num%10);
				num = num/10;
			}
			if(len == hset.size()) {
				System.out.print(i + " ");
			}
			hset.clear();
		}
	}

}
/* input = Enter the starting number: 2000
		   Enter the ending number: 2100
   output = 2013 2014 2015 2016 2017 2018 2019 2031 2034 2035 2036 2037 2038 2039 
   			2041 2043 2045 2046 2047 2048 2049 2051 2053 2054 2056 2057 2058 2059 
   			2061 2063 2064 2065 2067 2068 2069 2071 2073 2074 2075 2076 2078 2079 
   			2081 2083 2084 2085 2086 2087 2089 2091 2093 2094 2095 2096 2097 2098 
*/
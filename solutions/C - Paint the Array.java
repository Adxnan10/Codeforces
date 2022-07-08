import java.util.Scanner;
import java.util.ArrayList;


public class PaintTheArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// read input
		Scanner input = new Scanner(System.in);
		input.nextLine(); // Number of cases, not needed since i will use while loop
		while (input.hasNext()) { // for each case:
			int length = Integer.parseInt(input.nextLine());
			// To obtain d, I should find the GCD of both the numbers in odd positions 
			// and the numbers in even positions. 
			// Then check if either GCD(odd/even) is not a divisible of any number of the other array(even/odd).
			// if true then display that GCD. Otherwise, display 0.
			ArrayList<Long> odds = new ArrayList<>();
			ArrayList<Long> evens = new ArrayList<>();
			
			for (int i = 0; i < length; i++) {
				if (i % 2 == 0)
					evens.add(input.nextLong());
				else
					odds.add(input.nextLong());
			}
			
			long oddNumbersGCD = findGCD(odds);
			long evenNumbersGCD = findGCD(evens);
			boolean stop = false;
			boolean d = true;
			for (int i = 0; i < evens.size() && !stop; i++)
				if (evens.get(i) % oddNumbersGCD == 0) {
					stop = true;
					d = false;
				}
			if (d)
				System.out.println(oddNumbersGCD);
			else {
				stop = false;
				d = true;
				for (int i = 0; i < odds.size() && !stop; i++)
					if (odds.get(i) % evenNumbersGCD == 0) {
						stop = true;
						d = false;
					}
				if (d)
				  System.out.println(evenNumbersGCD);
				else 
				  System.out.println(0);
			}
			input.nextLine();
		}
	}

	static long findGCD(ArrayList<Long> array) {
		long result = 0;
		for (long element : array) {
			result = gcd(result, element);

			if (result == 1) {
				return 1;
			}
		}

		return result;
	}

	static long gcd(long a, long b) {
		if (a == 0)
			return b;
		return gcd(b % a, a);
	}

}

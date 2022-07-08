import java.util.Scanner;
import java.util.Arrays;

public class ChessTourney {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = 2 * Integer.parseInt(input.nextLine()); // Number of players + 1, the one is to make the index start from 1
		int[] ranks = new int[n];
		for (int i = 0; i < n; i++)
			ranks[i] = input.nextInt();
		Arrays.sort(ranks);
		for(int i = 0, j = n - 1; i < n/2; i++, j--) { // Since teams will always have an even number of players, the middle element will be n/2
			if (ranks[j] <= ranks[i]) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
			
	}

}

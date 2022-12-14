import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		String[][] list = new String[N][2];

		for (int i = 0; i < N; i++) {
			list[i][0] = sc.next();
			list[i][1] = sc.next();
		}
		
		Arrays.sort(list, new Comparator<String[]>() {
			public int compare(String[] s1, String[] s2) {
				return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
			}
			
		});

		
		for (int i = 0; i < N; i++) {
			System.out.println(list[i][0] + " " + list[i][1]);
		}

	}

}

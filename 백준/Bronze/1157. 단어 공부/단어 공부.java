import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String st = sc.next();

		int list[] = new int[26];

		for (int i = 0; i < st.length(); i++) {
			int n = st.charAt(i);

			if (97 <= n && n <= 122) {
				list[n - 'a']++;
			} else {
				list[n - 'A']++;
			}
		}

		int max = 0;

		for (int i = 0; i < list.length; i++) {
			max = Math.max(max, list[i]);
		}

		int cnt = 0;
		int temp = 0;
		for (int i = 0; i < list.length; i++) {
			if (max == list[i]) {
				temp = i;
				cnt++;
			}
		}

		if (cnt == 1) {
			System.out.println((char) (65 + temp));
		} else {
			System.out.println("?");
		}

	}

}

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {
			String s = sc.next();
			boolean check = false;
			Stack<Character> st = new Stack<Character>();

			if (s.charAt(0) == ')') {
				System.out.println("NO");
				continue;
			}

			for (int j = 0; j < s.length(); j++) {
				char c = s.charAt(j);

				if (c == ')') {
					if (st.size() == 0) {
						check = true;
						break;
					}
					st.pop();
				} else {
					st.push(c);
				}

			}
			if (st.size() == 0 && !check) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}

		}
	}

}

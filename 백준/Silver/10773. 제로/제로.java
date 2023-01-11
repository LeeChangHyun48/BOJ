import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Stack<Integer> st = new Stack<Integer>();

		int K = sc.nextInt();

		for (int i = 0; i < K; i++) {

			int n = sc.nextInt();

			if (n == 0) {
				st.pop();
			} else {
				st.push(n);
			}

		}

		int ans = 0;
		int size = st.size();

		for (int i = 0; i < size; i++) {
			ans += st.pop();
		}

		System.out.println(ans);

	}

}

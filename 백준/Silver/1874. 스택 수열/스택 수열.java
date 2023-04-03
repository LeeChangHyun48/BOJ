import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Stack<Integer> stack = new Stack<Integer>();
		StringBuilder sb = new StringBuilder();

		int n = sc.nextInt();
		int start = 0;

		for (int i = 0; i < n; i++) {
			int input = sc.nextInt();

			if (start < input) {
				for (int j = start + 1; j <= input; j++) {
					stack.push(j);
					sb.append("+").append("\n");
				}
				start = input;
			}

			else if (stack.peek() != input) {
				System.out.println("NO");
				return;
			}

			stack.pop();
			sb.append("-").append("\n");

		}

		System.out.println(sb);

	}

}

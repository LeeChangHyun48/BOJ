import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(bf.readLine()); // 입력되는 명령의 수

		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());

			String input = st.nextToken();
			if (input.equals("push")) { // stack에 정수를 입력
				int num = Integer.parseInt(st.nextToken());
				stack.push(num);
				continue;
			} else if (input.equals("pop")) { // stack에 가장 위에있는 정수를 빼고 출력 없는 경우 -1 출력
				if (stack.size() != 0) {
					System.out.println(stack.pop());
				} else {
					System.out.println(-1);
				}
			} else if (input.equals("size")) { // stack에 들어있는 정수 수 출력
				System.out.println(stack.size());
			} else if (input.equals("empty")) { // stack이 비어있으면 1 아니면 0
				if (stack.isEmpty()) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
			} else if (input.equals("top")) { // stack의 가장 위에있는 정수 출력 없는 경우 -1 출력
				if (stack.size() != 0) {
					System.out.println(stack.peek());
				} else {
					System.out.println(-1);
				}
			}

		}

	}

}

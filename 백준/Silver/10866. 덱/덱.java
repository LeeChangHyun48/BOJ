import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		Deque<Integer> deq = new LinkedList<Integer>();

		int N = Integer.parseInt(bf.readLine()); // 입력되는 명령의 수

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());

			String input = st.nextToken();
			if (input.equals("push_front")) { // deq 앞에 정수 입력
				int num = Integer.parseInt(st.nextToken());
				deq.offerFirst(num);
				continue;
			} else if (input.equals("push_back")) { // deq 뒤에 정수 입력
				int num = Integer.parseInt(st.nextToken());
				deq.offerLast(num);
				continue;
			} else if (input.equals("pop_front")) { // deq 가장 앞에 있는 수를 빼고 출력 없을 경우 -1 출력
				if (deq.peekFirst() != null) {
					System.out.println(deq.pollFirst());
				} else {
					System.out.println(-1);
				}
			} else if (input.equals("pop_back")) { // deq 가장 뒤에 있는 수를 빼고 출력 없을 경우 -1 출력
				if (deq.peekLast() != null) {
					System.out.println(deq.pollLast());
				} else {
					System.out.println(-1);
				}
			} else if (input.equals("size")) { // deq에 들어있는 정수 수 출력
				System.out.println(deq.size());
			} else if (input.equals("empty")) { // deq가 비어있으면 1 아니면 0 출력
				if (deq.isEmpty()) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
			} else if (input.equals("front")) { // deq에 가장 앞 정수 출력 없을 경우 -1 출력
				if (deq.peekFirst() != null) {
					System.out.println(deq.peekFirst());
				} else {
					System.out.println(-1);
				}
			} else if (input.equals("back")) { // deq에 가장 마지막 정수 출력 없을 경우 -1 출력
				if (deq.peekLast() != null) {
					System.out.println(deq.peekLast());
				} else {
					System.out.println(-1);
				}
			}

		}

	}

}

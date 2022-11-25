import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		Deque<Integer> queue = new LinkedList<Integer>();

		int N = Integer.parseInt(bf.readLine()); // 입력되는 명령의 수

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			
			String input = st.nextToken();
			if (input.equals("push")) { // queue에 정수 입력
				int num = Integer.parseInt(st.nextToken());
				queue.offer(num);
				continue;
			} else if (input.equals("pop")) { // queue에 정수를 뺴고 그 수를 출력 없을 경우 -1 출력
				if (queue.peek() != null) {
					System.out.println(queue.poll());
				} else {
					System.out.println(-1);
				}
			} else if (input.equals("size")) { // queue에 들어있는 정수의 개수
				System.out.println(queue.size());
			} else if (input.equals("empty")) { // queue가 비어있으면 1 아니면 0
				if (queue.isEmpty()) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
			} else if (input.equals("front")) { // queue에 가장 앞 정수 출력 없을 경우 -1 출력
				if (queue.peek() != null) {
					System.out.println(queue.peek());
				} else {
					System.out.println(-1);
				}
			} else if (input.equals("back")) { // queue에 가장 마지막 정수 출력 없을 경우 -1 출력
				if (queue.peekLast() != null) {
					System.out.println(queue.peekLast());
				} else {
					System.out.println(-1);
				}
			}

		}

	}

}

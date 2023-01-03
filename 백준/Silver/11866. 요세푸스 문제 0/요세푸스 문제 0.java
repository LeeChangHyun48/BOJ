import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		Queue<Integer> queue = new LinkedList<Integer>();

		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}

		ArrayList<Integer> list = new ArrayList<Integer>();

		while (!queue.isEmpty()) {

			for (int i = 1; i <= K; i++) {
				if (i == K) {
					list.add(queue.poll());
				} else {
					queue.offer(queue.poll());
				}
			}
		}

		System.out.print("<");
		for (int i = 0; i < list.size(); i++) {
			if (i < list.size() - 1) {
				System.out.print(list.get(i) + ", ");
			} else {
				System.out.print(list.get(i));
			}
		}

		System.out.print(">");

	}

}

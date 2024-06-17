import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		PriorityQueue<Long> pQ = new PriorityQueue<Long>(Collections.reverseOrder());

		int x = sc.nextInt();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < x; i++) {
			Long input = sc.nextLong();

			if (input == 0 && pQ.isEmpty()) {
				sb.append("0\n");
				continue;
			}

			if (input == 0) {
				sb.append(pQ.poll() + "\n");
			} else {
				pQ.offer(input);
			}

		}
		System.out.println(sb);
	}

}
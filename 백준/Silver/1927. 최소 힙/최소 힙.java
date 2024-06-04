import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		PriorityQueue<Long> pQ = new PriorityQueue<Long>();

		int x = sc.nextInt();

		for (int i = 0; i < x; i++) {
			Long input = sc.nextLong();

			if (input == 0 && pQ.isEmpty()) {
				System.out.println(0);
				continue;
			}

			if (input == 0) {
				System.out.println(pQ.poll());
			} else {
				pQ.offer(input);
			}

		}
	}

}

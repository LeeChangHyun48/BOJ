import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		HashSet<String> set = new HashSet<String>();

		for (int i = 0; i < N; i++) {
			set.add(sc.next());
		}

		ArrayList<String> list = new ArrayList<String>();

		for (int i = 0; i < M; i++) {
			String st = sc.next();

			if (set.contains(st)) {
				list.add(st);
			}
		}

		Collections.sort(list);

		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	}

}

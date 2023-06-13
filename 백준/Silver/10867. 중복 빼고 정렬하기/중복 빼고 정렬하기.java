import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		List<Integer> list = new ArrayList();

		for (int i = 0; i < N; i++) {
			list.add(sc.nextInt());
		}

		Set<Integer> set = new HashSet<Integer>(list);

		List<Integer> newList = new ArrayList(set);

		Collections.sort(newList);

		for (int i = 0; i < newList.size(); i++) {
			System.out.print(newList.get(i) + " ");
		}

	}

}

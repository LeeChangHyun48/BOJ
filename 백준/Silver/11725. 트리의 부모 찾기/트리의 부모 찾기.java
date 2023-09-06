import java.util.ArrayList;
import java.util.Scanner;

public class Main{
	static ArrayList<ArrayList<Integer>> list;
	static boolean[] visit;
	static int[] parents;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		list = new ArrayList<ArrayList<Integer>>();
		visit = new boolean[N + 1];
		parents = new int[N + 1];

		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < N - 1; i++) {
			int node1 = sc.nextInt();
			int node2 = sc.nextInt();

			list.get(node1).add(node2);
			list.get(node2).add(node1);
		}

		dfs(1);

		for (int i = 2; i < parents.length; i++) {
			System.out.println(parents[i]);
		}

	}

	private static void dfs(int i) {
		visit[i] = true;

		for (int v : list.get(i)) {
			if (!visit[v]) {
				dfs(v);
				parents[v] = i;
			}
		}

	}

}

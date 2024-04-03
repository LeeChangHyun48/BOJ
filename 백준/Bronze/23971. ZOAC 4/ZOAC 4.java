import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int H = sc.nextInt();
		int W = sc.nextInt();
		int N = sc.nextInt(); // 세로
		int M = sc.nextInt(); // 가로

		int h = (H - 1) / (N + 1) + 1;
		int w = (W - 1) / (M + 1) + 1;

		System.out.println(h * w);

	}

}

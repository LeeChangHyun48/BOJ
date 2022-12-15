import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		for (int t = 0; t < tc; t++) {
			int H = sc.nextInt(); // 층
			int W = sc.nextInt(); // 각 층의 방 수
			int N = sc.nextInt(); // 몇번째 손님

			int ho = N / H;
			int room = N % H;
			
			if(room != 0) {
				ho = ho + 1;
			}
			
			if(room == 0) {
				if(N >= H) {
					room = H;
				}else {
					room = 1;
				}
			}
			
			if(ho < 10) {
				System.out.println(room + "0" + ho);
			}else {
				System.out.println(room +""+ ho);
			}
			

		}

	}

}

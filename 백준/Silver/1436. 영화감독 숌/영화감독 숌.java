import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int cnt = 0;
		int num = 666;
		
		while(N != cnt) {
			String str = String.valueOf(num);
			if(str.contains("666")) {
				num = Integer.parseInt(str);
				cnt += 1;
			}
			num += 1;
		}
		
		System.out.println(num - 1);

	}

}

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int [] list = new int[N];
		
		for(int i = 0; i < N; i++) {
			list[i] = sc.nextInt();
		}
		
		Arrays.sort(list);
		
		int temp = 0;
		int sum = 0;
		for(int i = 0; i < N; i++) {
			temp += list[i];
			sum += temp;
		}
		
		System.out.println(sum);
		
		

	}

}

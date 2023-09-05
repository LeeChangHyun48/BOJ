import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		for(int i = 0; i < N; i++) {
			String adr = sc.next();
			String pw = sc.next();
			
			map.put(adr, pw);
		}
		
		for(int i = 0; i < M; i++) {
			String input = sc.next();
			
			if(map.get(input) != null) {
				System.out.println(map.get(input));
			}
		}
		
	}

}

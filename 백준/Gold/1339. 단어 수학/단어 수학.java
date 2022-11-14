import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		Integer [] list = new Integer[26]; // 알파벳 수만큼 배열 만들기
		Arrays.fill(list, 0); // Integer로 선언했기 때문 0으로 채워주기
		

		for (int i = 0; i < N; i++) {
			String st = sc.next();
			int temp = (int) Math.pow(10, st.length() - 1); // 입력된 문자의 크기 만큼 10^st.length()
			
			for(int j = 0; j < st.length(); j++) {
				list[st.charAt(j)-'A'] += temp; // 각 배열의 알파벳 위치에 자릿수 값 저장
				temp/=10; // /10씩 줄인다
			}	
			
		}
		
		Arrays.sort(list, Collections.reverseOrder()); // 내림차순으로 정렬
		
		int res = 0;
		int index = 9; // 내림차순으로 정렬을 하여 큰값부터 리스트에 나오기 때문에 9로 지정
		
		for(int j = 0; j < 26; j++) {
			if(list[j] == 0) { // 0이 나오면 반복 중단
				break;
			}
			res += list[j] * index;
			index -= 1;
		}
		
		System.out.println(res);
	}
}

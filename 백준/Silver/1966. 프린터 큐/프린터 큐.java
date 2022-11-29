import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        for (int t = 0; t < tc; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            Deque<int[]> deq = new LinkedList<int[]>();
            ArrayList<Integer> list = new ArrayList<Integer>();

            for (int i = 0; i < N; i++) {
                int input = sc.nextInt();
                deq.offer(new int[] { i, input });
                list.add(input);
            }

            Collections.sort(list, Collections.reverseOrder());

            int cnt = 1;

            while (!deq.isEmpty()) {
                if (deq.peek()[1] >= list.get(0)) {
                    list.remove(0);
                    if (deq.peek()[0] == M) {
                        System.out.println(cnt);
                        break;
                    }
                    deq.poll();
                    cnt += 1;
                } else {
                    int tempKey = deq.peek()[0];
                    int tempValue = deq.poll()[1];

                    deq.offerLast(new int[] { tempKey, tempValue });
                }

            }

        }
    }

}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /***
     * O/X 선택으로 N과 M (2) 풀기 시간복잡도는 O(2^n)으로 O(n!)보다 빠르다
     * 여기서 주의할 점은 정답도 오른차순으로 출력되기 때문에 ans[index]=value;가 먼저와야한다.
     */
    static int[] ans = new int[9];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        go(0, 1, N, M);
    }

    public static void go(int index, int value, int n, int m) {
        if (index == m) {
            StringBuilder sb = new StringBuilder();
            for (int i : ans) {
                if (i == 0) {
                    break;
                }
                sb.append(i).append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb);
            return;
        }
        if (value > n) return;
        /***
         * O인 경우
         */
        ans[index] = value;
        go(index + 1, value + 1, n, m);
        /***
         * X인 경우
         */
        ans[index] = 0;
        go(index, value + 1, n, m);
    }
}

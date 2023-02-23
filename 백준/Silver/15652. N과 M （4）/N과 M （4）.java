import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[] ans = new int[9];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        go(1, 0, N, M, sb);
        System.out.println(sb);
    }

    public static void go(int value, int start, int n, int m, StringBuilder sb) {
        if (start == m) {
            for (int i : ans) {
                if (i == 0) {
                    break;
                }
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = value; i <= n; i++) {
            ans[start] = i;
            go(i, start + 1, n, m, sb);
        }
    }
}

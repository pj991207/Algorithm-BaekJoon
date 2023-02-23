import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] ans = new int[8];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        go(0, M, N, sb);
        System.out.println(sb);
    }

    public static void go(int index, int m, int n, StringBuilder sb) {
        if (index == m) {
            for (int i : ans) {
                if (i == 0) {
                    break;
                }
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= n; i++) {
            ans[index] = i;
            go(index + 1, m, n, sb);
        }
    }
}

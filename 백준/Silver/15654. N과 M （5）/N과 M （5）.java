import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int[] ans = new int[8];
    public static boolean[] check = new boolean[8];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        go(0, N, M, arr, sb);
        System.out.println(sb);
    }

    public static void go(int index, int n, int m, int[] arr, StringBuilder sb) {
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
        for (int i = 0; i < n; i++) {
            if (check[i]) continue;
            ans[index] = arr[i];
            check[i] = true;
            go(index + 1, n, m, arr, sb);
            check[i] = false;
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {
    static int[] ans = new int[8];
    static boolean[] check = new boolean[8];

    static LinkedHashSet<String> result = new LinkedHashSet<>();

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
        go(0, N, M, arr);
        for (String i : result) {
            System.out.println(i);
        }
    }

    public static void go(int index, int n, int m, int[] arr) {
        if (index == m) {
            StringBuilder sb = new StringBuilder();
            for (int i : ans) {
                if (i == 0) {
                    break;
                }
                sb.append(i).append(' ');
            }
            result.add(sb.toString());
            return;
        }
        for (int i = 0; i < n; i++) {
            if (check[i]) continue;
            ans[index] = arr[i];
            check[i] = true;
            go(index + 1, n, m, arr);
            check[i] = false;
        }
    }
}

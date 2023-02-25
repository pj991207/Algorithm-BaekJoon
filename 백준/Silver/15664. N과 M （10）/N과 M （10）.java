import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main
{
    static int[] ans = new int[8];
    static int N;
    static int M;
    static LinkedHashSet<String> lh = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        go(0, 0, arr);
        for (String i : lh) {
            System.out.println(i);
        }
    }

    public static void go(int index, int start, int[] arr) {
        if (index == M) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                sb.append(ans[i]).append(" ");
            }
            lh.add(sb.toString());
            return;
        }
        for (int i = start; i < N; i++) {
            ans[index] = arr[i];
            go(index + 1, i + 1, arr);
        }
    }
}

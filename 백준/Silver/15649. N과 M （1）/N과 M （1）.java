import java.util.Scanner;

public class Main {
    public static int N;
    public static int M;
    public static int[] arr;
    public static boolean[] visit;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[M];
        visit = new boolean[N];
        dfs(0);
        System.out.println(sb.substring(0, sb.length() - 1));
    }

    public static void dfs(int perm) {
        if (perm == M) {
            for (int i : arr) {
                sb.append(i + " ");
            }
            sb.append("\n");
        } else {
            for (int i = 0; i < N; i++) {
                if (!visit[i]) {
                    visit[i] = true;
                    arr[perm] = i + 1;
                    dfs(perm + 1);
                    visit[i] = false;
                }
            }
        }
    }
}
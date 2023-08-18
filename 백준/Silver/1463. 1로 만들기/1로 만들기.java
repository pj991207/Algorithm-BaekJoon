import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bf.readLine());
        int[] memo = new int[1000001];
        for (int i = 2; i <= num; i++) {
            memo[i] = memo[i - 1] + 1;
            if (i % 2 == 0 && memo[i] > memo[i / 2] + 1) {
                memo[i] = memo[i / 2] + 1;
            }
            if (i % 3 == 0 && memo[i] > memo[i / 3] + 1) {
                memo[i] = memo[i / 3] + 1;
            }
        }
        System.out.println(memo[num]);
    }
}
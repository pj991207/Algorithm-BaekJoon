import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        boolean result = next_permutation(arr, num);
        if (!result) {
            System.out.println(-1);
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            System.out.println(sb);
        }
    }

    public static boolean next_permutation(int[] arr, int n) {
        int i = n - 1;
        while (i > 0 && arr[i] <= arr[i - 1]) {
            i--;
        }
        if (i <= 0) {
            return false;
        }
        int j = n - 1;
        while (arr[j] <= arr[i - 1]) {
            j--;
        }
        swap(arr, j, i - 1);
        j = n - 1;
        while (i < j) {
            swap(arr, i, j);
            i += 1;
            j -= 1;
        }
        return true;
    }

    public static void swap(int[] arr, int to, int from) {
        int temp = arr[to];
        arr[to] = arr[from];
        arr[from] = temp;
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static boolean before_permutation(int[] arr, int n) {
        int i = n - 1;
        while (i > 0 && arr[i] >= arr[i - 1]) {
            i--;
        }
        if (i <= 0) return false;
        int j = n - 1;
        while (arr[j] >= arr[i - 1]) {
            j--;
        }
        swap(arr, i - 1, j);
        j = n - 1;
        while (i < j) {
            swap(arr, j, i);
            i++;
            j--;
        }
        return true;
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[b];
        arr[b] = arr[a];
        arr[a] = temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bf.readLine());
        int[] arr = new int[num];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        boolean result = before_permutation(arr, num);
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
}

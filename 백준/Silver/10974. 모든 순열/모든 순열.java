import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        permutation(num, sb);
        System.out.println(sb);
    }

    public static void permutation(int num, StringBuilder sb) {
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = i + 1;
        }
        for (int i : arr) {
            sb.append(i).append(" ");
        }
        sb.append("\n");
        while (next_permutation(arr, num)) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
        }
    }

    public static boolean next_permutation(int[] arr, int n) {
        int i = n - 1;
        while (i > 0 && arr[i - 1] >= arr[i]) {
            i--;
        }
        if (i <= 0) return false;
        int j = n - 1;
        while (arr[i - 1] >= arr[j]) {
            j--;
        }
        swap(arr, i - 1, j);
        j = n - 1;
        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
        return true;
    }

    public static void swap(int[] arr, int n, int m) {
        int temp = arr[n];
        arr[n] = arr[m];
        arr[m] = temp;
    }
}

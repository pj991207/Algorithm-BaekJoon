import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bf.readLine());
        int[] arr = new int[num - 1];
        for (int i = 0; i < num - 1; i++) {
            arr[i] = i + 1;
        }
        int[][] weight = new int[num][num];
        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < num; j++) {
                weight[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int sum = 1000000 * 10 + 1;
        do {
            int temp = traveling(arr, weight, arr.length);
            if (sum > temp && temp > 0) {
                sum = temp;
            }
        } while (next_permutation(arr, arr.length));
        System.out.println(sum);
    }

    public static boolean next_permutation(int[] arr, int n) {
        int i = n - 1;
        while (i > 0 && arr[i - 1] >= arr[i]) {
            i--;
        }
        if (i <= 0) return false;
        int j = n - 1;
        while (arr[i - 1] > arr[j]) {
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

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static int traveling(int[] arr, int[][] w, int num) {
        int sum = 0;
        for (int i = 0; i < num - 1; i++) {
            int a = arr[i];
            int b = arr[i + 1];
            if (w[a][b] == 0) {
                return 1000000 * 10 + 2;
            } else {
                sum += w[a][b];
            }
        }
        if (w[0][arr[0]] == 0 || w[arr[num - 1]][0] == 0) {
            return 1000000 * 10 + 2;
        }
        sum += w[0][arr[0]] + w[arr[num - 1]][0];
        return sum;
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
        Arrays.sort(arr);
        int result = 0;
        do {
            int sum = calculate(arr, num);
            if (result < sum) {
                result = sum;
            }
        } while (next_permutation(arr, num));
        System.out.println(result);
    }

    public static int calculate(int[] arr, int num) {
        int sum = 0;
        for (int i = 0; i < num - 1; i++) {
            int temp = arr[i] - arr[i + 1];
            if (temp < 0) {
                temp = temp * -1;
            }
            sum += temp;
        }
        return sum;
    }

    public static boolean next_permutation(int[] arr, int num) {
        int i = num - 1;
        while (i > 0 && arr[i] <= arr[i - 1]) {
            i--;
        }
        if (i <= 0) return false;
        int j = num - 1;
        while (arr[i - 1] >= arr[j]) {
            j--;
        }
        swap(arr, i - 1, j);
        j = num - 1;
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
}

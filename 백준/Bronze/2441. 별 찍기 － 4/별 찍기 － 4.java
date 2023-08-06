import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		for(int i = 0; i<N;i++) {
			for(int j = 0;j<i;j++) {
				System.out.print(" ");
			}
			for(int j = i; j<N;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}

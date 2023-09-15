import java.util.*;
import java.io.*;

public class Main {
	static int T;
	static int N;
	static int M;
	static int end;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		int index = 0;
		while(index<T) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			sb.append(calc(n,m)).append("\n");
			index++;
		}
		System.out.println(sb);
	}
	static int calc(int n,int m) {
		int index = 0;
		int num = 0;
		while(num<=M*N) {
			num = index*N+n;
			int y = num%M;
			if(y==0) y=M;
			if(y==m) {
				return num;
			}
			index++;
		}
		return -1;
	}
}
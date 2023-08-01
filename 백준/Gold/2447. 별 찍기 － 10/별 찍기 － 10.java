import java.util.*;
import java.io.*;
public class Main {
	static int[][] arr;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		arr = new int[N][N];
		StringBuilder sb = new StringBuilder();
		star(0,0,N);
		for(int i=0 ; i<N;i++) {
			for(int j = 0; j<N;j++) {
				if(arr[i][j]==1)sb.append("*");
				if(arr[i][j]==0)sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	static void star(int a, int b, int n) {
		if(n==3) {
			for(int i = 0; i<3;i++) {
				for(int j = 0;j<3;j++) {
					if(i==1&&j==1)continue;
					arr[a+i][b+j] = 1;
				}
			}
		}
		else {
			for(int i =0;i<3;i++) {
				for(int j = 0;j<3;j++) {
					if(i==1&&j==1)continue;
					star(a+i*n/3,b+j*n/3,n/3);
				}
			}
		}
	}
}

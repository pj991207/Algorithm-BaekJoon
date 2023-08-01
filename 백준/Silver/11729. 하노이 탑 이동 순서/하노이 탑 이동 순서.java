import java.util.*;
import java.io.*;
public class Main {
	static int N;
	static StringBuilder sb = new StringBuilder();
	static int cnt = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		hanoi(N,1,2,3);
		System.out.println(cnt);
		System.out.println(sb);
	}
	static void hanoi(int n,int start,int temp,int end) {
		if(n==0) {
			return;
		}
		hanoi(n-1,start,end,temp);
		sb.append(start+" "+end+"\n");
		cnt++;
		hanoi(n-1,temp,start,end);
	}
}

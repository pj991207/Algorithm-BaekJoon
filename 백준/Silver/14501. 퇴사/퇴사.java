import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int Day;
	static Work[] a;
	static boolean[] check;
	static int MAX = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		a = new Work[N];
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int time = Integer.parseInt(st.nextToken());
			int money = Integer.parseInt(st.nextToken());
			a[i] = new Work(time,money);
		}
		check = new boolean[N];
		Day = N-1;
		PowerSet(0);
		System.out.println(MAX);
	}
	static void PowerSet(int cnt) {
		if(cnt==N) {
			int sum = 0;
			int day = 0; //상담이 가능한 다음일자
			for(int i = 0; i<N;i++) {
				if(check[i]) {
					Work work = a[i];
					if(i<day) { //상담이 가능하지 않으면 return;
						return;
					}
					day = i + work.time;
					sum += work.money;
					if(day>N) {
						return;
					}
				}
			}
			MAX = Math.max(sum,MAX);
			return;
		}
		check[cnt]=true;
		PowerSet(cnt+1);
		check[cnt]=false;
		PowerSet(cnt+1);
	}
	static class Work{
		int time;
		int money;
		public Work(int time, int money) {
			this.time = time;
			this.money = money;
		}
	}
}
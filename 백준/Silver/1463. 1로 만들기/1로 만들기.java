import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int MIN = 1000000;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		Queue<Box> q = new ArrayDeque<>();
		q.add(new Box(N,0));
		while(!q.isEmpty()) {
			Box box = q.poll();
			int num = box.num;
			int cnt = box.cnt;
			if(num == 1) {
				MIN = Math.min(MIN,cnt);
				break;
			}
			if(cnt>MIN) {
				continue;
			}
			if(num%3==0) {
				q.add(new Box(num/3,cnt+1));
			}
			if(num%2==0) {
				q.add(new Box(num/2,cnt+1));
			}
			q.add(new Box(num-1,cnt+1));
		}
		System.out.println(MIN);
	}
	static class Box{
		int num;
		int cnt;
		Box(int num,int cnt){
			this.num = num;
			this.cnt = cnt;
		}
	}
}
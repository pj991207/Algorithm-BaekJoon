import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		Queue<Integer> q = new ArrayDeque<>();
		for(int i = 1; i<=N;i++) {
			q.add(i);
		}
		while(q.size()>1) {
			q.remove();
			int x = q.remove();
			q.add(x);
		}
		System.out.println(q.peek());
	}
}
import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int dung;
	static List<P> list;
	static class P implements Comparable<P>{
		int x;
		int y;

		public P(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(P p) {
			int rx = x -p.x;
			int ry = y -p.y;
			if(rx>=0&&ry>=0) {
				return 0;
			}else if(rx<0&&ry<0){
				return 1;
			}
			return 0;
		}
	}
	List<P> que;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(bf.readLine());
		list = new LinkedList<>();
		for(int i = 0; i<N;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			list.add(new P(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		for(int i = 0; i<list.size();i++) {
			P point = list.get(i);
			int sum = 1;
			for(P p : list) {
				sum += point.compareTo(p);
			}
			sb.append(sum+" ");
		}
		System.out.println(sb);
	}

}
import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int MAX;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		MAX = 0;
		// 우선순위큐를 활용해서 정렬된 형태로 표현
		ArrayList<Time> q = new ArrayList<>();
		// 초기화
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			q.add(new Time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
//		while(!q.isEmpty()) {
//			Time time = q.remove();
//			System.out.println(time.start+" "+time.finish);
//		}
		// greedy를 사용한 최솟값 찾기
		Collections.sort(q, (a, b) -> {
			if (a.finish == b.finish) {
				return a.start - b.start;
			}
			return a.finish - b.finish;
		});
//		for(int i = 0; i<q.size();i++) {
//			System.out.println(q.get(i).start+" "+q.get(i).finish);
//		}
		Time time = q.get(0);
		int end = time.finish;
		int cnt = 1;
		for (int j = 1; j < q.size(); j++) {
			if (end <= q.get(j).start) {
				end = q.get(j).finish;
				cnt++;
			}
		}
		MAX = Math.max(MAX, cnt);
		System.out.println(MAX);
	}

	static class Time {
		int start;
		int finish;

		public Time(int start, int finish) {
			this.start = start;
			this.finish = finish;
		}
	}
}
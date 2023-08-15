import java.util.*;
import java.io.*;
public class Main {
	static int N;
	static boolean[] check;
	static boolean[] visited;
	static int[] nums;
	static int[] values;
	static int MIN = 100000;
	static ArrayList<Integer>[] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		check = new boolean[N];
		nums = new int[N];
		values = new int[N];
		map = new ArrayList[N];
		for(int i = 0; i<N;i++) {
			map[i] = new ArrayList<>();
		}
		
		StringTokenizer st =new StringTokenizer(bf.readLine());
		for(int i = 0; i<N;i++) {
			values[i]= Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i<N;i++) {
			st = new StringTokenizer(bf.readLine());
			int c = Integer.parseInt(st.nextToken());
			for(int j =0 ;j<c;j++) {
				map[i].add(Integer.parseInt(st.nextToken())-1);
			}
		}
		PowerSet(0,0);
		if(MIN==100000) {
			System.out.println(-1);
			return;
		}
		System.out.println(MIN);
	}
	
	static void PowerSet(int x,int cnt) {
		if(x==N) {
			if(cnt==0 ||cnt==N) {//모두 파란색이거나 빨간색인 경우를 제외.
				return;
			}
			int red = 0;
			int blue = 0;
			for(int i =0 ; i<N;i++) {
				if(red!=0&&blue!=0) { //그래프의 탐색이 끝나면 의미가 없으므로, 종료함.
					break;
				}
				if(red ==0) {
					if(check[i]) { //빨간색 부분만을 그래프 탐색으로 전체 영역을 계산함.
						visited = new boolean[N];
						red = redbfs(i);
						continue;
					}
				}
				if(blue==0) {
					if(!check[i]) { //파란색 부분만을 그래프 탐색으로 전체 영역을 계산함.
						visited = new boolean[N];
						blue = bluebfs(i);
						continue;
					}
				}
			}
			
			if(red!=cnt||blue!=N-cnt) { //red 와 부분집합의 갯수가 일치하지 않는것은 그래프가 연결되어있지않다고 판단함.
				return;
			}
			
			int redSum = 0;
			int blueSum = 0;
			for(int i = 0; i<N;i++) {
				if(check[i]) {
					redSum += values[i];
				}
				else {
					blueSum += values[i];
				}
			}
			MIN = Math.min(MIN,Math.abs(blueSum-redSum));
			return;
		}
		
		check[x]=true;
		PowerSet(x+1,cnt+1);
		check[x]=false;
		PowerSet(x+1,cnt);
	}
	
	static int redbfs(int x){
		int cnt=0;
		Queue<Integer> q = new ArrayDeque<>();
		visited[x]=true;
		q.add(x);
		while(!q.isEmpty()) {
			int y = q.remove();
			cnt++;
			for(int i = 0; i<map[y].size();i++) {
				int z = map[y].get(i);
				if(visited[z]) continue;
				if(!check[z])continue;
				q.add(z);
				visited[z] = true;
			}
		}
		return cnt;
	}
	static int bluebfs(int x){
		int cnt=0;
		Queue<Integer> q = new ArrayDeque<>();
		visited[x]=true;
		q.add(x);
		while(!q.isEmpty()) {
			int y = q.remove();
			cnt++;
			for(int i = 0; i<map[y].size();i++) {
				int z = map[y].get(i);
				if(visited[z]) continue;
				if(check[z])continue;
				q.add(z);
				visited[z] = true;
			}
		}
		return cnt;
	}
}
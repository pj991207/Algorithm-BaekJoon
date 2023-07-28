import java.util.*;
import java.io.*;
public class Main {
	static int N;
	static int M;
	static int[][] arr;
	static int[][] brr;
	static int  answer;
	static int[] nums;
	static int[] set;
	static int MIN = 10000;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Queue<place> home = new LinkedList<>();
		Queue<place> store = new LinkedList<>();
		arr = new int[N][N];
		for(int i = 0; i<N;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j = 0; j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==1) {
					home.add(new place(i,j));
				}else if(arr[i][j]==2) {
					store.add(new place(i,j));
				}
			}
		}
		int h = home.size();
		int s = store.size();
		brr = new int[h][s];
		set = new int[s];
		for(int i = 0; i<s;i++) {
			set[i] = i+1;
		}
		init(home,store);
		for(int i = 1; i<=M;i++) {
			nums = new int[i];
			combi(0,0,i);
		}
		System.out.println(MIN);
	}
	static void init(Queue<place> home,Queue<place> store) {
		int len = home.size();
		int size = store.size();
		for(int i = 0; i<len;i++) {
			place p = home.poll();
			int homeY = p.y;
			int homeX = p.x;
			for(int j =0;j<size;j++) {
				place s = store.poll();
				int storeY = s.y;
				int storeX = s.x;
				brr[i][j] = Math.abs(p.y-s.y)+Math.abs(p.x-s.x);
				store.add(s);
			}
		}
	}
	static void combi(int x, int start,int limit) {
		if(x==limit) {
			int sum = Road(nums);
			MIN = Math.min(sum,MIN);
			return;
		}
		for(int i = start; i<set.length;i++) {
			nums[x] = set[i];
			combi(x+1,i+1,limit);
			nums[x] = 0;
		}
	}
	
	static int Road(int[] nums) {
		int sum = 0;
		for(int i = 0; i<brr.length;i++) {
			int point = 1000;
			for(int j = 0 ;j < nums.length;j++) {
				point = Math.min(point,brr[i][nums[j]-1]);
			}
			sum+=point;
		}
		return sum;
	}
}
class place{
	int y;
	int x;
	public place(int y,int x) {
		this.y=y;
		this.x=x;
	}
}
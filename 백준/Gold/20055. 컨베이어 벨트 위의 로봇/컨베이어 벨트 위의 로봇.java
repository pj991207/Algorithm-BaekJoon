import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int K;
	static boolean[] Robot;
	static int[] line;
	static int[] num;
	static int cnt;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		line = new int[2*N];
		Robot = new boolean[N];
		num = new int[N];
		st = new StringTokenizer(bf.readLine());
		for(int i = 0; i<2*N;i++) {
			line[i] = Integer.parseInt(st.nextToken());
		}
		int ans = 0;
		init();
		while(cnt<K) {
			cnt = 0;
			move();
			Robotmove();
			setting();
			count();
			ans++;
		}
		System.out.println(ans);
	}
	static void init() {
		Arrays.setAll(num,i->i);
	}
	static void move() {
		for(int i = 0; i<N;i++) {
			num[i] = num[i]-1;
			if(num[i]<0) {
				num[i] = 2*N-1;
			}
			if(i==0)continue;
			Robot[N-i] = Robot[N-1-i];//로봇을 한칸씩 이동
		}
		Robot[0] = false;
		Robot[N-1] = false;//로봇이 내려감.
	}
	static void Robotmove() {
		for(int i = N-2; i>-1;i--) {
			if(!Robot[i])continue;//로봇이 없다면 안움직임.
			if(Robot[i+1])continue;//앞에 로봇이 존재하므로 못움직임.
			if(line[num[i+1]]<1)continue;//내구도가 1 미만인 경우
			Robot[i+1] = Robot[i];
			Robot[i] = false;
			line[num[i+1]] = line[num[i+1]] - 1;//이동후 이동한 위치의 내구도 1감소
		}
		Robot[N-1] = false; 
	}
	static void setting() {
		if(line[num[0]]==0)return;
		Robot[0] = true;
		line[num[0]] = line[num[0]]-1;//올리고 내구도 -1감소
	}
	static void count() {
		for(int i : line) {
			if(i==0) {
				cnt++;
			}
		}
	}
}
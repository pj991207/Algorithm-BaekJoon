import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static char[][] map;
	static int MAX = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			String line = bf.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		//가로만 먼저 다 바꾼다고 생각
		for(int i = 0;i<N;i++) {
			for(int j = 0;j<N-1;j++) {
				//swap
				char temp = map[i][j];
				map[i][j] = map[i][j+1];
				map[i][j+1] = temp;
				//count
				int cnt = check(i,j);
				MAX = Math.max(cnt,MAX);
				//복구
				map[i][j+1] = map[i][j];
				map[i][j] = temp;
			}
		}
		for(int i = 0; i<N;i++) {
			for(int j = 0;j<N-1;j++) {
				char temp = map[j][i];
				map[j][i] = map[j+1][i];
				map[j+1][i] = temp;
				//count
				int cnt = check(j,i);
				MAX = Math.max(cnt,MAX);
				//복구
				map[j+1][i] = map[j][i];
				map[j][i] = temp;
			}
		}
		System.out.println(MAX);
	}
	static int check(int y, int x) {
		//행 확인
		int ans = 0;
		int cnt = 1;
		for(int i = 0; i<N;i++) {
			for(int j = 0;j<N-1;j++){
				if(map[i][j]==map[i][j+1]) {
					cnt++;
					continue;
				}
				if(map[i][j]!=map[i][j+1]) {
					ans = Math.max(ans,cnt);
					cnt = 1;
					continue;
				}
			}
			ans = Math.max(ans,cnt);//한줄이 모두 같은 경우.
			cnt = 1;
		}
		//열 확인
		for(int i = 0; i<N;i++) {
			for(int j = 0;j<N-1;j++){
				if(map[j][i]==map[j+1][i]) {
					cnt++;
					continue;
				}
				if(map[j][i]!=map[j+1][i]) {
					ans = Math.max(ans,cnt);
					cnt = 1;
					continue;
				}
			}
			ans = Math.max(ans,cnt);//한줄이 모두 같은 경우.
			cnt = 1;
		}
		return ans;
	}
}
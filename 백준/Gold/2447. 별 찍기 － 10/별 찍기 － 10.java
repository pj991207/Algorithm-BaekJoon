import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
	static int N;
	static int[][] star;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		
		star = new int[N][N];
		star(0,0,N);
		
		for(int i = 0; i<N;i++) {
			for(int j = 0; j<N;j++) {
				sb.append(star[i][j]==1?"*":" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	static void star(int r, int c, int n) {
		
		//end comdaitons basecondition
		if(n==3) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if(i==1 && j==1)continue;// 다음 스탭 -> 중앙일때 아무일다안함
					star[r+i][c+j]=1;
				}
			}
		}
		else {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if(i==1 && j==1)continue;// 다음 스탭 -> 중앙일때 아무일다안함
					star(r+i*n/3,c+j*n/3,n/3);
				}
			}
		}
		
	}
}

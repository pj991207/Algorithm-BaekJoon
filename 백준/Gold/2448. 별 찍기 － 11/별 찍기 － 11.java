import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
	static int N;
	static int M;
	static int[][] star;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(bf.readLine());
		M = (2*N-1);
		star = new int[N][M];
		star(0,M/2,N);
		for(int i = 0; i<N;i++) {
			for(int j = 0 ;j <M;j++) {
				if(star[i][j]==1) {
					sb.append("*");
				}
				if(star[i][j]==0) {
					sb.append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	static void star(int a, int b, int n) {
		if(n==3) {
			for(int i = 0; i<3;i++) {
				for(int j=-2; j<3;j++) {
					if(i==0 && j==0) {
						star[a+i][b+j] = 1;
					}else if(i==1) {
						if(j==-1||j==1) {
							star[a+i][b+j] = 1;
						}
					}else if(i==2) {
						star[a+i][b+j]=1;
					}
				}
			}
			
		}else {
			star(a,b,n/2);
			star(a+n/2,b-n/2,n/2);
			star(a+n/2,b+n/2,n/2);
		}
	}
}

import java.util.*;
import java.io.*;
public class Main {
	static int ans=Integer.MIN_VALUE;
	static int N;
	static int M;
	static int[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i = 0 ; i<N;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j =0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		a();
		//System.out.println(ans);
		b();
		//System.out.println(ans);
		c();
		//System.out.println(ans);
		d();
		//System.out.println(ans);
		e();
		//System.out.println(ans);
		f();
		//System.out.println(ans);
		g();
		//System.out.println(ans);
		h();
		//System.out.println(ans);
		i();
		//System.out.println(ans);
		j();
		//System.out.println(ans);
		k();
		//System.out.println(ans);
		l();
		//System.out.println(ans);
		m();
		//System.out.println(ans);
		n();
		//System.out.println(ans);
		o();
		//System.out.println(ans);
		p();
		//System.out.println(ans);
		q();
		//System.out.println(ans);
		r();
		//System.out.println(ans);
		s();
		System.out.println(ans);
	}
	//ㅡ
	static void a() {
		for(int i = 0; i<N;i++) {
			for(int j = 0;j<M-3;j++) {
				int sum = map[i][j]+map[i][j+1]+map[i][j+2]+map[i][j+3];
				ans = Math.max(sum,ans);
			}
		}
	}
	//ㅣ
	static void b() {
		for(int i = 0; i<N-3;i++) {
			for(int j = 0;j<M;j++) {
				int sum = map[i][j]+map[i+1][j]+map[i+2][j]+map[i+3][j];
				ans = Math.max(sum,ans);
			}
		}
	}
	//ㅁ
	static void c() {
		for(int i = 0; i<N-1;i++) {
			for(int j = 0;j<M-1;j++) {
				int sum = map[i][j] + map[i+1][j]+map[i][j+1]+map[i+1][j+1];
				ans = Math.max(sum,ans);
			}
		}
	}
	//ㅗ
	static void d() {
		for(int i = 0; i<N-1;i++) {
			for(int j = 0; j<M-2;j++) {
				int sum = map[i][j+1]+map[i+1][j]+map[i+1][j+1]+map[i+1][j+2];
				ans = Math.max(sum,ans);
			}
		}
	}
	//ㅜ
	static void e() {
		for(int i = 0; i<N-1;i++) {
			for(int j = 0; j<M-2;j++) {
				int sum = map[i+1][j+1]+map[i][j]+map[i][j+1]+map[i][j+2];
				ans = Math.max(sum,ans);
			}
		}
	}
	//ㅓ
	static void f() {
		for(int i = 0; i<N-2;i++) {
			for(int j = 0; j<M-1;j++) {
				int sum = map[i+1][j]+map[i][j+1]+map[i+1][j+1]+map[i+2][j+1];
				ans = Math.max(sum,ans);
			}
		}
	}
	//ㅏ
	static void g() {
		for(int i = 0; i<N-2;i++) {
			for(int j = 0; j<M-1;j++) {
				int sum = map[i+1][j+1]+map[i][j]+map[i+1][j]+map[i+2][j];
				ans = Math.max(sum,ans);
			}
		}
	}
	//
	static void h() {
		for(int i = 0; i<N-2;i++) {
			for(int j = 0; j<M-1;j++) {
				int sum = map[i][j+1]+map[i+1][j]+map[i+1][j+1]+map[i+2][j];
				ans = Math.max(sum,ans);
			}
		}
	}
	//
	static void i() {
		for(int i = 0; i<N-2;i++) {
			for(int j = 0; j<M-1;j++) {
				int sum = map[i][j]+map[i+1][j]+map[i+1][j+1]+map[i+2][j+1];
				ans = Math.max(sum,ans);
			}
		}
	}
	//
	static void j() {
		for(int i = 0; i<N-1;i++) {
			for(int j = 0; j<M-2;j++) {
				int sum = map[i][j+1]+map[i][j+2]+map[i+1][j]+map[i+1][j+1];
				ans = Math.max(sum,ans);
			}
		}
	}
	//
	static void k() {
		for(int i = 0; i<N-1;i++) {
			for(int j = 0; j<M-2;j++) {
				int sum = map[i][j+1]+map[i][j]+map[i+1][j+1]+map[i+1][j+2];
				ans = Math.max(sum,ans);
			}
		}
	}
	
	static void l() {
		for(int i = 0; i<N-2;i++) {
			for(int j = 0; j<M-1;j++) {
				int sum = map[i][j]+map[i+1][j]+map[i+2][j]+map[i+2][j+1];
				ans = Math.max(sum,ans);
			}
		}
	}
	static void m() {
		for(int i = 0; i<N-2;i++) {
			for(int j = 0; j<M-1;j++) {
				int sum = map[i][j]+map[i+1][j]+map[i+2][j]+map[i][j+1];
				ans = Math.max(sum,ans);
			}
		}
	}
	static void n() {
		for(int i = 0; i<N-2;i++) {
			for(int j = 0; j<M-1;j++) {
				int sum = map[i][j+1]+map[i+1][j+1]+map[i+2][j+1]+map[i][j];
				ans = Math.max(sum,ans);
			}
		}
	}
	static void o() {
		for(int i = 0; i<N-2;i++) {
			for(int j = 0; j<M-1;j++) {
				int sum = map[i][j+1]+map[i+1][j+1]+map[i+2][j+1]+map[i+2][j];
				ans = Math.max(sum,ans);
			}
		}
	}
	
	static void p() {
		for(int i = 0; i<N-1;i++) {
			for(int j = 0; j<M-2;j++) {
				int sum = map[i][j]+map[i][j+1]+map[i][j+2]+map[i+1][j];
				ans = Math.max(sum,ans);
			}
		}
	}
	static void q() {
		for(int i = 0; i<N-1;i++) {
			for(int j = 0; j<M-2;j++) {
				int sum = map[i][j]+map[i][j+1]+map[i][j+2]+map[i+1][j+2];
				ans = Math.max(sum,ans);
			}
		}
	}
	static void r() {
		for(int i = 0; i<N-1;i++) {
			for(int j = 0; j<M-2;j++) {
				int sum = map[i+1][j]+map[i+1][j+1]+map[i+1][j+2]+map[i][j];
				ans = Math.max(sum,ans);
			}
		}
	}
	static void s() {
		for(int i = 0; i<N-1;i++) {
			for(int j = 0; j<M-2;j++) {
				int sum = map[i+1][j]+map[i+1][j+1]+map[i+1][j+2]+map[i][j+2];
				ans = Math.max(sum,ans);
			}
		}
	}
}
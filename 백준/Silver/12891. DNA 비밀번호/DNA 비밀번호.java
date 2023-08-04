import java.util.*;
import java.io.*;
public class Main {
	static int ans = 0;
	static int S;
	static int P;
	static String pwd;
	static int[] DNA= {0,0,0,0};
	static int[] valid = {0,0,0,0};
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		pwd = bf.readLine();
		st = new StringTokenizer(bf.readLine());
		for(int i = 0; i<4;i++) {
			DNA[i]=Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i<P;i++) {
			count(i,true);
		}
		check();
		for(int i = P; i<S;i++) {
			count(i,true);
			count(i-P,false);
			check();
		}
		System.out.println(ans);
	}
	static void count(int i,boolean t) {
		char elem = pwd.charAt(i);
		if(t) {
			if(elem=='A') {
				valid[0]++;
			}
			if(elem=='C') {
				valid[1]++;
			}
			if(elem=='G') {
				valid[2]++;
			}
			if(elem=='T') {
				valid[3]++;
			}
		}
		else {
			if(elem=='A') {
				valid[0]--;
			}
			if(elem=='C') {
				valid[1]--;
			}
			if(elem=='G') {
				valid[2]--;
			}
			if(elem=='T') {
				valid[3]--;
			}
		}
	}
	static void check() {
		if(valid[0]<DNA[0]) {
			return;
		}
		if(valid[1]<DNA[1]) {
			return;
		}
		if(valid[2]<DNA[2]) {
			return;
		}
		if(valid[3]<DNA[3]) {
			return;
		}
		ans++;
	}
}

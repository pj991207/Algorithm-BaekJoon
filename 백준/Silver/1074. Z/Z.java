import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int r;
	static int c;
	static int sum;
	static int[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		N = (int)Math.pow(2,N);
		Z(0,0,N);
	}
	static void Z(int sr,int sc,int width) {
		if(sr==r&&sc==c) {
			System.out.println(sum);
			return;
		}
		if(r>=sr&&r<sr+width&&c>=sc&&c<sc+width) {
			width = width/2;
			Z(sr,sc,width);
			Z(sr,sc+width,width);
			Z(sr+width,sc,width);
			Z(sr+width,sc+width,width);
		}else sum+=width*width;
	}
}
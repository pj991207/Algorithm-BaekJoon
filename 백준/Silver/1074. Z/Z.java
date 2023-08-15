import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static int r;
	static int c;
	static int sum=0;
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		Z(0,0,1<<N);
	}
	
	static void Z(int y,int x, int size) {
		if(y==r&&x==c) {
			System.out.println(sum);
			return;
		}
		if(y<=r&&r<y+size&&x<=c&&c<x+size) {
			Z(y,x,size/2);
			Z(y,x+size/2,size/2);
			Z(y+size/2,x,size/2);
			Z(y+size/2,x+size/2,size/2);
		}else {
			sum += size*size;
		}
	}
}
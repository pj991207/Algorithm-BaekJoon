import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int MAX;
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		if(N%5!=0) {
			MAX = N/5;
		}else {
			System.out.println(N/5);
			System.exit(0);
		}
		for(int i = MAX; i > 0; i--) {
			int div = N-5*i;
			if(div%3==0) {
				System.out.println(i+div/3);
				System.exit(0);
			}
		}
		if(N%3==0) {
			System.out.println(N/3);
			System.exit(0);
		}
		System.out.println(-1);
	}
}
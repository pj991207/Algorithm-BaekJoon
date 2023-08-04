import java.util.*;
import java.io.*;

public class Main {
	static int N;
	//static boolean[] filter;
	static int[] one = { 2, 3, 5, 7 };
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		int MAX = (int) Math.pow(10, N);
		int MIN = (int) Math.pow(10, N - 1);
		//filter = new boolean[MAX];
		for (int i = MIN; i < MAX; i++) {
			int div = MIN;
			boolean flag = true;
			while(div!=0) {
				int num = i/div;
				div = div/10;
				if(num==1||num==4||num==6||num==8||num==9) {
					flag=false;
					break;
				}
				int index = 2;
//				for(int j = i*2; j<MAX;j=i*index) {
//					filter[j]=true;
//					index++;
//				}
//				if(filter[num]) {
//					flag = false;
//					break;
//				}
				if(!isPrime(num)) {
					flag = false;
					break;
				}
			}
			if(flag) {
				sb.append(i + "\n");
			}
		}
		System.out.println(sb);
	}
	static boolean isPrime(int x) {
		for(int i = 2; i*i<=x;i++) {
			if((x%i)==0) {
				return false;
			}
		}
		return true;
	}

}

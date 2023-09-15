import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int T;
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		T = (int)Math.log10(N)+1;
		int answer = 0;
		for(int i = 0; i<T-1;i++) {
			int before = (int)Math.pow(10,i);
			int after = (int)Math.pow(10,i+1);
			answer += (after-before)*(i+1);
		}
		int before = (int)Math.pow(10,T-1);
		answer += (N-before+1)*T;
		System.out.println(answer);
	}
}
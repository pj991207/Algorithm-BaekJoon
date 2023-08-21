import java.util.*;
import java.io.*;

public class Main {
	static int T;
	static int timeA = 300;
	static int timeB = 60;
	static int timeC = 10;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(bf.readLine());
		//A,B,C는 서로 배수의 관계를 갖으므로 Greedy하게 문제를 해결 할 수 있다.
		sb.append(T/300).append(" ");//300 처리
		T = T%300;
		sb.append(T/60).append(" ");//60 처리
		T = T%60;
		sb.append(T/10).append(" ");//10 처리
		T = T%10;
		if(T!=0) {
			System.out.println(-1);
			return;
		}
		System.out.println(sb);
	}
}
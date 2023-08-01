import java.util.*;
import java.io.*;
public class Main {
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<N;i++) {
			for(int j = i+1; j<N;j++) {
				sb.append(" ");
			}
			sb.append("*");
			for(int j = 0;j<2*i-1;j++) {
				sb.append(" ");
			}
			if(i!=0) {
				sb.append("*");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}

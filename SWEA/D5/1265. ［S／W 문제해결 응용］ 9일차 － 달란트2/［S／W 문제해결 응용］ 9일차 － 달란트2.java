import java.util.*;
import java.io.*;
public class Solution {
	static int T;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i =0;i<T;i++) {
			sb.append("#"+(i+1)+" ");
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int max = Integer.parseInt(st.nextToken());
			int div = Integer.parseInt(st.nextToken());
			int[] num = new int[div];
			for(int j = 0; j<num.length;j++) {
				if(j==num.length-1) {
					num[j]=max;
					break;
				}
				num[j] = max/div;
				max = max -num[j];
				div = div - 1;
			}
			long mux = 1;
			for(int e : num) {
				mux = mux * e;
			}
			sb.append(mux+"\n");
		}
		System.out.println(sb);
	}

}
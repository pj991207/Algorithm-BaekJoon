import java.util.*;
import java.io.*;
public class Solution {
	static int T = 0;
	static int cnt = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<T;i++) {
			sb.append("#"+(i+1)+" ");
			String s = bf.readLine();
			cnt = 0;
			String[] arr = s.split("");
			if(arr[0].equals("1")) {
				cnt++;
			}
			for(int j = 1; j<arr.length;j++) {
				if(!(arr[j-1].equals(arr[j]))){
					cnt++;
				}
			}
			sb.append(cnt+"\n");
		}
		System.out.println(sb);
	}
}

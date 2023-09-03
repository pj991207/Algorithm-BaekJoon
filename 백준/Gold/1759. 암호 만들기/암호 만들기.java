import java.util.*;
import java.io.*;

public class Main {
	static int L;
	static int C;
	static String[] list;
	static StringBuilder sb = new StringBuilder();
	static Set<String> set = new HashSet<>(Arrays.asList(new String[] {"a","e","i","o","u"}));
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		list = new String[C];
		st = new StringTokenizer(bf.readLine());
		for(int i= 0; i<C;i++) {
			list[i] = st.nextToken();
		}
		Arrays.sort(list);
		Combi(0,0,0,0,"");
		System.out.println(sb);
	}
	static void Combi(int cnt,int start,int a, int b,String str){
		if(cnt==L) {
			if(a>=1&&b>=2) {
				sb.append(str).append("\n");
			}
			return;
		}
		for(int i = start;i<C;i++) {
			if(set.contains(list[i])) {
				Combi(cnt+1,i+1,a+1,b,str+list[i]);
			}else {
				Combi(cnt+1,i+1,a,b+1,str+list[i]);
			}
		}
	}
}
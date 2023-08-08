import java.util.*;
import java.io.*;
public class Main {
	static int[] alphabet = new int[27];
	static int N;
	static String s;
	static int ans = 0;
	static Set<String> list = new HashSet<>();
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		s = bf.readLine();
		N = s.length();
		for(int i = 0 ; i<N;i++) {
			alphabet[s.charAt(i)-'a']++;
		}
		bfs(0,' ');
		System.out.println(ans);
	}
	static void bfs(int index, char pre) {
		if(index == N) {
			ans++;
			return;
		}
		for(int i = 0; i<27;i++) {
			if(alphabet[i]==0) continue;
			
			if(pre != (char)(i+'a')) {
				alphabet[i]--;
				bfs(index+1,(char)(i+'a'));
				alphabet[i]++;
			}
		}
	}
}
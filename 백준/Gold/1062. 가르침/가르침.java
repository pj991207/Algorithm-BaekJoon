import java.util.*;
import java.io.*;
public class Main {
	static int N;
	static int K;
	static int R;
	static int MAX = 0;
	static boolean[] word = new boolean[26];
	static ArrayList<boolean[]> wordlist = new ArrayList<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		word['a'-'a']=true;
		word['n'-'a']=true;
		word['t'-'a']=true;
		word['i'-'a']=true;
		word['c'-'a']=true;
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		R = K-5;
		if(R<0) {
			System.out.println(0);
			return;
		}
		for(int i = 0; i<N;i++) {
			boolean[] temp = new boolean[26];
			temp['a'-'a']=true;
			temp['n'-'a']=true;
			temp['t'-'a']=true;
			temp['i'-'a']=true;
			temp['c'-'a']=true;
			String s = bf.readLine();
			s = s.substring(4,s.length()-4);
			char[] arr = s.toCharArray();
			for(int j=0;j<arr.length;j++) {
				if(!temp[arr[j]-'a']) {
					temp[arr[j]-'a']=true;
				}
			}
			wordlist.add(temp);
		}
		dfs(0,0);
		System.out.println(MAX);
	}
	static void dfs(int x,int start) {
		if(x==R) {
			int cnt = 0;
			for(boolean[] a : wordlist) {
				boolean flag = true;
				for(int i = 0; i<26;i++) {
					if(a[i]) {
						if(!word[i]) {
							flag = false;
							break;
						}
					}
				}
				if(flag) {
					cnt++;
				}
			}
			MAX = Math.max(MAX,cnt);
			return;
		}
		for(int i = start;i<26;i++) {
			if(word[i])continue;
			word[i]=true;
			dfs(x+1,i+1);
			word[i]=false;
		}
	}
}
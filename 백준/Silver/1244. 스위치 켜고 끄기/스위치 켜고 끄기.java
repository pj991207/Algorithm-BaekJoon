import java.util.*;
import java.io.*;
public class Main {
	static int[] arr;
	static int N;
	static int T;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		arr = new int[N+1];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i = 1; i<N+1;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		T = Integer.parseInt(bf.readLine());
		for(int i = 0; i<T;i++) {
			st = new StringTokenizer(bf.readLine());
			int sex = Integer.parseInt(st.nextToken());
			int pivot = Integer.parseInt(st.nextToken());
			if(sex==1) {
				for(int j = 1; j<N/pivot+1;j++) {
					int index = pivot*j;
					if(arr[index]==0) {
						arr[index]=1;
					}
					else if(arr[index]==1) {
						arr[index]=0;
					}
				}
			}
			if(sex==2) {
				int dr =  pivot;
				int dl =  pivot;
				for(int j = 0;j<N+1;j++) {
					dr = dr+1;
					dl = dl-1;
					if(dr>0&&dr<N+1&&dl>0&&dl<N+1) {
						if(arr[dr]!=arr[dl]) {
							dr = dr -1;
							dl = dl +1;
							break;
						}
					}
					else {
						dr = dr - 1;
						dl = dl + 1;
						break;
					}
				}
				for(int j = dl;j<=dr;j++) {
					if(arr[j]==0) {
						arr[j]=1;
					}
					else if(arr[j]==1) {
						arr[j]=0;
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i =1; i<arr.length;i++) {
			sb.append(arr[i]).append(" ");
			if(i%20==0) {
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}

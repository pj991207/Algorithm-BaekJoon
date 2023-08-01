import java.util.*;
import java.io.*;
public class Main {
	static int S;
	static int C;
	static int[][] arr;
	static int len;
	static int MAX = 2000;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		S = Integer.parseInt(bf.readLine());
		C = 0;
		arr = new int[MAX][MAX];
		for(int i = 0; i< MAX;i++) {
			Arrays.fill(arr[i], -1);
		}
		arr[1][0] = 0;
		P point = new P(1,0);
		bfs(point);
		int min = 1000000;
		for(int i : arr[S]) {
			if(i!=-1)
			min = Math.min(i, min);
		}
		System.out.println(min);
	}
	static void bfs(P point) {
		Queue<P> qu = new LinkedList<>();
		qu.add(point);
		while(!qu.isEmpty()) {
			P p = qu.poll();
			int y = p.y;
			int x = p.x;
			if(y-1>=0&&y-1<MAX) {
				if(arr[y-1][x]==-1) {
					arr[y-1][x] = arr[y][x]+1;
					qu.add(new P(y-1,x));
				}else {
					if(arr[y-1][x]>arr[y][x]+1) {
						arr[y-1][x] = arr[y][x]+1;
						qu.add(new P(y-1,x));
					}
				}
			}
			if(x!=0) {
				if(y+x>=0&&y+x<MAX) {
					if(arr[y+x][x]==-1) {
						arr[y+x][x] = arr[y][x]+1;
						qu.add(new P(y+x,x));
					}else {
						if(arr[y+x][x]>arr[y][x]+1) {
							arr[y+x][x] = arr[y][x]+1;
							qu.add(new P(y+x,x));
						}
					}
				}
			}
			if(y>=0&&y<MAX) {
				if(arr[y][y]==-1) {
					arr[y][y] = arr[y][x]+1;
					qu.add(new P(y,y));
				}
				else {
					if(arr[y][y]>arr[y][x]+1) {
						arr[y][y] = arr[y][x]+1;
						qu.add(new P(y,y));
					}
				}
			}
		}
	}
}
class P{
	int y;
	int x;
	public P(int y,int x) {
		this.y = y;
		this.x = x;
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static boolean[][] arr;
	static ArrayList<Integer>[] brr;

	static ArrayList<Edge> crr;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new boolean[N][N];
		brr = new ArrayList[N];
		crr = new ArrayList<>();
		for(int i = 0; i<N;i++){
			brr[i] = new ArrayList<Integer>();
		}
		for(int i=0;i<M;i++){
			st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x][y] = true;
			arr[y][x] = true;
			brr[x].add(y);
			brr[y].add(x);
			Edge edge = new Edge(x,y);
			crr.add(edge);
			edge = new Edge(y,x);
			crr.add(edge);
		}
		M *=2;

		for(int i = 0; i<crr.size();i++){
			for(int j = 0; j<crr.size();j++){
				int A = crr.get(i).to;
				int B = crr.get(i).from;
				int C = crr.get(j).to;
				int D = crr.get(j).from;
				if(A==B || C==D || A==D || A==C || B==D){
					continue;
				}
				if(!arr[B][C]){
					continue;
				}
				for(int k = 0; k<brr[D].size();k++){
					int check = brr[D].get(k);
					if(check == A || check ==B || check ==C||check==D){
						continue;
					}
					System.out.println(1);
					System.exit(0);
				}
			}

		}

		System.out.println(0);

	}
}
class Edge{
	int to;
	int from;
	public Edge(int to, int from){
		this.to = to;
		this.from = from;
	}
}

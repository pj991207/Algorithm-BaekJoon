import java.util.*;
import java.io.*;
public class Main {
	static int T;
	static int N;
	static String order;
	static int[] nums;
	static ArrayDeque<Integer> deq;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(bf.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<T;i++) {
			order = bf.readLine();
			N = Integer.parseInt(bf.readLine());
			StringTokenizer st = new StringTokenizer(bf.readLine(),"[],");
			deq = new ArrayDeque<>();
			for(int j=0;j<N;j++) {
				deq.addLast(Integer.parseInt(st.nextToken()));
			}
			
			order = order.replace("RR","");
			int R = 0;
			boolean flag = false;
			for(int j=0;j<order.length();j++) {
				char point = order.charAt(j);
				if(point=='R') {
					R++;
				}
				if(point=='D') {
					if(deq.size()==0) {
						sb.append("error").append("\n");
						flag = true;
						break;
					}
					if(R%2==1) {
						deq.removeLast();
					}else {
						deq.removeFirst();
					}
				}
			}
			if(!flag) {
				sb.append("[");
				if(deq.size()==0) {
					sb.append("]").append("\n");
					continue;
				}
				if(R%2==1) {
					while(!deq.isEmpty()) {
						sb.append(deq.removeLast());
						sb.append(",");
					}
				}else {
					while(!deq.isEmpty()) {
						sb.append(deq.removeFirst());
						sb.append(",");
					}
				}
				sb.delete(sb.length()-1, sb.length());
				sb.append("]").append("\n");
			}
		}
		System.out.println(sb);
	}
}
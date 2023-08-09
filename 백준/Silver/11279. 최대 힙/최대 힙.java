import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
		for(int i = 0; i<N;i++) {
			int num = Integer.parseInt(bf.readLine());
			if(num!=0) {
				q.add(num);
			}else {
				if(q.size()>0) {
					System.out.println(q.poll());
				}else {
					System.out.println(0);
				}
			}
		}
	}
}
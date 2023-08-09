import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> priorityqueue = new PriorityQueue<>();
		int N = Integer.parseInt(bf.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(bf.readLine());
			if (num == 0) {
				if(priorityqueue.size()>0) {
					System.out.println(priorityqueue.poll());
				}else {
					System.out.println(0);
				}
			}else {
				priorityqueue.add(num);
			}
		}
	}
}
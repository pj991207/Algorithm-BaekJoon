import java.util.*;
import java.io.*;
public class Main {
	static int N;
	static Stack<Work> stack = new Stack<>(); //스택을 활용해서 일을 처리한다.
	static int sum = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		for(int i = 0; i<N;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int T = Integer.parseInt(st.nextToken());
			if(T==1) {
				int reward = Integer.parseInt(st.nextToken());
				int time = Integer.parseInt(st.nextToken());
				if(time == 1) {
					sum += reward;
					continue;
				}
				stack.push(new Work(time-1,reward)); //하루 일을 한 것이므로 time-1, 일이 남은 경우 (time>1) 스택에 저장
			}
			if(T==0) { //T==0일 때 기존에 stack에 있는 일을 처리
				if(stack.isEmpty()) continue;
				Work work = stack.pop();
				if(work.time==1) {
					sum+=work.reward;
					continue;
				}
				stack.push(new Work(work.time-1,work.reward));
			}
		}
		System.out.println(sum);
	}
	static class Work{ //진행되는 일을 기록하기 위해서 work 자료구조 생성
		int time;
		int reward;
		Work(int time,int reward){
			this.time = time;
			this.reward = reward;
		}
	}
	
}
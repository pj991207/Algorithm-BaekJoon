import java.util.*;
import java.io.*;
public class Main {
	static int T;
	static int N;
	static char[] order;
	static int R;
	static ArrayDeque<Integer> arr;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(bf.readLine());
		for(int i = 0;i < T; i++) {
			String orderStr = bf.readLine().replace("RR","");//수행할 함수 P를 chararray로 입력받음.
			order = orderStr.toCharArray();
			//배열 초기화
			N = Integer.parseInt(bf.readLine());
			StringTokenizer st = new StringTokenizer(bf.readLine(),"[],");
			R = 0;
			arr = new ArrayDeque<>();
			
			while(st.hasMoreTokens()) {
				arr.add(Integer.parseInt(st.nextToken()));
			}
//			if(N>0) {
//				for(int j = 0; j<numArr.length;j++) {
//					arr.add(Integer.parseInt(numArr[j]));
//				}
//			}
			//수행할 함수 P를 동작시킴
			boolean flag = false; //에러가 나는 경우를 판단하기 위해서 flag를 사용
			for(int j = 0; j<order.length;j++) {
				if(order[j]=='R') {
					R++;
				}
				if(order[j]=='D') {
					if(R%2==1) {
						flag = D_Last();
					}
					else {
						flag = D_First();
					}
				}
				if(flag) {
					break;
				}
			}
			if(flag) {
				sb.append("error").append("\n");
				continue;
			}
			if(R%2==1) {
				sb.append("[");
				int len = arr.size();
				for(int k = 0; k<len;k++) {
					sb.append(arr.removeLast());
					sb.append(",");
				}
				if(len>0) {
					sb.delete(sb.length()-1,sb.length());
				}
				sb.append("]").append("\n");
			}
			else {
				sb.append("[");
				int len = arr.size();
				for(int k =0;k<len;k++) {
					sb.append(arr.removeFirst());
					sb.append(",");
				}
				if(len>0) {
					sb.delete(sb.length()-1,sb.length());
				}
				sb.append("]").append("\n");
			}
		}
		System.out.println(sb);
	}
	
//	static void R() {
//		int len = arr.size();
//		Stack<Integer> stack = new Stack<>();
//		for(int i = 0; i<len;i++) {
//			stack.push(arr.removeFirst());
//		}
//		while(!stack.isEmpty()) {
//			arr.addLast(stack.pop());
//		}
//	}
	
	static boolean D_First() {
		if(arr.size()==0) {
			return true;
		}
		arr.removeFirst();
		return false;
	}
	
	static boolean D_Last() {
		if(arr.size()==0) {
			return true;
		}
		arr.removeLast();
		return false;
	}
}
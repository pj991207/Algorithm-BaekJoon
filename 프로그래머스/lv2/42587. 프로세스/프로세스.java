import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
class Solution {
    public int solution(int[] priorities, int location) {
				int answer = 1;
		int[] numArray = new int[priorities.length];
		System.arraycopy(priorities, 0, numArray, 0, priorities.length);
		Arrays.sort(numArray);
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < priorities.length; i++) {
			queue.add(numArray[priorities.length - 1 - i]);
		}
		while (!queue.isEmpty()) {
			for (int i = 0; i < priorities.length; i++) {
				if (priorities[i] == queue.peek()) {
					if (i == location) {
						return answer;
					}
					queue.poll();
					answer++;
				}
			}
		}
		return answer;

    }
}
/* 우선순위 큐를 참고
원래 priorityQueue를 사용할 수도 있으나 queue로 구현
*/
class Solution {
    public int solution(int[] priorities, int location) {
		int answer = 0;
		int[] numArray = new int[priorities.length];
		int time = 0;
		int count = 0;
		while (true) {
			int index = time % priorities.length;
			boolean check = true;
			for (int i = 0; i < priorities.length; i++) {
				int num = priorities[i];
				if (num > priorities[index]) {
					check = false;
					break;
				}
			}
			if (check) {
				count++;
				numArray[index] = count;
				priorities[index] = 0;
			}
			time++;
			if (numArray[location] != 0) {
				answer = numArray[location];
				break;
			}
		}
		return answer;
    }
}
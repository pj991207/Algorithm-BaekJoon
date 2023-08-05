import java.util.*;
import java.io.*;

public class Main {
	static int S;
	static String[] N;
	static int[] nums;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		S = Integer.parseInt(st.nextToken());
		N = st.nextToken().split("");
		nums = new int[N.length];
		for (int i = 0; i < N.length; i++) {
			nums[i] = Integer.parseInt(N[i]);
		}
		for (int j = 0; j < N.length; j++) {
			// 맨위 "-" 를 결정
			if (nums[j] == 1 || nums[j] == 4) {
				row(false);
			}
			if (nums[j] == 0 || nums[j] == 2 || nums[j] == 3 || nums[j] == 5 || nums[j] == 6 || nums[j] == 7
					|| nums[j] == 8 || nums[j] == 9) {
				row(true);
			}
			sb.append(" ");
		}
		sb.append("\n");
		// 상단 "|"를 결정
		for (int k = 0; k < S; k++) {
			for (int j = 0; j < N.length; j++) {
				if (nums[j] == 0 || nums[j] == 4 || nums[j] == 8 || nums[j] == 9) {
					column(true, true);
				}
				if (nums[j] == 1 || nums[j] == 2 || nums[j] == 3 || nums[j] == 7) {
					column(false, true);
				}
				if (nums[j] == 5 || nums[j] == 6) {
					column(true, false);
				}
				sb.append(" ");
			}
			sb.append("\n");
		}
		// 중간 "-" 를 결정
		for (int j = 0; j < N.length; j++) {
			if (nums[j] == 1 || nums[j] == 7 || nums[j] == 0) {
				row(false);
			}
			if (nums[j] == 4 || nums[j] == 2 || nums[j] == 3 || nums[j] == 5 || nums[j] == 6 || nums[j] == 9|| nums[j] == 8) {
				row(true);
			}
			sb.append(" ");
		}
		sb.append("\n");
		// 하단 "|"를 결정
		for (int k = 0; k < S; k++) {
			for (int j = 0; j < N.length; j++) {
				if (nums[j] == 1 || nums[j] == 4 || nums[j] == 3 || nums[j] == 9 || nums[j] == 7 || nums[j] == 5) {
					column(false, true);
				}
				if (nums[j] == 0 || nums[j] == 6 || nums[j] == 8) {
					column(true, true);
				}
				if (nums[j] == 2) {
					column(true, false);
				}
				sb.append(" ");
			}
			sb.append("\n");
		}
		//맨아래 "-"를 결정
		for (int j = 0; j < N.length; j++) {
			if (nums[j] == 1 || nums[j] == 7 || nums[j] == 4) {
				row(false);
			}
			if (nums[j] == 0 || nums[j] == 2 || nums[j] == 3 || nums[j] == 5 || nums[j] == 6 || nums[j] == 9|| nums[j] == 8) {
				row(true);
			}
			sb.append(" ");
		}
		System.out.println(sb);
	}

	static void row(boolean flag) {
		sb.append(" ");
		if (flag) {
			for (int i = 0; i < S; i++) {
				sb.append("-");
			}
		}
		if (!flag) {
			for (int i = 0; i < S; i++) {
				sb.append(" ");
			}
		}
		sb.append(" ");
	}

	static void column(boolean frontflag, boolean backflag) {
		if (frontflag) {
			sb.append("|");
		}
		if (!frontflag) {
			sb.append(" ");
		}
		for (int j = 0; j < S; j++) {
			sb.append(" ");
		}
		if (backflag) {
			sb.append("|");
		}
		if (!backflag) {
			sb.append(" ");
		}
	}
}

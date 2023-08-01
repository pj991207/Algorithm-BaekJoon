import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	static int[][] arr;
	static int[] dy = {0,0,1,-1,-1,1,-1,1};
	static int[] dx = {-1,1,0,0,1,-1,-1,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[19][19];
		for(int i = 0; i<19;i++) {
			StringTokenizer st =new StringTokenizer(br.readLine());
			for(int j = 0; j<19;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		StringBuilder sb = new StringBuilder();
		boolean flag = false;
		exit:
		for(int i = 0; i<19;i++) {
			for(int j = 0; j<19;j++) {
				int y = i;
				int x = j;
				if(arr[y][x]!=0) {
					if(row(y,x)) {
						sb.append(arr[y][x]+"\n");
						sb.append((y+1)+" "+(x-1));
						flag=true;
						break exit;
					}
					//세로체크
					if(col(y,x)) {
						sb.append(arr[y][x]+"\n");
						sb.append((y-1)+" "+(x+1));
						flag=true;
						break exit;
					}
					//오른쪽 대각 체크
					if(right(y,x)) {
						sb.append(arr[y][x]+"\n");
						sb.append((y+3)+" "+(x-1));
						flag=true;
						break exit;
					}
					//왼쪽 대각 체크
					if(left(y,x)) {
						sb.append(arr[y][x]+"\n");
						sb.append((y-1)+" "+(x-1));
						flag=true;
						break exit;
					}
				}
			}
		}
		if(!flag) {
			sb.append(0);
		}
		System.out.println(sb);
	}
	static boolean row(int y, int x) {
		int num = arr[y][x];
		for(int i = 0; i<2;i++){
			int a = y;
			int b = x;
			for(int k = 0 ; k<2;k++) {
				a = a+dy[i];
				b = b+dx[i];
				if(a>=0&&a<19&&b>=0&&b<19) {
					if(arr[a][b]!=num) {
						return false;
					}
				}
				else {
					return false;
				}
			}
		}
		if(x-3>=0&&x-3<19) {
			if(arr[y][x-3]==num)return false;
		}
		if(x+3>=0&&x+3<19) {
			if(arr[y][x+3]==num)return false;
		}
		return true;
	}
	static boolean col(int y, int x) {
		int num = arr[y][x];
		for(int i = 2; i<4;i++){
			int a = y;
			int b = x;
			for(int k = 0 ; k<2;k++) {
				a = a+dy[i];
				b = b+dx[i];
				if(a>=0&&a<19&&b>=0&&b<19) {
					if(arr[a][b]!=num) {
						return false;
					}
				}
				else {
					return false;
				}
			}
		}
		if(y-3>=0&&y-3<19) {
			if(arr[y-3][x]==num)return false;
		}
		if(y+3>=0&&y+3<19) {
			if(arr[y+3][x]==num)return false;
		}
		return true;
	}
	static boolean right(int y, int x) {
		int num = arr[y][x];
		for(int i = 4; i<6;i++){
			int a = y;
			int b = x;
			for(int k = 0 ; k<2;k++) {
				a = a+dy[i];
				b = b+dx[i];
				if(a>=0&&a<19&&b>=0&&b<19) {
					if(arr[a][b]!=num) {
						return false;
					}
				}
				else {
					return false;
				}
			}
		}
		if(y-3>=0&&y-3<19&&x+3>=0&&x+3<19) {
			if(arr[y-3][x+3]==num)return false;
		}
		if(y+3>=0&&y+3<19&&x-3>=0&&x-3<19) {
			if(arr[y+3][x-3]==num)return false;
		}
		return true;
	}
	static boolean left(int y, int x) {
		int num = arr[y][x];
		for(int i = 6; i<8;i++){
			int a = y;
			int b = x;
			for(int k = 0 ; k<2;k++) {
				a = a+dy[i];
				b = b+dx[i];
				if(a>=0&&a<19&&b>=0&&b<19) {
					if(arr[a][b]!=num) {
						return false;
					}
				}else {
					return false;
				}
			}
		}
		if(y-3>=0&&y-3<19&&x-3>=0&&x-3<19) {
			if(arr[y-3][x-3]==num)return false;
		}
		if(y+3>=0&&y+3<19&&x+3>=0&&x+3<19) {
			if(arr[y+3][x+3]==num)return false;
		}
		return true;
	}
}


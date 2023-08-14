import java.util.*;
import java.io.*;

public class Main {
	static int spaces[][],white,green;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		spaces = new int[N][N];
		
		for(int r = 0; r<N;r++) {
			for(int c = 0;c<N;c++) {
				spaces[r][c] = sc.nextInt();
			}
		}
		makeSpaces(0,0,N);
		System.out.println(white);
		System.out.println(green);
	}
	
	private static void makeSpaces(int sr, int sc,int size) {//영역의 좌상단 r,c, 영역 크기 size
		
		int sum = 0;
		for(int r = sr; r<size+sr;r++) {
			for(int c = sc;c<size+sc;c++) {
				sum += spaces[r][c]; 
			}
		}
		
		if(sum == 0) { //모두 하얀 색인 공간 (기저조건)
			white++;
		}else if(sum==size*size) { //모두 초록색인 공간 (기저조건)
			green++;
		}else {//두 색이 섞여 있는 공간
			makeSpaces(sr,sc,size/2);
			makeSpaces(sr+size/2,sc,size/2);
			makeSpaces(sr,sc+size/2,size/2);
			makeSpaces(sr+size/2,sc+size/2,size/2);
		}
	}
}
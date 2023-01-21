// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 숫자 정사각형
// https://www.acmicpc.net/problem/1051
import java.util.Scanner;

public class Main {	
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N, M;
		N = sc.nextInt();
		M = sc.nextInt();
		int[][] board = new int[N][M];

		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				board[i][j] = str.charAt(j) - '0';
			}
		}
	    // 1. 모든 행(i), 열(j)을 기준으로 변의 길이(k+1)만큼 떨어진 3좌표값을 비교하여, 모두 같은 값이면 최대 넓이 값을 갱신해줌.
		int answer = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = 1; i + k < N && j + k < M; k++) { 
	                if (board[i][j] == board[i + k][j] && board[i][j] == board[i][j + k]  && board[i][j] == board[i + k][j + k]) {
	                    if ( (k + 1) * (k + 1) > answer) {
	                        answer = (k + 1) * (k + 1) ;	                    	
	                    }
	                }
				}
			}
		}
			    
	    System.out.println(answer);		
	}
}

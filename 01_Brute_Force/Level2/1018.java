// 체스판 다시 칠하기
// https://www.acmicpc.net/problem/1018
import java.util.Scanner;

public class Main {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = 0, M = 0;
		String s;
		N = sc.nextInt();
		M = sc.nextInt();
		
		int[][] table = new int[N][M];
		
	    //1. 입력받기, W는 0, B는 1로 저장
		for (int i = 0; i < N; i++) {
			s = sc.next();
			for (int j = 0; j < M; j++) {
				if (s.charAt(j) == 'W') {
					table[i][j] = 0;
				} else {
					table[i][j] = 1;					
				}
			}
		}
		
		int answer = 8 * 8;
		for (int i = 0; i + 7 < N; i++) {
			for (int j = 0; j + 7 < M; j++) {
				int BW = 0;
				int WB = 0;
	            for (int ki = 0; ki < 8; ki++)
	            {
	                for (int kj = 0; kj < 8; kj++)
	                {
	                    // BW로 시작하는 체스판과의 차이 계산
	                    if ((ki + kj) % 2 == 0 && table[i + ki][j + kj] != 1)
	                    {
	                        BW += 1;
	                    }
	                    else if ((ki + kj) % 2 == 1 && table[i + ki][j + kj] != 0)
	                    {
	                        BW += 1;
	                    }
	                    // // WB로 시작하는 체스판과의 차이 계산 (BW의 반대값으로 계산)
	                    WB = 64 - BW;
	                }
	            }
	            answer = Math.min(answer, BW);
	            answer = Math.min(answer, WB);
			}
		}
	
	    
	    System.out.println(answer);		
	}
}

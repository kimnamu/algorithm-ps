// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 분해합
// https://www.acmicpc.net/problem/2231
import java.util.Scanner;

public class Main {	
	
	// 2. 분해합 계산
	public static int decomposition(int k) {
		int ret = k;
		
		while(k > 0) {
			ret = ret + k % 10;
			k = k /10;
		}
		
		return ret;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N, M =0;
		N = sc.nextInt();
		
	    // 1. 0 부터 N까지 완전 탐색을 통해 작은 수 부터 분해합이 N과 같아지는 최초의 수 찾기
		for (int i = 0; i < N; i++) {
			if (N == decomposition(i)) {
				M=i;
				break;
			}
		}
	
	    
	    System.out.println(M);		
	}
}

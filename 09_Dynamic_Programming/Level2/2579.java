// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 계단 오르기
// https://www.acmicpc.net/problem/2579
// 힌트
// 1. 연달아 세 계단을 밟을 수 없으므로 직전 계단을 안밟은 경우, 직전 계단을 밟은 경우를 나누어 dynamic programming 해준다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] v = new int[N];
		
		for(int i = 0; i < N; i++) {
			v[i] = Integer.parseInt(br.readLine());
		}
		
		int[][] dp = new int[2][N];
		
	    if (N >= 1)
	    {
	        dp[0][0] = v[0];
	        dp[1][0] = v[0];
	    }
	    if (N >= 2)
	    {
	        dp[0][1] = v[1];
	        dp[1][1] = v[0] + v[1];
	    }
	    for (int i = 2; i < N; i++)
	    {
	        dp[0][i] = v[i] + Math.max(dp[0][i - 2], dp[1][i - 2]);
	        dp[1][i] = v[i] + dp[0][i - 1];
	    }
	    
	    System.out.println(Math.max(dp[0][N - 1], dp[1][N - 1]));
		
	}
}

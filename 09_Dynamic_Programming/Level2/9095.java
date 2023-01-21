// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
  // 1, 2, 3 더하기
// https://www.acmicpc.net/problem/9095
// 힌트
// 1. 특정 숫자 n을 만들기 위해서는 n-3번째 수로부터 3을 더하거나, n-2번째 수로 부터 2를 더하거나, n-1번째 수로 부터 1을 만드는 방법 밖에 없음을 이용한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int MAXNUM = 12;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		int[] dp = new int[MAXNUM];
		
	    dp[1] = 1; // 1
	    dp[2] = 2; // 1+1, 2
	    dp[3] = 4; // 1+1+1, 1+2, 2+1, 3
	    for (int i = 4; i < MAXNUM; i++)
	    {
	        dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
	    }
	    while (T-- > 0)
	    {
	        int n = Integer.parseInt(br.readLine());
	        System.out.println(dp[n]);
	    }

	}
}

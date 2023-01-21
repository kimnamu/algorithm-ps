// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 1로 만들기
// https://www.acmicpc.net/problem/1463
// 힌트
// 1. Top-Down 방식을 이용한 dynamic programming 방법을 이용한다.
// 2. n에 도달했을때 비용이 기존에 memoization해둔 값보다 크다면 더 이상 탐색하지 않는다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[] dp = new int[1000001];
	
	static void solve(int n, int cnt)
	{
	    if (dp[n] > cnt)
	    {
	        dp[n] = cnt;
	    }
	    else
	    {
	        return;
	    }
	    if (n == 1)
	        return;
	    if (n % 2 == 0)
	        solve(n / 2, cnt + 1);
	    if (n % 3 == 0)
	        solve(n / 3, cnt + 1);
	    solve(n - 1, cnt + 1);
	}

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int answer = 0;
		
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		solve(N, 0);
		
		System.out.println(dp[1]);
		
		
	}
}

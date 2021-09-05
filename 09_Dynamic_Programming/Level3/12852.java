//1로 만들기 2
//https://www.acmicpc.net/problem/12852
//힌트
//1. Bottom up으로 0에서 N까지 번호 하나씩 순회하며 해당 번호까지 도달하는 최소 횟수를 갱신해준다.
//2. 최소 횟수의 과정을 출력해주기 위해, 각 번호의 최소 횟수 갱신 시 해당 번호로 오기 직전의 번호를 기록하는 배열을 같이 업데이트 해준다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int[] dp = new int[1000001];
	static int[] from = new int[1000001];

	static int solve(int N)
	{
	    dp[1] = 0;
	    for (int i = 2; i <= N; i++)
	    {
	        dp[i] = dp[i - 1] + 1;
	        from[i] = i - 1;
	        if (i % 3 == 0)
	        {
	            if (dp[i] > dp[i / 3] + 1)
	            {
	                dp[i] = dp[i / 3] + 1;
	                from[i] = i / 3;
	            }
	        }
	        if (i % 2 == 0)
	        {
	            if (dp[i] > dp[i / 2] + 1)
	            {
	                dp[i] = dp[i / 2] + 1;
	                from[i] = i / 2;
	            }
	        }
	    }
	    return dp[N];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
	    System.out.println(solve(N));
	    
	    while (true)
	    {
	        if (N == 0)
	            break;
	        System.out.print(N + " ");
	        N = from[N];
	    }

	}
}

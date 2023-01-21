// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 파일 합치기
// https://www.acmicpc.net/problem/11066
// 힌트
// 1. DFS를 통해 구간별 합치기 값이 가장 최소가 되는 값을 찾는다.
// 2. 각 구간별 합의 최소값을 찾기 위해 직전의 두 구간을 모두 search하고 이때 각 구간에 대해 또다시 최소 값을 구해준다.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] C;
	static int[] sum;
	static int[][] dp = new int[501][501];

	static int dfs(int l, int r)
	{
	    if (dp[l][r] != -1)
	        return dp[l][r];
	    if (r == l)
	    {
	        dp[l][r] = 0;
	        return dp[l][r];
	    }
	    int ret = Integer.MAX_VALUE;
	    for (int i = l; i < r; i++)
	    {
	        ret = Math.min(ret, dfs(l, i) + dfs(i + 1, r) + sum[r] - sum[l - 1]);
	    }
	    dp[l][r] = ret;
	    return ret;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			int K = Integer.parseInt(br.readLine());
			C = new int[K + 1];
			sum = new int[K + 1];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= K; i++) {
				C[i] = Integer.parseInt(st.nextToken());
	            sum[i] = sum[i - 1] + C[i];
	            
	            Arrays.fill(dp[i],-1);
			}
			
			System.out.println(dfs(1, K));
		}
	}

}

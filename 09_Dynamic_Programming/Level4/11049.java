// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 행렬 곱셈 순서
// https://www.acmicpc.net/problem/11049
// 힌트
// 1. DFS를 통해 구간별 연산수 값이 가장 최소가 되는 값을 찾는다.
// 2. 각 구간별 연산수의 최소값을 찾기 위해 직전의 두 메트릭스를 모두 search하고 이때 각 구간에 대해 또 다시 최소값을 구해준다.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int MAX_NUM = 501;
	static int N;
	static int[][] matrices = new int[MAX_NUM][2];
	static int[][] dp = new int[MAX_NUM][MAX_NUM];
	
	static int dfs(int l, int r)
	{
	    if (l == r)
	        return 0;
	    int ret = Integer.MAX_VALUE;
	    if (dp[l][r] != 0)
	        return dp[l][r];
	    for (int i = l; i < r; i++)
	        ret = Math.min(ret, dfs(l, i) + dfs(i + 1, r) + (matrices[l][0] * matrices[i][1] * matrices[r][1]));

	    dp[l][r] = ret;
	    return dp[l][r];
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				matrices[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
	    int answer = dfs(0, N - 1);
	    
	    System.out.println(answer);
	}

}

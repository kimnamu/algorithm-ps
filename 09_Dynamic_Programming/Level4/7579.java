// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 앱
// https://www.acmicpc.net/problem/7579
// 힌트
// 1. Memoization을 통해 첫 번째 부터 n번째까지의 비용에 따른 최소 메모리사용 값을 갱신해준다.
// 2. 이때 메모리를 사용할지 사용하지 않을지에 따라 다음 번째의 비용과 메모리값을 다르게 넣어준다.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] dp = new int[100][10001];
	static int[] m;
	static int[] c;
	static int answer = 1000000000;

	static void dfs(int index, int volume, int cost)
	{
	    if (volume >= M)
	    {
	        answer = Math.min(answer, cost);
	    }
	    if (dp[index][cost] != 0 && dp[index][cost] >= volume)
	    {
	        return;
	    }
	    dp[index][cost] = volume;
	    if (index + 1 < N)
	    {
	        dfs(index + 1, volume + m[index + 1], cost + c[index + 1]);
	        dfs(index + 1, volume, cost);
	    }
	    return;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		m = new int[N];
		c = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			m[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			c[i] = Integer.parseInt(st.nextToken());
		}
		
	    dfs(0, m[0], c[0]);
	    dfs(0, 0, 0);

	    System.out.println(answer);
	}

}

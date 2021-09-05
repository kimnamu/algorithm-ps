// 평범한 배낭
// https://www.acmicpc.net/problem/12865
// 힌트
// 1. dp[i][j]는 1부터 i번째 물품 중 무게의 합이 j인 경우의 가치 합이다.
// 2. dp[i][j]는 i번째 물건을 담는 경우와 담지 않는 경우의 최대값을 넣어준다.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K= Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[101][100001];
		int[] W = new int[101];
		int[] V = new int[101];
		
	    for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
	        W[i] = Integer.parseInt(st.nextToken());
	        V[i] = Integer.parseInt(st.nextToken());
	    	
	    }

	    for (int i = 1; i <= N; i++)
	    {
	        for (int j = 1; j <= K; j++)
	        {
	            if (j - W[i] >= 0)
	                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - W[i]] + V[i]);
	            else
	                dp[i][j] = dp[i - 1][j];
	        }
	    }
	    
	    System.out.println(dp[N][K]);

	}
}

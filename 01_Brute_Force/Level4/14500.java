//테트로미노
//https://www.acmicpc.net/problem/14500
//힌트
//1. 반례세트 : https://www.acmicpc.net/board/view/61597
//2. dfs를 활용하여 길이(크기)가 4일때까지의 합 중 가장 큰 값을 정답으로 갱신한다.
//3. 같은 위치의 같은 모양이 중복되지 않도록, limit_i, limit_j를 지정해주어
// 추가되는 블록이 limit_i보다 위에나 limit_i와 같거나 limit_j보다 작은쪽으로 생성되지 않도록 한다.
//4. dp를 사용하여 이미 점유된 블록은 추가로 점유하지 않도록 한다.
import java.util.Scanner;

public class Main {
	static int N, M;
	static int[][] scores;
	static boolean[][] dp;
	static int limit_i, limit_j;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		scores = new int[N][M];
		dp = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				scores[i][j] = sc.nextInt();
			}
		}
		
		int answer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				limit_i = i;
				limit_j = j;
				answer = Math.max(answer, dfs(i, j, 1));
			}
		}
		
		System.out.println(answer);
	}
	
	static int dfs(int i, int j, int length) {
		
	    if (i < 0 || i >= N || j < 0 || j >= M)
	        return 0;

	    // 3. 같은 위치의 같은 모양이 중복되지 않도록, limit_i, limit_j를 지정해주어
	    //    추가되는 블록이 limit_i보다 위에나 limit_i와 같거나 limit_j보다 작은쪽으로 생성되지 않도록 한다.
	    if (i < limit_i || (i == limit_i && j < limit_j))
	        return 0;
	    
	    // 4. dp를 사용하여 이미 점유된 블록은 추가로 점유하지 않도록 한다.
	    if (dp[i][j])
	        return 0;
	    
	    dp[i][j] = true;
	    int ret = 0;

	    // 크기가 4가 아니라면 다음 블록을 추가로 생성해야한다. 상하좌우 네 방향으로 시도후 가장 높은 점수로 갱신.
	    if (length != 4)
	    {
	        ret = Math.max(ret, dfs(i + 1, j, length + 1));
	        ret = Math.max(ret, dfs(i, j + 1, length + 1));
	        ret = Math.max(ret, dfs(i - 1, j, length + 1));
	        ret = Math.max(ret, dfs(i, j - 1, length + 1));
	    }
	    
	    // 크기가 1이면 상하좌우 외에도 아래 1칸 + 오른쪽 2칸 혹은 아래 2칸 + 오른쪽 1칸이 가능하다.
	    // 예를 들어, 아래 블록 모양
	    // 134  14
	    // 4    3
	    //    , 4
	    if (length == 1)
	    {
	        ret = Math.max(ret, dfs(i + 1, j, length + 2) + dfs(i, j + 1, length + 3));
	        ret = Math.max(ret, dfs(i + 1, j, length + 3) + dfs(i, j + 1, length + 2));
	    }
	    
	    // 크기가 2이면 상하좌우 외에도 아래 모양이 가능하다.
	    // 124   1    1  1
	    //  4   424  42  24
	    //    ,    ,  4, 4 ,
	    if (length == 2)
	    {
	        ret = Math.max(ret, dfs(i + 1, j, length + 2) + dfs(i, j + 1, length + 2));
	        ret = Math.max(ret, dfs(i, j - 1, length + 2) + dfs(i, j + 1, length + 2));
	        ret = Math.max(ret, dfs(i, j - 1, length + 2) + dfs(i + 1, j, length + 2));
	        ret = Math.max(ret, dfs(i + 1, j, length + 2) + dfs(i, j + 1, length + 2));
	    }
	    
	    dp[i][j] = false;
	    ret += scores[i][j];
	    
	    return ret;
	}
}

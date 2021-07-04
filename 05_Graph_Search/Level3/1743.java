//음식물 피하기
//https://www.acmicpc.net/problem/1743
//힌트
//1. 모든 위치를 탐색하다가 음식물이 발견되면 
// 해당 위치에서 상하좌우 위치로 DFS를 이용하여
// 음식물의 갯수를 모두 더해준다. 한번 카운팅했다면 0으로 만들어주어 다시 세지 않도록 한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int table[][];
	static boolean check[][];
	
	static int solve() {
		int answer = 0;
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < M + 1; j++) {
				if (table[i][j] == 1) {					
					answer = Math.max(answer, dfs(i, j, 1));
				}
			}
		}
		
		return answer;
	}
	
	static int dfs(int i, int j, int cnt) {
		table[i][j] = 0;
		if (i - 1 > 0 && table[i-1][j] == 1)
			cnt += dfs(i-1, j, 1);
	    if (j - 1 > 0 && table[i][j - 1] == 1)
	        cnt += dfs(i, j - 1, 1);
	    if (i + 1 <= N && table[i + 1][j] == 1)
	        cnt += dfs(i + 1, j, 1);
	    if (j + 1 <= M && table[i][j + 1] == 1)
	        cnt += dfs(i, j + 1, 1);
		
		return cnt;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
			
		table = new int[N+1][M+1];		
		check = new boolean[N+1][M+1];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			table[a][b] = 1;
		}
		
		int answer = solve();
		
		System.out.println(answer);
		
	}
}

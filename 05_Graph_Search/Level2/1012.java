// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 유기농 배추
// https://www.acmicpc.net/problem/1012
// 힌트
// 1. 모든 위치를 탐색하다가 배추가 심어진 곳을 발견하면,
// 정답에 1을 추가하고, dfs를 활용하여 인접한 모든 위치의 배추값을 false으로 바꿔 준다.
// 이러면 인접한 배추에 대해서는 정답에 1만 기여하게 된다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int M;
	static int N;
	static boolean table[][];
	
	static int solve() {
		int answer = 0;
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (table[i][j]) {
					answer++;
					DFS(i, j);
				}
			}
		}
		
		return answer;
	}
	
	static void DFS(int i, int j) {
		if (table[i][j])
			table[i][j] = false;
		if (i + 1 < M &&  table[i+1][j])
			DFS(i+1, j);
		if (i - 1 >= 0 &&  table[i-1][j])
			DFS(i-1, j);
		if (j + 1 < N && table[i][j+1])
			DFS(i,j+1);
		if (j - 1 >= 0 && table[i][j-1])
			DFS(i,j-1);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			table = new boolean[M][N];			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				table[a][b] = true;
			}
			
			int answer = solve();
			
			System.out.println(answer);
		}
	}
}

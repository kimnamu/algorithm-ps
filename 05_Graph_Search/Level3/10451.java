// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 순열 사이클
// https://www.acmicpc.net/problem/10451
// 힌트
// 1. 방향서이 있기 때문에 연결된 graph의 table을 만들게 된다면, 행과 열의 역할을 구분지어야한다.
// 2. 행은 from, 열은 to 관계일때, DFS를 통해 한쪽 방향으로 검출하도록 하자.
//  이때, 한번 방문하게된 노드는 따로 표시를 해두고, 새롭게 시작되는 노드의 갯수를 구하기가 시작되면 사이클의 갯수를 구하기 쉬울 것이다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] graph; 
	static boolean[] check;
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			graph = new int[N + 1][N + 1];
			check = new boolean[N + 1];
			
			for (int i = 1; i < N + 1; i++) {
				int y = Integer.parseInt(st.nextToken());
				graph[i][y] = 1;
			}
			
			int answer = solve();
			
			System.out.println(answer);
		}
	}
	
	static int solve() {
		int answer = 0;
		
		for (int i = 1; i < N + 1; i++) {
			if (!check[i]) {
				check[i] = true;
				DFS(i);
				answer++;
			}
		}
		
		return answer;
	}
	
	static void DFS(int s) {
		for (int i = 1; i < N + 1; i++) {
			if (!check[i] && graph[s][i] == 1) {
				DFS(i);
				check[i] = true;
			}
		}
	}
}

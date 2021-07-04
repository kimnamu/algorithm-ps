//DFS와 BFS
//https://www.acmicpc.net/problem/1260
//힌트
//1. DFS와 BFS를 기본적으로 구현할 수 있는지를 확인하는 문제이다.
//2. 만약 문제를 풀 수 없다면, 이론 공부를 좀 더 할 필요가 있다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static boolean[] check;
	static boolean[][] table;
	static int N;
	
	static void DFS(int k) {
		System.out.print(k + " ");
		check[k] = true;
		
		for (int i = 1; i <= N; i++) {
			if (!check[i] && table[k][i]) {
				DFS(i);
			}
		}
	}
	
	static void BFS(int k) {
		Queue<Integer> q = new LinkedList<>();
		q.add(k);
		check[k] = true;
		
		while(!q.isEmpty()) {
			int from = q.poll();
			System.out.print(from + " ");
			for (int i = 1; i <= N; i++) {
				if (!check[i] && table[from][i]) {
					check[i] = true;
					q.add(i);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		table = new boolean[N+1][N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			table[a][b] = true;
			table[b][a] = true;
		}
		
		check = new boolean[N+1];
		DFS(V);
		System.out.println();
		
		check = new boolean[N+1];
		BFS(V);
	}
}

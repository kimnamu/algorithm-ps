// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 바이러스
// https://www.acmicpc.net/problem/2606
// 1. DFS를 활용하여 1번 바이러스와 이어져있는 컴퓨터를 모두 찾으며 counting한다.
//    이때, 한번 방문한 컴퓨터는 재방문 할 필요가 없으므로 check배열을 통해 이미 한번 방문한 곳은 재방문하지 않도록 해준다.

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
	static int answer = -1;
	
	static void DFS(int k) {
		check[k] = true;
		answer++;
		
		for (int i = 1; i <= N; i++) {
			if (!check[i] && table[k][i]) {
				DFS(i);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		
		table = new boolean[N+1][N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			table[a][b] = true;
			table[b][a] = true;
		}
		
		check = new boolean[N+1];
		DFS(1);
		
		System.out.println(answer);
	}
}

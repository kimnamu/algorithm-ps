// 결혼식
// https://www.acmicpc.net/problem/5567
// 힌트
// 1. BFS를 이용하여 깊이 2까지의 모든 노드의 개수를 파악한다.

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
	
	static int BFS(int s, int limit) {
		int answer = 0;
		Queue<Integer> q = new LinkedList<>();		
		q.add(s);
		
		while (!q.isEmpty() && limit >= 0) {
			int q_size = q.size();
			
			for (int i = 0 ; i < q_size; i++) {
				int from = q.poll();
				
				if (!check[from]) {
					answer += 1;
					check[from] = true;
					
					for (int j = 1; j <= N; j++) {
						if (!check[j] && table[from][j]) {
							q.add(j);
						}
					}				
				}
			}
	        limit -= 1;
		}
		
		return answer - 1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		table = new boolean[N+1][N+1];
		check = new boolean[N+1];
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			table[x][y] = true;
			table[y][x] = true;
		}
		
		int answer = BFS(1, 2);
		
		System.out.println(answer);
	}}

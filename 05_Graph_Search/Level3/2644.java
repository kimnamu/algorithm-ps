// 촌수계산
// https://www.acmicpc.net/problem/2644
// 힌트
// 1. 부모-자식, 자식-부모 와같이 특별히 순서는 상관 없다.
// 2. BFS를 통해 목표로 하는 노드를 찾는데 걸리는 스텝이 촌수계산의 답이 됩니다.

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
	
	static int BFS(int s, int e) {
		Queue<Integer> q = new LinkedList<>();
		
		q.add(s);
		check[s] = true;
		
		int answer = 0;
		while(!q.isEmpty()) {
			int q_size = q.size();
			for (int i = 0 ; i < q_size; i++) {
				int from = q.poll();
				if (from == e)
					return answer;
				for (int j = 1; j <= N; j++) {
					if (!check[j] && table[from][j]) {
						check[j] = true;
						q.add(j);
					}
				}				
			}
			answer += 1;
		}
		
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		int M = Integer.parseInt(br.readLine()); 
		table = new boolean[N+1][N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			table[x][y] = true;
			table[y][x] = true;
		}
		
		check = new boolean[N+1];
		int answer = BFS(s, e);
		
		System.out.println(answer);
	}
}

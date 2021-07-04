// 벽 부수고 이동하기
// https://www.acmicpc.net/problem/2206
// 힌트
// 1. BFS를 통해 시작지점에서 끝점까지 도달하는데 필요한 가장 짦은 거리를 구한다.
// 2. 벽을 부순 경우와, 부수지 않은 경우를 나누너 최소 거리를 갱신해 준다. (dist 매트릭스를 2배로 만들어 활용)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos{
	int y;
	int x;
	int block;
	public Pos(int y, int x, int block) {
		this.y = y;
		this.x = x;
		this.block = block;
	}
}

public class Main {
	static int N, M;
	static int[][] table;
	static int[][][] dist;
	static int[] dx_array = {1, -1, 0, 0};
	static int[] dy_array = {0, 0, -1, 1};

	static int BFS() {
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(0, 0, 1));
		dist[0][0][1] = 1;
		
		while (!q.isEmpty()) {
			Pos tp = q.poll();
			int y = tp.y;
			int x = tp.x;
			int block = tp.block;
			
			if (y == N - 1 && x == M - 1) {
				return dist[y][x][block];
			}
			
			for (int i = 0; i < 4; i++) {
				int dy = y + dy_array[i];
				int dx = x + dx_array[i];
				
	            if (0 <= dy && dy < N && 0 <= dx && dx < M)
	            {
	                if (table[dy][dx] == 1 && block == 1)  
	                {
	                    dist[dy][dx][0] = dist[y][x][1] + 1;
	                    q.add(new Pos(dy, dx, 0));
	                }
	                else if (table[dy][dx] == 0 && dist[dy][dx][block] == 0)
	                {
	                    dist[dy][dx][block] = dist[y][x][block] + 1;
	                    q.add(new Pos(dy, dx, block));
	                }
	            }
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		table = new int[N][M];
		dist = new int[N][M][2];
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < M; j++) {
				table[i][j] = tmp.charAt(j) - '0';
			}
		}
		
		int answer = BFS();
		System.out.println(answer);
	}
}

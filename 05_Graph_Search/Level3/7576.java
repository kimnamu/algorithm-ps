// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 토마토
// https://www.acmicpc.net/problem/7576
// 힌트
// 1. 처음에 익은 토마토를 queue에 넣어주어 상하좌우 방향으로 안익은 토마토를 익힌 토마토로 바꾸어 나가면 된다.
//  queue에 들어오는 값들이 처음 input 위치와 얼마만큼 떨어졌는지를 계산해 내야한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point{
	int x;
	int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Point add(Point p) {
		return new Point(this.x + p.x, this.y + p.y);
	}
}

public class Main {
	static int board[][];
	static boolean check[][];
	static int N, M;
	static Point[] dxy = {new Point(-1, 0), new Point(1, 0), new Point(0, -1), new Point(0, 1)};
	
	static int solve() {
		int answer = 0;
		
		Queue<Point> q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 1) {
					q.add(new Point(i, j));
					check[i][j] = true; 
				}
			}
		}

		while(!q.isEmpty()) {
			if (isAllRipen()) {
				return answer;
			}
			int q_size = q.size();
			
			for (int i = 0; i < q_size; i++) {
				Point current = q.poll();
				
				for (Point tp : dxy) {
					Point np = current.add(tp);
					if (insideBoard(np) && board[np.x][np.y]==0 && !check[np.x][np.y]) {
						q.add(np);
						check[np.x][np.y] = true; 
						board[np.x][np.y] = 1; 
					}
				}				
			}
			answer += 1;
		}
		
		return -1;
	}
	
	// 창고에 있는 토마토가 모두 익었는지 확인하는 함수
	static boolean isAllRipen() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}
	
	static boolean insideBoard(Point p) {
		return (p.x >= 0 && p.x < N && p.y >=0 && p.y < M);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		check = new boolean[N][M];
		
		for (int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answer = solve();
		
		System.out.println(answer);
	}
}

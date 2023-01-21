// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
//섬의 개수
//https://www.acmicpc.net/problem/4963
//힌트
//1. 모든 섬의 위치를 순회하면서, 
// 한번도 방문한적 없는 새로운 섬의 번호가 나타나면
// DFS를 활용하여 인접한 섬을 모두 순회한다.
//2. 이때 인접한 모든 섬은 상하좌우 뿐만 아니라 대각선도 포함됨을 주의하자.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int w;
	static int h;
	static int table[][];
	
	static int solve() {
		int answer = 0;
		
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (table[i][j] == 1) {
					answer++;
					DFS(i, j);
				}
			}
		}
		
		return answer;
	}
	
	static void DFS(int i, int j) {
		if (table[i][j] == 1)
			table[i][j] = 0;
		
		for (int ii = -1; ii <= 1; ii++) {
			for (int jj = -1; jj <= 1; jj++) {
				if (ii == 1 && i + ii >= h)
					continue;
				if (ii == -1 && i + ii < 0)
					continue;
				if (jj == 1 && j + jj >= w)
					continue;
				if (jj == -1 && j + jj < 0)
					continue;
				
				if (table[i + ii][j + jj] == 1) {
					DFS(i+ii, j+jj);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if (w ==0 && h ==0){
				break;
			}
			
			table = new int[h][w];			
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					table[i][j] = Integer.parseInt(st.nextToken());					
				}
			}
			
			int answer = solve();
			
			System.out.println(answer);
		}
	}
}

// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 상근이의 여행
// https://www.acmicpc.net/problem/9372
// 힌트
// 1. 모든 나라가 연결되어 있다면, 모든 나라를 연결하는 최소의 간선 개수는 N-1개 이다.(최소 스패닝 트리 성질)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			boolean[][] table = new boolean[N+1][N+1];
			
			for (int i = 0; i < M; i++) {
				st= new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				table[a][b] = true;
				table[b][a] = true;
			}
			
			System.out.println(N-1);
		}
	}

}

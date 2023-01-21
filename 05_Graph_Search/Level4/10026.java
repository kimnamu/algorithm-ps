// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
//적록색약
//https://www.acmicpc.net/problem/10026
//힌트
//1. RGB의 서로 다른 색상들에대해 DFS를 활용하여 몇개의 군집으로 나뉘어져있는지 counting한다.
//2. 적록색약이 R과 G의 구분이 없는 것이므로 모든 R을 G로 바꿔 준 후 1을 반복한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static char[][] table;
	static boolean[][] check;
	static int[] dx_array = {-1, 1, 0, 0};
	static int[] dy_array = {0, 0, -1, 1};

	static int solve() {
		int answer = 0;
		check = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!check[i][j]) {
					answer++;
					check[i][j] = true;
					dfs(i, j);
				}
			}
		}
		
		return answer;
	}
	
	static void dfs(int i, int j) {
	    for (int k = 0; k < 4; k++)
	    {
	        int dx = i + dx_array[k];
	        int dy = j + dy_array[k];
	        if (0 <= dx && dx < N && 0 <= dy && dy < N  && 
	        		table[i][j] == table[dx][dy] && !check[dx][dy])
	        {
	        	check[dx][dy] = true;
	            dfs(dx, dy);
	        }
	    }

	}
	
	static void convertR2G()
	{
	    for (int i = 0; i < N; i++)
	    {
	        for (int j = 0; j < N; j++)
	        {
	            if (table[i][j] == 'R')
	                table[i][j] = 'G';
	        }
	    }
	}

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		table = new char[N][N];
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < N; j++) {
				table[i][j] = tmp.charAt(j);
			}
		}
		
		int answer1 = solve();
		
		convertR2G();
		
		int answer2 = solve();
		
		System.out.println(answer1 + " " + answer2);
	}

}

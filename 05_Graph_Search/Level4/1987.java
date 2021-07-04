// 알파벳
// https://www.acmicpc.net/problem/1987
// 힌트
// 1. DFS를 통해 가장 길게 만들수 있는 알파벳의 길이를 갱신한다.
// 2. 이때 한번 지나간 알파벳은 체크해주어 DFS탐색 위치에서 배재해준다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int R, C;
	static int[][] table;
	static boolean[] alpha;
	static int answer = 1;
	static int[] dx_array = {1, -1, 0, 0};
	static int[] dy_array = {0, 0, -1, 1};

	static void DFS(int i, int j, int depth) {
		answer = Math.max(answer, depth);
		
		for (int k = 0; k < 4; k++) {
			int dx = i + dx_array[k];
			int dy = j + dy_array[k];
			
			if (0 <= dx && dx < R && 0 <= dy && dy < C && alpha[table[dx][dy]]) {
				alpha[table[dx][dy]] = false;
				DFS(dx, dy, depth + 1);
				alpha[table[dx][dy]] = true;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		table = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				table[i][j] = s.charAt(j) - 'A';
			}
		}
		
		alpha = new boolean[26];
		Arrays.fill(alpha, true);
		alpha[table[0][0]] = false;
		
		DFS(0, 0, 1);
		
		System.out.println(answer);
	}
}

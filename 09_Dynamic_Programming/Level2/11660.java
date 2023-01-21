// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 구간 합 구하기 5
// https://www.acmicpc.net/problem/11660
// 힌트
// 1. 매번 구간합을 구하려면 O(N^2 x M)이 계속 발생하므로 하기의 점화식을 이용하여 구간합을 반환해준다.
// - 이 점화식을 이용하면 모든 좌표에 대해 (0,0) 부터 (x,y)의 합을 O(N^2)에 구해 놓을 수 있고, 그후로는 O(1)만에 값을 반환할 수 있어 전체 복잡도가 O(N^2)이 된다.
// - 점화식 : 구간합(x1, y1, x2, y2) = 구간합(0, 0, x1-1, y2) + 구간합(0, 0, x2, y1-1) - 구간합(0, 0, x1-1, y1-1) + 값 (x2, y2)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] table = new int[N + 1][N + 1];
		int[][] area = new int[N + 1][N + 1];
		
	    for (int i = 1; i <= N; i++)
	    {
	    	st = new StringTokenizer(br.readLine());
	        for (int j = 1; j <= N; j++)
	        {
	            table[i][j] = Integer.parseInt(st.nextToken());
	        }
	    }

	    for (int i = 1; i <= N; i++)
	    {
	        for (int j = 1; j <= N; j++)
	        {
	            area[i][j] += area[i - 1][j] + area[i][j - 1] - area[i - 1][j - 1] + table[i][j];
	        }
	    }
	    
	    while (M-- > 0)
	    {
	        int x1, y1, x2, y2;
	        st = new StringTokenizer(br.readLine());
	        x1 = Integer.parseInt(st.nextToken());
	        y1 = Integer.parseInt(st.nextToken());
	        x2 = Integer.parseInt(st.nextToken());
	        y2 = Integer.parseInt(st.nextToken());
	        x1 -= 1;
	        y1 -= 1;
	        int answer = area[x2][y2] - area[x1][y2] - area[x2][y1] + area[x1][y1];
	        System.out.println(answer);
	    }
	    
		
	}
}

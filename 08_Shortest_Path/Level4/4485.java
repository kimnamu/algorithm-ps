// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 녹색 옷 입은 애가 젤다지?
// https://www.acmicpc.net/problem/4485
// 1. bfs를 통해 0,0에서 상, 하, 좌, 우로 한칸씩 순회하며 순회하는 위치에서 최소비용으로 도달할 경우,
//    그 위치를 중심으로 다시 상, 하, 좌, 우를 순회하며 모든 지점의 최소 비용을 갱신한다.
// 2. 해당 위치에서 최소비용으로의 갱신이 일어나지 않으면 그 순회는 멈추도록 한다.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Queue;

class Po{
	int x;
	int y;
	int z;
	public Po(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}

public class Main {
	static final int MAX_N = 125;
	static int table[][] = new int[MAX_N][MAX_N];
	static int[][] dp;

	static int dx[] = {-1, 0, 1, 0};
	static int dy[] = {0, 1, 0, -1};
	
	static void bfs(int N) {
		Queue<Po> q = new LinkedList<>();
		q.add(new Po(0, 0, 0));
		
	    while (!q.isEmpty())
	    {
	        int size = q.size();
	        while (size-- > 0)
	        {
	            Po p = q.poll();
	            int i = p.x;
	            int j = p.y;
	            int cost = p.z;
	            
	            if (dp[i][j] > table[i][j] + cost)
	            {
	                dp[i][j] = table[i][j] + cost;
	                for (int k = 0; k < 4; k++)
	                {
	                    int x = i + dx[k];
	                    int y = j + dy[k];
	                    if (x >= 0 && x < N && y >= 0 && y < N)
	                    {
	                        q.add(new Po(x, y, dp[i][j]));
	                    }
	                }
	            }
	        }
	    }

	}
	
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int index = 0;
		while (true) {
			index += 1;
			int N = Integer.parseInt(br.readLine());
			if (N == 0)
				break;
			dp = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					table[i][j] = Integer.parseInt(st.nextToken());					
				}
				Arrays.fill(dp[i], Integer.MAX_VALUE);
			}
			
			bfs(N);
			
			System.out.println("Problem " + index +": " + dp[N-1][N-1]);
			
			
		}
		
	}
}

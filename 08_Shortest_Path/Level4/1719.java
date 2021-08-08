// 택배
// https://www.acmicpc.net/problem/1719
// 힌트
// 1. 모든 지점간의 최단 거리를 계산해주는 플로이드 와샬 알고리즘을 이용한다.
//    입력받는 지점의 출발점을 지정해 두었다가 최소거리가 갱신되면 갱신된 지점의 출발점으로 현재 출발점을 바꾸어주는 원리이다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final int MAXNUM = 201;
	static int n, m;
	static int[][] dist = new int[MAXNUM][MAXNUM];
	static int[][] from = new int[MAXNUM][MAXNUM];
	
	static void floydwarshall()
	{
	    for (int k = 1; k <= n; k++)
	    {
	        for (int i = 1; i <= n; i++)
	        {
	            for (int j = 1; j <= n; j++)
	            {
	                if (dist[i][j] > dist[i][k] + dist[k][j])
	                {
	                    dist[i][j] = dist[i][k] + dist[k][j];
	                    from[i][j] = from[i][k];
	                }
	            }
	        }
	    }
	}

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
	    for (int i = 0; i < MAXNUM; i++)
	    {
	        for (int j = 0; j < MAXNUM; j++)
	        {
	            if (i == j)
	            {
	                dist[i][j] = 0;
	            }
	            else
	            {
	                dist[i][j] = 1000000000;
	            }
	        }
	    }

	    for (int i = 0; i < m; i++)
	    {
	    	st = new StringTokenizer(br.readLine());
	    	int a = Integer.parseInt(st.nextToken());
	    	int b = Integer.parseInt(st.nextToken());
	    	int c = Integer.parseInt(st.nextToken());
	        dist[a][b] = c;
	        dist[b][a] = c;
	        from[a][b] = b;
	        from[b][a] = a;
	    }

	    floydwarshall();

	    for (int i = 1; i <= n; i++)
	    {
	        for (int j = 1; j <= n; j++)
	        {
	            if (i == j)
	            {
	                System.out.print("- ");
	            }
	            else
	            {
	            	System.out.print(from[i][j] + " ");
	            }
	        }
	        System.out.println();
	    }

	}
}

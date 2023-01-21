// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 음악프로그램
// https://www.acmicpc.net/problem/2623
// 힌트
// 1.  PD들 서로의 목록에 싸이클이 있는 경우 모든 PD들의 요구사항을 만족할 수 없으니 위상정렬을 하면서 사이클 존재 여부 또한 검사해야한다.
// 2.  맨 마지막 노드인 리프를 제일 끝에 두는 방법이 일반적인 위상 정렬의 방법이다.
//     leaf 노드들을 결과를 저장할 배열의 끝에 넣고, 트리에 제외하면서 다음 리프노드를 찾는것을 반복하면 결국 배열에는 위상 정렬된 트리를 얻을 수 있다.


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer> v = new ArrayList<>();
	static boolean[] visited;
	static boolean[][] adj;
	static int N;

	static boolean dfs(int k)
	{
	    visited[k] = true;
	    
	    for (int i = 0; i < N; i++)
	    {
	        if (adj[k][i] == false)
	            continue;
	        
	        if (visited[i])
	        {
	            if (!v.contains(i))
	                return false;
	        } else
	        {
	            if (!dfs(i))
	                return false;
	        }
	    }
	    v.add(k);
	    return true;
	}

	
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N];
		adj = new boolean[N][N];
		
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int t = Integer.parseInt(st.nextToken());
			int a = 0;
			int b = 0;
			
			for (int j = 0; j < t; j++) {
				a = Integer.parseInt(st.nextToken()) - 1;
	            if (j != 0)
	            {
	                adj[b][a] = true;
	            }
	            b = a;
			}
		}
		
	    for (int i = 0; i < N; i++)
	    {
	        if (!visited[i] && !dfs(i))
	        {
	            System.out.println(0);
	            return;
	        }
	    }
	    
	    for (int i = N - 1; i >= 0; i--) {
	    	System.out.println(v.get(i) + 1);
	    }
	}
}

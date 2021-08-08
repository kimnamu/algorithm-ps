// 작업
// https://www.acmicpc.net/problem/2056
// 힌트
// 1. 전에 작업에 걸리는 시간을 위상정렬을 통해 구한다.
// - i번까지 작업을 완료하는데 걸리는 시간을 cost[i]라고 하고, 처음에 0으로 초기화 한다.
// - depth[i] == 0 인 정점들만 작업하는데 걸리는 시간으로 cost를 초기화 한다.
// - 위상정렬된 순서대로 정점들을 방문하면서 cost[next] = max(cost[next], cost[curr]+work[next])로 초기화해준다.
// - 위상정렬 후 cost[i]중 최대값을 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 

public class Main {
	static int[] v, depth, cost;
	static ArrayList<ArrayList<Integer>> adj;
	static int N;
	
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		depth = new int[N + 1];
		cost = new int[N + 1];
		v = new int[N + 1];
		
		adj = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) {
			adj.add(new ArrayList<>());
		}
		
		StringTokenizer st;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			v[i] = Integer.parseInt(st.nextToken());
			
			int M = Integer.parseInt(st.nextToken());
			for (int j = 0; j < M; j++) {
	            int x = Integer.parseInt(st.nextToken());
	            adj.get(x).add(i);
	            depth[i] += 1;

			}
		}
	    
		Queue<Integer> q = new LinkedList<>();
	    for (int i = 1; i <= N; i++)
	    {
	        if (depth[i] == 0)
	        {
	        	q.add(i);
	            cost[i] = v[i];
	        }
	    }
	    
	    while (q.size() > 0)
	    {
	        int curr = q.poll();
	        
	        for (int j = 0; j < adj.get(curr).size(); j++)
	        {
	            int y = adj.get(curr).get(j);
	            
	            cost[y] = Math.max(cost[y], v[y] + cost[curr]);
	            depth[y] -= 1;
	            if (depth[y] == 0)
	            {
	                q.add(y);
	            }
	        }
	    }
	    int answer = 0;
	    for (int i = 1; i <= N; i++)
	    {
	    	answer = Math.max(answer,  cost[i]);
	    }
	    System.out.println(answer);
    }
}

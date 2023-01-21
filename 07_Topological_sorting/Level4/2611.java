// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 자동차경주
// https://www.acmicpc.net/problem/2611
// 힌트
// 1. 문제 조건을 통해 경로 내 순환 사이클이 없다는 점을 확인하여 위상정렬을 이용하여 푼다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Road{
	int to;
	int score;
	
	public Road(int to, int score) {
		this.to = to;
		this.score = score;
	}
}

public class Main {
	static int[] d, pre, depth, cost;
	static ArrayList<ArrayList<Road>> adj;
	
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		depth = new int[N + 1];
		cost = new int[N + 1];
		d = new int[N + 1];
		pre =new int[N + 1];
		
		adj = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) {
			adj.add(new ArrayList<>());
		}
		
		StringTokenizer st;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			
			if (p == 1) {
				d[q] = r;
				pre[q] = 1;
			} else {
				adj.get(p).add(new Road(r, q));
				depth[q] += 1;
			}
		}
	    
		Queue<Integer> q = new LinkedList<>();
	    for (int i = 1; i <= N; i++)
	    {
	        if (depth[i] > 0)
	        {
	        	continue;
	        }
	        for (int j = 0; j < adj.get(i).size(); j++)
	        {
	            int nv = adj.get(i).get(j).to, nx = adj.get(i).get(j).score;
	            if (d[nx] < d[i] + nv)
	            {
	                d[nx] = d[i] + nv;
	                pre[nx] = i;
	            }
	            depth[nx] -= 1;
	        }
	        depth[i] = 1;
	        i = -1;
	    }
	    
	    int cnt = 0;

	    cost[cnt++] = 1;
	    while (pre[1] != 1)
	    {
	        cost[cnt++] = pre[1];
	        pre[1] = pre[pre[1]];
	    }
	    cost[cnt++] = pre[1];
	    
	    System.out.println(d[1]);
	    for (int i = cnt - 1; i >= 0; i--) {
	    	System.out.print(cost[i] + " ");
	    }

    }
}

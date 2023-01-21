// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 게임 개발
// https://www.acmicpc.net/problem/1516
// 힌트
// 1. node간의 인과관계가 있기 때문에 위상정렬을 이용하여 풀 수 있다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 

public class Main {
	static int[] depth, value, cost;
	static ArrayList<ArrayList<Integer>> v;
	static int N;
	
	static void topologicalSort()
	{
		Queue<Integer> q = new LinkedList<>();
	    for (int i = 1; i <= N; i++)
	    {
	        if (depth[i] == 0)
	        {
	        	q.add(i);
	            cost[i] = value[i];
	        }
	    }
	    for (int i = 1; i <= N; i++)
	    {
	        int x = q.poll();
	        
	        for (int j = 0; j < v.get(x).size(); j++)
	        {
	            int y = v.get(x).get(j);
	            cost[y] = Math.max(cost[y], value[y] + cost[x]);
	            depth[y] -= 1;
	            if (depth[y] == 0)
	            {
	                q.add(y);
	            }
	        }
	    }
	}
	
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		depth = new int[N + 1];
		value = new int[N + 1];
		cost = new int[N + 1];
		
		v = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) {
			v.add(new ArrayList<>());
		}
		
		StringTokenizer st;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			value[i] = Integer.parseInt(st.nextToken());
			
	        while (true)
	        {
	            int x = Integer.parseInt(st.nextToken());
	            if (x == -1)
	                break;
	            v.get(x).add(i);
	            depth[i] += 1;
	        }
		}
		
	    topologicalSort();
	    for (int i = 1; i <= N; i++)
	    {
	    	System.out.println(cost[i]);
	    }
	}
}

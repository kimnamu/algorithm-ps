// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 최종 순위
// https://www.acmicpc.net/problem/3665
// 힌트
// 1. 위상정렬을 이용해 정렬 후 순위를 출력 한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static final int MAXNUM = 501;
	static int[] team = new int[MAXNUM];
	static int[] order = new int[MAXNUM];
	static int[] indegree = new int[MAXNUM];
	
	static ArrayList<Integer> answer = new ArrayList<>();
	static boolean[][] adj = new boolean[MAXNUM][MAXNUM];
	static int n, m;
	static BufferedReader br;
	
	static int topologicalSort()
	{
	    Queue<Integer> q = new LinkedList<>();
	    for (int i = 1; i <= n; i++)
	    {
	        if (indegree[i] == 0)
	            q.add(i);
	    }

	    while (q.size()>0)
	    {
	        if (q.size() > 1)
	            return 0; //불확실한 순위
	        int cur = q.poll();

	        answer.add(team[cur]);
	        if (answer.size() == n)
	            return 1; //올바른 순위

	        for (int i = 1; i <= n; i++)
	        {
	            if (!adj[cur][i])
	                continue;
	            adj[cur][i] = false;
	            indegree[i]--;
	            if (indegree[i] == 0)
	                q.add(i);
	        }
	    }
	    return -1; //순위를 정할 수 없음
	}

	static void init() throws IOException
	{
	    answer.clear();
	    Arrays.fill(team, 0);
	    Arrays.fill(order, 0);
	    
	    Arrays.fill(indegree, 0);
	    adj = new boolean[MAXNUM][MAXNUM];
	    
		StringTokenizer st = new StringTokenizer(br.readLine());

	    for (int i = 1; i <= n; i++)
	    {
	        team[i] = Integer.parseInt(st.nextToken());
	        order[team[i]] = i;
	    }

	    for (int i = 1; i < n; i++)
	    {
	        for (int j = i + 1; j <= n; j++)
	        {
	            adj[i][j] = true;
	            indegree[j] += 1;
	        }
	    }
	}

	public static void main(String[] args) throws IOException, NumberFormatException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			n = Integer.parseInt(br.readLine());
			init();
			m = Integer.parseInt(br.readLine());
			
	        for (int j = 0; j < m; j++)
	        {
	        	StringTokenizer st = new StringTokenizer(br.readLine());
	        	int f = Integer.parseInt(st.nextToken());
	        	int s = Integer.parseInt(st.nextToken());
	            if (order[f] > order[s]) {
	            	int tmp = f;
	            	f = s;
	            	s = tmp;
	            }
	                
	            int node_f = order[f], node_s = order[s];

	            adj[node_f][node_s] = false;
	            indegree[node_s]--;

	            adj[node_s][node_f] = true;
	            indegree[node_f] += 1;
	        }
			
	        int result = topologicalSort();
	        if (result == -1)
	            System.out.println("IMPOSSIBLE");
	        else if (result == 0)
	            System.out.println("?");
	        else
	        {
	        	for (int j = 0; j < answer.size(); j++)
	            	System.out.print(answer.get(j)+ " ");
	        	System.out.println();
	        }	
		}		
	}
}

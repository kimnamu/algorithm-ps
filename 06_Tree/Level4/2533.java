// 사회망 서비스(SNS)
// https://www.acmicpc.net/problem/2533
// 힌트
// 1. Tree구조를 이용한 완전탐색과 DP를 활용한다.
// 2. 현재 정점이 얼리어답터라면, 연결되어 있는 정점도 얼리어답터로 설정하는 경우, 연결되어 있는 정점을 얼리어답터로 설정하지 않는 경우.
//    이 2가지 경우를 모두 비교한 후에 더 최소값으로 값을 저장해 주면 된다.
// 3. 현재 정점이 얼리어답터가 아니라면, 이 현재 정점과 연결되어 있는 정점들은 반드시 얼리어답터여야 한다.
//    따라서 이 경우에는 다음 정점으로 넘어가기 위해서 탐색을 할 때, 연결되어 있는 정점들은 반드시 얼리어답터가 되도록탐색을 진행하면 된다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static ArrayList<ArrayList<Integer>> v;
	static ArrayList<ArrayList<Integer>> tree;
	static boolean[] visited;
	static int dp[][];
	
	static void init_tree(int index)
	{
	    visited[index] = true;
	    for (int i = 0; i < v.get(index).size(); i++)
	    {
	        int next = v.get(index).get(i);
	        if (visited[next] == false)
	        {
	            tree.get(index).add(next);
	            init_tree(next);
	        }
	    }
	}

	static int DFS(int index, int state)
	{
	    if (dp[index][state] != -1)
	        return dp[index][state];
	    if (state == 1)
	    {
	        dp[index][state] = 1;
	        for (int i = 0; i < tree.get(index).size(); i++)
	        {
	            int next = tree.get(index).get(i);
	            dp[index][state] += Math.min(DFS(next, 0), DFS(next, 1));
	        }
	    }
	    else
	    {
	        dp[index][state] = 0;
	        for (int i = 0; i < tree.get(index).size(); i++)
	        {
	            int next = tree.get(index).get(i);
	            dp[index][state] += DFS(next, 1);
	        }
	    }
	    return dp[index][state];
	}

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		v = new ArrayList<>();
		tree = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) {
			v.add(new ArrayList<>());
			tree.add(new ArrayList<Integer>());
		}
		
		StringTokenizer st;
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			v.get(a).add(b);
			v.get(b).add(a);
		}
		visited = new boolean[N + 1];
		init_tree(1);
		
		dp = new int[N + 1][2];
		for (int i = 0; i< N + 1; i++) {
			dp[i][0] = dp[i][1] = -1;
		}
		
		System.out.println(Math.min(DFS(1, 0), DFS(1, 1)));
		
	}
}

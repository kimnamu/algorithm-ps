// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 나무 탈출
// https://www.acmicpc.net/problem/15900
// 힌트
// 1. 성원이는 먼저 시작하기 때문에 홀수 번째 턴이다. 때문에 짝수 번째 턴에 모든 말이 사라지면 성원이가 지가 된다.
// 2. root의 깊이를 0으로 잡았을때, 모든 리프노드의 깊이의 합이 홀수이면 성원이가 이기게 된다.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> tree;
	static int total_depth = 0;
	
	static void dfs(int node, int depth)
	{
	    boolean flag = true;
	    int size = tree.get(node).size();
	    for (int i = 0; i < size; i++)
	    {
	        int node_c = tree.get(node).get(i);
	        if (visited[node_c])
	            continue;
	        visited[node_c] = true;
	        flag = false;
	        dfs(node_c, depth + 1);
	    }
	    if (flag)
	    {
	        total_depth += depth % 2;
	    }
	}

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		visited = new boolean[N + 1];
		
		tree = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) {
			tree.add(new ArrayList<>());
		}
		
		for (int i = 0; i < N - 1; i++) {
			int a, b;
			StringTokenizer st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			tree.get(a).add(b);
			tree.get(b).add(a);
		}
		
		visited[1] = true;
		dfs(1, 0);
		
	    if (total_depth % 2 == 0)
	    {
	        System.out.println("No");
	    }
	    else
	    {
	        System.out.println("Yes");
	    }

	}
}

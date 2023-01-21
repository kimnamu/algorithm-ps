// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// LCA 2
// https://www.acmicpc.net/problem/11438
// 힌트
// 1. 공통 조상을 상위 노드 하나씩 비교를 하다보면 시간 안에 통과할 수가 없다. 복잡도 O(NxM)이기 때문이다.
// 2. LCA (11437문제)와의 차이는 조상을 찾는 검색 복잡도를 log로 줄여주기 위해, 높이를 맞춰주는 과정에서 2의 n승씩 점프를 해가면서 부모값을 찾아 비교한다.
//    이를 위해 2의 n승의 부모 노드를 미리 저장해 놓는다.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<ArrayList<Integer>> node;
	static int N, M;
	static boolean[] check = new boolean[100001];
	static int[] depth = new int[100001];
	static int[][] parent = new int[100001][20];
	
	static int LCA(int u, int v)
	{
	    if (depth[u] > depth[v]) {
	    	int tmp = u;
	    	u = v;
	    	v = tmp;
	    }

	    // 두 노드의 깊이가 같아질때까지 v노드는 위로 거슬러 올라감
	    while (depth[u] != depth[v])
	    {
	        // 두 노드의 깊이 차이
	        int dist = depth[v] - depth[u];

	        for (int i = 0; i < 20; i++)
	        {
	            if (dist <= (2 << i))
	            {
	                // 2^i 만큼 거슬러 오라감
	                v = parent[v][i];
	                break;
	            }
	        }
	    }
	    while (u != v)
	    {
	        for (int i = 0; i < 20; i++)
	        {
	            if (parent[u][i + 1] == parent[v][i + 1])
	            {
	                u = parent[u][i];
	                v = parent[v][i];
	                break;
	            }
	        }
	    }
	    return u;
	}

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		node = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) {
			node.add(new ArrayList<>());
		}
		
		for (int i = 0; i < N - 1; i++) {
			int a, b;
			StringTokenizer st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			node.get(a).add(b);
			node.get(b).add(a);
		}
		
		check[1] = true;
		Queue<Integer> q = new LinkedList<>();
		q.add(1);

	    while (q.size() > 0)
	    {
	        int x = q.poll();
	        
	        for (int i = 0; i < node.get(x).size(); i++)
	        {
	            int child = node.get(x).get(i);
	            if (!check[child])
	            {
	                depth[child] = depth[x] + 1;
	                check[child] = true;
	                parent[child][0] = x;
	                for (int j = 0; j < 20; j++)
	                {
	                    parent[child][j + 1] = parent[parent[child][j]][j];
	                    // 2^(j+1) 위에 부모노드가 없을 경우
	                    if (parent[child][j + 1] == 0)
	                        break;
	                }
	                q.add(child);
	            }
	        }
	    }
	    
	    M = Integer.parseInt(br.readLine());
	    
	    for (int i = 0; i < M; i++)
	    {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			System.out.println(LCA(u, v));
	    }
		
	}
}

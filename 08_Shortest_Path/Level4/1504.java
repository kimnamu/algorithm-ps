// 특정한 최단 경로
// https://www.acmicpc.net/problem/1504
// 1. 다익스트라 알고리즘을 이용하여 v1과 v2로 부터 모든 지점에 대한 최단 거리를 구한다.
// 2. 두 최단거리 배열을 이용하여 1->v1->v2->N 과 1->v2->v1->N 거리 중 더 짧은 거리 거리를 반환한다.
// 3. 이때 하나의 구간이라도 연결이 되어있지 않다면 -1을 반환한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Route implements Comparable<Route>{
	int to;
	int val;
	public Route(int to, int val) {
		this.to = to;
		this.val = val;
	}
	
	@Override
	public int compareTo(Route o) {
		return this.val - o.val;
	}
}

public class Main {
	static int[] dijkstra(int N, int start, ArrayList<ArrayList<Route>> arr)
	{
		int[] dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		boolean[] check = new boolean[N + 1];
		PriorityQueue<Route> q = new PriorityQueue<Route>();
		
		q.add(new Route(start, 0));
	    dist[start] = 0;

	    while (!q.isEmpty())
	    {
	    	Route r = q.poll();
	        int here = r.to;
	        int cost = r.val;
	        
	        if (check[here]) continue;
	        check[here] = true;
	        
	        for (int i = 0; i < arr.get(here).size(); i++)
	        {
	            int next = arr.get(here).get(i).to;
	            int nextcost = arr.get(here).get(i).val;

	            if (check[next] == false && dist[next] > dist[here] + nextcost)
	            {
	                dist[next] = dist[here] + nextcost;
	        		q.add(new Route(next, dist[next]));
	            }
	        }
	    }
	    return dist;
	}

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<ArrayList<Route>> arr = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) {
			arr.add(new ArrayList<>());
		}
		
	    for (int i = 0; i < M; i++)
	    {
	    	st = new StringTokenizer(br.readLine());
	    	int from = Integer.parseInt(st.nextToken());
	    	int to = Integer.parseInt(st.nextToken());
	    	int val = Integer.parseInt(st.nextToken());
	    	
	        arr.get(from).add(new Route(to, val));
	        arr.get(to).add(new Route(from, val));
	    }
	    
    	st = new StringTokenizer(br.readLine());
    	int v1 = Integer.parseInt(st.nextToken());
    	int v2 = Integer.parseInt(st.nextToken());
    	
    	int[] dist1 = dijkstra(N, v1, arr);
    	int[] dist2 = dijkstra(N, v2, arr);
    	
        int dist_v12 = dist1[v2];
        int answer = -1;
        if (dist1[1] != Integer.MAX_VALUE && 
        		dist_v12 != Integer.MAX_VALUE && dist2[1] != Integer.MAX_VALUE)
        {
            answer = dist_v12 + Math.min(dist1[1] + dist2[N], dist1[N] + dist2[1]);
        }
        
        System.out.println(answer);

	}
}

//파티
//https://www.acmicpc.net/problem/1238
//1. 다익스트라 알고리즘을 이용하여 모든 지점에서 X까지 가는 길의 최소 시간을 계산해준다.
//2. 다익스트라 알고리즘을 이용하여 X지점에서 모든 지점까지 가는 길의 최소 시간을 계산해준다.
//3. 모든 지점에서 X지점까지의 왕복 거리 합이 가장 큰 값을 반환해준다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	static class Pos implements Comparable<Pos>{
		int x;
		int y;
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(Pos o) {
			return this.y - o.y;
		}
		
	}
	
	static int[] dijkstra(int N, int start, ArrayList<ArrayList<Pos>> arr)
	{
		int[] dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		boolean[] check = new boolean[N + 1];
		PriorityQueue<Pos> q = new PriorityQueue<Pos>();
		
		q.add(new Pos(start, 0));
	    dist[start] = 0;

	    while (!q.isEmpty())
	    {
	    	Pos r = q.poll();
	        int here = r.x;
	        int cost = r.y;
	        
	        if (check[here]) continue;
	        check[here] = true;
	        
	        for (int i = 0; i < arr.get(here).size(); i++)
	        {
	            int next = arr.get(here).get(i).x;
	            int nextcost = arr.get(here).get(i).y;

	            if (check[next] == false && dist[next] > dist[here] + nextcost)
	            {
	                dist[next] = dist[here] + nextcost;
	        		q.add(new Pos(next, dist[next]));
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
		int X = Integer.parseInt(st.nextToken());
		
		ArrayList<ArrayList<Pos>> adj = new ArrayList<>();
		
		for (int i= 0; i < N + 1; i++) {
			adj.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
        	st  = new StringTokenizer(br.readLine());
        	
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
        	
            adj.get(a).add(new Pos(b, c));
		}
		
	    int[] dist1 = dijkstra(N, X, adj);
	    int answer = 0;
	    for (int i = 1; i < N + 1; i++)
	    {
	        int[] dist2 = dijkstra(N, i, adj);
	        answer = Math.max(answer, dist1[i] + dist2[X]);
	    }
	    System.out.println(answer);

	}
}

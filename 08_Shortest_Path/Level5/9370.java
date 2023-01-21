// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 미확인 도착지
// https://www.acmicpc.net/problem/9370
// 힌트
// 1. 다익스트라 알고리즘을 이용하여 S-G-H-Dst 혹은 S-H-G-Dst 경로의 최단 거리를 찾아주는 문제이다.
// 2. 위읭 각 구간별 최단 거리를 구해주고 마지막 Dst까지 최단경로가 되는 정점을 찾아주면 된다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static final int MAXNUM = 2010;
	static final int INF = 1000000000;
	static int distGH;
	static int[] distS = new int[MAXNUM];
	static int[] distG = new int[MAXNUM];
	static int[] distH = new int[MAXNUM];
	static ArrayList<Integer> dists = new ArrayList<>();
	static ArrayList<ArrayList<Pos>> v;
	
	static int S, G, H;
	
	static class Pos implements Comparable<Pos>{
		int x;
		int y;
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(Pos o) {
			return this.x - o.x;
		}
	}
	
	static void dijkstra(int from, int dist[])
	{
	    PriorityQueue<Pos> q = new PriorityQueue<>();
	    
	    q.add(new Pos(0, from));
	    dist[from] = 0;

	    while (!q.isEmpty())
	    {
	    	Pos p = q.poll();
	        int cost = p.x;
	        int curr = p.y;

	        for (int i = 0; i < v.get(curr).size(); i++)
	        {
	            int next = v.get(curr).get(i).x;
	            int cost_next = v.get(curr).get(i).y;

	            if (dist[next] > cost + cost_next)
	            {
	                dist[next] = cost + cost_next;
	                q.add(new Pos(dist[next], next));
	            }
	        }
	    }
	}

	
	static void solve()
	{
	    dijkstra(S, distS);
	    dijkstra(G, distG);
	    distGH = distG[H];
	    dijkstra(H, distH);
	    
	    Collections.sort(dists);
	    
	    for (int i = 0; i < dists.size(); i++)
	    {
	        int dst = dists.get(i);
	        if (distS[dst] == distS[G] + distGH + distH[dst]) {
	            System.out.print(dst + " ");
	        }
	        else if (distS[dst] == distS[H] + distGH + distG[dst]) {
	            System.out.print(dst + " ");
	        }
	    }
	    System.out.println();
	}
		

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		v = new ArrayList<ArrayList<Pos>>();
		for (int i = 0; i < MAXNUM; i++) {
			v.add(new ArrayList<>());
		}
		
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			for (int i = 0; i < MAXNUM; i++) {
	            v.get(i).clear();
				distS[i] = INF;
	            distG[i] = INF;
	            distH[i] = INF;				
			}
			dists.clear();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			S = Integer.parseInt(st.nextToken());
			G = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < m; i++) {
		    	st = new StringTokenizer(br.readLine());
		    	
		    	int a = Integer.parseInt(st.nextToken());
		    	int b = Integer.parseInt(st.nextToken());
		    	int c = Integer.parseInt(st.nextToken());
		    	
		    	v.get(a).add(new Pos(b, c));
		    	v.get(b).add(new Pos(a, c));
			}
			
	        for (int i = 0; i < t; i++)
	        {
	            int a = Integer.parseInt(br.readLine());
	            dists.add(a);
	        }

			solve();
		}
	}
}

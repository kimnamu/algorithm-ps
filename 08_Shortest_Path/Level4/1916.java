// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 최소비용 구하기
// https://www.acmicpc.net/problem/1916
// 힌트
// 1. 각 구간 별 단방향으로 주어진 가격임을 주의해야한다.
// 2. 다익스트라 알고리즘을 이용하여 최단 거리를 구하되,
//    주의할 점은 같은 구간에 대해 서로 다른 요금이 주어질 수 있어 최소 요금을 찾고 알고리즘을 적용해야한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Posit implements Comparable<Posit>{
	int x;
	int y;
	
	public Posit(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Posit o) {
		// TODO Auto-generated method stub
		return this.y - o.y;
	}
}


public class Main {
	
	static int[] dijkstra(int N, int start, ArrayList<ArrayList<Posit>> arr)
	{
		int[] dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		boolean[] check = new boolean[N + 1];
		PriorityQueue<Posit> q = new PriorityQueue<Posit>();
		
		q.add(new Posit(start, 0));
	    dist[start] = 0;

	    while (!q.isEmpty())
	    {
	    	Posit r = q.poll();
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
	        		q.add(new Posit(next, dist[next]));
	            }
	        }
	    }
	    return dist;
	}
	
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		HashMap<Posit, Integer> m = new HashMap<>();
		
		for (int i = 0; i < M; i++) {
	    	StringTokenizer st = new StringTokenizer(br.readLine());
	    	int from = Integer.parseInt(st.nextToken());
	    	int to = Integer.parseInt(st.nextToken());
	    	int val = Integer.parseInt(st.nextToken());
	    	
	    	Posit p = new Posit(from ,to);
	    	
	    	if (m.containsKey(p)) {
	    		m.put(p, Math.min(m.get(p), val));
	    	} else {
	    		m.put(p, val);
	    	}
		}
		
		ArrayList<ArrayList<Posit>> arr = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) {
			arr.add(new ArrayList<>());
		}

		
	    for (Posit k : m.keySet())
	    {
	    	arr.get(k.x).add(new Posit(k.y, m.get(k)));
	    }
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int A = Integer.parseInt(st.nextToken());
	    int B = Integer.parseInt(st.nextToken());

	    int[] dist = dijkstra(N, A, arr);
	    
	    System.out.println(dist[B]);

	}
}

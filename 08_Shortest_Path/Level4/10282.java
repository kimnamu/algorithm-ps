// 해킹
// https://www.acmicpc.net/problem/10282
// 1. 다익스트라 알고리즘을 활용하여 가장 처음 감염된 C로 부터 다른 노드까지의 최단거리를 구하면 된다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Comput implements Comparable<Comput>{
	int comp;
	int time;
	
	public Comput (int comp, int time) {
		this.comp = comp;
		this.time = time;
	}

	@Override
	public int compareTo(Comput o) {
		return this.time - o.time;
	}
}

public class Main {
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
	    	StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			int[] v = new int[N + 1];
			int[] dist = new int[N + 1]; Arrays.fill(dist, Integer.MAX_VALUE);
			boolean[] check = new boolean[N + 1];
			
			ArrayList<ArrayList<Comput>> adj = new ArrayList<>();
			
			for (int i= 0; i < N + 1; i++) {
				adj.add(new ArrayList<>());
			}
			
	        for (int i = 0; i < D; i++)
	        {
	        	st  = new StringTokenizer(br.readLine());
	        	
	            int a = Integer.parseInt(st.nextToken());
	            int b = Integer.parseInt(st.nextToken());
	            int c = Integer.parseInt(st.nextToken());
	            
	            adj.get(b).add(new Comput(a, c));
	            v[a]++;
	        }
	        
	        PriorityQueue<Comput> pq  = new PriorityQueue<>();
	        
	        dist[C] = 0;
	        pq.add(new Comput(C, 0));
	        
	        while (!pq.isEmpty())
	        {
        		Comput com = pq.poll();

	            if (dist[com.comp] < com.time)
	                continue;
            	
	            for (int j = 0; j < adj.get(com.comp).size(); j++) {
	            	Comput p = adj.get(com.comp).get(j);
	                int nxt = p.comp;
	                int cost = p.time;
	                
	                if (dist[nxt] > dist[com.comp] + cost)
	                {
	                    dist[nxt] = dist[com.comp] + cost;
	                    pq.add(new Comput(nxt, dist[nxt]));
	                }
	            }
	        }
	        
	        int cnt = 0, mx = 0;
	        for (int i = 1; i <= N; i++)
	        {
	            if (dist[i] != Integer.MAX_VALUE)
	            {
	                cnt++;
	                mx = Math.max(mx, dist[i]);
	            }
	        }
			System.out.println(cnt + " " + mx);
		}
	}
}

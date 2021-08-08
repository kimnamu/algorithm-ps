//K번째 최단경로 찾기
//https://www.acmicpc.net/problem/1854
//1. 다익스트라 알고리즘의 원리에 탑승해, 각 지점 별 경로의 길이를 저장하여 해당 지점의 K번째 최단 경로를 찾는다.
//2. 각 지점 별 도달 경로의 길이를 우선순위 큐를 이용하여 누적시키고, 그 개수가 K개보다 많아지면 가장 긴 경로와의 값을 비교하여 K번째 값만 갱신해 준다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	static ArrayList<PriorityQueue<Integer>> answer;
	
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
	
	static void dijkstra(int N, int X, int K, ArrayList<ArrayList<Pos>> arr)
	{
		PriorityQueue<Pos> q = new PriorityQueue<>();
		
		q.add(new Pos(0, X));
	    answer.get(1).add(0);
	    
	    while (!q.isEmpty())
	    {
	    	Pos p = q.poll();
	        int cost = p.x;
	        int here = p.y;

	        for (int i = 0; i < arr.get(here).size(); i++)
	        {
	            int next = arr.get(here).get(i).x;
	            int nextcost = arr.get(here).get(i).y + cost;

	            if( answer.get(next).size() < K){
	            	answer.get(next).add(nextcost);
	                q.add(new Pos(nextcost, next));
	            }else if(answer.get(next).peek() > nextcost){
	                answer.get(next).poll();
	                answer.get(next).add(nextcost);
	                q.add(new Pos(nextcost, next));
	            }
	        }
	    }
	}
	


	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		ArrayList<ArrayList<Pos>> adj = new ArrayList<>();
		answer = new ArrayList<>();
		
		for (int i= 0; i < N + 1; i++) {
			adj.add(new ArrayList<>());
			answer.add(new PriorityQueue<>(Collections.reverseOrder()));
		}
		
		for (int i = 0; i < M; i++) {
        	st  = new StringTokenizer(br.readLine());
        	
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
        	
            adj.get(a).add(new Pos(b, c));
		}
		
		
		dijkstra(N, 1, K, adj);
		
	    for(int i = 1 ; i<= N; i++){
	        if(answer.get(i).size()<K) {
	        	System.out.println(-1);
	        } else {
	        	System.out.println(answer.get(i).peek());
	        }
	    }

	}
}

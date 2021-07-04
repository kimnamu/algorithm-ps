// 최단경로
// https://www.acmicpc.net/problem/1753
// 힌트
// 1. BFS알고리즘을 이용하면 메모리 초과가 발생한다.
// 2. Dijkstra알고리즘을 이용하여 시작점으로 각 노드에 대한 최단 거리를 구한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{
	int to;
	int weight;
	
	public Edge(int to, int weight) {
		this.to = to;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge o) {
		return this.weight - o.weight;
	}
}

public class Main {
	static int V;
	static ArrayList<ArrayList<Edge>> edges;
	static int minDist[];
	
	static void dijkstra(int start) {
		PriorityQueue<Edge> q = new PriorityQueue<>();
		
		q.add(new Edge(start, 0));
		
		while(!q.isEmpty()) {
			Edge ed = q.poll();
			int s = ed.to;
			for (Edge e: edges.get(s)) {
				int to = e.to;
				int weight = e.weight;
				if (minDist[s] + weight < minDist[to]) {
					minDist[to] = minDist[s] + weight;
					q.add(new Edge(to, minDist[to]));
				}
				
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		
		edges = new ArrayList<>();
		for (int i = 0; i < V + 1; i++) {
			edges.add(new ArrayList<Edge>());
		}
		minDist = new int[V + 1];
		Arrays.fill(minDist, Integer.MAX_VALUE);
		minDist[K] = 0;
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()); 
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			edges.get(u).add(new Edge(v, w));
		}
		
		dijkstra(K);
		
		for (int i = 1; i < V + 1; i++) {
			if (minDist[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			} else {
				System.out.println(minDist[i]);
			}
		}
	}
}

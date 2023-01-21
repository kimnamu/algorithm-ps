// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
//최소 스패닝 트리
//https://www.acmicpc.net/problem/1197
//힌트
//1. 크루스칼 알고리즘을 이용하여 가중치가 낮은 node부터 순차적으로 연결해준다.
//2. 이미 연결되어 있는 node는 스킵한다. 이미 연결되어 있는지의 체크는 union-find 방식을 이용한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{
	int x;
	int y;
	int weight;
	
	public Edge(int x, int y, int weight) {
		this.x = x;
		this.y = y;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge o) {
		return this.weight - o.weight;
	}
}

public class Main {
	static List<Edge> edges ;
	static int[] parent;
	
	static int find_parent(int k){
	    if(parent[k]==-1){
	        parent[k] = k;
	        return k;
	    }
	    if(parent[k]==k) return k;
	    return find_parent(parent[k]);
	}

	static void union_edge(int e1, int e2){
	    if(parent[e1]==-1 && parent[e2]==-1){
	        parent[e1] = e1;
	        parent[e2] = e1;
	    }else if(parent[e1]==-1){
	        parent[e1] = parent[e2];
	    }else if(parent[e2]==-1){
	        parent[e2] = parent[e1];
	    }else{
	        int p1 = find_parent(e1);
	        parent[p1] = find_parent(e2);
	    }
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		edges = new ArrayList<>();
		parent = new int[V+1];
		Arrays.fill(parent, -1);
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edges.add(new Edge(x, y, weight));
		}
		
		Collections.sort(edges);
		
	    int answer = 0;
	    for(int i = 0; i < E; i++){
	        int edge1 = edges.get(i).x;
	        int edge2 = edges.get(i).y;
	        if(find_parent(edge1)!=find_parent(edge2)|| parent[edge1]==-1 || parent[edge2]==-1){
	            union_edge(edge1, edge2);
	            answer += edges.get(i).weight;
	        }
	    }
	    
	    System.out.println(answer);
	}
}

// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 중량제한
// https://www.acmicpc.net/problem/1939
// 힌트
// 1. BFS를 활용하여 지정한 중량으로 공장이 이어질 수 있는지 찾는다.
// 2. 여기서 중량의 범위가 방대하므로 binary search를 통해 값을 찾아낸다.
//    이때, 복잡도는 O(nlogc)이다.
import java.io.*;
import java.util.*;

class Node {
	int to;
	int weight;
	
	public Node(int to, int weight) {
		this.to = to;
		this.weight = weight;
	}
}

public class Main {
	static int N, M;
	static int loc1, loc2, maxWeight;
	static HashMap<Integer, ArrayList<Node>> adj;
	static boolean[] check = new boolean[100001];

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		adj = new HashMap<>();
		maxWeight = 0;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			addNodeToMap(n1, n2, weight);
			addNodeToMap(n2, n1, weight);
			
			maxWeight = Math.max(weight, maxWeight);
		}
		
		st = new StringTokenizer(br.readLine());
		
		loc1 = Integer.parseInt(st.nextToken());
		loc2 = Integer.parseInt(st.nextToken());
		
		int answer = bs();
		
		System.out.println(answer);
	}
	
	static void addNodeToMap(int from, int to, int weight) {
		if (adj.containsKey(from)) {
			adj.get(from).add(new Node(to, weight));
		} else {
			adj.put(from, new ArrayList<Node>() {{add(new Node(to, weight));}});
		}
	}
	
	static int bs() {
		int start = 1;
		int end = maxWeight;
		int mid = -1;
		
		while (start <= end) {
			mid = (start + end) / 2;
			if (bfs(mid)) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
			
			Arrays.fill(check, false);	
		}
		
		return end;
	}
	
	static boolean bfs(int val) {
		Queue<Integer> q = new LinkedList<>();
		q.add(loc1);
		check[loc1] = true;
		
		while(!q.isEmpty()) {
			int from = q.poll();
			
			for (Node v : adj.get(from)) {
				int nextNode = v.to;
				int cost = v.weight;
				
				if (!check[nextNode] && cost >= val) {
					check[nextNode] = true;
					q.add(nextNode);
				}
			}
		}
		
		
		return check[loc2]; 
	}
	
}

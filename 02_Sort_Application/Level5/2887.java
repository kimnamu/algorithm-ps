// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 행성 터널
// https://www.acmicpc.net/problem/2887
// 힌트
// 1. N이 100,000이기 때문에 모든 행성간의 간선을 구하면 메모리 초과가 된다.
// 2. 각 세 좌표값 차이의 절대값의 최소를 거리로 삼으므로
//    각 좌표값으로 정렬하여 이웃한 간선만을 구하면 3 * (N-1)개의 간선만 구하면 된다.
// 3. 간선의 거리를 오름차순으로 정렬한 뒤 Kruskal 알고리즘으로 최소 스패닝 트리를 구하면 된다.

import java.io.*;
import java.util.*;

public class Main {
	static int[] parents;
	static int answer = 0;
	
	// 현재 노드 집합에 연결된 최소 idx를 반환
	static int get_parent(int idx) {
		if (idx != parents[idx]) {
			parents[idx] = get_parent(parents[idx]);
		}
		
		return parents[idx];
	}
	
	// idx1과 idx2를 같은 집합에 속하게 만들어주는 함수
	static void union_find(int idx1, int idx2) {
		int pdx1 = get_parent(idx1);
		int pdx2 = get_parent(idx2);
		
		if (pdx1 > pdx2) {
			parents[pdx2] = pdx1;
		} else {
			parents[pdx1] = pdx2;
		}
	}
	
	public static void main(String[] args) throws IOException, NumberFormatException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] stars = new int[N][4];
		
	    // 사이클을 형성하는 간선을 제외하기 위해 각 노드에 연결된 집합의 최소 index 노드를 가지게 할 parents 생성(기본적으로 다른 노드와 연결되어 있지 않으면 자기 자신의 index를 가짐)
    	parents = new int[N];

	    // 1. 각 행성의 좌표와 index를 저장한다.
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			stars[i][0] = Integer.parseInt(st.nextToken());
			stars[i][1] = Integer.parseInt(st.nextToken());
			stars[i][2] = Integer.parseInt(st.nextToken());
			stars[i][3] = i;
			
			parents[i] = i;
		}
		
	    // 2. x,y,z 각각 좌표별로 정렬한 뒤, 인접한 행성끼리 거리를 구해서 edge에 저장한다.		
		int[][] edges = new int[(N-1) * 3][3];
		for (int i = 0; i < 3; i++) {
			final int k = i;
			Arrays.sort(stars, (s1, s2) -> s1[k] - s2[k]);
			for (int j = 0; j < N - 1; j++) {
				edges[i * (N-1) + j][0] = Math.abs(stars[j + 1][i] - stars[j][i]);
				edges[i * (N-1) + j][1] = stars[j][3];
				edges[i * (N-1) + j][2] = stars[j+1][3];
			}
		}
		
	    // 3. 행성간의 거리를 기준으로 오름차순으로 정렬해준다.
		Arrays.sort(edges, (e1, e2) -> e1[0] - e2[0]);
		
		for (int i = 0; i < edges.length - 1; i++) {
	        // 5. 두 정점이 같은 집합에 속하는지 판별
			if (get_parent(edges[i][1]) != get_parent(edges[i][2])) {
	            // 두 정점을 같은 집합에 속하게 병합
				union_find(edges[i][1], edges[i][2]);
				answer += edges[i][0];
			}
		}
		
		System.out.println(answer);
	}
}

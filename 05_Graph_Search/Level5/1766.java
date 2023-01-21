// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
//문제집
//https://www.acmicpc.net/problem/1766
//힌트
//1. 위상정렬을 이용한다.
//2. 각 순서를 갇는 노드에 대해 뒤에 오는 노드에 대해 앞에 와야만 하는 이전 노드의 수를 counting해 둔다.
//3. 앞에 와야만 하는 노드의 수가 0인 노드들을 순서대로 출력하면서, 연결된 노드들의 이전 노드의 수를 갱신해 준다.
// 단, 이때 input node의 수가 0인 노드 중 가장 작은 숫자 부터 출력해야 하므로 우선순위 큐를 이용해준다.

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] inCnt = new int[N + 1];
		List<List<Integer>> v = new ArrayList<List<Integer>>();
		
		for (int i = 0; i < N + 1; i++) {
			v.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());			
			int b = Integer.parseInt(st.nextToken());
			inCnt[b] += 1;
			v.get(a).add(b);
		}
		
		PriorityQueue<Integer> q = new PriorityQueue<>();
		
		for (int i = 1; i <= N; i++) {
			if (inCnt[i] == 0) {
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int i = q.poll();
			bw.write(i + " ");
			for (int j = 0; j < v.get(i).size(); j++) {
				inCnt[v.get(i).get(j)] -= 1;
				if (inCnt[v.get(i).get(j)] == 0) {
					q.add(v.get(i).get(j));
				}
			}
		}
		
		bw.flush();
	}
}

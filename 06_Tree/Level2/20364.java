// 부동산 다툼
// https://www.acmicpc.net/problem/20364
// 힌트
// 1. 땅 번호를 모두 초기화 하여 해당 초기화 값을 가지면 root로 부터 도달할 수 있는 땅으로 간주한다.
// 2. root로부터 도달 가능한 땅이라면, 그 땅을 시작으로 child node는 모두 root로 부터 도달 할 수 없고 그때 root로 부터 가장 가까운 땅은  그 땅이 된다.
// 3. 때문에 그 땅의 모든 child node를 그 땅의 번호로 update해준다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] tree; 
	
	static void dfs(int index, int value) {
		if (tree.length <= index) {
			return;
		}
		tree[index] = value;
		dfs(index * 2, value);
		dfs(index * 2 + 1, value);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		tree = new int[N+1];
		
		while (Q--> 0) {
			int q = Integer.parseInt(br.readLine());
			if (tree[q] == 0) {
				tree[q] = q;
				dfs(q * 2, tree[q]);
				dfs(q * 2 + 1, tree[q]);
				System.out.println(0);
			} else {
				System.out.println(tree[q]);
			}
		}
		

	}
}

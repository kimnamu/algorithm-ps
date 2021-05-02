import java.util.Scanner;
import java.util.Arrays;

// 차이를 최대로
// https://www.acmicpc.net/problem/10819
// 순열을 이용하여 Brute-Force로 푸는 문제. 
// Java에서는 C++, Python에서처럼 순열을 제공하는 함수가 없으므로 직접 코딩하여야함.
// 순열을 구하는 방법에는 여러 방식이 있는데 이 풀이에서는 DFS를 이용하여 구현.

public class Main {
	static int[] A; // 입력배열
	static boolean[] visited;
	static int[] output; // 임시배열
	static int answer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		A = new int[N];
		visited = new boolean[N];
		output = new int[N];
		
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		
		answer = 0;
		
		perm(0, N);
		
		System.out.println(answer);
	}
	
	static void perm(int depth, int n) {
		if (depth == n) { // depth가 마지막까지 도달하였으면
			// 현재 배열로 값 계산
			int temp =0;
			for (int i = 0; i < n -1; i++) {
				temp += Math.abs(output[i] - output[i+1]);
			}
			answer = Math.max(answer, temp);
			
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (!visited[i]) { // 사용한 index가 아니면
				visited[i] = true; // 현재 index를 사용
				output[depth] = A[i]; // output 배열의 depth번째 값에 A 배열의 현재 index번째 값을 사용.
				perm(depth+1, n);
				visited[i] = false; // 현재 index를 사용 해제
			}
		}
	}
	
}

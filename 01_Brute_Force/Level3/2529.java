import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Arrays;

// 차이를 최대로
// https://www.acmicpc.net/problem/10819
// 순열을 이용하여 Brute-Force로 푸는 문제. 
// 1. DFS를 이용해 앞자리 부터 부등호 규칙을 만족하는 수를 찾아간다.
// 2. 부등호를 만족시키는 수를 찾을때 9부터 0까지 순서대로 DFS를 통해 찾은 첫 수가 최대값이 된다.
// 3. 부등호를 만족시키는 수를 찾을때 0부터 9까지 순서대로 DFS를 통해 찾은 첫 수가 최소값이 된다.

public class Main {
	static boolean[] signs; 
	static boolean[] visited;
	static int[] output;
	static boolean flag;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		signs = new boolean[N];
		output = new int[N+1];
		visited = new boolean[10];
		
		sc.nextLine();		
		String[] signsStr = sc.nextLine().split(" ");
		
		for (int i = 0; i < N; i++) {
			if (signsStr[i].equals(">")) {
				signs[i] = true;
			}
		}
		
		flag = false;
		perm(0, N, true);
				
		flag = false;
		perm(0, N, false);
	}
	
	static void perm(int depth, int n, boolean reverse) {
		if (depth == n + 1) { // depth가 마지막까지 도달하였으면
			for (int i = 0; i < n + 1; i++) {
				System.out.print(output[i]);
			}
			System.out.println();
			flag = true;
			
			return;
		}
		
		for (int k = 0, i = 0; k <= 9; k++) {
			if (reverse) {
				i = 9 - k;
			} else {
				i = k;
			}
			
			if (!visited[i] && !flag) { // 사용한 index가 아니면
				if (depth == 0 || (signs[depth-1] && (output[depth-1] > i) ) 
					|| ((!signs[depth-1] && (output[depth-1] < i))) ) {
					visited[i] = true; // 현재 index를 사용
					output[depth] = i;
					perm(depth+1, n, reverse);
					visited[i] = false; // 현재 index를 사용 해제					
				}
			}
		}
	}
	
}

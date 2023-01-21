// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 부분수열의 합
// https://www.acmicpc.net/problem/14225
import java.util.Scanner;

public class Main {
	static int[] nums;
	static boolean[] visited;
	static int N; 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		visited = new boolean[N * 100000];
		nums = new int[N];
		
		for(int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}
		
	    // dfs로 완전 탐색
		dfs(0, 0);
		
	    // 1부터 방문하여 부분수열의 합으로 만들수 없는 최초의 수를 출력
	    for (int i = 1; i < visited.length; i++)
	    {
	        if (!visited[i])
	        {
	            System.out.println(i);
	            break;
	        }
	    }
		
	}
	
	static void dfs(int num, int sum) {
		if (num == N) {
			visited[sum] = true;
			return;
		}
		
	    // 해당 number를 사용하는 경우
		dfs(num + 1, sum + nums[num]);
	    // 해당 number를 사용하지 않는 경우
		dfs(num + 1, sum);		
	}
}
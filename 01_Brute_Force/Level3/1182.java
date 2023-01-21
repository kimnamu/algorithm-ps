// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
//부분수열의 합
//https://www.acmicpc.net/problem/1182
//힌트
//1. 부분수열은 꼭 연속한수의 집합이 아니여도 된다.
//2. 모든 부분 수열을 탐색해야 한다.
import java.util.Scanner;

public class Main {
	static int[] A;
	static int[] filter;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int S = sc.nextInt();
	
		A = new int[N];
		filter = new int[N];
		
		for (int i = 0; i < A.length; i++) {
			A[i] = sc.nextInt();
		}
				
		int answer = 0;
		for (int i = 0; i < N; i++) {
			answer += solve(i, N, S);
		}
		
		System.out.println(answer);
	}
	
	static int solve(int index, int N, int S) {
		int answer = 0;
	    // 2. Filter를 만들어준다.
	    // 만약 N==4라면, Filter는 다음과 같은 순서로 만들어 준다.
	    // {0, 0, 0, 1}
	    // {0, 0, 1, 1}
	    // {0, 1, 1, 1}
	    // {1, 1, 1, 1}
		for (int i = 0; i < N; i++) {
			if (i >= N - index - 1) {
				filter[i] = 1;	
			} else {
				filter[i] = 0;
			}
		}
	    
	    // 3. filter 배열을 다음 순열로 바꿔가면서 filter의 값들위치를 바꿔주고,
	    // 4. 해당 바뀐 위치의 값들만 더해준 sum이 S와 일치하면 정답으로 counting한다.
	    do
	    {
	        int sum = 0;
	        for (int i = 0; i < N; i++)
	        {
	            if (filter[i] == 1)
	                sum += A[i];
	        }
	        
	        if (sum == S){
	            answer++;
	        }
	    } while (next_permutation());
	    
	    return answer;
	}
	
	// 현재 순열보다 다음으로 큰 순열 구함
	static boolean next_permutation() {
		int i = filter.length - 1;
		
		while(i > 0 && filter[i-1] >= filter[i]) {
			i--;
		}
		
		if (i <= 0) {
			return false;
		}
		
		int j = filter.length - 1;
		
		while (filter[i-1] >= filter[j]) j--;
		swap(i-1, j);
		
		j = filter.length - 1;
		
		while(i < j) {
			swap(i, j);
			i++; j--;
		}
		
		return true;
	}
	
	static void swap(int n, int m) {
		int temp = filter[n];
		filter[n] = filter[m];
		filter[m] = temp;
	}
}

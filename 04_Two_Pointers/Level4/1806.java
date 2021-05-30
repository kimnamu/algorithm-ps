//부분합
//https://www.acmicpc.net/problem/1806
//힌트
//1. 투 포인터 방법을 활용해 부분합의 가장 왼쪽 위치와 오른쪽 위치를 조정해가면서 부분합을 계산한다.
//1.1. 부분합이 S보다 크거나 같다면, 왼쪽 포인터 위치의 값을 빼주고 오른쪽으로 한칸 옮겨준다.
//1.2. 부분합이 S보다 작다면, 오른쪽 포인터 위치를 오른쪽으로 한칸 옮겨준 후 해당 위치 값을 더해준다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] A = new int[N + 1];
		
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0;
		int right = 0;
		long sum = A[0];
		int answer = N + 1;
		
		while (right < N) {
			if (sum >= S) {
				answer = Math.min(answer, right - left + 1);
				sum -= A[left];
				left += 1;
				
			} else {
				right += 1;
				sum += A[right];
			}
		}
		
		if (answer == N + 1) {
			answer = 0;
		}
		
		System.out.println(answer);
	}
}

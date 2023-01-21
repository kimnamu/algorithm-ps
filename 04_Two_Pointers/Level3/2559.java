// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
//수열
//https://www.acmicpc.net/problem/2559
//힌트
//1. K개의 수를 합하는게 정해져 있으므로 K의 위치차이를 가지는 투 포인터를 활용하여 구간 합을 구한다.
//2. 오른쪽 포인터를 증가시키면서 값을 더하고, 왼쪽 포인터를 증가시키면서 값을 빼준다.
//3. 이렇게 포인터를 옮겨가면서 더한 합이 가장 큰 값을 정답으로 반환한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] A = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0;
		int right = M-1;
		int sum = 0;
		for (int i = 0; i < M; i++) {
			sum += A[i];
		}
		
		int answer = sum;
		while (right < N - 1) {
			// left 는 sum에 더해준 뒤 +1을 해주고, right은 +1을 해준뒤 sum에 더해준다.
			sum = sum - A[left++] + A[++right];
			if (answer < sum) {
				answer = sum;
			}
		}						
		
		System.out.println(answer);
	}
}

// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 두 수의 합
// https://www.acmicpc.net/problem/3273
// 힌트
// 1. 리스트를 정렬을 한 뒤, 투 포인터를 사용하여
// 2. 하나는 작은 값부터 올라가면서, 다른 하나는 큰 값부터 내려가면서 합이 x가 되는 쌍을 찾으면 된다.
// 3. 합이 x보다 작으면 작은 값을 하나 더 큰 값으로 올려주고, 합이 x보다 작다면 큰 값을 하나 더 작은 값으로 내려주면 된다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken()); 
		}
		int x = Integer.parseInt(br.readLine());
		
		Arrays.sort(A);
		
		int left = 0;
		int right = N-1;
		
		int answer = 0;
		
		while (left < right) {
			if (A[left] + A[right] == x) {
				answer += 1;
				left += 1;
				right -= 1;
			} else if (A[left] + A[right] > x) {
				right -= 1;
			} else {
				left += 1;
			}
		}
		
		System.out.println(answer);
	}
}

// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// K번째 수
// https://www.acmicpc.net/problem/1300
// 힌트
// 1. 임의의 숫자를 골라 K번째 숫자가 맞는지 찾아보자.
//    이때 임의의 숫자를 Bruete force로 맞으면 시간초과가 발생하기 때문에 binary search를 적용해 찾아보자.
// 2. 임의의 숫자보다 작은 수의 갯수를 찾는 방법은 i번째 행의 모든 값은 i의 배수임을 활용해서 구할 수 있는데,
//    min(mid/i, n)이 i번째 행에서 임의의 숫자보다 작은 숫자들의 개수가 된다.

import java.io.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		
		int left = 1;
		int right = k;
		int mid = -1;
		
		while (left <= right) {
			mid = (left + right) / 2;
			
			long cnt = 0;
			for (int i = 1; i <= N; i++) {
				cnt += Math.min(mid / i,  N);
			}
			
			if (cnt < k) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
		int answer = left;
		
		System.out.println(answer);
	}

}

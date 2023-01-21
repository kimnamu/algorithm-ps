// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 좌표 압축
// https://www.acmicpc.net/problem/18870
// 힌트
// 1. 기존 배열을 복사하여 오름차순으로 정렬.
// 2. 정렬된 배열을 HashMap을 사용하여 새로운 값이 존재할 때마다 count를 1씩 올려서 저장.
// 3. 기존 배열 순서대로 HashMap의 결과값을 출력

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int[] nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] nums2 = nums.clone();
		Arrays.sort(nums2);
		
		int cnt = 0;
		Map<Integer, Integer> m = new HashMap<>();
		for (int i = 0; i < N; i++) {
			if (!m.containsKey(nums2[i])) {
				m.put(nums2[i], cnt++);
			}
		}
		
		for (int i = 0; i < N; i++) {
			sb.append(m.get(nums[i])).append(" ");
		}
		
		System.out.println(sb.toString());
	}
}

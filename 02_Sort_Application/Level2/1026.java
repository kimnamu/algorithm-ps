// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 보물
// https://www.acmicpc.net/problem/1026
// 힌트
// 1. B의 순서가 바뀌지 않는다는 조건이 있지만 B에 맞춰 A를 출력하거나 하는 것이 아니기때문에 A, B 값들의 순서는 신경써줄 필요가 없다.
// 2. B의 가장 작은 수부터 A의 가장 큰 수가 곱해지도록 하면 전체 합이 가장 작아진다.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arrA = new int[N];
		int[] arrB = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arrA[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arrB[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arrA);
		Arrays.sort(arrB);
		
		int S =0;
		for (int i = 0; i < N; i++) {
			S += arrA[i] * arrB[N - i - 1];
		}
		
		System.out.println(S);
	}
}

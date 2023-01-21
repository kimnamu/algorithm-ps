// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// N번째 큰 수
// https://www.acmicpc.net/problem/2075
// 힌트
// 1. 모든 수에 대해 정렬 후 끝에서 N번째 인자 출력
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] v = new int[N * N];
		
		StringTokenizer st;
		for (int i = 0; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0 ; j < N; j++) {
				v[i*N + j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Arrays.sort(v);
		
		System.out.println(v[N * N - N]);
	}
}

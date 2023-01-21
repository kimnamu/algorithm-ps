// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
//예산
//https://www.acmicpc.net/problem/2512
//힌트
//1. 상한선이 될 금액을 binary search로 구하면 된다. 이때 상한선 금액의 초기 범위는 0부터 가장큰 예산이다.

import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int v_max;
	static int budget[];
	
	static boolean solve(int k) {
		long total = 0;
		for (int i = 0; i < N; i++) {
			total += Math.min(k,  budget[i]);
		}
		
		if (total <= M) {
			return true;
		} else {
			return false;
		}
	}
	
	static int bs() {
		int l = 0;
		int r = v_max;
		int m = 0;
		
		while (l <= r) {
			m = (l + r) / 2;
			
			if (solve(m)) {
				 l = m + 1;
			} else {
				r = m - 1;
			}	
		}
		
		return r;
	}
	
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		budget = new int[N];
		v_max = 0;
		for (int i = 0; i < N; i++) {
			budget[i] = Integer.parseInt(st.nextToken());
			v_max = Math.max(v_max, budget[i]);
		}
		M = Integer.parseInt(br.readLine());
		
		int answer = bs();
		
		System.out.println(answer);
		
		
	}
}


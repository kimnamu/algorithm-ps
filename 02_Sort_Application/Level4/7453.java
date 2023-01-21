// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 합이 0인 네 정수
// https://www.acmicpc.net/problem/7453
// 힌트
// 1. 4중 for문을 쓰게되면 시간초과
// 2. 2중 for문을 통해 A+B의 덧셈 집합(AB)과 C+D의 덧셈 집합(CD)을 각각 만들어줌
// 3. AB 수열 값 * -1 값이 CD 수열에 있는지 Binary Search
// 4. 이때 AB와 CD값이 유니크하지 않기 때문에 값이 여러개 일 수 있고 이를 찾는데 오래 걸리므로 
//    map을 이용해서 dynamic programming 해줌

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static long[] ab;
	static long[] cd;
	static HashMap <Integer, Long> mm = new HashMap<>();
	
	// 해당 index를 기준으로 같은 값이 몇개 있는지 return하는 함수
	static long getSameValue(int index) {
		if (mm.containsKey(index)) {
			return mm.get(index);
		}
		long ret = 0;
		
		for (int i = index; i < cd.length; i++) {
			if (cd[i] == cd[index]) ret += 1;
			else break;
		}
		
		for (int i =index - 1; i >= 0; i--) {
			if (cd[i] == cd[index]) ret +=1;
			else break;
		}
		
		mm.put(index, ret);
		return ret;
		
	}
	
	// 해당 값이 cd 배열에서 몇개 있는지 구하는 함수
	static long binarySearch(long k) {
		int l = 0;
		int r = cd.length -1;
		int m = 0;
		while (true) {
			if (m == (l + r) / 2) {
				return 0;
			}
			m = (l + r) / 2;
			if (cd[m] == k) 
				break;
			else if (cd[m] < k) {
				l = m + 1;
			} else {
				r = m - 1;
			}
		}
		
		return getSameValue(m);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		long[] A = new long[N];
		long[] B = new long[N];
		long[] C = new long[N];
		long[] D = new long[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			A[i] = Long.parseLong(st.nextToken());
			B[i] = Long.parseLong(st.nextToken());
			C[i] = Long.parseLong(st.nextToken());
			D[i] = Long.parseLong(st.nextToken());
		}
		
		ab = new long[N * N];
		cd = new long[N * N];
		
		// ab와 cd의 합을 구함
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ab[i*N+j] = A[i] + B[j];
				cd[i*N+j] = C[i] + D[j];
			}
		}
		
		// ab, cd 오름차순으로 정렬
		Arrays.sort(ab);
		Arrays.sort(cd);
		
		long answer = 0;
		for(int i = 0; i < ab.length; i++) {
			answer += binarySearch(-ab[i]);
		}
		
		System.out.println(answer);
	}
}

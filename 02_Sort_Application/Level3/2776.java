// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
//암기왕
//https://www.acmicpc.net/problem/2776
//1. N과 M을 일일이 비교하면 복잡도가 O(NM)이기 때문에 시간 초과가 된다.
//2. N을 정렬하여 M의 값들을 binary search하여 logN만에 찾도록 하자.
//3. BufferedReader, BufferdWriter 쓰지 않으면 시간 초과됨.

import java.io.*;
import java.util.*;

public class Main {
	static String binarySearch(int val, int[] arr) {
		int l = 0;
		int r = arr.length - 1;
		
		while ( l <= r) {
			int m = (l + r) / 2;
			if (val == arr[m]) {
				return "1";
			}
			else if (val < arr[m]) {
				r = m - 1;
			} else {
				l = m + 1;
			}
		}
		
		return "0";
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		while( T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int[] arr1 = new int[N];			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr1[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr1);
			
			int M = Integer.parseInt(br.readLine());
			int[] arr2 = new int[M];			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				arr2[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < M; i++) {
//				System.out.println(binarySearch(arr2[i], arr1));
				bw.write(binarySearch(arr2[i], arr1));
				bw.newLine();
			}
		}
		bw.flush();
		bw.close();
	}
}

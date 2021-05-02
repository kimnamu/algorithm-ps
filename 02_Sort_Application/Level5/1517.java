// 버블 소트
// https://www.acmicpc.net/problem/1517
// 힌트
// 1. 버블 소트로 문제를 풀면 O(N^2)로 시간 초과
// 2. 버블 소트는 수열의 왼쪽에 있는 수가 오른쪽에 있는 수보다 몇개나 더 큰지 알아내면 됨.
// 3. 합병정렬(merge sort)를 통해 정렬을 하며, 정렬 중 왼쪽에 있는 수가 오른쪽에 있는
//    수보다 몇개가 더 큰지 계산하여 더해줌
// 4. 합병정렬의 시간복잡도는 O(nlogn)으로 시간내에 통과가능

import java.io.*;
import java.util.*;

public class Main {
	static long answer;
	static long[] numbers;
	static long[] temp;
	
	static void merge(int left, int middle, int right) {
		int i = left;
		int j = middle + 1;
		int index = left;
		
		while (i <= middle && j <= right) {
			if (numbers[i] <= numbers[j]) {
				temp[index++] = numbers[i++];
			} else {
				temp[index++] = numbers[j++];
				answer += (middle + 1 - i);
			}
		}
		
		while (i <= middle) {
			temp[index++] = numbers[i++];
		}
		
		while (j <= right) {
			temp[index++] = numbers[j++];
		}
		
		for (int k = left; k <= right; k++) {
			numbers[k] = temp[k];
		}
	}
	
	static void mergeSort(int left, int right) {
		if (left >= right) {
			return;
		}
		
		int middle = (left + right) / 2;
		
		mergeSort(left, middle);		
		mergeSort(middle + 1, right);
		
		merge(left, middle, right);
	}
	
	public static void main(String[] args) throws IOException, NumberFormatException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		numbers = new long[N];
		temp = new long[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Long.parseLong(st.nextToken());
		}
		
		answer = 0;
		
		mergeSort(0, N - 1);
		
		System.out.println(answer);
	}
}

// 수 묶기
// https://www.acmicpc.net/problem/1744
// 힌트
// 1. 오름차순으로 정렬
// 2. 정렬된 순서대로 추의 값을 더함
// 3. 현재까지 추의 합 + 1 이 다음의 추의 값보다 작으면
//    현재까지 추의 합 + 1 은 표현 못함.

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] numbers = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
	    // 오름차순으로 정렬
    	Arrays.sort(numbers);
		
		int currentSum = 0;
		
		for (int i = 0; i < N; i++) {
	        // 현재까지의 합 + 1보다 현재 값이 더 크면 break
			if (currentSum + 1 < numbers[i]) {
				break;
			} else {
				currentSum += numbers[i];
			}
		}
		
		System.out.println(currentSum + 1);
	}
}

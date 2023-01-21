// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
//ATM
//https://www.acmicpc.net/problem/11399
//힌트
//1. 대기시간이 짧은 사람이 먼저 ATM기를 이용할 수록 뒷사람들의 누적 대기시간이 짧아진다.

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		
		for (int i=0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);
		
		int answer = 0;
		int temp = 0;
		
		for (int i = 0; i < N; i++) {
	        // 1. 누적 대기시간			
			temp += arr[i];
			// 2. 누적 대기시간의 합
			answer += temp;
		}
		
		System.out.println(answer);
	}	
}

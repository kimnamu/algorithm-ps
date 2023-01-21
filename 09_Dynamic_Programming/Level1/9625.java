// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// BABBA
// https://www.acmicpc.net/problem/9625
// 힌트
// 1. Bottom-Up 방식의 다이나믹 프로그래밍을 이용하여 이전 상태에서 다음 상태를 갱신하여 O(N)안에 풀 수 있다.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine());
		
	    int A = 1, B =0 ;
	    while (K-- > 0){
	        int A_new = B;
	        int B_new = A + B;
	        A = A_new;
	        B = B_new;
	    }

	    System.out.println(A + " " + B);
	}
}

// 정수 제곱근
// https://www.acmicpc.net/problem/2417
// 힌트
// 1. Binary Search를 이용하여 left와 right의 중앙값을 활용하여 탐색 범위를 좁혀간다.

import java.io.*;

public class Main {	
	static long bs(long n) {
		long l = 0;
		long r = n - 1;
		long m = (l + r) / 2;
		
		while (l <= r) {
	        m = (l + r) / 2;
	        if (m < Math.sqrt(n))
	        {
	            l = m + 1;
	        }
	        else
	        {
	        	r = m - 1;
	        }
		}
		
		return l;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long n = Long.parseLong(br.readLine());
		
//		 방법 1. Binary Search 이용
		long answer = bs(n);
		System.out.println(answer);
		
//		 방법 2. sqrt 함수 사용하며, 제곱으로 값이 일치하지 않는 경우 +1 하여 정답
//		long answer = (long)(Math.sqrt(n));
//		if (answer * answer != n) {
//			answer += 1;
//		}
//		System.out.println(answer);
	}
}

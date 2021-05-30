//게임
//https://www.acmicpc.net/problem/1072
//힌트
//1. 최소 몇번을 이겨야하는지 그 횟수를 binary search를 통해 찾아보자.
//2. 형변환에 주의하자.
// 예를 들어, 정수형 변수 x, y에 대해서 "(y*100)/x"과  "y/x * 100"은 값이 다르다.

import java.util.Scanner;

public class Main {
	static long x;
	static long y;
	
	static long solve() {
		if (x == y || 99 <= (y * 100) / x)
			return -1;
		
		long z = (y * 100) / x;
		
		long l = 0;
		long r = 1000000000;
		long m = -1;
		
		while (l <= r) {
			m = (l + r) / 2;
			long z_new = (y + m) * 100 / (x + m);
			if (z_new <= z) {
				l = m + 1;
			} else {
				r = m - 1;
			}
		}
		return l;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		x = sc.nextLong();
		y = sc.nextLong();
		
		long answer = solve();
		
		System.out.println(answer);
	}
}

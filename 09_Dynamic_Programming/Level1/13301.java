// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>

// 타일 장식물
// https://www.acmicpc.net/problem/13301
// 힌트
// 1. 타일의 크기는 피보나치수열을 이루고 있다.
// 2. "타일의 둘레 = 이전 타일의 둘레 + 새로 만들어진 타일의 크기 * 2" 의 점화식을 
//     이용하여 bottom-up의 다이나믹 프로그래밍을 이용한다.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		 
		long[] v = new long[N + 2];
		v[0] = v[1] = v[2] = 1;
		
	    for (int i = 3; i <= N; i++)
	    {
	        v[i] = v[i - 1] + v[i - 2];
	    }
	    
	    long answer = 4;
	    for (int i = 2; i <= N; i++)
	    {
	        answer += v[i] * 2;
	    }
	    
	    System.out.println(answer);
	}
}

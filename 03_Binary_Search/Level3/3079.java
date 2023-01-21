// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 입국심사
// https://www.acmicpc.net/problem/3079
// 힌트
// 1. 구해야할 최소 시간을 Binary Search를 통해 탐색한다.
// 2. 해당 시간안에 M명의 사람들이 모두 통과할 수 있는지를 체크하면서 통과 가능한 가장 작은 수를 찾으면 된다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int M;
	static int N;
	static long[] v;
	
	static long solve(long time)
	{
	    long ret = 0;
	    for (int i = 0; i < N; i++)
	    {
	        ret += time / v[i];
	    }
	    return ret;
	}

	static long bs(long right)
	{
	    long l = 1;
	    long r = right;
	    long m = (l + r) / 2;
	    while (l < r)
	    {
	        m = (l + r) / 2;
	        if (solve(m) >= M)
	        {
	            r = m;
	        }
	        else
	        {
	            l = m + 1;
	        }
	    }
	    return l;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		v = new long[N];
		
		long right = 0;
		for (int i = 0; i < N; i++) {
			v[i] = Integer.parseInt(br.readLine());
			right = Math.max(right,  v[i]);
		}
		
		right *= M;
		
		long answer = bs(right);
		
		System.out.println(answer);
	}
}

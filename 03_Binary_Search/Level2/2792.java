// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 보석 상자
// https://www.acmicpc.net/problem/2792
// 힌트
// 1. 한명의 아이가 가질 수 있는 최대 보석의 수를 찾으면 되는 문제로 해당 개수를 Binary Search를 통해 찾아보자.
// 2. Binary search로 개수를 추정해가는 부분과 해당 개수로 아이들에게 모두 나눠줄 수 있는지를 평가하는 부분을 작성하면 된다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int M;
	static int N;
	static int[] v;
	
	static int solve(int k)
	{
	    int ret = 0;
	    for (int i = 0; i < M; i++)
	    {
	        ret += (v[i] + k - 1) / k;
	    }
	    return ret;
	}

	static int bs(int right)
	{
	    int l = 1;
	    int r = right;
	    int m = (l + r) / 2;
	    while (l < r)
	    {
	        m = (l + r) / 2;
	        if (solve(m) <= N)
	        {
	            r = m;
	        }
	        else
	        {
	            l = m + 1;
	        }
	    }
	    return r;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		v = new int[M];
		int right = 0;
		for (int i = 0; i < M; i++) {
			v[i] = Integer.parseInt(br.readLine());
			right = Math.max(right,  v[i]);
		}
		
		int answer = bs(right);
		
		System.out.println(answer);
	}
}

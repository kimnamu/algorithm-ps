// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// Dance Dance Revolution
// https://www.acmicpc.net/problem/2342
// 1. Memoization을 이용하여 왼발, 오른발, 차례에 따른 최소 비용 값을 갱신해준다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer> v;
	static int[][][] dp = new int[5][5][100000];
	
	static int move(int from, int to)
	{
	    int ret = 0;
	    if (from == to)
	        ret = 1;
	    else if (from == 0)
	    {
	        ret = 2;
	    }
	    else if (from == 1)
	    {
	        ret = to == 3 ? 4 : 3;
	    }
	    else if (from == 2)
	    {
	        ret = to == 4 ? 4 : 3;
	    }
	    else if (from == 3)
	    {
	        ret = to == 1 ? 4 : 3;
	    }
	    else if (from == 4)
	    {
	        ret = to == 2 ? 4 : 3;
	    }
	    return ret;
	}

	static int solve(int l, int r, int n)
	{
	    if (n == v.size())
	        return 0;
	    if (dp[l][r][n] != 0)
	        return dp[l][r][n];
	    dp[l][r][n] = Math.min(move(l, v.get(n)) + solve(v.get(n), r, n + 1),
	                      move(r, v.get(n)) + solve(l, v.get(n), n + 1));

	    return dp[l][r][n];
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = new ArrayList<>();
		while (true) {
			int n = Integer.parseInt(st.nextToken());
			if (n == 0) 
				break;
			v.add(n);
		}
		
		int answer = solve(0, 0, 0);
		System.out.println(answer);
	}

}

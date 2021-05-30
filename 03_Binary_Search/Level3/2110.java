// 공유기 설치
// https://www.acmicpc.net/problem/2110
// 힌트
// 1. 공유기를 설치하기 위한 최소한의 간격을 binary search로 찾으면 된다.
// 2. 첫번째 위치를 시작으로 최소한의 간격 이상일때만 공유기를 놓아주면서 c 갯수 이상 뒀는지, 부족하게 뒀는지로 binary search를 해준다.

import java.io.*;
import java.util.*;

public class Main {
	static int n, c;
	static int[] v;
	
	static boolean solve(int dist) {
	    int pos = v[0];
	    int cnt = 1;
	    for (int i = 1; i < n; i++)
	    {
	        // dist거리 이상 떨어졌을때만 와이파이를 설치한다.
	        if (v[i] - pos >= dist)
	        {
	            cnt += 1;
	            pos = v[i];
	        }
	    }
	    if (cnt >= c)
	        return true;
	    else
	        return false;

	}
	
	static int bs() {
		int l = 0;
		int r = v[n-1] - v[0];
		int m = 0;
		
		while (l <= r) {
			m = (l + r) / 2;
			if (solve(m)) {
				l = m + 1;
			} else {
				r = m - 1;
			}
		}
		
		return r;
	}
	
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		v = new int[n];
		for (int i = 0; i < n; i++) {
			v[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(v);
		
		int answer = bs();
		
		System.out.println(answer);

	}
}

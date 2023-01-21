// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 캠프가는 영식
// https://www.acmicpc.net/problem/1590
// 힌트
// 1. 버스의 모든 시간을 입력하여 정렬한다.
// 2. 정렬된 버스를 기준으로 영식이의 도착시간이 가장 빠른 시간보다 빠르거나 가장 늦은 시간보다 늦으면 brute force로 구하고,
//    중간에 있을 경우 binary search로 도착시간과 같거나, 늦은 시간중 가장 이른 시간을 구해서 도착시간에서 빼준다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int N, T;
	static ArrayList<Long> times;
	
	static long bs()
	{
		if (times.get(times.size() - 1) < T) return -1;
		if (times.get(0) >= T) return times.get(0) - T;
		
	    long l = 0;
	    long r = times.size() - 1;
	    long m = (l + r) / 2;
	    while (l < r)
	    {
	        m = (l + r) / 2;
	        if (times.get((int)m) == T)
	        {
	            return 0;
	        }
	        else if (times.get((int)m) > T) {
	        	r = m;
	        }
	        else
	        {
	            l = m + 1;
	        }
	    }
	    return times.get((int)r) - T;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		times = new ArrayList<>();
		
		for (int i = 0; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			long start = Long.parseLong(st.nextToken());
			long gap = Long.parseLong(st.nextToken());
			long num = Long.parseLong(st.nextToken());
			
			for (int j = 0; j < num; j++) {
				times.add(gap * j + start);
			}
		}
		
		Collections.sort(times);
		long answer = bs();
		
		System.out.println(answer);
	}
}

// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 꼬인 전깃줄
// https://www.acmicpc.net/problem/1365
// 힌트
// 1. 왼쪽 전봇대를 기준으로 오른쪽에 매칭된 전봇대의 위치가 단조 증가하게 되면 꼬인 전깃줄이 없게 된다.
//    즉, LIS(Longest Increasing Subsequence)의 길이를 구하여 전체 전깃줄의 개수에서 빼주면 된다.
// 2. LIS를 구하는 방법에서 오른쪽 전봇대의 위치값을 기준으로 순차적으로 구할 때, 새로운 전봇대의 위치가
//    축적시켜놓은 vector의 어느 위치에 넣어주어야 할지 binary search로 찾아주면 시간 내에 풀 수 있다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static ArrayList<Integer> v;
	
	static int BS(int num)
	{
	    int left = 0;
	    int right = v.size() - 1;

	    while (left < right)
	    {
	        int mid = (left + right) / 2;
	        if (v.get(mid) >= num)
	            right = mid;
	        else
	            left = mid + 1;
	    }
	    return right;
	}

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		v = new ArrayList<>();
		v.add(-1);
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (num > v.get(v.size()-1)) {
				v.add(num);
			} else {
				int idx = BS(num);
				v.set(idx, num);
			}
		}
		
		System.out.println(N - v.size() + 1);
	}
}

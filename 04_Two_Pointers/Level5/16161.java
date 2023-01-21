// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 가장 긴 증가하는 팰린드롬 부분수열
// https://www.acmicpc.net/problem/16161
// 힌트
// 1. 처음 시작 위치에 left, right 포인터를 주고, 왼쪽으로 하나씩 읽었을때 증가하는 수열에 대해 right 포인터를 같이 옮겨준다.
// 2. 이때 같거나, 감소하는 수열을 만나게 되면 그 지점을 중심으로 좌우 수열이 팰린드롬 수열인지 확인해 준다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] s = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			s[i] = Integer.parseInt(st.nextToken());
		}
		
	    int left = 0;
	    int right = 0;
	    int answer = 1;
	    while (right < N - 1)
	    {
	        int cnt, l, r;
	        if (s[right] < s[right + 1])
	        {
	            right += 1;
	        }
	        else
	        {
	            if (s[right] > s[right + 1])
	            {
	                cnt = 1;
	                l = right - 1;
	                r = right + 1;
	            }
	            else
	            {
	                cnt = 0;
	                l = right;
	            }
	            r = right + 1;

	            while (l >= left && r < N)
	            {
	                if (s[l] == s[r])
	                {
	                    cnt += 2;
	                    l -= 1;
	                    r += 1;
	                }
	                else
	                    break;
	            }
	            answer = Math.max(answer, cnt);

	            right += 1;
	            left = right;
	            right = right;
	        }
	    }
	    
	    System.out.println(answer);
	}
}

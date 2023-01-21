// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 사냥꾼
// https://www.acmicpc.net/problem/8983
// 힌트
// 1. 동물을 기준으로 사냥 가능한 범위에 사로가 있는지 이분 탐색으로 구하면 된다.
// 2. 사냥 가능한 범위는 L값을 기준으로 동물의 위치로 부터 가장 멀리 떨어 질 수 있는 lower와 upper를 구한다.
// 3. 각각의 동물에 대해 lower와 upper를 지정 후, 가능한 사로가 있는지 이분 탐색 한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[] v = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0 ; i < M; i++) {
			v[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(v);
		
		int answer = 0;
	    for (int i = 0; i < N; i++)
	    {
	    	st = new StringTokenizer(br.readLine());
	    	int x = Integer.parseInt(st.nextToken());
	    	int y = Integer.parseInt(st.nextToken());
	        if (y > L)
	            continue;
	        int upper = x + (L - y), lower = x - (L - y);
	        int left = 0, right = M - 1;
	        
	        while (left <= right)
	        {
	            int mid = (left + right) / 2;
	            if (lower <= v[mid] && v[mid] <= upper)
	            {
	                answer++;
	                break;
	            }
	            else if (v[mid] < lower)
	            {
	                left = mid + 1;
	            }
	            else
	            {
	                right = mid - 1;
	            }
	        }
	    }
	    
	    System.out.println(answer);

	}
}

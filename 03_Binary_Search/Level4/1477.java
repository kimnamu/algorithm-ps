//휴게소 세우기
//https://www.acmicpc.net/problem/1477
//힌트
//1. 휴게소와 휴게소 사이에 새로운 휴게소를 설치할때, 새로운 휴게소 기준으로 왼쪽 휴게소로 부터 "얼마 만큼 떨어진 휴게소"를 지을지 거리를 정하고,
// 그 거리로 설치하게 되면 "총 몇 개의 휴게소룰 새로설치"하게 되는지 계산을해서, 새로 설치하는 휴게소가 제한된 개수보다 적거나 같으면 더 작은 간격으로 설치가 가능하다.
// 반대로 새로 설치하는 휴게소 개수가 제한된 개수보다 많으면 더 멀리 떨어지게 휴게소를 만들 수 있다.

import java.io.*;
import java.util.*;

public class Main {
	static int N, M, length;
	static int[] v;
	
	static boolean solve(int distance)
	{
	    int cnt = 0;
	    for (int i = 0; i < N + 1; i++)
	    {
	        int d = v[i + 1] - v[i];
	        int temp = 0;
	        if (d / distance > 0)
	        {
	            // 휴게소간의 거리가 새로 설치한 distance로 나누었을때 딱 나눠떨어지면,
	            // 나눈값에 -1개 한 수만큼 설치가 가능하다.
	            if (d % distance == 0)
	                temp = (d / distance) - 1;
	            else
	                temp = (d / distance);
	            cnt += temp;
	        }
	    }
	    if (cnt > M)
	        return true;
	    return false;
	}

	
	static int bs() {
		int left = 1;
		int right = length - 1;
		int middle = -1;
		
		while (left <= right) {
			middle = (left + right) / 2;
			
			// 현재 middle 초과하여 거리 차이가 가능하면, 더 큰 최대값 찾기
			if (solve(middle)) {
				left = middle + 1;
			} else {
				right = middle - 1;
			}
		}
		
		return left;
	}
	
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		length = Integer.parseInt(st.nextToken());
		
		v = new int[N + 2];
		v[0] = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i < N + 1; i++) {
			v[i] = Integer.parseInt(st.nextToken());
		}
		v[N + 1] = length;
		
		Arrays.sort(v);
		
		int answer = bs();
		
		System.out.println(answer);
		
	}
}

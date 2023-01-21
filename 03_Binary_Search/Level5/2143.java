// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 두 배열의 합
// https://www.acmicpc.net/problem/2143
// 힌트
// 1. a배열의 누적합과 b배열의 누적합을 각각 이용해 만들어질수 있는 부분 배열합을 새로운 배열에 만들자.
//    이때 각 부분 배열합을 만드는데 필요한 복잡도는 O(n^2), O(m^2)이다.
// 2. 새로운 부분 배열합 a의 i번째 원소를 기준으로 t-a[i] 값이 부분배열합 b에 몇개 존재하는지 찾으면 된다.
// 3. Brute force로 찾게되면 O(n^2 * m^2)이므로 제한된 시간내에 탐색할 수 없기 때문에 binary search를 이용한다.
//    값이 있는지 없는지 뿐만아니라 몇개 존재하는지 확인하기 위해 t-a[i]값이 시작하는지점과 끝나는 지점을 각각 찾아주어야 한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int T, N, M;
	static int A[], B[];
	static ArrayList<Long> aPartials, bPartials;
	
	static ArrayList<Long> getPartials(int v[]) {
		int n = v.length;
		long[] v_sum = new long[n];
		for (int i = 1; i < n; i++) {
			v_sum[i] = v_sum[i-1] + v[i];
		}
		
		ArrayList<Long> partials = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				partials.add(v_sum[j] - v_sum[i]);
			}
		}
		
		return partials;
	}
	
	static long bs(long k) {
		
	    int l = 0;
	    int r = bPartials.size() - 1;
	    int mid = (l + r) / 2;
	    int start, end;
	    // k가 시작되는 지점찾기
	    while (l < r)
	    {
	        mid = (l + r) / 2;
	        if (bPartials.get(mid) >= k)
	        {
	            r = mid;
	        }
	        else
	        {
	            l = mid + 1;
	        }
	    }
	    if (bPartials.get(l) != k)
	        return 0;
	    start = l;

	    // k가 끝나는 지점 찾기
	    l = 0;
	    r = bPartials.size() - 1;
	    while (l < r)
	    {
	        mid = (l + r + 1) / 2;
	        if (bPartials.get(mid) > k)
	        {
	            r = mid - 1;
	        }
	        else
	        {
	            l = mid;
	        }
	    }
	    end = l;
	    return end - start + 1;
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		N = Integer.parseInt(br.readLine());
		A = new int[N + 1];
		A[0] = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		M = Integer.parseInt(br.readLine());
		B = new int[M + 1];
		B[0] = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < M + 1; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		aPartials = getPartials(A);
		bPartials = getPartials(B);
		
		Collections.sort(aPartials);
		Collections.sort(bPartials);
		
		long answer = 0;
		for (int i = 0; i < aPartials.size(); i++) {
			answer += bs(T - aPartials.get(i));
		}
		
		System.out.println(answer);
	}
}

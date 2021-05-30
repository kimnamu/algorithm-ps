// 개똥벌레
// https://www.acmicpc.net/problem/3020
// 힌트
// 1. 개똥벌레가 통과하려는 구간(1~h)에 따라 통과해야 하는 장애물의 수를 찾으면 되고 장애물 수는 U자 곡선을 그리게 된다.
// 2. 통과 구간이 정해지면 정렬해놓은 종유석, 석순에 대해 binary search로 파괴해야하는 장애물 수를 구한다.
//    이때 복잡도는 O(NlogN + HlogN) 이 된다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, H;
	static int bottom[], top[];
	
	static int bs(int height)
	{
	    // 1. 파괴해야하는 석순
	    int cnt = 0;
	    int left = 0;
	    int right = N / 2 - 1;
	    int mid = -1;
	    while (left <= right)
	    {
	        mid = (left + right) / 2;
	        if (bottom[mid] >= height)
	        {
	            right = mid - 1;
	        }
	        else
	        {
	            left = mid + 1;
	        }
	    }
	    cnt += N / 2 - left;
	    
	    // 2. 파괴해야하는 종유석
	    left = 0;
	    right = N / 2 - 1;
	    mid = -1;
	    while (left <= right)
	    {
	        mid = (left + right) / 2;
	        if (top[mid] >= H - height + 1)
	        {
	            right = mid - 1;
	        }
	        else
	        {
	            left = mid + 1;
	        }
	    }
	    cnt += N / 2 - left;
	    return cnt;
	}

	
	static void solve() {
		int answer = N;
		int temp = 0;
		int answer_cnt = 0;
		
		for (int i = 1; i <= H; i++) {
			temp = bs(i);
			
			if (answer == temp) {
				answer_cnt += 1;
			}
			
			if (answer > temp) {
				answer = temp;
				answer_cnt = 1;
			}
		}
		
		System.out.println(answer + " " + answer_cnt);
	}
	
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		bottom = new int[N/2];
		top = new int[N/2];
		
		for (int i = 0; i < N; i++) {
			if (i % 2 == 0) {
				bottom[i/2] = Integer.parseInt(br.readLine()); 
			} else {
				top[i/2] = Integer.parseInt(br.readLine());				
			}
		}
		
		Arrays.sort(bottom);
		Arrays.sort(top);
		
		solve();
	}
}

// 랜선 자르기
// https://www.acmicpc.net/problem/1654
// 힌트
// 1. n이 1이상이므로 자를 랜선의 길이는 가장 긴 랜선보다 클수 없다.
//    가장 긴 랜선보다 크면 0이 되기 때문인데, 그렇기 때문에 binary search의 가장 큰 값은 가장긴 랜선의 길이로 지정하면 된다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int lan_max;
	static int lan[];
	
	static boolean solve(long m) {
		if (m == 0) 
			return true;
		
		long total = 0;
		
		for (int i = 0; i < N; i++) {
			total += lan[i] / m;
		}
		
		if (total >= M) {
			return true;
		} else {
			return false;
		}
	}
	
	static int bs() {
		long l = 0;
		long r = lan_max;
		long m = 0;
		
		while (l <= r) {
			m = (l + r) / 2;
			
			if (solve(m)) {
				 l = m + 1;
			} else {
				r = m - 1;
			}	
		}
		
		return (int)r;
	}
	
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
				
		lan = new int[N];
		lan_max = 0;
		for (int i = 0; i < N; i++) {
			lan[i] = Integer.parseInt(br.readLine());
			lan_max = Math.max(lan_max, lan[i]);
		}
		
		int answer = bs();
		
		System.out.println(answer);
	}
}


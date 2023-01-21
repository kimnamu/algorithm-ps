// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 기타 레슨
// https://www.acmicpc.net/problem/2343
// 힌트
// 1. 레슨 수가 적힌 배열을 순차적으로 합해가면서, 제한된 블루레이 용량을 초과할 경우 새로운 블루레이로 교환해주면 된다.
//    이때, 제한된 블루레이 용량을 Binary search로 찾으면 된다. 
// 2. Binary Search의 범위를 설정할때 최소값은 적어도 하나의 레슨은 담을 수 있는 용량으로 해야하고, 최대값을 모든 레슨을 한번에 담을 수 있응 용량으로 해야한다.
//    다시 말해, 블루레이 용량의 최소값을 레슨 중 최대값이 되어야하고, 최대값을 레슨의 모든 합이 되어야 한다.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int v_min, v_max;
	static int v[];
	
	static boolean solve(int k) {
		long currentSum = 0;
		int cnt = 1;
		
		for (int i = 0; i < N; i++) {
			currentSum += v[i];
			if (currentSum > k) {
				cnt += 1;
				currentSum = v[i];
			}
		}
		
		if (cnt > M) {
			return false;
		} else {
			return true;
		}
	}
	
	static int bs() {
		int l = v_min;
		int r = v_max;
		int m = 0;
		
		while (l <= r) {
			m = (l + r) / 2;
			
			if (solve(m)) {
				r = m - 1;
			} else {
				l = m + 1;
			}	
		}
		
		return l;
	}
	
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());

		v = new int[N];
		v_max = 0;
		v_min = 0;
		for (int i = 0; i < N; i++) {
			v[i] = Integer.parseInt(st.nextToken());
			
			v_min = Math.max(v_min, v[i]);
			v_max += v[i];
		}
		
		int answer = bs();
		
		System.out.println(answer);
		
		
	}
}
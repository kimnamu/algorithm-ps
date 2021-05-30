//귀여운 라이언
//https://www.acmicpc.net/problem/15565
//힌트
//1. K개의 1을 포함하는 배열의 길이가 최소가 뙬때를 찾으면 된다.
//2. 투 포인터를 이용하여 1의 갯수가 K개보다 작으면 오른쪽 포인터를 키워주고,
// K보다 크면 오니쪽 포인터를 키워 준다.
//3. 어떤 경우도 K개의 1을 포함하지 못할 경우 -1을 반환한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static boolean isRyon(int num) {
		return num == 1;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] A = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0;
		int right = 0;
		int cnt = isRyon(A[0]) ? 1 : 0;
		int answer = N + 1;
		
		while (right < N) {
			if (cnt == k) {
				answer = Math.min(right - left + 1, answer);
				if (isRyon(A[left])) {
					cnt -= 1;
				}
				left += 1;

			} else if (cnt < k) {
				right += 1;
				if (isRyon(A[right])) {
					cnt +=1;
				}
			} else {
				if (isRyon(A[left])) {
					cnt -= 1;
				}
				left += 1;
			}
		}
		if (answer == N + 1)
			answer = -1;
		
		System.out.println(answer);
	}
}

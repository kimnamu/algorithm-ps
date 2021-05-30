//회전 초밥
//https://www.acmicpc.net/problem/2531
//힌트
//1. 회전이기 때문에 배열의 뒷부분에 배열과 같은 순서의 k개의 초밥을 더 해준다.
//2. 0번째 부터 k-1번째 까지의 k개의 초밥을 먼저 선택하면서 몇 가지의 초밥이 포함되었는지 카운팅 한다.
//3. 포인터 개념을 이용하여 왼쪽 포인터는 0번째 부터, 오른쪽 포인터는 K-1번째 부터 시작하면서
// 왼쪽 포인터는 제외하고 오른쪽 포인터는 추가하면서 포인터 위치를 한칸씩 높여준다.
//4. 이때 선택한 회전 초밥 중에 쿠폰번호 초밥이 포함되어있지 않으면 +1을 해준다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] A = new int[N + k];
		
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		
		int[] check = new int[d+1];
		int cnt = 0;
		for (int i = 0; i < k; i++) {
			A[N+i] = A[i];
			if (check[A[i]] == 0) {
				cnt +=1;
			}
			check[A[i]] += 1;
		}
		
		int answer = 0;
		if (check[c] ==0) {
			answer = cnt + 1;
		} else {
			answer = cnt;
		}
		
		int left, right;
	    for (int i = 0; i < N; i++)
	    {
	        left = i;
	        right = i + k;
	        check[A[left]] -= 1;
	        if (check[A[left]] == 0)
	            cnt -= 1;
	        if (check[A[right]] == 0)
	            cnt += 1;
	        check[A[right]] += 1;

	        if (check[c] == 0)
	            answer = Math.max(answer, cnt + 1);
	        else
	            answer = Math.max(answer, cnt);
	    }

	    System.out.println(answer);
	}
}

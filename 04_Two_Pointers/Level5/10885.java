// 수열의 장인
// https://www.acmicpc.net/problem/10885
// 힌트
// 1. 마이너스(-)의 개수가 짝수일때 2 혹은 -2의 개수가 최대치가 되는 때를 구하면 된다.
// 2. 왼쪽부터 순차적으로 포인터를 오른쪽으로 이동해가며 구해주고, 오른쪽에서부터 순차적으로 왼쪽으로 포인터를 이동하며 구해주면 된다.
// 3. 마이너스(-)가 짝수이면서 2 혹은 -2가 없는 경우 예외처리를 위해 단일 수의 최대값을 정답의 초기값으로 지정해준다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	static int[] v;
	static int cntTwo, cntMinus;
	static int ansTwo, answer;
	
	static void solve(int idx)
	{
	    if (v[idx] == 0)
	    {
	        cntTwo = 0; cntMinus = 0;
	        return;
	    }
	    if (v[idx] < 0)
	        cntMinus += 1;

	    if (v[idx] == 2 || v[idx] == -2)
	        cntTwo += 1;

	    if (cntMinus % 2 == 0)
	    {
	        ansTwo = Math.max(ansTwo, cntTwo);
	        answer = 1;
	    }
	}

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while (T-- >0) {
			int N = Integer.parseInt(br.readLine());
			
			v = new int[N];
			answer = -2;
			ansTwo = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				v[i] = Integer.parseInt(st.nextToken());
	            answer = answer < v[i] ? v[i] : answer;
			}
	        cntTwo = 0; cntMinus = 0;
	        for (int i = 0; i < N; ++i)
	            solve(i);

	        cntTwo = 0; cntMinus = 0;
	        for (int i = N - 1; i >= 0; --i)
	            solve(i);

	        while (ansTwo-- > 0)
	            answer = (answer << 1) % 1000000007;
        	
	        System.out.println(answer);
			
		}
	}
}

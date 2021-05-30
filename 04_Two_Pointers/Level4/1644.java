//소수의 연속합
//https://www.acmicpc.net/problem/1644
//힌트
//1. 먼저 N 제한인 4000000까지 (혹은 N까지)의 소수를 구한다. 에라토스테네스의 체 방법을 이용하면 O(NloglogN)만에 모든 소수를 구할 수 있다.
//2. 모든 소수에 대해서 투 포인터를 이용해 구간을 이동시키면서 합을 구한다.
//2.1 구간합이 N보다 크면 왼쪽 포인터 위치 값을 빼주면서 한칸 옮겨준다.
//2.2 구간합이 N보다 작으면 오른쪽 포인터 위치 값을 한칸 옮겨준 후 값을 더해준다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	static boolean[] primeCheck;
	static ArrayList<Integer> primeNumbers;
	static int N;
	
	static void getPrimeNumbers(int N) {
	    // 2부터 특정 수의 배수에 해당하는 수를 모두 지움
		for (int i = 2; i < N + 1; i++) {
			if (!primeCheck[i]) {
				continue;// 이미 지워진 수라면 건너뜀
			}
			
	        // 이미 지워진 숫자가 아니라면, 해당 숫자의 배수를 모두 true로 만듦			
			int j = 2;
			while(j * i < N + 1) {
				primeCheck[j * i] = false;
				j++;
			}
		}
		
		for (int i = 2; i < N + 1; i++) {
			if (primeCheck[i]) {
				primeNumbers.add(i);
			}
		}
	}
	
	static int solve() {
		if (N == 1)
			return 0;
		
		int left = 0;
		int right = 0;
		long sum = primeNumbers.get(right);
		
		int answer = 0;
	    while (true)
	    {
	        if (sum == N)
	        {
	            answer += 1;
	            sum -= primeNumbers.get(left);
	            left += 1;
	        }
	        else if (sum > N)
	        {
	            sum -= primeNumbers.get(left);
	            left += 1;
	        }
	        else
	        {
	            right += 1;
	            if (right == primeNumbers.size())
	            	break;
	            sum += primeNumbers.get(right);
	        }
	    }
	    
	    return answer;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		primeCheck = new boolean[N + 1];
		Arrays.fill(primeCheck, true);
		primeNumbers = new ArrayList<Integer>();
		
		getPrimeNumbers(N);
		
		int answer = solve();
		
		System.out.println(answer);
	}
}

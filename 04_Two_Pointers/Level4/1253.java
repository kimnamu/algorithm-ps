// https://www.acmicpc.net/problem/1253
// 힌트
// 1. 먼저 주어진 수열을 정렬한다.
// 2. 가장 큰 수부터 target으로 지정하고, target의 나머지 수 중 가장 작은 수중 가장 작은 수와 가장 큰수를 먼저 선정하여
//    two pointer방법을 이용하여 합이 target과 같은때가 존재하는지 찾는다.
//    2.1 두 수의 합이 target보다 크면 큰 수의 포인터를 하나 더 작은 수로 옮기고,
//    2.2 두 수의 합이 target보다 작으면 작은 수의 포인터를 하나 더 큰 수로 옮긴다.
// 3. 같은 수가 존재 할 수 있음을 유의하자.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] v = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			v[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(v);
		
		int answer = 0;
	    for (int i = N - 1; i >= 0; i--)
	    {
	        int target = v[i];
	        int left = 0;
	        int right = N - 1;
	        while (left < right)
	        {
	            if (left == i)
	                left += 1;
	            if (right == i)
	                right -= 1;
	            if (left >= right)
	                break;
	            if (v[left] + v[right] == target)
	            {
	                answer += 1;
	                break;
	            }
	            else if (v[left] + v[right] > target)
	            {
	                right -= 1;
	            }
	            else
	            {
	                left += 1;
	            }
	        }
	    }

	    System.out.println(answer);
	}
}

//고냥이
//https://www.acmicpc.net/problem/16472
//힌트
//1.투포인터를 이용하여 포인터사이에 포함된 문자열의 종류의 갯수가 N개 이하일 때 가장 긴 거리를 찾으면 된다.
//2.포인터 사이 문자열 종류의 갯수가 N보다 적으면 더 긴 문자열을 만들 수 있으므로 right 포인터를 오른쪽으로 한칸 옮기면서 해당 알파벳의 갯수와 종류값을 업데이트 해준다.
//3.포인터 사이 문자열 종류의 갯수가 N보다 크면 문자열이 더 짤아져야 하기 때문에 left 포인터의 문자열을 하나씩 제거해주면서 오른쪽으로 한칸 이동시켜주고, 그때의 알파벳 변화와 종류의 수를 업데이트 해준다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		int[] check = new int[26];
		
		int left = 0;
		int right = 0;
		check[str.charAt(0) -'a'] = 1;
		
		int cnt = 1;
		int answer = 1;
		
		while (true) 
		{
			if (cnt <= N) 
			{
				answer = Math.max(answer,  right - left + 1);
				right += 1;
				if (right == str.length())
					break;
				if (check[str.charAt(right) - 'a'] == 0) 
				{
					cnt += 1;
				}
				check[str.charAt(right) - 'a'] += 1;
				
			} else 
			{
				check[str.charAt(left) - 'a'] -= 1;
				if (check[str.charAt(left) - 'a'] == 0) 
				{
					cnt -= 1;
				}
				left += 1;
			}
		}
		
		System.out.println(answer);
	}
}

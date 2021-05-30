//회문
//https://www.acmicpc.net/problem/17609
//힌트
//1. 문자열의 왼쪽끝과 오른쪽 끝에서부터 하나씩 비교하면서 회문인지 확인한다.
//2. 유사회문이 될 수 있으므로 서로 다른 문자를 비교하게 되면 왼쪽 포인터를 오른쪽으로 한칸 옮기고 마저 비교하거나,
// 오른쪽 포인터를 하나 건너띄고 비교하면 된다.
//3. 왼쪽에서 건너띌지 오른쪽에서 건너뛸지 알수 없기 때문에 각각 수행해준다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			String str = br.readLine();
			
			int N = str.length();
			
			int left = 0;
			int right = N-1;
			
			int cnt = 0;
			
			while (left <= right) {
				if (str.charAt(left) == str.charAt(right)) {
					left += 1;
					right -= 1;
				} else {
	                // 일치 하지 않는 문자가 나왔을때 왼쪽 포인터부터 한칸 건너 뛴다.					
					if (cnt == 1) {
						cnt = 2;
						break;
					}
					else {
						left += 1;
						cnt += 1;
					}
				}
			}
			if (cnt == 0) {
				System.out.println(0);
				continue;
			} else if (cnt == 1) {
				System.out.println(1);
				continue;
			}
			
	        // 왼쪽 포인터부터 건너뛰었을때 일반 문자열로 나온다면,
	        // 오른쪽 포인터부터 건너뛰었을때 유사회문이 될 수 있는지 추가로 비교해야한다.
	        left = 0;
	        right = N-1;
	        cnt = 0;
	        while (left < right)
	        {
	            if (str.charAt(left) == str.charAt(right))
	            {
	                left += 1;
	                right -= 1;
	            }
	            else
	            {
	                if (cnt == 1)
	                {
	                    cnt = 2;
	                    break;
	                }
	                else
	                {
	                    right -= 1;
	                    cnt += 1;
	                }
	            }
	        }
			if (cnt == 1) {
				System.out.println(1);
			} else { 
				System.out.println(2);
			}
		}
	}
}

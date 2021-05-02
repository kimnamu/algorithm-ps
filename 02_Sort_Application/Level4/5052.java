// 전화번호 목록
// https://www.acmicpc.net/problem/5052
// 힌트
// 1. 전화번호 목록을 문자열 형식으로 받아서 문자열 순서대로 정렬
// 2. 문자열 순서대로 정렬되어 있으므로 현재 번호와 다음 번호만 비교하면 가능
import java.io.*;
import java.util.Arrays;

public class Main {
	// 인접한 두 번호가 접두어로 시작하는지 확인하는 함수 
	static boolean solve(String[] numbers) {
		for (int i = 0 ; i < numbers.length - 1; i++) {
			if (numbers[i+1].startsWith(numbers[i])) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		while ( T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			
			// 전화번호를 문자열 형식으로 입력받아 저장
			String[] pNumbers = new String[N];
			for (int i = 0; i < N; i++) {
				pNumbers[i] = br.readLine();
			}
			
			// 오름차순으로 정렬
			Arrays.sort(pNumbers);
			
			if (solve(pNumbers)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}

//암호 만들기
//https://www.acmicpc.net/problem/1759
//힌트
//1. 문자를 순서대로 정렬한 후, dfs를 활용하여 완전탐색을 하며 만들어지는 문자열들 중
// 모음수, 자음수 조건을 만족하는 문자열을 순서대로 출력한다.
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static char[] alphas;
	static boolean[] visited;
	static int vowel = 0;
	static int consonant = 0;
	static int L;
	static int C;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		L = sc.nextInt();
		C = sc.nextInt();
		
		alphas = new char[C];
		visited = new boolean[C];
		
		sc.nextLine();
		
		String[] strs = sc.nextLine().split(" ");
		
		for (int i = 0; i < strs.length; i++) {
			alphas[i] = strs[i].charAt(0);
		}
		
		// 정렬된 문자열 출력을 위해 정렬함
		Arrays.sort(alphas);
		
		dfs(0, 0);
	}
	
	static void dfs(int index, int depth) {
		if (depth == L) {
			if (vowel >= 1 && consonant >=2) {
				for (int i = 0; i < C; i++) {
					if (visited[i]) {
						System.out.print(alphas[i]);
					}
				}
				System.out.println();				
			}
			
			return;
		}
		
		// 정렬된 문자열만 정답이 되므로, index부터 시작
		for (int i = index; i < C; i++) {
			if (!visited[i]) {
				
				visited[i] = true;
				if (isVowel(alphas[i])) {
					vowel += 1;
				} else {
					consonant += 1;
				}
				
				// dfs로 다음 위치의 문자 탐색
				dfs(i + 1, depth + 1);
				
				visited[i] = false;
				if (isVowel(alphas[i])) {
					vowel -= 1;
				} else {
					consonant -= 1;
				}
				
			}
		}
	}
	
	// 모음인지 판단
	static boolean isVowel(char ch) {
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ) {
        	return true;
        }
        return false;
	}
}

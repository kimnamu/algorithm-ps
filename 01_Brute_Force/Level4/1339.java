// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
import java.util.Scanner;
import java.util.Arrays;

public class Main {
	static String[] words;
	static int[] alpha = new int[26];
	static int result = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		words = new String[N];
		
		for(int i = 0; i < N; i++) {
			words[i] = sc.next();
		}
		
		solve();
		
		System.out.println(result);
	}
	
	// 각 알파벳 별로 다 합쳤을때 얼마나 기여하는지 계산
	static void solve() {
		
		for (int i = 0; i < words.length; i++) {
			int pow = 1;
			for (int j = words[i].length() - 1; j >= 0; j--) {
				int val = words[i].charAt(j) - 'A';
				alpha[val] += pow;
				pow *= 10;
			}
		}
		
		Arrays.sort(alpha);
		
	    // 기여도가 높은 순으로 9부터 대입시켜준 합을 구함.
		int num = 9;
		for (int i = 25; i >= 0; i--) {
			if (alpha[i] == 0) continue;
			result += (alpha[i] * num);
			num--;
		}
	}
}

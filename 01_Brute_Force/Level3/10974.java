import java.util.Scanner;
import java.util.Arrays;

// 모든 순열
// https://www.acmicpc.net/problem/10974
// 힌트
// 순열을 이용하여 Brute-Force로 푸는 문제. 
// Java에서는 C++, Python에서처럼 순열을 제공하는 함수가 없으므로 직접 코딩하여야함.
// 순열을 구하는 방법에는 여러 방식이 있는데 이 풀이에서는 C++에서처럼 next_permutation 함수 구현하여 사용

public class Main {
	static int[] A;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		A = new int[N];
		
		for (int i = 0; i < A.length; i++) {
			A[i] = i + 1;
		}
		
		// 아래 방식으로 순서대로 순열을 구하기 위해서는 오름차순으로 정렬 필요. 
		Arrays.sort(A); 
		
		do {
			for (int i = 0; i < A.length; i++) {
				System.out.print(A[i] + " ");
			}
			System.out.println();
		} while(next_permutation());
		
	}
	
	// 현재 순열보다 다음으로 큰 순열 구함
	static boolean next_permutation() {
		int i = A.length - 1;
		
		// 1. A[i-1] < A[i]를 만족하는 마지막 i를 찾기
		while(i > 0 && A[i-1] >= A[i]) {
			i--;
		}
		
		// i가 0이면 내림차순으로 list가 정렬되어 있으므로 더 이상 다음 순열이 존재 하지 않음.
		if (i <= 0) {
			return false;
		}
		
		int j = A.length - 1;
		
		// 2. A[i-1] 보다 큰 마지막 A[j]를 찾아 swap 해주기.
		// 1에서 i 이후에는 A[i-1] >= A[i] 만족하므로 실제적으로 A[i] 이후에 값 중 제일 작은 A[j] 값이 선택됨.
		while (A[i-1] >= A[j]) j--;
		swap(i-1, j);
		
		j = A.length - 1;
		
		// 3. i 부터 내림차순으로 정렬되어 있으니까 오름차순으로 변경.
		while(i < j) {
			swap(i, j);
			i++; j--;
		}
		
		return true;
	}
	
	static void swap(int n, int m) {
		int temp = A[n];
		A[n] = A[m];
		A[m] = temp;
	}
}

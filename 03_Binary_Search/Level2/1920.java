// 수 찾기
// https://www.acmicpc.net/problem/1920
// 힌트
// 1. m개의 숫자들을 n개의 숫자내에서 완전 탐색으로 찾게되면 복잡도가 o(nm)이 되므로 완전탐색을 하면 시간초과가 난다.
// 2. 정렬 후 binary search를 통해 정렬 하고나서는 o(log n)에 찾을 수 있다.
import java.io.*;
import java.util.*;

public class Main {
	static int N = 0;
	static int[] a;
	
	static boolean bs(int k) {
		
	    // l, r, m은 index 일뿐 실제 값을 a에서 찾아 비교해야 한다.
		int l = 0;
		int r = N - 1;
		
		if (a[l] > k || a[r] < k) {
			return false;
		}
		
		while (l <= r) {
	        int m = (l + r) / 2;
	        
	        if (a[m] == k)
	        {
	            return true;
	        }
	        else if (a[m] > k)
	        {
	            r = m - 1;
	        }
	        else
	        {
	            l = m + 1;
	        }
		}
		
		return false;
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		a = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a);
		
		int M = Integer.parseInt(br.readLine());
		int[] b = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			b[i] = Integer.parseInt(st.nextToken());
			if (bs(b[i])) {
				System.out.println("1");
			} else {
				System.out.println("0");				
			}
		}
	}
}

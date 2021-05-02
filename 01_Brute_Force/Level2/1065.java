//한수
//https://www.acmicpc.net/problem/1065
//# 힌트
//1. 1~99는 모두 한수
import java.util.Scanner;

public class Main {	
	
	// n의 자릿수를 반환
	static int getCipher(int n)
	{
	    int ret = 0;
	    while (n != 0)
	    {
	        ret = ret + 1;
	        n = n / 10;
	    }
	    return ret;
	}
	
	// 1. 한수인지 체크하는 function
	public static boolean func(int n)
	{
	    // 2. getCipher는 n의 자릿수를 반환
	    int k = getCipher(n);
	    // 3. 1~2자릿수는 모두 한수
	    if (k <= 2)
	        return true;
	    // 4. 1의 자릿수(small)과 10의 자릿수(big)을 통해 등차(diff)를 구함
	    int small = n % 10;
	    n = n / 10;
	    int big = n % 10;
	    int diff = big - small;
	    // 5. 나머지 수들이 같은 등차(diff)를 갖는지 체크
	    for (int i = 0; i < k - 2; i++)
	    {

	        small = big;
	        big = (n / 10) % 10;
	        if (diff != big - small)
	            return false;
	        n = n / 10;
	    }
	    return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N;
		N = sc.nextInt();
		
		int count = 0;
		for (int i = 1; i <= N; i++) {
			if (func(i))
				count = count + 1;
		}
	    
	    System.out.println(count);		
	}
}

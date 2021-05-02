//토너먼트
//https://www.acmicpc.net/problem/1057
import java.util.Scanner;

public class Main {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N, a, b;
		N = sc.nextInt();
		a = sc.nextInt();
		b = sc.nextInt();
		
	    // 1. a < b로 swap 해준다.
		if (a > b) {
			int temp = a;
			a = b;
			b = temp;
		}
		
		int answer = 1;
	    // 2. 토너먼트에서 지정된 두 사람이 만나기 위해서는, 번호가 낮은사람이 홀수, 번호가 큰사람이 그보다 1큰 짝수 일때 대결을 하게 된다.
	    while (true)
	    {
	        if (a % 2 == 1 && b - a == 1)
	        {
	            break;
	        }
	        a = (a + 1) / 2;
	        b = (b + 1) / 2;
	        answer += 1;
	    }

	    System.out.println(answer);		
	}
}

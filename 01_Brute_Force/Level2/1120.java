// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
//문자열
//https://www.acmicpc.net/problem/1120
//힌트
//1. A의 앞뒤에는 B에 맞출 수 있기 때문에, B부분 문자열 중에서 A문자열과 가장 적은 차이가 나는때를 찾아 비교하면 된다.
import java.util.Scanner;

public class Main {	
	
	static int distance(String a, String b) {
	    if (a.length() != b.length())
	        return -1;
	    int ret = 0;
	    for (int i = 0; i < a.length(); i++)
	    {
	        if (a.charAt(i) != b.charAt(i))
	            ret += 1;
	    }
	    return ret;
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String A, B;
		A = sc.next();
		B = sc.next();
		
		int answer = A.length();
		for (int i = 0; i + A.length() <= B.length(); i++) {
	        int diff = distance(A, B.substring(i, i + A.length()));
	        if (diff < answer)
	            answer = diff;
			
		}
	    
	    System.out.println(answer);		
	}
}

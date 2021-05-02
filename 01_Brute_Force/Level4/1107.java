//리모컨
//https://www.acmicpc.net/problem/1107
//힌트
//1. 리모컨으로 숫자를 먼저 고를때 0부터 누르는 경우는 카운팅하지 않도록 하자.
//2. 반례 (https://www.acmicpc.net/board/view/46120)
import java.util.Scanner;

public class Main {
	static boolean[] broken;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		broken = new boolean[10];
		
		for(int i = 0; i < M; i++) {
			int brokenNum = sc.nextInt();
			broken[brokenNum] = true;
		}
		
	    // +/-로 채널 변경했을때
		int answer = Math.abs(N - 100);
		
	    // 수동 채널 변경 후 +/- 채널 변경했을때
		answer = Math.min(answer, changeEntirely(N));
				
	    // 정답 출력
		System.out.println(answer);
	}
	
	static int changeEntirely(int m) {
		int result = 500000;
		
	    //1000000에서 - 버튼으로 찾아가는 경우를 고려하여.
		for (int i = 0; i < 1000000; i++) {
	        //해당 채널을 누를 수 있다면
			if (valid(i)) {
				int dist = count(i) + Math.abs(i-m);
				if (result > dist) {
					result = dist;
				}
			}
		}
		
		return result;
	}
	
	//누른 채널의 길이
	static int count(int num) {
		int cnt = 0;
		do {
			cnt++;
			num = num /10;			
		} while(num > 0);
		
		return cnt;
	}
	
	//해당 채널을 누르는 것이 가능한지 여부
	static boolean valid(int num) {
		do {
			if (broken[num%10] == true) {
				return false;
			}
			num = num /10;			
		} while(num > 0);
		
		return true;
	}
}

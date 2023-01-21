// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 가장 긴 증가하는 부분 수열
// https://www.acmicpc.net/problem/11053
// 힌트
// 1. Bottom up으로 왼쪽에서 오른쪽까지 번호 하나씩 순회하며 해당 번호까지 가장 긴 증가하는 부분 수열 개수를 입력해준다.
// 2. 다음 위치에서 해당 위치까지의 가장 긴 부분수열을 구하기 위해 이전 값을 모두 순회하며 해당 값보다 작을 경우,
//    최소 그 위치의 가장 긴 부분 수열 개수 + 1이 되도록 해준다.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		
		int[] A = new int[N];
		int[] cnts = new int[N];
		Arrays.fill(cnts, 1);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0 ; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
	    for (int i = 0; i < N; i++)
	    {
	        int cnt = 1;
	        for (int j = 0; j < i; j++)
	        {
	            if (A[j] < A[i])
	            {
	                cnt = Math.max(cnt, cnts[j] + 1);
	            }
	        }
	        cnts[i] = cnt;
	        answer = Math.max(answer, cnt);
	    }
	    
	    System.out.println(answer);
	}

}

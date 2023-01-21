// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
//용돈 관리
//https://www.acmicpc.net/problem/6236
//힌트
//1. 문제의 시뮬레이션이 정상 작동하는데 최소 인출 회수(cnt)를 구해서, 
// 그 최소 횟수가 m이하이면 가능한 경우로 보고 가능한 가장 작은 수를 구한다.
//2. 인출하는 비용을 binary search를 통해 찾는다. 
// 이때 최대 값은 인출을 한번만 해도 되는 모든 금액의 합으로 지정한다.

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] bank;
	static int bank_full = 0;
	
	static boolean solve(int k){
	    int amount = 0;
	    int cnt = 0;
	    for(int i = 0; i < N; i++){
	        if(amount < bank[i]){
	            amount = k;
	            cnt+=1;
	        }
	        amount -= bank[i];
	        // 인출해도 값을 지불하지 못하면 실패.
	        if(amount < 0) return false;
	    }
	    if(cnt <= M) return true;
	    else return false;
	}
	
	
	static int bs(){
	    int l = 0;
	    int r = bank_full;
	    int middle = -1;
	    while(l<=r){
	        middle = (l+r)/2;
	        if(solve(middle)){
	            r = middle-1;
	        }else{
	            l = middle+1;
	        }
	    }
	    return l;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		bank = new int[N];
		
		for (int i = 0; i < N; i ++) {
			bank[i] = Integer.parseInt(br.readLine().strip());
			bank_full += bank[i];
		}
		
		int answer = bs();
		
		System.out.println(answer);
		
	}
}

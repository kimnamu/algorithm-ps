// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 수 묶기
// https://www.acmicpc.net/problem/1744
// 힌트
// 1. 1보다 큰 경우, 1인 경우, 0보다 작거나 같은 경우 세가지로 분류한다.
// 2. 1보다 큰 경우는 큰 순서로 정렬하여 두개의 수를 곱해주면 된다.
// 3. 1인 경우는 해당 수를 더해 주면 된다.
// 4. 0보다 작은 경우는 절대값이 큰 순서대로 정렬하여 두개의 수를 곱해주면 된다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int answer = 0;
		
		ArrayList<Integer> posArr = new ArrayList<>();
		ArrayList<Integer> negArr = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			int currentVal = Integer.parseInt(br.readLine());
			
	        // 1보다 크면 posArr에 입력
			if (currentVal > 1) {
				posArr.add(currentVal);
		    // 1인 경우면 answer에 더해줌				
			} else if (currentVal == 1) {
				answer += 1;
		    // 0보다 같거나 작은 경우는 negArr에 입력
			} else {
				negArr.add(currentVal);
			}
		}
		
	    // posArr는 내림차순으로 정렬
		Collections.sort(posArr, Collections.reverseOrder());
	    // negArr는 오름차순으로 정렬		
		Collections.sort(negArr);
		
		if (posArr.size() > 1) {
			for (int i = 0; i < posArr.size() - 1; i += 2) {
				answer += posArr.get(i) * posArr.get(i + 1);
			}
		}
	    // 개수가 홀수개이면 1개가 남으므로 더해준다.		
		if (posArr.size() % 2 == 1) {
			answer += posArr.get(posArr.size() - 1);
		}
		
		if (negArr.size() > 1) {
			for (int i = 0; i < negArr.size() - 1; i += 2) {
				answer += negArr.get(i) * negArr.get(i + 1);
			}
		}
	    // 개수가 홀수개이면 1개가 남으므로 더해준다.		
		if (negArr.size() % 2 == 1) {
			answer += negArr.get(negArr.size() - 1);
		}
		
		System.out.println(answer);
		
	}
}

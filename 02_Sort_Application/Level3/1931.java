// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
//회의실 배정
//https://www.acmicpc.net/problem/1931
//힌트
//1. 끝나는 시간 순으로 정렬
//2. 끝나는 시간이 같으면 시작시간이 빠른 순으로 정렬
//3. 끝나는 순서가 빠른 순으로 예약하면서 예약 가능한 회의만 카운트 해줌.

import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

// 시작시간과 종료시간을 가진 class
class Conf implements Comparable<Conf> {
	public Conf(int startTime, int endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	int startTime;
	int endTime;
	
	@Override
	public int compareTo(Conf o) {
		if (this.endTime > o.endTime) {
			return 1;
		} else if (this.endTime == o.endTime) {
			if (this.startTime > o.startTime) {
				return 1;
			}
		}
		
		return -1;
	}
}

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		ArrayList<Conf> confArr = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			int startTime = sc.nextInt();
			int endTime = sc.nextInt();
			
			confArr.add(new Conf(startTime, endTime));
		}
		
		Collections.sort(confArr);
		
		int currentEndTime = 0;
		int answer = 0;
	    // 앞 회의와 겹치지 않는지 체크하면서 정답 수를 추가 해줌.		
		for (int i = 0; i < N; i++) {
			if (currentEndTime <= confArr.get(i).startTime) {
				currentEndTime = confArr.get(i).endTime;
				answer++;
			}
		}
		
		System.out.println(answer);
	}
}

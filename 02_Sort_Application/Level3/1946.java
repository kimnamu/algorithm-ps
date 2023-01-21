// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
//신입 사원
//https://www.acmicpc.net/problem/1946

import java.io.*;
import java.util.*;

class Member implements Comparable<Member>{
	public Member(int paperScore, int interviewScore) {
		this.paperScore = paperScore;
		this.interviewScore = interviewScore;
	}
	int paperScore;
	int interviewScore;
	
	@Override
	public int compareTo(Member o) {
		if (this.paperScore > o.paperScore) {
			return 1;
		} else if (this.paperScore == o.paperScore) {
			if (this.interviewScore > o.interviewScore) {
				return 1;
			}
		}
		
		return -1;
	}
}

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
		int T = Integer.parseInt(reader.readLine());
		
		while (T-- > 0) {
			int N = Integer.parseInt(reader.readLine());
			
			ArrayList<Member> memberArr = new ArrayList<>();
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(reader.readLine());
				int paperScore = Integer.parseInt(st.nextToken());
				int interviewScore = Integer.parseInt(st.nextToken());
				
				memberArr.add(new Member(paperScore, interviewScore));
			}
			
			Collections.sort(memberArr);
			
	        // 1. 서류면접 순위가 가장 높은 사람을 먼저 뽑고,
			int cis = memberArr.get(0).interviewScore;
			int answer = 1;
			for (int i = 1; i < N; i++) {
	            // 2. 이후 면접 순위가 앞의 통과자들의 면접 순위보다 높은 사람을 뽑으면서, 최소 면접 순위를 갱신함
				if (cis > memberArr.get(i).interviewScore) {
					cis = memberArr.get(i).interviewScore;
					answer++;
				}
			}
			
			System.out.println(answer);
		}
		
	}
}

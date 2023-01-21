// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 완전 이진 트리
// https://www.acmicpc.net/problem/9934
// 힌트
// 1. Input으로 들어오는 값들을 하나의 배열에 입력 받았을때, 가운데 값을 중심으로 왼쪽 오른쪽 트리가 만들어짐
// 2. 1의 방식이 재귀함수 방식으로 왼쪽 트리, 오른족 트리에서 동일하게 적용됨
// 3. 트리의 깊이에 따른 ArrayList를 선언하여 입력을 받아놓으면, 나중에 깊이에 따라 출력할 수 있음.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int[] v;
	static ArrayList<ArrayList<Integer>> answer;
	
	static void solve(int s, int e, int depth) {
		if (e - s == 1) {
			answer.get(depth).add(v[s]);
		} else {
			int m = (s + e - 1) / 2;
			answer.get(depth).add(v[m]);
			solve(s, m, depth + 1);
			solve(m + 1, e, depth + 1);
		}
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		
		int num = 1;
		for (int i = 0; i < k; i++) {
			num *= 2;
		}
		num -= 1;
		
		v = new int[num];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < num; i++) {
			v[i] = Integer.parseInt(st.nextToken());
		}
		
		answer = new ArrayList<>();
		for (int i = 0 ; i < k; i++) {
			answer.add(new ArrayList<Integer>());
		}
		
		solve(0, num, 0);
		
		for (int i = 0; i < k; i++) {
			for (int j =0; j < answer.get(i).size(); j++) {
				System.out.print(answer.get(i).get(j) + " ");
			}
			System.out.println();
		}
		
	}
}

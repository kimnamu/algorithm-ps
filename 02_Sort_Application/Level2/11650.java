// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 좌표 정렬하기
// https://www.acmicpc.net/problem/11650
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// x, y 좌표계 정보를 담는 class
class Point implements Comparable<Point>{
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	int x;
	int y;
	
	@Override
	public int compareTo(Point o) {
		// x 오름차순으로 정렬
		if (this.x > o.x) {
			return 1;
		} else if (this.x == o.x) { // x 값이 같으면
			// y 오름차순으로 정렬
			if (this.y > o.y) {
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
		ArrayList<Point> pointArr = new ArrayList<>();
		
		// 1. x와 y를 받아 point Class 생성 후 ArrayList에 순차적으로 입력
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			pointArr.add(new Point(x, y));
		}
		
		// 2. point Class에 정의된 compareTo 함수에 맞게 정렬
		Collections.sort(pointArr);
		
		for (int i = 0; i < N; i++) {
			System.out.println(pointArr.get(i).x + " " + pointArr.get(i).y);
		}
	}
}

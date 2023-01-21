// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
//일곱 난쟁이
//https://www.acmicpc.net/problem/2309
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {	
	// 두 명의 키를 제외하고 모두 더하기	
	static int solution(ArrayList<Integer> heights, int n1, int n2) {
	    int ret = 0;
	    for (int i = 0; i < heights.size(); i++)
	    {
	        if (i == n1 || i == n2)
	            continue;
	        ret += heights.get(i);
	    }
	    return ret;

	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Integer> heights = new ArrayList<Integer>();
		
		for (int i = 0; i < 9; i++) {
			heights.add(sc.nextInt());
		}
		
	    // 1. 9명 중 2명을 제외하는 모든 방법들을 탐색하며, 나머지 7명 키의 합이 100이 되는 때를 찾는다.
	    int n1 = 0, n2 = 0;
	    for (int i = 0; i < 9; i++)
	    {
	        for (int j = i + 1; j < 9; j++)
	        {
	            if (100 == solution(heights, i, j))
	            {
	                n1 = i;
	                n2 = j;
	            }
	        }
	    }
	    
	    // 3. n1 < n2이므로 n2, n1순으로 제거해 준다.
	    heights.remove(n2);
	    heights.remove(n1);

	    
	    // 4. 정렬 후 출력
	    Collections.sort(heights);
	    for (int i = 0; i < heights.size(); i++)
	    {
	    	System.out.println(heights.get(i));
	    }
	}
}

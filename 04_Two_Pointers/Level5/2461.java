//대표 선수
//https://www.acmicpc.net/problem/2461
//힌트
//1.각 반의 모든 선수들의 능력치를 하나의 배열에 담아 순서대로 나열 한다. 이때 각 선수들이 무슨반인지는 알 수 있도록 해야 한다.
//2.순서대로 나열된 선수들의 능력치를 투포인터를 이용하여 각 반의 선수가 최소 한명씩 포함되도록 하는 구간을 찾으면서
//왼쪽 포인터와 오른쪽 포인터에 위치한 선수들 간의 능력 차이가 최소가 되는 구간을 출력하면 된다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//age, name 정보를 가진 Customer Class
class Player implements Comparable<Player>{
	public Player(int score, int cls) {
		this.score = score;
		this.cls = cls;
	}
	int score;
	int cls;
	
	@Override
	public int compareTo(Player o) {
		// age 오름차순으로 정렬
		return this.score - o.score;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<Player> abilities = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int score = Integer.parseInt(st.nextToken());
				abilities.add(new Player(score, i));
			}
		}
		
		Collections.sort(abilities);
		
		int[] count = new int[N];
		
	    int left = 0;
	    int right = 0;
	    int cnt = 1;
	    
	    count[abilities.get(right).cls] += 1;
	    
	    int answer = abilities.get(abilities.size() - 1).score - abilities.get(0).score;
	    
	    while (true)
	    {
	        if (cnt == N)
	        {
	            answer = Math.min(answer, abilities.get(right).score - abilities.get(left).score);
	            count[abilities.get(left).cls] -= 1;
	            if (count[abilities.get(left).cls] == 0)
	                cnt -= 1;
	            left += 1;
	        }
	        else if (cnt < N)
	        {
	            right += 1;
	            
	            if (right == abilities.size())
	            	break;
	            
	            if (count[abilities.get(right).cls] == 0)
	                cnt += 1;
	            count[abilities.get(right).cls] += 1;
	        }
	    }
	    
	    System.out.println(answer);
	}
}

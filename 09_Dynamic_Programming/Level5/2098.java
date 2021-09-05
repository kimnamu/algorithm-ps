// 외판원 순회
// https://www.acmicpc.net/problem/2098
// 힌트
// 1. 순회시 최소 비용을 계산하는 것이므로 어떤 출발지점이든 상관이 없다. 즉, 시작점을 고정해두고 시작해도 괜찮다.
// 2. 현재 섬에 도달하기까지 방문한 섬들의 state를 저장해두어 memoization하여 다이나믹 프로그래밍으로 연산속도를 높인다.
//    이때, state는 비트마스크를 사용한다. 모든 섬을 방문했을때의 비트마스크 값은 1 << N -1이 된다.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int INF = 987654321;
	static int MAX = 16;
	static int N;
	static int[][] table = new int[MAX][MAX];
	static int[][] cost = new int[MAX][1 << MAX];
	
	static int solve(int pos, int state)
	{
	    if (state == (1 << N) - 1)
	    {
	        if (table[pos][0] == 0)
	            return INF;
	        else
	            return table[pos][0];
	    }

	    if (cost[pos][state] != 0)
	        return cost[pos][state];
	    
	    cost[pos][state] = INF;

	    for (int i = 0; i < N; i++)
	    {
	        if (table[pos][i] == 0)
	            continue;
	        if ((state & (1 << i)) == (1 << i))
	            continue;

	        cost[pos][state] = Math.min(cost[pos][state], table[pos][i] + solve(i, state | 1 << i));
	    }
	    
	    return cost[pos][state];
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				table[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
	    int answer = solve(0, 1);
	    
	    System.out.println(answer);

	}

}

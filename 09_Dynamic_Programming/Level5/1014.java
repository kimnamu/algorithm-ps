// 컨닝
// https://www.acmicpc.net/problem/1014
// 힌트
// 1. 다이나믹 프로그래밍을 이용하여 이전 행의 학생 배치에 따라 현재 행에서의 학생 배치값이 최대값인지 memoization해준다.
// 2. 상태에 대한 memoization은 최대 10개의 위치에 대해서 bitmask를 활용해준다.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static char[][] table = new char[12][12];
	static int[] curr = new int[11];
	static int[][] dp = new int[12][1 << 10];
	static ArrayList<String> combinations = new ArrayList<>();
	
	static void dfs(int index)
	{
	    if (index == M)
	    {
	        String str = "";
	        for (int i = M - 1; i >= 0; i--)
	        {
	            if (curr[i] > 0)
	                str += "1";
	            else
	                str += "0";
	        }
	        combinations.add(str);
	        return;
	    }
	    curr[index] = 0;
	    dfs(index + 1);
	    if ((index == 0) || (curr[index - 1] == 0))
	    {
	        curr[index] = 1;
	        dfs(index + 1);
	    }
	}
	
	static int solve(int line, int state)
	{
	    if (line == N)
	        return 0;

	    int ret = dp[line][state];
	    if (ret > 0)
	        return ret;
	    ret = 0;

	    for (String s : combinations)
	    {
	        int state_curr = 0;
	        boolean FLAG = true;
	        int cnt = 0;
	        
	        for (int i = 0; i < M; i++)
	        {
	            if (s.charAt(i) == '1')
	            {
	                cnt += 1;
	                if (table[line][i] == 'x')
	                {
	                    FLAG = false;
	                    break;
	                }
	                state_curr |= (1 << i);
	                if (i > 0 && (state & (1 << (i - 1)))>0)
	                {
	                    FLAG = false;
	                    break;
	                }
	                if (i < M && (state & (1 << (i + 1)))>0)
	                {
	                    FLAG = false;
	                    break;
	                }
	            }
	        }
	        if (FLAG)
	        {
	            ret = Math.max(ret, solve(line + 1, state_curr) + cnt);
	        }
	        dp[line][state] = ret;
	    }
	    return ret;
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int C = Integer.parseInt(br.readLine());
		
		while (C-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			combinations.clear();
			dfs(0);
			
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 1<<10; j++) {
					dp[i][j] = -1;
				}
			}
			
			for (int i = 0 ; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < M; j++) {
					table[i][j] = s.charAt(j);
				}
			}
			
			System.out.println(solve(0, 0));
		}
	}
}

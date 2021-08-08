// 숨바꼭질 3
// https://www.acmicpc.net/problem/13549
// 1. BFS를 이용하여 최단거리로 도달할 수 있는 방법을 찾는다.
// 2. 이때, 우선순위 Queue를 이용하여 2배 위치로 점프할 경우 가중치가 유지되어 먼저 search하도록 해준다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos{
	int pos;
	int answer;
	public Pos(int pos, int answer) {
		this.pos = pos;
		this.answer = answer;
	}
}

public class Main {
	static final int MAXNUM = 100000;
	
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int n = Integer.parseInt(st.nextToken());
    	int k = Integer.parseInt(st.nextToken());
    	
    	boolean[] visit = new boolean[MAXNUM + 1];
    	Queue<Pos> dq = new LinkedList<>();
    	
    	dq.add(new Pos(n, 0));
    	
        int ans = Integer.MAX_VALUE;

        while (!dq.isEmpty())
        {
            Pos curr = dq.poll();
            int pos = curr.pos;
            int answer = curr.answer;

            visit[pos] = true;

            if (pos == k)
            {
            	ans = Math.min(ans, answer);
            }

            int l = pos - 1;
            int r = pos + 1;
            int jump = pos * 2;

            if (jump <= MAXNUM && !visit[jump])
            {
                dq.add(new Pos(jump, answer));
            }
            if (r <= MAXNUM && !visit[r])
            {
                dq.add(new Pos(r, answer + 1));
            }
            if (l >= 0 && !visit[l])
            {
                dq.add(new Pos(l, answer + 1));
            }
        }
        
        System.out.println(ans);
        
	}
}

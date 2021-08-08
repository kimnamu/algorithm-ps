// 합리적인 이동경로
// https://www.acmicpc.net/problem/2176
// 힌트
// 1. T(=2)로부터 모든 지점의 최단 거리를 구하여, 정점 이동시 2에 가까워지는 합리적인 이동경로 인지 체크하는데 활용한다.
// 2. S(=1)에서 T(=2)까지 가는 모든 합리적인 이동경로를 dfs로 구할 시 시간 초과가 발생하므로 dynamic programming을 활용하여 중간 경로의 값을 저장해서 활용해준다.


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	static int[] dp;
	
	static class Pos implements Comparable<Pos>{
		int x;
		int y;
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(Pos o) {
			return this.y - o.y;
		}
		
	}
	
	static int[] dijkstra(int N, int start, ArrayList<ArrayList<Pos>> arr)
	{
		int[] dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		boolean[] check = new boolean[N + 1];
		PriorityQueue<Pos> q = new PriorityQueue<Pos>();
		
		q.add(new Pos(start, 0));
	    dist[start] = 0;

	    while (!q.isEmpty())
	    {
	    	Pos r = q.poll();
	        int here = r.x;
	        int cost = r.y;
	        
	        if (check[here]) continue;
	        check[here] = true;
	        
	        for (int i = 0; i < arr.get(here).size(); i++)
	        {
	            int next = arr.get(here).get(i).x;
	            int nextcost = arr.get(here).get(i).y;

	            if (check[next] == false && dist[next] > dist[here] + nextcost)
	            {
	                dist[next] = dist[here] + nextcost;
	        		q.add(new Pos(next, dist[next]));
	            }
	        }
	    }
	    return dist;
	}
	
	static int findPath(int here, int[] dist, ArrayList<ArrayList<Pos>> arr){
		
	    if(dp[here]!=-1){ 
	        return dp[here];
	    }
	    
	    if(here==2){
	        return 1;
	    }
	    
	    int ret = 0;
	    for(int i= 0 ; i< arr.get(here).size(); i++){
	        int next = arr.get(here).get(i).x;
	        if(dist[here] > dist[next]){
	            ret += findPath(next, dist, arr);
	        }
	    }
	    dp[here]= ret;
	    return ret;
	}



	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<ArrayList<Pos>> adj = new ArrayList<>();
		
		for (int i= 0; i < N + 1; i++) {
			adj.add(new ArrayList<>());
		}
		dp = new int[N + 1];
		Arrays.fill(dp, -1);
		
		
		for (int i = 0; i < M; i++) {
        	st  = new StringTokenizer(br.readLine());
        	
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
        	
            adj.get(a).add(new Pos(b, c));
            adj.get(b).add(new Pos(a, c));
		}
		int[] dist = dijkstra(N, 2, adj);
		int answer = findPath(1, dist, adj);
		
	    System.out.println(answer);

	}
}

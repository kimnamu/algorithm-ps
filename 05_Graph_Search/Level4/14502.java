// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
//연구소
//https://www.acmicpc.net/problem/14502
//힌트
//1. 벽의 위치 3곳을 완전 탐색을 통해 모든 경우를 위치 시킨다. N, M이 최대 8이므로 O(NM^3) 10만 단위의 복잡도까지 밖에 되지 않는다.
//2. 각 경우에 대해, 바이러스가 감염되어 퍼지게 한다.
//3. 바이러스가 퍼진 상태에서 멀쩡한 0의 위치를 counting한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] table;
	static int[][] infection;
	static int[] dx_array = {-1, 1, 0, 0};
	static int[] dy_array = {0, 0, -1, 1};
	
	static void spread(int i, int j){
	    for(int k = 0 ; k < 4; k++){
	        int dx = dx_array[k] + i;
	        int dy = dy_array[k] + j;
	        if(0<=dx && dx < N && 0<= dy && dy < M && infection[dx][dy]==0){
	            infection[dx][dy]=2;
	            spread(dx, dy);
	        }
	    }
	}

	static int dfs(int i, int j, int cnt){
	    for(int k = 0 ; k < 4; k++){
	        int dx = dx_array[k] + i;
	        int dy = dy_array[k] + j;
	        if(0<=dx && dx < N && 0<= dy && dy < M && infection[dx][dy]==0){
	            infection[dx][dy]=-1;
	            cnt += dfs(dx, dy, 1);
	        }
	    }
	    return cnt;
	}
	
	static int[][] deepCopy(int[][] map){
	    int[][] map2 = new int[N][M];
	    for(int i=0; i<N; i++){
	        for(int j=0; j<M; j++){
	            map2[i][j] = map[i][j];
	        }
	    }
	    return map2;
	}

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		table = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				table[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
	    int answer = 0;
	    
	    for(int k1 = 0 ; k1 < N*M; k1++){
	        int x1 = k1/M, y1 = k1%M;
	        if(table[x1][y1]!=0) continue;
	        
	        for(int k2 = k1+1 ; k2 < N*M; k2++){
	            int x2 = k2/M, y2 = k2%M;
	            if(table[x2][y2]!=0) continue;
	            
	            for(int k3 = k2+1 ; k3 < N*M; k3++){
	                int x3 = k3/M, y3 = k3%M;
	                if(table[x3][y3]!=0) continue;
	                
	                infection = deepCopy(table);
	                	                
	                // 3군데 벽 세우기
	                infection[x1][y1] = 1;
	                infection[x2][y2] = 1;
	                infection[x3][y3] = 1;
	                
	                // 바이러스 퍼뜨리기
	                for(int i = 0 ; i< N; i++){
	                    for(int j = 0 ; j< M; j++){
	                        if(infection[i][j]==2){
	                            spread(i, j);
	                        }
	                    }
	                }
	                
	                // 안전영역 계산
	                int cnt = 0;
	                for(int i = 0 ; i< N; i++){
	                    for(int j = 0 ; j< M; j++){
	                        if(infection[i][j]==0){
	                            infection[i][j] = -1;
	                            cnt += dfs(i, j, 1);
	                        }
	                    }
	                }
	                
	                answer = Math.max(answer, cnt);
	            }
	        }
	    }
	    
	    System.out.println(answer);
	}

}

// 연구소
// https://www.acmicpc.net/problem/14502
// 힌트
// 1. 벽의 위치 3곳을 완전 탐색을 통해 모든 경우를 위치 시킨다. N, M이 최대 8이므로 O(NM^3) 10만 단위의 복잡도까지 밖에 되지 않는다.
// 2. 각 경우에 대해, 바이러스가 감염되어 퍼지게 한다.
// 3. 바이러스가 퍼진 상태에서 멀쩡한 0의 위치를 counting한다.
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int N, M;
int dx_array[4] = {-1, 1, 0, 0};
int dy_array[4] = {0, 0, -1, 1};
vector<vector<int>> table;
vector<vector<int>> infection;

void spread(int i, int j){
    for(int k = 0 ; k < 4; k++){
        int dx = dx_array[k] + i;
        int dy = dy_array[k] + j;
        if(0<=dx && dx < N && 0<= dy && dy < M && infection[dx][dy]==0){
            infection[dx][dy]=2;
            spread(dx, dy);
        }
    }
}

int dfs(int i, int j, int cnt){
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


int main(){
    cin >> N >> M;
    table = vector<vector<int>>(N, vector<int>(M, 0));
    for(int i = 0 ; i < N; i++){
        for(int j = 0; j < M; j++){
            cin >> table[i][j];
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
                infection.assign(table.begin(), table.end());
                infection[x1][y1] = 1;
                infection[x2][y2] = 1;
                infection[x3][y3] = 1;
                for(int i = 0 ; i< N; i++){
                    for(int j = 0 ; j< M; j++){
                        if(infection[i][j]==2){
                            spread(i, j);
                        }
                    }
                }
                int cnt = 0;
                for(int i = 0 ; i< N; i++){
                    for(int j = 0 ; j< M; j++){
                        if(infection[i][j]==0){
                            infection[i][j] = -1;
                            cnt += dfs(i, j, 1);
                        }
                    }
                }
                answer = max(answer, cnt);
            }
        }
    }
    cout << answer << endl;
    return 0;
}
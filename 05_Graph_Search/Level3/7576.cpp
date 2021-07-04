// 토마토
// https://www.acmicpc.net/problem/7576
// 힌트
// 1. 처음에 익은 토마토를 queue에 넣어주어 상하좌우 방향으로 안익은 토마토를 익힌 토마토로 바꾸어 나가면 된다.
//    queue에 들어오는 값들이 처음 input 위치와 얼마만큼 떨어졌는지를 계산해 내야한다.
#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;

int M, N;
int dx_array[4] = {-1, 0, 1, 0};
int dy_array[4] = {0, -1, 0, 1};
vector<vector<int>> table;

struct Point{
    int x= 0;
    int y= 0;
};
queue<Point> q;

bool check(){
    for(int i = 0 ; i < N; i++){
        for(int j = 0  ; j< M; j++){
            if(table[i][j]==0)
                return false;
        }
    }
    return true;
}

int BFS(){
    int day = -1;
    while(q.size()){
        int size = q.size();
        for(int i = 0 ; i< size; i++){
            Point p = q.front(); q.pop();
            for(int j = 0 ;j < 4; j++){
                int dx = p.x+dx_array[j];
                int dy = p.y+dy_array[j];
                if(0<=dx && dx < N && 0<=dy && dy < M && table[dx][dy]==0){
                    table[dx][dy]= 1;
                    Point p_new = {dx, dy};
                    q.push(p_new);
                }
            }
        }
        day += 1;
    }
    return day;
}

int main(){
    cin >> M >> N;
    table = vector<vector<int>>(N, vector<int>(M, 0));
    for(int i = 0 ; i < N; i++){
        for(int j = 0  ; j< M; j++){
            cin >> table[i][j];
            if(table[i][j]==1){
                Point p= {i, j};
                q.push(p);
            }
        }
    }

    int answer = BFS();

    if(check()){
        cout << answer << endl;
    }else{
        cout << -1 << endl;
    }
    return 0;
}
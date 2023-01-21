// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 음식물 피하기
// https://www.acmicpc.net/problem/1743
// 힌트
// 1. 모든 위치를 탐색하다가 음식물이 발견되면 
//    해당 위치에서 상하좌우 위치로 DFS를 이용하여
//    음식물의 갯수를 모두 더해준다. 한번 카운팅했다면 0으로 만들어주어 다시 세지 않도록 한다.
#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;
int M, N, K;
int answer = 0;
vector<vector<int> > table;

int dfs(int i, int j, int cnt)
{
    table[i][j] = 0;
    if (i - 1 > 0 && table[i - 1][j] == 1)
        cnt += dfs(i - 1, j, 1);
    if (j - 1 > 0 && table[i][j - 1] == 1)
        cnt += dfs(i, j - 1, 1);
    if (i + 1 <= N && table[i + 1][j] == 1)
        cnt += dfs(i + 1, j, 1);
    if (j + 1 <= M && table[i][j + 1] == 1)
        cnt += dfs(i, j + 1, 1);
    return cnt;
}
int main()
{
    cin >> N >> M >> K;
    answer = 0;
    table = vector<vector<int> >(N + 1, vector<int>(M + 1, 0));
    for (int i = 0; i < K; i++)
    {
        int a, b;
        cin >> a >> b;
        table[a][b] = 1;
    }
    for (int i = 1; i <= N; i++)
    {
        for (int j = 1; j <= M; j++)
        {
            if (table[i][j] == 1)
            {
                answer = max(answer, dfs(i, j, 1));
            }
        }
    }
    cout << answer << endl;
    return 0;
}
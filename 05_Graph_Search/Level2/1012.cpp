// 유기농 배추
// https://www.acmicpc.net/problem/1012
// 힌트
// 1. 모든 위치를 탐색하다가 배추가 심어진 곳을 발견하면,
//    정답에 1을 추가하고, dfs를 활용하여 인접한 모든 위치의 배추값을 0으로 바꿔 준다.
//    이러면 인접한 배추에 대해서는 정답에 1만 기여하게 된다.
#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;
int T, M, N, K;
int answer = 0;
vector<vector<int> > table;

void dfs(int i, int j)
{
    table[i][j] = 0;
    if (i - 1 >= 0 && table[i - 1][j] == 1)
        dfs(i - 1, j);
    if (j - 1 >= 0 && table[i][j - 1] == 1)
        dfs(i, j - 1);
    if (i + 1 < N && table[i + 1][j] == 1)
        dfs(i + 1, j);
    if (j + 1 < M && table[i][j + 1] == 1)
        dfs(i, j + 1);
}
int main()
{
    cin >> T;
    while (T--)
    {
        cin >> N >> M >> K;
        answer = 0;
        table = vector<vector<int> >(N, vector<int>(M, 0));
        for (int i = 0; i < K; i++)
        {
            int a, b;
            cin >> a >> b;
            table[a][b] = 1;
        }
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < M; j++)
            {
                if (table[i][j] == 1)
                {
                    answer += 1;
                    dfs(i, j);
                }
            }
        }
        cout << answer << endl;
    }
    return 0;
}
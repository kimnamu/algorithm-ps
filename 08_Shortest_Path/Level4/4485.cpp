// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 녹색 옷 입은 애가 젤다지?
// https://www.acmicpc.net/problem/4485
// 1. bfs를 통해 0,0에서 상, 하, 좌, 우로 한칸씩 순회하며 순회하는 위치에서 최소비용으로 도달할 경우,
//    그 위치를 중심으로 다시 상, 하, 좌, 우를 순회하며 모든 지점의 최소 비용을 갱신한다.
// 2. 해당 위치에서 최소비용으로의 갱신이 일어나지 않으면 그 순회는 멈추도록 한다.
#include <iostream>
#include <vector>
#include <queue>
#include <memory.h>
#define MAX_N 125
#define INF 1e9
using namespace std;

typedef pair<int, int> pii;
typedef pair<pii, int> ppi;
int table[MAX_N][MAX_N];
vector<vector<int> > dp;
int dx[4] = {-1, 0, 1, 0};
int dy[4] = {0, 1, 0, -1};

int answer = 0;
void bfs(int N)
{
    queue<ppi> q;
    q.push({{0, 0}, 0});
    while (!q.empty())
    {
        int size = q.size();
        while (size--)
        {
            ppi e = q.front();
            q.pop();
            int i = e.first.first;
            int j = e.first.second;
            int cost = e.second;
            if (dp[i][j] > table[i][j] + cost)
            {
                dp[i][j] = table[i][j] + cost;
                for (int k = 0; k < 4; k++)
                {
                    int x = i + dx[k];
                    int y = j + dy[k];
                    if (x >= 0 && x < N && y >= 0 && y < N)
                    {
                        q.push({{x, y}, dp[i][j]});
                    }
                }
            }
        }
    }
    return;
}

int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    int N;
    int index = 0;
    while (true)
    {
        index += 1;
        cin >> N;
        if (N == 0)
            break;
        dp = vector<vector<int> >(N, vector<int>(N, INF));
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                cin >> table[i][j];
            }
        }
        bfs(N);
        cout << "Problem " << index << ": " << dp[N - 1][N - 1] << "\n";
    }
    return 0;
}
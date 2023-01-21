// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 자동차경주
// https://www.acmicpc.net/problem/2611
// 힌트
// 1. 문제 조건을 통해 경로 내 순환 사이클이 없다는 점을 확인하여 위상정렬을 이용하여 푼다.
#include <iostream>
#include <algorithm>
#include <vector>
#define MAXNUM 1001
using namespace std;

typedef pair<int, int> pii;
int main()
{
    int cnt, N, M;
    int p, q, r;
    vector<int> d(MAXNUM), pre(MAXNUM), depth(MAXNUM), cost(MAXNUM);
    vector<pii> adj[MAXNUM];
    cin >> N >> M;
    for (int i = 0; i < M; i++)
    {
        cin >> p >> q >> r;
        if (p == 1){
            d[q] = r;
            pre[q] = 1;
        }
        else
        {
            adj[p].push_back(pii(r, q));
            depth[q] += 1;
        }
    }
    for (int i = 1; i <= N; i++)
    {
        if (depth[i])
            continue;
        for (int j = 0; j < adj[i].size(); j++)
        {
            int nv = adj[i][j].first, nx = adj[i][j].second;
            if (d[nx] < d[i] + nv)
            {
                d[nx] = d[i] + nv;
                pre[nx] = i;
            }
            depth[nx] -= 1;
        }
        depth[i] = 1, i = -1;
    }
    cost[cnt++] = 1;
    while (pre[1] != 1)
    {
        cost[cnt++] = pre[1];
        pre[1] = pre[pre[1]];
    }

    cout << d[1] << "\n1 ";
    for (int i = cnt - 1; i >= 0; i--)
        cout << cost[i] << " ";

    return 0;
}
// 작업
// https://www.acmicpc.net/problem/2056
// 힌트
// 1. 전에 작업에 걸리는 시간을 위상정렬을 통해 구한다.
// - i번까지 작업을 완료하는데 걸리는 시간을 cost[i]라고 하고, 처음에 0으로 초기화 한다.
// - depth[i] == 0 인 정점들만 작업하는데 걸리는 시간으로 cost를 초기화 한다.
// - 위상정렬된 순서대로 정점들을 방문하면서 cost[next] = max(cost[next], cost[curr]+work[next])로 초기화해준다.
// - 위상정렬 후 cost[i]중 최대값을 출력한다.
#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;
#define MAXNUM 10001

int main()
{
    int N;
    vector<int> v(MAXNUM, 0);
    vector<int> depth(MAXNUM, 0);
    vector<int> cost(MAXNUM, 0);
    vector<int> adj[MAXNUM];

    queue<int> q;

    cin >> N;

    for (int i = 1; i <= N; i++)
    {
        int K, M;
        cin >> K >> M;
        v[i] = K;
        for (int j = 0, v; j < M; j++)
        {
            cin >> v;
            adj[v].push_back(i);
            depth[i] += 1;
        }
    }

    for (int i = 1; i <= N; i++)
        if (depth[i] == 0)
        {
            q.push(i);
            cost[i] = v[i];
        }

    while (!q.empty())
    {
        int curr = q.front();
        q.pop();

        for (int next : adj[curr])
        {
            cost[next] = max(cost[next], cost[curr] + v[next]);
            if (--depth[next] == 0)
                q.push(next);
        }
    }

    int answer = 0;
    for (int i = 1; i <= N; i++)
        answer = max(answer, cost[i]);

    cout << answer << '\n';
    return 0;
}
// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 최종 순위
// https://www.acmicpc.net/problem/3665
// 힌트
// 1. 위상정렬을 이용해 정렬 후 순위를 출력 한다.
#include <iostream>
#include <vector>
#include <queue>
#include <memory.h>
#define MAXNUM 501

using namespace std;
typedef pair<int, int> p;

int n, m, team[MAXNUM], order[MAXNUM];
int indegree[MAXNUM];
bool adj[MAXNUM][MAXNUM];
vector<int> answer;

int topologicalSort()
{
    queue<int> q;
    for (int i = 1; i <= n; i++)
    {
        if (indegree[i] == 0)
            q.push(i);
    }

    while (!q.empty())
    {
        if (q.size() > 1)
            return 0; //불확실한 순위
        int cur = q.front();
        q.pop();

        answer.push_back(team[cur]);
        if (answer.size() == n)
            return 1; //올바른 순위

        for (int i = 1; i <= n; i++)
        {
            if (!adj[cur][i])
                continue;
            adj[cur][i] = false;
            indegree[i]--;
            if (indegree[i] == 0)
                q.push(i);
        }
    }
    return -1; //순위를 정할 수 없음
}

void init()
{
    cin >> n;

    answer.clear();
    memset(team, 0, sizeof(team));
    memset(order, 0, sizeof(order));
    memset(adj, 0, sizeof(adj));
    memset(indegree, 0, sizeof(indegree));

    for (int i = 1; i <= n; i++)
    {
        cin >> team[i];
        order[team[i]] = i;
    }

    for (int i = 1; i < n; i++)
    {
        for (int j = i + 1; j <= n; j++)
        {
            adj[i][j] = true;
            indegree[j] += 1;
        }
    }
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(NULL);

    int tc, f, s;
    cin >> tc;
    for (int i = 0; i < tc; i++)
    {
        init();
        cin >> m;
        for (int j = 0; j < m; j++)
        {
            cin >> f >> s;
            if (order[f] > order[s])
                swap(f, s);
            int node_f = order[f], node_s = order[s];

            adj[node_f][node_s] = false;
            indegree[node_s]--;

            adj[node_s][node_f] = true;
            indegree[node_f] += 1;
        }
        int result = topologicalSort();
        if (result == -1)
            cout << "IMPOSSIBLE\n";
        else if (result == 0)
            cout << "?\n";
        else
        {
            for (int j = 0; j < answer.size(); j++)
                cout << answer[j] << " ";
            cout << "\n";
        }
    }

    return 0;
}

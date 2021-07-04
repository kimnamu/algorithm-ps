// 최단경로
// https://www.acmicpc.net/problem/1753
// 힌트
// 1. BFS알고리즘을 이용하면 메모리 초과가 발생한다.
// 2. Dijkstra알고리즘을 이용하여 시작점으로 각 노드에 대한 최단 거리를 구한다.
#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>    // priority_queue
#include <climits>  //INT_MAX

using namespace std;
typedef pair<int, int> pii;
int V, E, K, u, v, w;
vector<vector<pii>> table;
vector<int> dist;

void dijkstra(int start)
{
    priority_queue<pair<int, int> > q;

    q.push({0, start});
    dist[start] = 0;

    while (q.size())
    {
        int cost = -q.top().first;
        int here = q.top().second;

        q.pop();

        for (int i = 0; i < table[here].size(); i++)
        {
            int next = table[here][i].first;
            int nextcost = table[here][i].second;

            if (dist[next] > dist[here] + nextcost)
            {
                dist[next] = dist[here] + nextcost;
                q.push({-dist[next], next});
            }
        }
    }
}

int main()
{
    cin >> V >> E >> K;
    table = vector<vector<pii> >(V + 1);
    dist = vector<int>(V + 1, INT_MAX);
    for (int i = 0; i < E; i++)
    {
        cin >> u >> v >> w;
        table[u].push_back({v, w});
    }
    dijkstra(K);
    for (int i = 1; i <= V; i++)
    {
        if (dist[i] == INT_MAX)
        {
            cout << "INF ";
        }
        else
        {
            cout << dist[i] << " ";
        }
    }
    return 0;
}
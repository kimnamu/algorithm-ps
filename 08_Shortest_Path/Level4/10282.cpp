// 해킹
// https://www.acmicpc.net/problem/10282
// 1. 다익스트라 알고리즘을 활용하여 가장 처음 감염된 C로 부터 다른 노드까지의 최단거리를 구하면 된다.
#include <iostream>
#include <vector>
#include <queue>
#define INF 1e9

using namespace std;
typedef pair<int,int> pii;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    int T, N, D, C;
    cin >> T;
    while (T--)
    {
        cin >> N >> D >> C;
        vector<vector<pii > > adj(N + 1);
        vector<int> v(N + 1), dist(N + 1, INF);
        for (int i = 0; i < D; i++)
        {
            int a, b, c;
            cin >> a >> b >> c;
            adj[b].push_back({a, c});
            v[a]++;
        }
        priority_queue<pii > pq;
        dist[C] = 0;
        pq.push({C, 0});
        while (!pq.empty())
        {

            auto qt = pq.top();
            pq.pop();

            if (dist[qt.first] < -qt.second)
                continue;

            for (auto p : adj[qt.first])
            {
                int nxt = p.first, cost = p.second;
                if (dist[nxt] > dist[qt.first] + cost)
                {
                    dist[nxt] = dist[qt.first] + cost;
                    pq.push({nxt, dist[nxt]});
                }
            }
        }
        int cnt = 0, mx = 0;
        for (int i = 1; i <= N; i++)
        {
            if (dist[i] != INF)
            {
                cnt++;
                mx = max(mx, dist[i]);
            }
        }
        cout << cnt << " " << mx << "\n";
    }
}
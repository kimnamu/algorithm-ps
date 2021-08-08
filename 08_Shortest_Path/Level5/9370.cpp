// 미확인 도착지
// https://www.acmicpc.net/problem/9370
// 힌트
// 1. 다익스트라 알고리즘을 이용하여 S-G-H-Dst 혹은 S-H-G-Dst 경로의 최단 거리를 찾아주는 문제이다.
// 2. 위읭 각 구간별 최단 거리를 구해주고 마지막 Dst까지 최단경로가 되는 정점을 찾아주면 된다.
#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

#define MAXNUM 2010
#define INF 1e9
using namespace std;

int N, M, T, S, G, H, distGH;
int distS[MAXNUM];
int distG[MAXNUM];
int distH[MAXNUM];

vector<pair<int, int> > v[MAXNUM];
vector<int> dists;

void dijkstra(int from, int dist[MAXNUM])
{
    priority_queue<pair<int, int> > q;
    q.push(make_pair(0, from));
    dist[from] = 0;

    while (q.empty() == 0)
    {
        int cost = -q.top().first;
        int curr = q.top().second;
        q.pop();

        for (int i = 0; i < v[curr].size(); i++)
        {
            int next = v[curr][i].first;
            int cost_next = v[curr][i].second;

            if (dist[next] > cost + cost_next)
            {
                dist[next] = cost + cost_next;
                q.push(make_pair(-dist[next], next));
            }
        }
    }
}

void solve()
{
    dijkstra(S, distS);
    dijkstra(G, distG);
    distGH = distG[H];
    dijkstra(H, distH);
    sort(dists.begin(), dists.end());
    for (int i = 0; i < dists.size(); i++)
    {
        int dst = dists[i];
        if (distS[dst] == distS[G] + distGH + distH[dst])
            cout << dst << " ";
        else if (distS[dst] == distS[H] + distGH + distG[dst])
            cout << dst << " ";
    }
    cout << "\n";
}

int main(void)
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T;
    cin >> T;
    while (T--)
    {
        for (int i = 0; i < MAXNUM; i++)
        {
            v[i].clear();
            distS[i] = INF;
            distG[i] = INF;
            distH[i] = INF;
        }
        dists.clear();

        cin >> N >> M >> T;
        cin >> S >> G >> H;
        for (int i = 0; i < M; i++)
        {
            int a, b, c;
            cin >> a >> b >> c;
            v[a].push_back(make_pair(b, c));
            v[b].push_back(make_pair(a, c));
        }
        for (int i = 0; i < T; i++)
        {
            int a;
            cin >> a;
            dists.push_back(a);
        }

        solve();
    }

    return 0;
}

// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 최소비용 구하기
// https://www.acmicpc.net/problem/1916
// 힌트
// 1. 각 구간 별 단방향으로 주어진 가격임을 주의해야한다.
// 2. 다익스트라 알고리즘을 이용하여 최단 거리를 구하되,
//    주의할 점은 같은 구간에 대해 서로 다른 요금이 주어질 수 있어 최소 요금을 찾고 알고리즘을 적용해야한다.
#include <iostream>
#include <vector>
#include <queue>
#include <map>
#define INF 1e9
using namespace std;

vector<int> dijkstra(int N, int X, vector<pair<int, int> > arr[])
{
    vector<int> dist(N + 1, INF);
    priority_queue<pair<int, int> > q;

    q.push({0, X});
    dist[X] = 0;

    while (!q.empty())
    {
        int cost = -q.top().first;
        int here = q.top().second;

        q.pop();

        for (int i = 0; i < arr[here].size(); i++)
        {
            int next = arr[here][i].first;
            int nextcost = arr[here][i].second;

            if (dist[next] > dist[here] + nextcost)
            {
                dist[next] = dist[here] + nextcost;
                q.push({-dist[next], next});
            }
        }
    }
    return dist;
}

int main()
{
    cin.tie(NULL);
    ios::sync_with_stdio(false);
    int N, M;
    cin >> N >> M;
    vector<pair<int, int> > arr[N + 1];
    map<pair<int, int>, int> m;
    for (int i = 0; i < M; i++)
    {
        int from, to, val;
        cin >> from >> to >> val;
        pair<int, int> pii = make_pair(from, to);
        if (m.find(pii) == m.end())
        {
            m[pii] = val;
        }
        else
        {
            m[pii] = min(m[pii], val);
        }
    }

    for (auto k : m)
    {
        arr[k.first.first].push_back({k.first.second, k.second});
    }
    int A, B;
    cin >> A >> B;
    vector<int> dist = dijkstra(N, A, arr);
    cout << dist[B] << endl;

    return 0;
}
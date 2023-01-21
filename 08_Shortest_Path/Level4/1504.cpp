// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 특정한 최단 경로
// https://www.acmicpc.net/problem/1504
// 1. 다익스트라 알고리즘을 이용하여 v1과 v2로 부터 모든 지점에 대한 최단 거리를 구한다.
// 2. 두 최단거리 배열을 이용하여 1->v1->v2->N 과 1->v2->v1->N 거리 중 더 짧은 거리 거리를 반환한다.
// 3. 이때 하나의 구간이라도 연결이 되어있지 않다면 -1을 반환한다.
#include <iostream>
#include <vector>
#include <queue>
#define INF 1e9
using namespace std;

vector<int> dijkstra(int N, int start, vector<pair<int, int> > arr[])
{
    vector<int> dist(N + 1, INF);
    priority_queue<pair<int, int> > q;

    q.push({0, start});
    dist[start] = 0;

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
    int N, M;
    cin >> N >> M;
    vector<pair<int, int> > arr[N + 1];
    for (int i = 0; i < M; i++)
    {
        int from, to, val;
        cin >> from >> to >> val;
        arr[from].push_back({to, val});
        arr[to].push_back({from, val});
    }
    int v1, v2;
    cin >> v1 >> v2;
    vector<int> dist1 = dijkstra(N, v1, arr);
    vector<int> dist2 = dijkstra(N, v2, arr);
    int dist_v12 = dist1[v2];
    int answer = -1;
    if (dist1[1] != INF && dist_v12 != INF && dist2[1] != INF)
    {
        answer = dist_v12 + min(dist1[1] + dist2[N], dist1[N] + dist2[1]);
    }
    cout << answer << endl;
    return 0;
}
// 파티
// https://www.acmicpc.net/problem/1238
// 1. 다익스트라 알고리즘을 이용하여 모든 지점에서 X까지 가는 길의 최소 시간을 계산해준다.
// 2. 다익스트라 알고리즘을 이용하여 X지점에서 모든 지점까지 가는 길의 최소 시간을 계산해준다.
// 3. 모든 지점에서 X지점까지의 왕복 거리 합이 가장 큰 값을 반환해준다.
#include <iostream>
#include <vector>
#include <queue>
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
    int N, M, X;
    cin >> N >> M >> X;
    vector<pair<int, int> > arr[N + 1];
    for (int i = 0; i < M; i++)
    {
        int from, to, val;
        cin >> from >> to >> val;
        arr[from].push_back({to, val});
    }
    vector<int> dist1 = dijkstra(N, X, arr);
    int answer = 0;
    for (int i = 1; i < N + 1; i++)
    {
        vector<int> dist2 = dijkstra(N, i, arr);
        answer = max(answer, dist1[i] + dist2[X]);
    }
    cout << answer << endl;
    return 0;
}
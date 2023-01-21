// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// K번째 최단경로 찾기
// https://www.acmicpc.net/problem/1854
// 1. 다익스트라 알고리즘의 원리에 탑승해, 각 지점 별 경로의 길이를 저장하여 해당 지점의 K번째 최단 경로를 찾는다.
// 2. 각 지점 별 도달 경로의 길이를 우선순위 큐를 이용하여 누적시키고, 그 개수가 K개보다 많아지면 가장 긴 경로와의 값을 비교하여 K번째 값만 갱신해 준다.
#include <iostream>
#include <vector>
#include <queue>
#define INF 1e9
using namespace std;

priority_queue<int> answer[1010];

void dijkstra(int N, int X, int K, vector<pair<int, int> > arr[])
{
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>  > q;

    q.push({0, X});
    answer[1].push(0);
    while (!q.empty())
    {
        int cost = q.top().first;
        int here = q.top().second;

        q.pop();

        for (int i = 0; i < arr[here].size(); i++)
        {
            int next = arr[here][i].first;
            int nextcost = arr[here][i].second + cost;

            if(answer[next].size() < K){
                answer[next].push(nextcost);
                q.push({nextcost, next});
            }else if(answer[next].top() > nextcost){
                answer[next].pop();
                answer[next].push(nextcost);
                q.push({nextcost, next});
            }
        }
    }
}

int main()
{

    cin.tie(NULL);
    ios_base::sync_with_stdio(false);
    int N, M, K;
    cin >> N >> M >> K;
    vector<pair<int, int> > arr[N + 1];
    for (int i = 0; i < M; i++)
    {
        int from, to, val;
        cin >> from >> to >> val;
        arr[from].push_back({to, val});
    }
    dijkstra(N, 1, K, arr);

    for(int i = 1 ; i<= N; i++){
        if(answer[i].size()<K) cout << -1 << "\n";
        else cout << answer[i].top() << "\n";
    }
    return 0;
}
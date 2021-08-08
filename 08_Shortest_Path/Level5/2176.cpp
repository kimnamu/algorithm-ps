// 합리적인 이동경로
// https://www.acmicpc.net/problem/2176
// 힌트
// 1. T(=2)로부터 모든 지점의 최단 거리를 구하여, 정점 이동시 2에 가까워지는 합리적인 이동경로 인지 체크하는데 활용한다.
// 2. S(=1)에서 T(=2)까지 가는 모든 합리적인 이동경로를 dfs로 구할 시 시간 초과가 발생하므로 dynamic programming을 활용하여 중간 경로의 값을 저장해서 활용해준다.
#include <iostream>
#include <vector>
#include <queue>
#define INF 1e9
using namespace std;

vector<int> dist;
vector<int> dp;

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

int findPath(int here, vector<pair<int, int> > arr[]){
    if(dp[here]!=-1){
        return dp[here];
    }
    if(here==2){
        return 1;
    }
    int ret = 0;
    for(int i= 0 ; i< arr[here].size(); i++){
        int next = arr[here][i].first;
        if(dist[here] > dist[next]){
            ret += findPath(next, arr);
        }
    }
    dp[here]= ret;
    return ret;
}


int main()
{
    int N, M;
    cin >> N >> M;
    vector<pair<int, int> > arr[N + 1];
    dp = vector<int>(N+1, -1);
    for (int i = 0; i < M; i++)
    {
        int from, to, val;
        cin >> from >> to >> val;
        arr[from].push_back({to, val});
        arr[to].push_back({from, val});
    }
    dist = dijkstra(N, 2, arr);
    int answer = findPath(1, arr);

    cout << answer << "\n";
    return 0;
}
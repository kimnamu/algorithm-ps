// LCA 2
// https://www.acmicpc.net/problem/11438
// 힌트
// 1. 공통 조상을 상위 노드 하나씩 비교를 하다보면 시간 안에 통과할 수가 없다. 복잡도 O(NxM)이기 때문이다.
// 2. LCA (11437문제)와의 차이는 조상을 찾는 검색 복잡도를 log로 줄여주기 위해, 높이를 맞춰주는 과정에서 2의 n승씩 점프를 해가면서 부모값을 찾아 비교한다.
//    이를 위해 2의 n승의 부모 노드를 미리 저장해 놓는다.
// * cpp의 경우 ios_base::sync_with_stdio(false); cin.tie(NULL);을 해주지 않으면 시간 초과 발생.
#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;

int N, M;
int u, v;
queue<int> q;
vector<int> node[100001];
vector<bool> check(100001);
vector<int> depth(100001);
int parent[100001][20];

int LCA(int u, int v)
{
    if (depth[u] > depth[v])
        swap(u, v);

    // 두 노드의 깊이가 같아질때까지 v노드는 위로 거슬러 올라감
    while (depth[u] != depth[v])
    {
        // 두 노드의 깊이 차이
        int dist = depth[v] - depth[u];

        for (int i = 0; i < 20; i++)
        {
            if (dist <= (2 << i))
            {
                // 2^i 만큼 거슬러 오라감
                v = parent[v][i];
                break;
            }
        }
    }
    while (u != v)
    {
        for (int i = 0; i < 20; i++)
        {
            if (parent[u][i + 1] == parent[v][i + 1])
            {
                u = parent[u][i];
                v = parent[v][i];
                break;
            }
        }
    }
    return u;
}

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> N;
    for (int i = 0; i < N - 1; i++)
    {
        cin >> u >> v;
        node[u].push_back(v);
        node[v].push_back(u);
    }

    check[1] = true;
    q.push(1);

    while (!q.empty())
    {
        int x = q.front();
        q.pop();
        for (int i = 0; i < node[x].size(); i++)
        {
            int child = node[x][i];
            if (!check[child])
            {
                depth[child] = depth[x] + 1;
                check[child] = true;
                parent[child][0] = x;
                for (int j = 0; j < 20; j++)
                {
                    parent[child][j + 1] = parent[parent[child][j]][j];
                    // 2^(j+1) 위에 부모노드가 없을 경우
                    if (parent[child][j + 1] == 0)
                        break;
                }
                q.push(child);
            }
        }
    }
    cin >> M;
    for (int i = 0; i < M; i++)
    {
        cin >> u >> v;
        cout << LCA(u, v) << '\n';
    }
}
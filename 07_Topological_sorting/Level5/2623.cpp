// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 음악프로그램
// https://www.acmicpc.net/problem/2623
// 힌트
// 1.  PD들 서로의 목록에 싸이클이 있는 경우 모든 PD들의 요구사항을 만족할 수 없으니 위상정렬을 하면서 사이클 존재 여부 또한 검사해야한다.
// 2.  맨 마지막 노드인 리프를 제일 끝에 두는 방법이 일반적인 위상 정렬의 방법이다.
//     leaf 노드들을 결과를 저장할 배열의 끝에 넣고, 트리에 제외하면서 다음 리프노드를 찾는것을 반복하면 결국 배열에는 위상 정렬된 트리를 얻을 수 있다.
#include <iostream>
#include <vector>
#include <queue>
#include <cstring>
#include <algorithm>
#include <stack>

using namespace std;

vector<vector<bool> > adj;
vector<bool> visited;
vector<int> v;

bool dfs(const int &k)
{
    visited[k] = true;
    for (int i = 0; i < adj[k].size(); i++)
    {
        if (adj[k][i] == false)
            continue;
        if (visited[i])
        {
            if (find(v.begin(), v.end(), i) == v.end())
                return false;
        }
        else
        {
            if (!dfs(i))
                return false;
        }
    }
    v.push_back(k);
    return true;
}

int main()
{
    int N, M;
    cin >> N >> M;
    adj = vector<vector<bool> >(N, vector<bool>(N, false));
    visited = vector<bool>(N, false);
    for (int i = 0; i < M; i++)
    {
        int t;
        cin >> t;
        int a, b;
        for (int j = 0; j < t; j++)
        {
            cin >> a;
            a -= 1;
            if (j != 0)
            {
                adj[b][a] = true;
            }
            b = a;
        }
    }

    for (int i = 0; i < N; i++)
    {
        if (!visited[i] && !dfs(i))
        {
            cout << 0;
            return 0;
        }
    }
    for (int i = N - 1; i >= 0; i--)
        cout << v[i] + 1 << "\n";

    return 0;
}

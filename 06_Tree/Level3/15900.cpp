// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 나무 탈출
// https://www.acmicpc.net/problem/15900
// 힌트
// 1. 성원이는 먼저 시작하기 때문에 홀수 번째 턴이다. 때문에 짝수 번째 턴에 모든 말이 사라지면 성원이가 지가 된다.
// 2. root의 깊이를 0으로 잡았을때, 모든 리프노드의 깊이의 합이 홀수이면 성원이가 이기게 된다.
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

vector<vector<int> > tree;
vector<bool> visited;

int total_depth = 0;
void dfs(int node, int depth)
{
    bool flag = true;
    int size = tree[node].size();
    for (int i = 0; i < size; i++)
    {
        int node_c = tree[node][i];
        if (visited[node_c])
            continue;
        visited[node_c] = true;
        flag = false;
        dfs(node_c, depth + 1);
    }
    if (flag)
    {
        total_depth += depth % 2;
    }
}

int main()
{
    int N;
    cin >> N;
    tree = vector<vector<int> >(N + 1, vector<int>(0));
    visited = vector<bool>(N + 1, false);
    for (int i = 0; i < N - 1; i++)
    {
        int a, b;
        cin >> a >> b;
        tree[a].push_back(b);
        tree[b].push_back(a);
    }
    visited[1] = true;
    dfs(1, 0);
    if (total_depth % 2 == 0)
    {
        cout << "No" << endl;
    }
    else
    {
        cout << "Yes" << endl;
    }

    return 0;
}
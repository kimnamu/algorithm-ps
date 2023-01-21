// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// DFS와 BFS
// https://www.acmicpc.net/problem/1260
// 힌트
// 1. DFS와 BFS를 기본적으로 구현할 수 있는지를 확인하는 문제이다.
// 2. 만약 문제를 풀 수 없다면, 이론 공부를 좀 더 할 필요가 있다.
#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;
int N, M, V;
vector<vector<bool> > table;
vector<bool> check;

void DFS(int k)
{
    if (check[k])
    {
        cout << k << " ";
        check[k] = false;
    }
    for (int i = 1; i <= N; i++)
    {
        if (table[k][i] && check[i])
        {
            DFS(i);
        }
    }
}

void BFS(int k)
{
    queue<int> q;
    cout << k << " ";
    q.push(k);
    check[k] = false;
    while (q.size())
    {
        int size = q.size();
        int num = q.front();
        q.pop();
        for (int i = 1; i <= N; i++)
        {
            if (table[num][i] && check[i])
            {
                cout << i << " ";
                q.push(i);
                check[i] = false;
            }
        }
    }
}

int main()
{
    cin >> N >> M >> V;
    table = vector<vector<bool> >(N + 1, vector<bool>(N + 1, false));
    for (int i = 0; i < M; i++)
    {
        int a, b;
        cin >> a >> b;
        table[a][b] = true;
        table[b][a] = true;
    }
    // DFS
    check = vector<bool>(N + 1, true);
    DFS(V);
    cout << endl;
    // BFS
    check = vector<bool>(N + 1, true);
    BFS(V);
    cout << endl;
    return 0;
}
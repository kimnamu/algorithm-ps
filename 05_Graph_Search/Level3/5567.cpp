// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 결혼식
// https://www.acmicpc.net/problem/5567
// 힌트
// 1. BFS를 이용하여 깊이 2까지의 모든 노드의 개수를 파악한다.
#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;

int n, m, a, b;
vector<vector<bool> > table;
vector<bool> check;
int BFS(int start, int limit)
{
    int answer = 0;
    queue<int> q;
    q.push(start);
    while (q.size() && limit >= 0)
    {
        int size = q.size();
        for (int i = 0; i < size; i++)
        {
            int curr = q.front();
            q.pop();
            if (check[curr])
            {
                answer += 1;
                check[curr] = false;
                for (int j = 1; j <= n; j++)
                {
                    if (table[curr][j] && check[j])
                    {
                        q.push(j);
                    }
                }
            }
        }
        limit -= 1;
    }
    // 상근이 자기자신 한명 빼주기
    return answer - 1;
}

int main()
{
    cin >> n >> m;
    table = vector<vector<bool> >(n + 1, vector<bool>(n + 1, false));
    check = vector<bool>(n + 1, true);
    for (int i = 0; i < m; i++)
    {
        cin >> a >> b;
        table[a][b] = true;
        table[b][a] = true;
    }
    int answer = BFS(1, 2);
    cout << answer << endl;
    return 0;
}
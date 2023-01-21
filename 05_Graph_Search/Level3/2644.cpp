// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 촌수계산
// https://www.acmicpc.net/problem/2644
// 힌트
// 1. 부모-자식, 자식-부모 와같이 특별히 순서는 상관 없다.
// 2. DFS를 통해 목표로 하는 노드를 찾는데 걸리는 스텝이 촌수계산의 답이 됩니다.
#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;

int n, m, x, y;
int a, b;

vector<vector<bool> > table;

int BFS(int a)
{
    vector<bool> check(n + 1, true);
    queue<int> q;
    q.push(a);
    int answer = 0;
    while (q.size())
    {
        int size = q.size();
        for (int i = 0; i < size; i++)
        {
            int curr = q.front();
            q.pop();
            if (curr == b)
                return answer;
            if (check[curr])
            {
                check[curr] = false;
                for (int j = 1; j < n + 1; j++)
                {
                    if (table[curr][j] && check[j])
                    {
                        q.push(j);
                    }
                }
            }
        }
        answer += 1;
    }
    return -1;
}

int main()
{
    cin >> n;
    cin >> a >> b;
    cin >> m;
    table = vector<vector<bool> >(n + 1, vector<bool>(n + 1, false));
    for (int i = 0; i < m; i++)
    {
        cin >> x >> y;
        table[x][y] = true;
        table[y][x] = true;
    }
    int answer = BFS(a);
    cout << answer << endl;
    return 0;
}
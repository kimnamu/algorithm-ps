// 게임 개발
// https://www.acmicpc.net/problem/1516
// 힌트
// 1. node간의 인과관계가 있기 때문에 위상정렬을 이용하여 풀 수 있다.
#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
#define MAXNUM 501
using namespace std;

int n, m, a, b, c;
vector<int> v[MAXNUM], depth(MAXNUM), value(MAXNUM), cost(MAXNUM);

void topologicalSort()
{
    queue<int> q;
    for (int i = 1; i <= n; i++)
    {
        if (depth[i] == 0)
        {
            q.push(i);
            cost[i] = value[i];
        }
    }
    for (int i = 1; i <= n; i++)
    {
        int x = q.front();
        q.pop();
        for (int j = 0; j < v[x].size(); j++)
        {
            int y = v[x][j];
            cost[y] = max(cost[y], value[y] + cost[x]);
            depth[y] -= 1;
            if (depth[y] == 0)
            {
                q.push(y);
            }
        }
    }
}

int main()
{
    cin >> n;
    for (int i = 1; i <= n; i++)
    {
        cin >> value[i];
        while (true)
        {
            int x;
            cin >> x;
            if (x == -1)
                break;
            v[x].push_back(i);
            depth[i] += 1;
        }
    }
    topologicalSort();
    for (int i = 1; i <= n; i++)
        cout << cost[i] << "\n";
    return 0;
}
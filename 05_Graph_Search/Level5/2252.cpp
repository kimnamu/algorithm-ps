// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 줄 세우기
// https://www.acmicpc.net/problem/2252
// 힌트
// 1. 위상정렬을 이용한다.
// 2. 각 순서를 갇는 노드에 대해 뒤에 오는 노드에 대해 앞에 와야만 하는 이전 노드의 수를 counting해 둔다.
// 3. 앞에 와야만 하는 노드의 수가 0인 노드들을 순서대로 출력하면서, 연결된 노드들의 이전 노드의 수를 갱신해 준다.
#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>
using namespace std;

const int max_size = 32000;
int in_cnt[max_size + 1];
vector<int> v[max_size + 1];

int main()
{
    int n, m, a, b;
    cin >> n >> m;
    for (int i = 0; i < m; i++)
    {
        cin >> a >> b;
        in_cnt[b] += 1;
        v[a].push_back(b);
    }

    queue<int> q;
    for (int i = 1; i <= n; i++)
    {
        if (in_cnt[i] == 0)
        {
            q.push(i);
        }
    }

    while (!q.empty())
    {
        int i = q.front();
        q.pop();
        cout << i << endl;

        for (int j = 0; j < v[i].size(); j++)
        {
            in_cnt[v[i][j]] -= 1;
            if (in_cnt[v[i][j]] == 0)
            {
                q.push(v[i][j]);
            }
        }
    }
}
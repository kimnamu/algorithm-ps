// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 바이러스
// https://www.acmicpc.net/problem/2606
// 1. DFS를 활용하여 1번 바이러스와 이어져있는 컴퓨터를 모두 찾으며 counting한다.
//    이때, 한번 방문한 컴퓨터는 재방문 할 필요가 없으므로 check배열을 통해 이미 한번 방문한 곳은 재방문하지 않도록 해준다.
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
int n, m;
vector<vector<bool> > table;
vector<bool> check;
int answer = 0;
void DFS(int k)
{
    if (check[k])
    {
        answer += 1;
        check[k] = false;
    }
    for (int i = 1; i <= n; i++)
    {
        if (table[k][i] && check[i])
        {
            DFS(i);
        }
    }
}

int main()
{
    cin >> n >> m;
    table = vector<vector<bool> >(n + 1, vector<bool>(n + 1, false));
    check = vector<bool>(n + 1, true);
    for (int i = 0; i < m; i++)
    {
        int a, b;
        cin >> a >> b;
        table[a][b] = true;
        table[b][a] = true;
    }
    DFS(1);
    cout << answer - 1 << endl;
    return 0;
}
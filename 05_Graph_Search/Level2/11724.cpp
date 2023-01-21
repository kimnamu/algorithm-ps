// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 연결 요소의 개수
// https://www.acmicpc.net/problem/11724
// 힌트
// 1. DFS를 활용하여 1~N까지의 연결 요소를 탐색하며, 염결된 정점이 있으면 방문하도록 하자.
// 2. 이때 한번 방문한 정점을 반복해서 방문하지 않도록 check 배열을 이용해 준다.
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
int N, M;
vector<vector<bool> > table;
vector<bool> check;
int answer = 0;
void DFS(int k)
{
    if (check[k])
    {
        check[k] = false;
    }
    else
    {
        return;
    }
    for (int i = 1; i <= N; i++)
    {
        if (table[k][i] && check[i])
        {
            DFS(i);
        }
    }
}

int main()
{
    cin >> N >> M;
    table = vector<vector<bool> >(N + 1, vector<bool>(N + 1, false));
    check = vector<bool>(N + 1, true);
    for (int i = 0; i < M; i++)
    {
        int a, b;
        cin >> a >> b;
        table[a][b] = true;
        table[b][a] = true;
    }
    for (int i = 1; i <= N; i++)
    {
        if (check[i])
        {
            answer += 1;
            DFS(i);
        }
    }
    cout << answer << endl;
    return 0;
}
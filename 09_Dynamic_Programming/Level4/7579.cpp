// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 앱
// https://www.acmicpc.net/problem/7579
// 힌트
// 1. Memoization을 통해 첫 번째 부터 n번째까지의 비용에 따른 최소 메모리사용 값을 갱신해준다.
// 2. 이때 메모리를 사용할지 사용하지 않을지에 따라 다음 번째의 비용과 메모리값을 다르게 넣어준다.
#include <iostream>
#include <algorithm>
#include <vector>
#include <string.h>
using namespace std;
int N, M;
int dp[100][10001];
vector<int> m;
vector<int> c;
int answer = 1e9;
void dfs(int index, int volume, int cost)
{
    if (volume >= M)
    {
        answer = min(answer, cost);
    }
    if (dp[index][cost] != -1 && dp[index][cost] >= volume)
    {
        return;
    }
    dp[index][cost] = volume;
    if (index + 1 < N)
    {
        dfs(index + 1, volume + m[index + 1], cost + c[index + 1]);
        dfs(index + 1, volume, cost);
    }
    return;
}

int main()
{
    cin >> N >> M;
    memset(dp, -1, sizeof(dp));
    int temp;
    for (int i = 0; i < N; i++)
    {
        cin >> temp;
        m.push_back(temp);
    }
    for (int i = 0; i < N; i++)
    {
        cin >> temp;
        c.push_back(temp);
    }

    dfs(0, m[0], c[0]);
    dfs(0, 0, 0);

    cout << answer << endl;
    return 0;
}
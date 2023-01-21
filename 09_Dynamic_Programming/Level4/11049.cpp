// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 행렬 곱셈 순서
// https://www.acmicpc.net/problem/11049
// 힌트
// 1. DFS를 통해 구간별 연산수 값이 가장 최소가 되는 값을 찾는다.
// 2. 각 구간별 연산수의 최소값을 찾기 위해 직전의 두 메트릭스를 모두 search하고 이때 각 구간에 대해 또 다시 최소값을 구해준다.
#include <iostream>
#include <algorithm>
#include <vector>
#include <string.h>
#include <limits.h>
using namespace std;

#define MAX_NUM 501

int N;
int matrices[MAX_NUM][2];
int dp[MAX_NUM][MAX_NUM];

int dfs(int l, int r)
{
    if (l == r)
        return 0;
    int ret = INT_MAX;
    if (dp[l][r] != -1)
        return dp[l][r];
    for (int i = l; i < r; i++)
        ret = min(ret, dfs(l, i) + dfs(i + 1, r) + (matrices[l][0] * matrices[i][1] * matrices[r][1]));

    dp[l][r] = ret;
    return dp[l][r];
}

int main()
{
    int N;
    cin >> N;
    memset(dp, -1, sizeof(dp));

    for (int i = 0; i < N; i++)
        for (int j = 0; j < 2; j++)
            cin >> matrices[i][j];
    int answer = dfs(0, N - 1);
    cout << answer << endl;

    return 0;
}
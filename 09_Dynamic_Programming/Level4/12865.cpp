// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 평범한 배낭
// https://www.acmicpc.net/problem/12865
// 힌트
// 1. dp[i][j]는 1부터 i번째 물품 중 무게의 합이 j인 경우의 가치 합이다.
// 2. dp[i][j]는 i번째 물건을 담는 경우와 담지 않는 경우의 최대값을 넣어준다.
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int dp[101][100001];
int W[101];
int V[101];

int main()
{
    int N, K;
    cin >> N >> K;
    for (int i = 1; i <= N; i++)
        cin >> W[i] >> V[i];

    for (int i = 1; i <= N; i++)
    {
        for (int j = 1; j <= K; j++)
        {
            if (j - W[i] >= 0)
                dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - W[i]] + V[i]);
            else
                dp[i][j] = dp[i - 1][j];
        }
    }
    cout << dp[N][K] << '\n';

    return 0;
}
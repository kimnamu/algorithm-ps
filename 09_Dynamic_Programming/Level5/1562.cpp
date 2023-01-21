// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 계단 수
// https://www.acmicpc.net/problem/1562
// 힌트
// 1. 다이나믹프로그래밍을 이용하여 dp[i][j][k]에 i번째 숫자 맨앞 숫자가 나온 숫자는 비트연산으로 체크한다.
// 단, 맨앞자리가 0인 경우, 9일 경우 각각 -1, 10이 될수 없으므로 이 부분을 예외처리 해주어야 합니다.
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
#define MOD 1000000000

long long dp[110][10][2000];

int main(void)
{
    int N;
    cin >> N;

    for (int i = 0; i <= 9; i++)
        dp[1][i][1 << i] = 1;

    for (int i = 2; i <= N; i++)
    {
        for (int j = 0; j <= 9; j++)
        {
            int a = 1 << j;
            for (int k = 1; k <= 1023; k++)
            {
                if (j == 0)
                    dp[i][j][k | a] += dp[i - 1][j + 1][k];
                else if (j == 9)
                    dp[i][j][k | a] += dp[i - 1][j - 1][k];
                else
                    dp[i][j][k | a] += dp[i - 1][j - 1][k] + dp[i - 1][j + 1][k];

                dp[i][j][k | a] %= MOD;
            }
        }
    }
    long long sum = 0;
    for (int i = 1; i <= 9; i++)
    {
        sum += dp[N][i][1023];
    }
    cout << sum % MOD;
    return 0;
}
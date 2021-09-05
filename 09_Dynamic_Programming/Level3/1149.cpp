// RGB거리
// https://www.acmicpc.net/problem/1149
// 힌트
// 1. Bottom UP Dynamic Programming을 이용하여 순차적으로 가장 작은 값이 되는 답을 찾는다.
// 2. 이때, 각 색깔이 연달아 이어지면 안되기 때문에 이번에 R을 선택할 경우 이전 G, B 중 최소거리 값을 이어 받도록한다. G, B도 마찬가지이다.

#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main()
{
    int n;
    cin >> n;
    vector<int> r(n), g(n), b(n);
    vector<vector<int> > dp(3, vector<int>(n));
    for (int i = 0; i < n; i++)
    {
        cin >> r[i] >> g[i] >> b[i];
    }

    dp[0][0] = r[0];
    dp[1][0] = g[0];
    dp[2][0] = b[0];

    for (int i = 1; i < n; i++)
    {
        dp[0][i] = min(dp[1][i - 1], dp[2][i - 1]) + r[i];
        dp[1][i] = min(dp[2][i - 1], dp[0][i - 1]) + g[i];
        dp[2][i] = min(dp[0][i - 1], dp[1][i - 1]) + b[i];
    }
    cout << min(min(dp[0][n - 1], dp[1][n - 1]), dp[2][n - 1]) << endl;
    return 0;
}
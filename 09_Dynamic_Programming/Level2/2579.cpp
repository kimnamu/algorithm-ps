// 계단 오르기
// https://www.acmicpc.net/problem/2579
// 힌트
// 1. 연달아 세 계단을 밟을 수 없으므로 직전 계단을 안밟은 경우, 직전 계단을 밟은 경우를 나누어 dynamic programming 해준다.
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main()
{
    int n;
    cin >> n;
    vector<int> v(n);
    for (int i = 0; i < n; i++)
    {
        cin >> v[i];
    }
    vector<vector<int> > dp(2, vector<int>(n));

    if (n >= 1)
    {
        dp[0][0] = v[0];
        dp[1][0] = v[0];
    }
    if (n >= 2)
    {
        dp[0][1] = v[1];
        dp[1][1] = v[0] + v[1];
    }
    for (int i = 2; i < n; i++)
    {
        dp[0][i] = v[i] + max(dp[0][i - 2], dp[1][i - 2]);
        dp[1][i] = v[i] + dp[0][i - 1];
    }
    cout << max(dp[0][n - 1], dp[1][n - 1]) << endl;
    return 0;
}
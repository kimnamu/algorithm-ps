// 파일 합치기
// https://www.acmicpc.net/problem/11066
// 힌트
// 1. DFS를 통해 구간별 합치기 값이 가장 최소가 되는 값을 찾는다.
// 2. 각 구간별 합의 최소값을 찾기 위해 직전의 두 구간을 모두 search하고 이때 각 구간에 대해 또다시 최소 값을 구해준다.
#include <iostream>
#include <algorithm>
#include <vector>
#include <string.h>
#include <limits.h>
using namespace std;
int T, K;

vector<int> C;
vector<int> sum;
int dp[501][501];
int dfs(int l, int r)
{
    if (dp[l][r] != -1)
        return dp[l][r];
    if (r == l)
    {
        dp[l][r] = 0;
        return dp[l][r];
    }
    int ret = INT_MAX;
    for (int i = l; i < r; i++)
    {
        ret = min(ret, dfs(l, i) + dfs(i + 1, r) + sum[r] - sum[l - 1]);
    }
    dp[l][r] = ret;
    return ret;
}

int main()
{
    cin >> T;
    while (T--)
    {
        cin >> K;
        C = vector<int>(K + 1, 0);
        sum = vector<int>(K + 1, 0);
        memset(dp, -1, sizeof(dp));
        for (int i = 1; i <= K; i++)
        {
            cin >> C[i];
            sum[i] = sum[i - 1] + C[i];
        }
        cout << dfs(1, K) << '\n';
    }
    return 0;
}
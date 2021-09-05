// 1로 만들기
// https://www.acmicpc.net/problem/1463
// 힌트
// 1. Top-Down 방식을 이용한 dynamic programming 방법을 이용한다.
// 2. n에 도달했을때 비용이 기존에 memoization해둔 값보다 크다면 더 이상 탐색하지 않는다.
#include <iostream>
#include <algorithm>
#include <vector>
#define INF 1e9
using namespace std;

vector<int> dp(1000001, INF);

void solve(int n, int cnt)
{
    if (dp[n] > cnt)
    {
        dp[n] = cnt;
    }
    else
    {
        return;
    }
    if (n == 1)
        return;
    if (n % 2 == 0)
        solve(n / 2, cnt + 1);
    if (n % 3 == 0)
        solve(n / 3, cnt + 1);
    solve(n - 1, cnt + 1);
}

int main()
{
    int N;
    cin >> N;
    int answer = 0;
    solve(N, 0);
    cout << dp[1] << endl;

    return 0;
}
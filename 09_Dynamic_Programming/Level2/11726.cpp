// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 2×n 타일링
// https://www.acmicpc.net/problem/11726
// 힌트
// 1. 특정 숫자 n을 만들기 위해서는 n-1번째 부터 세로 블록을 쌓거나, n-2번째 두개의 가로블록을 쌓는 방법 밖에 없음을 이용한다.
// 2. mod로 사욛되는 10007을 언제 나눠줄 것인지가 중요하다.
#include <iostream>
#include <algorithm>
#include <vector>
#define MAXNUM 1001
using namespace std;
int main()
{
    int n;
    cin >> n;
    vector<int> dp(n + 1);
    if (n >= 1)
        dp[1] = 1;
    if (n >= 2)
        dp[2] = 2;
    for (int i = 3; i <= n; i++)
    {
        dp[i] = (dp[i - 1] + dp[i - 2])% 10007;
    }
    cout << dp[n] << endl;
    return 0;
}
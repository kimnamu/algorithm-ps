// 1, 2, 3 더하기
// https://www.acmicpc.net/problem/9095
// 힌트
// 1. 특정 숫자 n을 만들기 위해서는 n-3번째 수로부터 3을 더하거나, n-2번째 수로 부터 2를 더하거나, n-1번째 수로 부터 1을 만드는 방법 밖에 없음을 이용한다.
#include <iostream>
#include <algorithm>
#include <vector>
#define MAXNUM 12
using namespace std;
int main()
{
    int T;
    cin >> T;
    vector<int> dp(MAXNUM);
    dp[1] = 1; // 1
    dp[2] = 2; // 1+1, 2
    dp[3] = 4; // 1+1+1, 1+2, 2+1, 3
    for (int i = 4; i < MAXNUM; i++)
    {
        dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
    }
    while (T--)
    {
        int n;
        cin >> n;
        cout << dp[n] << "\n";
    }

    return 0;
}
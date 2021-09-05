// Dance Dance Revolution
// https://www.acmicpc.net/problem/2342
// 1. Memoization을 이용하여 왼발, 오른발, 차례에 따른 최소 비용 값을 갱신해준다.
#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;
vector<int> v;
int dp[5][5][100000];
int move(int from, int to)
{
    int ret;
    if (from == to)
        ret = 1;
    else if (from == 0)
    {
        ret = 2;
    }
    else if (from == 1)
    {
        ret = to == 3 ? 4 : 3;
    }
    else if (from == 2)
    {
        ret = to == 4 ? 4 : 3;
    }
    else if (from == 3)
    {
        ret = to == 1 ? 4 : 3;
    }
    else if (from == 4)
    {
        ret = to == 2 ? 4 : 3;
    }
    return ret;
}

int solve(int l, int r, int n)
{
    if (n == v.size())
        return 0;
    if (dp[l][r][n] != 0)
        return dp[l][r][n];
    dp[l][r][n] = min(move(l, v[n]) + solve(v[n], r, n + 1),
                      move(r, v[n]) + solve(l, v[n], n + 1));

    return dp[l][r][n];
}

int main()
{
    int n;
    while (true)
    {
        cin >> n;
        if (n == 0)
            break;
        v.push_back(n);
    }
    int answer = solve(0, 0, 0);
    cout << answer << endl;

    return 0;
}
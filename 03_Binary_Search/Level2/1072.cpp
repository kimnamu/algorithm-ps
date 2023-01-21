// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 게임
// https://www.acmicpc.net/problem/1072
// 힌트
// 1. 최소 몇번을 이겨야하는지 그 횟수를 binary search를 통해 찾아보자.
// 2. 형변환에 주의하자.
//    예를 들어, 정수형 변수 x, y에 대해서 "(y*100)/x"과  "y/x * 100"은 값이 다르다.
#include <iostream>
#include <algorithm>
typedef long long ll;
using namespace std;

ll solve(ll x, ll y)
{
    if (x == y || 99 <= (y * 100) / x)
        return -1;
    ll z = (y * 100) / x;
    ll l = 0;
    ll r = 1000000000;
    ll m = -1;

    while (l <= r)
    {
        m = (l + r) / 2;
        ll z_new = (y + m) * 100 / (x + m);
        if (z_new > z)
        {
            r = m - 1;
        }
        else
        {
            l = m + 1;
        }
    }

    return l;
}

int main()
{
    ll x, y;
    cin >> x >> y;

    ll answer = solve(x, y);
    cout << answer << endl;
    return 0;
}
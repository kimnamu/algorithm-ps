// 정수 제곱근
// https://www.acmicpc.net/problem/2417
// 힌트
// 1. Binary Search를 이용하여 left와 right의 중앙값을 활용하여 탐색 범위를 좁혀간다.

#include <iostream>
#include <algorithm>
#include <math.h>

typedef long long ll;
using namespace std;

ll bs(ll n)
{
    ll l = 0;
    ll r = n - 1;
    ll m = (l + r) / 2;
    while (l <= r)
    {
        m = (l + r) / 2;
        if (m >= sqrt(n))
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
    ll n;
    cin >> n;
    // 방법 1. Binary Search 이용
    ll answer = bs(n);
    // 방법 2. sqrt 함수 사용하여, 제곱으로 값이 일치하지 않는 경우 +1 하여 정답
    // ll answer = (ll)sqrt(n);
    // if (answer * answer != n)
    //     answer += 1;
    cout << answer << endl;
    return 0;
}
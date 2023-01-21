// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 나무 자르기
// https://www.acmicpc.net/problem/2805
// 힌트
// 1. Binary Search를 통해 적정 자르는 나무의 범위를 좁힌다.
//    자르는 나무높이의 범위는 [0, 가장 큰 나무] 이다.
// 2. 대소관계에 유의하자.
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

typedef long long ll;
vector<int> v;
int n, m, v_max = 0;

bool solve(int tree)
{
    ll total = 0;
    for (int i = 0; i < n; i++)
    {
        total += max(0, v[i] - tree);
    }
    if (total >= m)
        return true;
    else
        return false;
}

int bs()
{
    int l = 0;
    int r = v_max;
    int m = -1;
    while (l <= r)
    {
        m = (l + r) / 2;
        if (solve(m))
        {
            l = m + 1;
        }
        else
        {
            r = m - 1;
        }
    }
    return l - 1;
}

int main()
{
    cin >> n >> m;
    v = vector<int>(n);
    for (int i = 0; i < n; i++)
    {
        cin >> v[i];
        v_max = max(v_max, v[i]);
    }
    int answer = bs();
    cout << answer << endl;
    return 0;
}
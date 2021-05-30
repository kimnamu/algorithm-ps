// 예산
// https://www.acmicpc.net/problem/2512
// 힌트
// 1. 상한선이 될 금액을 binary search로 구하면 된다. 이때 상한선 금액의 초기 범위는 0부터 가장큰 예산이다.
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
vector<int> v;
int n, m, v_max = 0;

bool solve(int amount)
{
    int total = 0;
    for (int i = 0; i < n; i++)
    {
        if (v[i] > amount)
        {
            total += amount;
        }
        else
        {
            total += v[i];
        }
    }
    if (total <= m)
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
    cin >> n;
    v = vector<int>(n);
    for (int i = 0; i < n; i++)
    {
        cin >> v[i];
        v_max = max(v_max, v[i]);
    }
    cin >> m;
    int answer = bs();
    cout << answer << endl;
    return 0;
}
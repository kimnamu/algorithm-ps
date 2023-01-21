// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 랜선 자르기
// https://www.acmicpc.net/problem/1654
// 힌트
// 1. n이 1이상이므로 자를 랜선의 길이는 가장 긴 랜선보다 클수 없다.
//    가장 긴 랜선보다 크면 0이 되기 때문인데, 그렇기 때문에 binary search의 가장 큰 값은 가장긴 랜선의 길이로 지정하면 된다.
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

typedef long long ll;

int k, n;
int line_max = 0;
vector<int> lines;

bool solve(int m)
{
    if (m == 0)
        return true;
    int cnt = 0;
    for (int i = 0; i < lines.size(); i++)
    {
        cnt += lines[i] / m;
    }
    // 문제에서는 n개 이상을 자르는 것도 n개로 자른것으로 간주함
    if (cnt >= n)
        return true;
    else
        return false;
}

int bs()
{
    ll l = 0;
    ll r = line_max;
    ll m = -1;
    while (l <= r)
    {
        // l+r이 int자료형을 벗어날 수 있으므로 long long 자료형을 사용해준다.
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
    return r;
}

int main()
{
    cin >> k >> n;
    lines = vector<int>(k);
    for (int i = 0; i < k; i++)
    {
        cin >> lines[i];
        // Binary Search의 범주중 가장 큰 값은 라인중 가장큰 값이 된다.
        line_max = max(line_max, lines[i]);
    }
    int answer = bs();
    cout << answer << endl;
    return 0;
}
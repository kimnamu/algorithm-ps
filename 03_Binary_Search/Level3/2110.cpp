// 공유기 설치
// https://www.acmicpc.net/problem/2110
// 힌트
// 1. 공유기를 설치하기 위한 최소한의 간격을 binary search로 찾으면 된다.
// 2. 첫번째 위치를 시작으로 최소한의 간격 이상일때만 공유기를 놓아주면서 c 갯수 이상 뒀는지, 부족하게 뒀는지로 binary search를 해준다.
#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;
int n, c;
vector<int> v;
bool solve(int dist)
{
    int pos = v[0];
    int cnt = 1;
    for (int i = 1; i < n; i++)
    {
        // dist거리 이상 떨어졌을때만 와이파이를 설치한다.
        if (v[i] - pos >= dist)
        {
            cnt += 1;
            pos = v[i];
        }
    }
    if (cnt >= c)
        return true;
    else
        return false;
}

int bs()
{
    int l = 0;
    int r = v[v.size() - 1] - v[0];
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
    return l-1;
}

int main()
{
    cin >> n >> c;
    v = vector<int>(n);
    for (int i = 0; i < n; i++)
    {
        cin >> v[i];
    }
    sort(v.begin(), v.end());
    int answer = bs();
    cout << answer << endl;
    return 0;
}
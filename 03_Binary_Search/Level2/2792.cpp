// 보석 상자
// https://www.acmicpc.net/problem/2792
// 힌트
// 1. 한명의 아이가 가질 수 있는 최대 보석의 수를 찾으면 되는 문제로 해당 개수를 Binary Search를 통해 찾아보자.
// 2. Binary search로 개수를 추정해가는 부분과 해당 개수로 아이들에게 모두 나눠줄 수 있는지를 평가하는 부분을 작성하면 된다.
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
int N, M;
vector<int> v;

int solve(int k)
{
    int ret = 0;
    for (int i = 0; i < M; i++)
    {
        ret += (v[i] + k - 1) / k;
    }
    return ret;
}

int bs(int right)
{
    int l = 1;
    int r = right;
    int m = (l + r) / 2;
    while (l < r)
    {
        m = (l + r) / 2;
        if (solve(m) <= N)
        {
            r = m;
        }
        else
        {
            l = m + 1;
        }
    }
    return r;
}

int main()
{
    cin >> N >> M;
    v = vector<int>(M);
    int right = 0;
    for (int i = 0; i < M; i++)
    {
        cin >> v[i];
        right = max(right, v[i]);
    }
    int answer = bs(right);
    cout << answer << endl;
    return 0;
}
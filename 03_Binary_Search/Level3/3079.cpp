// 입국심사
// https://www.acmicpc.net/problem/3079
// 힌트
// 1. 구해야할 최소 시간을 Binary Search를 통해 탐색한다.
// 2. 해당 시간안에 M명의 사람들이 모두 통과할 수 있는지를 체크하면서 통과 가능한 가장 작은 수를 찾으면 된다.
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
typedef long long ll;
int N, M;
vector<ll> T;

ll solve(ll time)
{
    ll ret = 0;
    for (int i = 0; i < N; i++)
    {
        ret += time / T[i];
    }
    return ret;
}

ll bs(ll right)
{
    ll l = 0;
    ll r = right;
    ll m = (l + r) / 2;
    while (l < r)
    {
        m = (l + r) / 2;
        if (solve(m) >= M)
        {
            r = m;
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
    cin >> N >> M;
    T = vector<ll>(N);
    ll right = 0;
    for (int i = 0; i < N; i++)
    {
        cin >> T[i];
        if (right < T[i])
            right = T[i];
    }
    right *= M;
    ll answer = bs(right);
    cout << answer << endl;
    return 0;
}
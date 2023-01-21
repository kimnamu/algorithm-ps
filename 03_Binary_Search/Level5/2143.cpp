// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 두 배열의 합
// https://www.acmicpc.net/problem/2143
// 힌트
// 1. a배열의 누적합과 b배열의 누적합을 각각 이용해 만들어질수 있는 부분 배열합을 새로운 배열에 만들자.
//    이때 각 부분 배열합을 만드는데 필요한 복잡도는 O(n^2), O(m^2)이다.
// 2. 새로운 부분 배열합 a의 i번째 원소를 기준으로 t-a[i] 값이 부분배열합 b에 몇개 존재하는지 찾으면 된다.
// 3. Brute force로 찾게되면 O(n^2 * m^2)이므로 제한된 시간내에 탐색할 수 없기 때문에 binary search를 이용한다.
//    값이 있는지 없는지 뿐만아니라 몇개 존재하는지 확인하기 위해 t-a[i]값이 시작하는지점과 끝나는 지점을 각각 찾아주어야 한다.
#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;
typedef long long ll;
ll t, n, m, temp;
vector<ll> a_sum, b_sum;
vector<ll> a_partials, b_partials;

vector<ll> init_and_get_partials()
{
    // 각 배열을 입력해준다.
    cin >> n;
    vector<ll> v;
    v.push_back(0);
    for (int i = 0; i < n; i++)
    {
        cin >> temp;
        v.push_back(temp);
    }
    // 부분합을 찾기 위해 전체 누적합을 구해준다.
    vector<ll> v_sum(n + 1);
    v_sum[0] = 0;
    for (int i = 1; i < n + 1; i++)
    {
        v_sum[i] = v_sum[i - 1] + v[i];
    }

    // 누적합을 이용해 부분합을 모두 구해 배열에 추가한다.
    vector<ll> v_partials;
    for (int i = 0; i < n + 1; i++)
    {
        for (int j = i + 1; j < n + 1; j++)
        {
            v_partials.push_back(v_sum[j] - v_sum[i]);
        }
    }
    return v_partials;
}

ll bs(ll k)
{
    int l = 0;
    int r = b_partials.size() - 1;
    int mid = (l + r) / 2;
    int start, end;
    // k가 시작되는 지점찾기
    while (l < r)
    {
        mid = (l + r) / 2;
        if (b_partials[mid] >= k)
        {
            r = mid;
        }
        else
        {
            l = mid + 1;
        }
    }
    if (b_partials[l] != k)
        return 0;
    start = l;

    // k가 끝나는 지점 찾기
    l = 0;
    r = b_partials.size() - 1;
    while (l < r)
    {
        mid = (l + r + 1) / 2;
        if (b_partials[mid] > k)
        {
            r = mid - 1;
        }
        else
        {
            l = mid;
        }
    }
    end = l;
    return end - start + 1;
}

int main()
{
    cin >> t;
    a_partials = init_and_get_partials();
    b_partials = init_and_get_partials();
    sort(a_partials.begin(), a_partials.end());
    sort(b_partials.begin(), b_partials.end());

    ll answer = 0;
    for (int i = 0; i < a_partials.size(); i++)
    {
        answer += bs(t - a_partials[i]);
    }
    cout << answer << endl;
    return 0;
}
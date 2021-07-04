// 구간 합 구하기
// https://www.acmicpc.net/problem/2042
// 힌트
// 1. Brute Force의 시간복잡도는 O(N^2 x M)이므로 시간초과를 하게 된다. 세그트리를 이용하면 시간복잡도는 O(logN * M)로 제한 시간안에 풀 수 있다.
// 2. 세그트리는 크게 세부분으로 나누어 구현한다.
// 2.1. init : 세그트리를 초기화 해준다. N의 크기에 맞춰 트리의 높이를 계산해주고, 그 높이에 맞는 tree를 만들어준다.
// 2.2. query : 구간을 던져주면 해당 구간합을 반환 한다.문제에서 sum이라고 하지만 세그트리에서는 구간을 던져주면 그에 대한 구간합을 만들어주기 때문에 query라고 한다.
// 2.3. update : 특정 index의 값이 바뀌면 해당 index를 포함하는 tree node값을 갱신해준다.
// *cpp의 경우 ios_base::sync_with_stdio(0); cin.tie(0); 작성해주어야 시간초과가 나지 않는다.
#include <iostream>
#include <algorithm>
#include <vector>
#include <cmath>
using namespace std;

typedef long long ll;

vector<ll> arr(1000001);
vector<ll> tree(10000001);

ll init(int node, int start, int end)
{
    if (start == end)
    {
        return tree[node] = arr[start];
    }
    return tree[node] = init(node * 2, start, (start + end) / 2) + init(node * 2 + 1, (start + end) / 2 + 1, end);
}

void update(int node, int start, int end, int i, ll diff)
{
    if (i < start || end < i)
    {
        return;
    }
    tree[node] = tree[node] + diff;
    if (start != end)
    {
        update(node * 2, start, (start + end) / 2, i, diff);
        update(node * 2 + 1, (start + end) / 2 + 1, end, i, diff);
    }
}

ll query(int node, int start, int end, int i, int j)
{
    if (j < start || end < i)
    {
        return 0;
    }
    if (i <= start && end <= j)
    {
        return tree[node];
    }
    return query(node * 2, start, (start + end) / 2, i, j) + query(node * 2 + 1, (start + end) / 2 + 1, end, i, j);
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    int N, M, K;
    cin >> N >> M >> K;

    for (int i = 0; i < N; i++)
    {
        cin >> arr[i];
    }

    init(1, 0, N - 1);

    for (int i = 0; i < M + K; i++)
    {
        ll a, b, c;
        cin >> a >> b >> c;
        if (a == 1)
        {
            ll diff = c - arr[b - 1];
            arr[b - 1] = c;
            update(1, 0, N - 1, b - 1, diff);
        }
        else
        {
            if (b > c)
            {
                swap(b, c);
            }
            cout << query(1, 0, N - 1, b - 1, c - 1) << "\n";
        }
    }

    return 0;
}

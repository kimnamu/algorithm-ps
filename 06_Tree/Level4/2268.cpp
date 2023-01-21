// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 수들의 합
// https://www.acmicpc.net/problem/2268
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

long long init(vector<long long> &tree, vector<long long> &arr, int node, int start, int end)
{
    if (start == end)
        return tree[node] = arr[start];
    else
    {
        int mid = (start + end) / 2;
        return tree[node] = init(tree, arr, node * 2, start, mid) + init(tree, arr, node * 2 + 1, mid + 1, end);
    }
}

void update(vector<long long> &tree, int node, int start, int end, int idx, long long diff)
{
    if (!(start <= idx && idx <= end))
        return;

    tree[node] += diff;

    if (start != end)
    {
        long long mid = (start + end) / 2;

        update(tree, node * 2, start, mid, idx, diff);
        update(tree, node * 2 + 1, mid + 1, end, idx, diff);
    }
}

long long query(vector<long long> &tree, int node, int start, int end, int i, int j)
{
    if (i > end || j < start)
        return 0;

    if (i <= start && end <= j)
        return tree[node];

    long long mid = (start + end) / 2;

    return query(tree, node * 2, start, mid, i, j) + query(tree, node * 2 + 1, mid + 1, end, i, j);
}

int main(void)
{
    ios_base::sync_with_stdio(0); cin.tie(0);
    int N, M;
    cin >> N >> M;
    // 2.1. Initialization
    int height = (int)ceil(log2(N));
    int tree_size = 1 << (height + 1);
    vector<long long> arr(N + 1), tree(tree_size);
    init(tree, arr, 1, 1, N);

    for (int index = 0; index < M; index++)
    {
        int mode;
        cin >> mode;
        // 2.2. Sum
        if (mode == 0)
        {
            int i, j;
            cin >> i >> j;
            if (i > j)
                swap(i, j);
            cout << query(tree, 1, 1, N, i, j) << "\n";
        }
        // 2.3. Update
        else
        {
            int idx, val;
            cin >> idx >> val;
            long long diff = val - arr[idx];
            arr[idx] = val;
            update(tree, 1, 1, N, idx, diff);
        }
    }
    return 0;
}

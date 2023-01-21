// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 버블 소트
// https://www.acmicpc.net/problem/1517
// 힌트
// 1. 실제 버블소트로 계산하면 시간초과 발생 O(n^2)
// 2. 수열의 왼쪽에 있는 수 보다 오른쪽에 몇개의 더 작은 수가 있는지 세면 된다.
// 3. 2의 연산과정을 merge sort를 이용해 구할 수 있다.
#include <iostream>
#include <vector>
using namespace std;

long long result = 0;
void merge(vector<int> &v, int start, int end)
{
    int mid = (start + end) / 2;
    int left = start;
    int right = mid + 1;
    vector<int> temp;

    if (start == end)
    {
        return;
    }

    merge(v, start, mid);
    merge(v, mid + 1, end);

    while (left <= mid && right <= end)
    {
        if (v[left] <= v[right])
        {
            temp.push_back(v[left++]);
        }
        else
        {
            temp.push_back(v[right++]);
            result += (mid + 1 - left);
        }
    }
    while (left <= mid)
    {
        temp.push_back(v[left++]);
    }
    while (right <= end)
    {
        temp.push_back(v[right++]);
    }
    for (int i = start, j = 0; i <= end; ++i, ++j)
    {
        v[i] = temp[j];
    }
}

int main()
{
    int n;
    cin >> n;
    vector<int> v(n);
    for (int i = 0; i < n; ++i)
    {
        cin >> v[i];
    }
    merge(v, 0, n - 1);
    cout << result << endl;
    return 0;
}
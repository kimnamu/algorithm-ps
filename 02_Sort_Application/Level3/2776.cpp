// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 암기왕
// https://www.acmicpc.net/problem/2776
// 1. N과 M을 일일이 비교하면 복잡도가 O(NM)이기 때문에 시간 초과가 된다.
// 2. N을 정렬하여 M의 값들을 binary search하여 logN만에 찾도록 하자.
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

bool check(vector<int> &a, int b)
{
    int l = 0;
    int r = a.size();
    while (l <= r)
    {
        int m = (l + r) / 2;
        if (b == a[m])
            return true;
        else if (b < a[m])
        {
            r = m - 1;
        }
        else
        {
            l = m + 1;
        }
    }
    return false;
}

int main()
{
    int T, N, M;
    cin >> T;
    while (T--)
    {
        cin >> N;
        vector<int> ns(N);
        for (int i = 0; i < N; i++)
        {
            cin >> ns[i];
        }
        cin >> M;
        vector<int> ms(M);
        for (int i = 0; i < M; i++)
        {
            cin >> ms[i];
        }
        sort(ns.begin(), ns.end());

        int p = 0;

        for (int i = 0; i < ms.size(); i++)
        {
            if (check(ns, ms[i]))
                cout << "1\n";
            else
                cout << "0\n";
        }
    }
    return 0;
}
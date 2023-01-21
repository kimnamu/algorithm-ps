// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 세 용액
// https://www.acmicpc.net/problem/2473
// 힌트
// 이 문제를 풀기전에 두 용액(https://www.acmicpc.net/problem/2470)을 먼저 풀기를 권장 한다.
// 1. 용액의 값을 정렬 후 하나의 용액 값을 먼저 정하고, 나머지 두 용액의 합은 투포인터를 활용해 찾는다.
// 2. 첫 번째 용액의 위치를 순차적으로 정해주고, 첫 번째 용액 위치를 기준으로 오른쪽에 있는 모든 용액에 대해 투포인터를 이용해서 답을 찾는다.
// 3. 두 포인터는 왼쪽과 오른쪽 끝에서부터 시작하여, 각 위치값의 합이 0보다 큰지 작은지에 따라 포인터를 이동시킨다.
//   3.1. 두 위치값의 합과 첫번째 용액의 합이 0보다 크면, 합을 줄이기 위해 오른쪽 포인터를 왼쪽으로 한칸 옮겨준다. 
//   3.2. 두 위치값의 합과 첫번째 용액의 합이 0보다 작으면, 합을 키워주기 위해 왼쪽 포인터를 오른쪽으로 한칸 옮겨준다. 
#include <iostream>
#include <algorithm>
#include <vector>
typedef long long ll;
using namespace std;

int main()
{
    int N;
    cin >> N;
    vector<ll> v(N);
    for (int i = 0; i < N; ++i)
        cin >> v[i];
    sort(v.begin(), v.end());

    ll min = abs(v[0] + v[1] + v[2]);
    ll answer1 = v[0], answer2 = v[1], answer3 = v[2];
    for (int i = 0; i < N; i++)
    {
        int left = i + 1;
        int right = N - 1;
        while (left < right)
        {
            ll sum = v[i] + v[left] + v[right];
            if (min > abs(sum))
            {
                min = abs(sum);
                answer1 = v[i];
                answer2 = v[left];
                answer3 = v[right];
            }

            if (sum < 0)
                left += 1;
            else
                right -= 1;
        }
    }
    cout << answer1 << " " << answer2 << " " << answer3;
}
// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 두 용액
// https://www.acmicpc.net/problem/2470
// 힌트
// 1. 용액의 값을 정렬 후 투포인터 알고리즘을 이용해 답이 되는 두 쌍의 용액을 찾는다.
// 2. 두 포인터를 왼쪽과 오른쪽 끝에서 부터 시작하여, 각 위치값의 합이 0보다 큰지 작은지에 따라 포인터를 이동시킨다.
//   2.1. 두 위치값의 합이 0보다 크면, 합을 줄이기 위해 오른쪽 포인터를 왼쪽으로 한칸 옮겨준다. 
//   2.2. 두 위치값의 합이 0보다 작으면, 합을 키워주기 위해 왼쪽 포인터를 오른쪽으로 한칸 옮겨준다. 
#include <iostream>
#include <algorithm>
#include <climits>
#include <vector>
using namespace std;

int main()
{
    int N;
    cin >> N;
    vector<int> v(N);
    int answer1, answer2;
    for (int i = 0; i < N; ++i)
        cin >> v[i];
    sort(v.begin(), v.end());

    int left = 0;
    int right = N - 1;
    int min = INT_MAX;
    while (left < right)
    {
        int sum = v[left] + v[right];

        if (min > abs(sum))
        {
            min = abs(sum);
            answer1 = v[left];
            answer2 = v[right];
        }

        if (sum < 0)
            left += 1;
        else
            right -= 1;
    }

    cout << answer1 << " " << answer2;
}
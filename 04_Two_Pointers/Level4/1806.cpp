// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 부분합
// https://www.acmicpc.net/problem/1806
// 힌트
// 1. 투 포인터 방법을 활용해 부분합의 가장 왼쪽 위치와 오른쪽 위치를 조정해가면서 부분합을 계산한다.
//   1.1. 부분합이 S보다 크거나 같다면, 왼쪽 포인터 위치의 값을 빼주고 오른쪽으로 한칸 옮겨준다.
//   1.2. 부분합이 S보다 작다면, 오른쪽 포인터 위치를 오른쪽으로 한칸 옮겨준 후 해당 위치 값을 더해준다.
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main()
{
    int N, S;
    cin >> N >> S;
    vector<int> v(N);
    for (int i = 0; i < N; i++)
    {
        cin >> v[i];
    }
    int left = 0;
    int right = 0;
    int sum = v[right];
    int answer = N + 1;
    while (right < N)
    {
        if (sum >= S)
        {
            answer = min(answer, right - left + 1);
            sum -= v[left];
            left += 1;
        }
        else
        {
            right += 1;
            sum += v[right];
        }
    }
    if (answer == N + 1)
        cout << 0 << endl;
    else
        cout << answer << endl;
    return 0;
}

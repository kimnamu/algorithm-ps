// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 수열
// https://www.acmicpc.net/problem/2559
// 힌트
// 1. K개의 수를 합하는게 정해져 있으므로 K의 위치차이를 가지는 투 포인터를 활용하여 구간 합을 구한다.
// 2. 오른쪽 포인터를 증가시키면서 값을 더하고, 왼쪽 포인터를 증가시키면서 값을 빼준다.
// 3. 이렇게 포인터를 옮겨가면서 더한 합이 가장 큰 값을 정답으로 반환한다.
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main()
{
    int N, K;
    cin >> N >> K;
    vector<int> v(N);
    for (int i = 0; i < N; i++)
    {
        cin >> v[i];
    }
    int sum = 0;
    for (int i = 0; i < K; i++)
    {
        sum += v[i];
    }
    int left = 0;
    int right = K - 1;
    int answer = sum;
    while (right < N)
    {
        answer = max(answer, sum);
        right += 1;
        sum += v[right];
        sum -= v[left];
        left += 1;
    }
    cout << answer << endl;
    return 0;
}
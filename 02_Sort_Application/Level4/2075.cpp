// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// N번째 큰 수
// https://www.acmicpc.net/problem/2075
// 힌트
// 1. 모든 수에 대해 내림차순 정렬 후 N-1 인자 출력
// * cpp의 경우 cin.tie(NULL); ios_base::sync_with_stdio(false);를 작성해주지 않으면 시간 초과발생
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);
    vector<int> v;
    int N;
    cin >> N;
    v = vector<int>(N * N);
    for (int i = 0; i < N * N; i++)
    {
        cin >> v[i];
    }
    sort(v.begin(), v.end(), greater<int>());
    cout << v[N - 1] << "\n";

    return 0;
}

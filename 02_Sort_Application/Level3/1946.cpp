// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 신입 사원
// https://www.acmicpc.net/problem/1946
#include <iostream>
#include <algorithm>
#include <vector>
// 힌트
// 1. cpp stl sort로 pair vector를 정렬 시 first, second 우선순위로 자동 정렬됨
using namespace std;
int main()
{
    int T, N;
    cin >> T;
    while (T--)
    {
        cin >> N;
        vector<pair<int, int> > v(N);
        for (int i = 0; i < N; i++)
        {
            cin >> v[i].first >> v[i].second;
        }
        sort(v.begin(), v.end());
        // 1. 서류면접 순위가 가장 높은 사람을 먼저 뽑고,
        int answer = 1;
        int index = v[0].second;
        for (int i = 1; i < N; i++)
        {
            // 2. 이후 면접 순위가 앞의 통과자들의 면접 순위보다 높은 사람을 뽑으면서, 최소 면접 순위를 갱신함
            if (v[i].second < index)
            {
                answer += 1;
                index = v[i].second;
            }
        }
        cout << answer << endl;
    }
    return 0;
}
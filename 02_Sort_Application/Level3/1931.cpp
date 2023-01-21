// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 회의실 배정
// https://www.acmicpc.net/problem/1931
// 힌트
// 1. 끝나는 시간 순으로 정렬
// 2. 끝나는 시간이 같으면 시작시간이 빠른 순으로 정렬
// 3. 끝나는 순서가 빠른 순으로 예약하면서 예약 가능한 회의만 카운트 해줌.
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

bool cmp(pair<int, int> a, pair<int, int> b)
{
    if (a.second == b.second)
        return a.first < b.first;
    else
        return a.second < b.second;
}

int main()
{
    int n;
    cin >> n;
    vector<pair<int, int> > times(n);

    for (int i = 0; i < n; i++)
    {
        cin >> times[i].first >> times[i].second;
    }
    sort(times.begin(), times.end(), cmp);
    // 1. 첫 번째 회의를 먼저 등록하면서 끝나는 시간을 갱신함
    int answer = 1;
    int end_time = times[0].second;
    // 2. 두 번재 회의부터 앞 회의와 겹치지 않는지 체크하면서 정답 수를 추가 해줌.
    for (int i = 1; i < n; i++)
    {
        if (end_time <= times[i].first)
        {
            end_time = times[i].second;
            answer += 1;
        }
    }
    cout << answer << endl;
    return 0;
}
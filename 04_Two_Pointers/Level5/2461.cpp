// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 대표 선수
// https://www.acmicpc.net/problem/2461
// 힌트
// 1.각 반의 모든 선수들의 능력치를 하나의 배열에 담아 순서대로 나열 한다. 이때 각 선수들이 무슨반인지는 알 수 있도록 해야 한다.
// 2.순서대로 나열된 선수들의 능력치를 투포인터를 이용하여 각 반의 선수가 최소 한명씩 포함되도록 하는 구간을 찾으면서
//   왼쪽 포인터와 오른쪽 포인터에 위치한 선수들 간의 능력 차이가 최소가 되는 구간을 출력하면 된다.
#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

bool cmp(pair<int, int> a, pair<int, int> b)
{
    if (a.first == b.first)
    {
        return a.second < b.second;
    }
    return a.first < b.first;
}

int main()
{
    int N, M;
    cin >> N >> M;
    vector<pair<int, int> > abilities;
    vector<int> count(N, 0);
    int ability;
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < M; j++)
        {
            cin >> ability;
            abilities.push_back({ability, i});
        }
    }
    sort(abilities.begin(), abilities.end(), cmp);
    int left = 0;
    int right = 0;
    int cnt = 1;
    count[abilities[right].second] += 1;
    int answer = abilities[abilities.size() - 1].first - abilities[0].first;
    while (right < abilities.size())
    {
        if (cnt == N)
        {
            answer = min(answer, abilities[right].first - abilities[left].first);
            count[abilities[left].second] -= 1;
            if (count[abilities[left].second] == 0)
                cnt -= 1;
            left += 1;
        }
        else if (cnt < N)
        {
            right += 1;
            if (count[abilities[right].second] == 0)
                cnt += 1;
            count[abilities[right].second] += 1;
        }
    }
    cout << answer << endl;
    return 0;
}
// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 외판원 순회
// https://www.acmicpc.net/problem/2098
// 힌트
// 1. 순회시 최소 비용을 계산하는 것이므로 어떤 출발지점이든 상관이 없다. 즉, 시작점을 고정해두고 시작해도 괜찮다.
// 2. 현재 섬에 도달하기까지 방문한 섬들의 state를 저장해두어 memoization하여 다이나믹 프로그래밍으로 연산속도를 높인다.
//    이때, state는 비트마스크를 사용한다. 모든 섬을 방문했을때의 비트마스크 값은 1 << N -1이 된다.
#include <iostream>
#include <algorithm>
#include <string.h>
#include <limits.h>
#define INF 987654321
#define MAX 16

using namespace std;

int N;
int table[MAX][MAX];
int cost[MAX][1 << MAX];

int solve(int pos, int state)
{
    if (state == (1 << N) - 1)
    {
        if (table[pos][0] == 0)
            return INF;
        else
            return table[pos][0];
    }

    if (cost[pos][state] != -1)
        return cost[pos][state];
    cost[pos][state] = INF;

    for (int i = 0; i < N; i++)
    {
        if (table[pos][i] == 0)
            continue;
        if ((state & (1 << i)) == (1 << i))
            continue;

        cost[pos][state] = min(cost[pos][state], table[pos][i] + solve(i, state | 1 << i));
    }
    return cost[pos][state];
}

int main(void)
{
    cin >> N;
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
        {
            cin >> table[i][j];
        }
    }
    memset(cost, -1, sizeof(cost));
    int answer = solve(0, 1);
    cout << answer << endl;
    return 0;
}

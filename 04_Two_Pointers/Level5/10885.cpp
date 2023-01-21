// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 수열의 장인
// https://www.acmicpc.net/problem/10885
// 힌트
// 1. 마이너스(-)의 개수가 짝수일때 2 혹은 -2의 개수가 최대치가 되는 때를 구하면 된다.
// 2. 왼쪽부터 순차적으로 포인터를 오른쪽으로 이동해가며 구해주고, 오른쪽에서부터 순차적으로 왼쪽으로 포인터를 이동하며 구해주면 된다.
// 3. 마이너스(-)가 짝수이면서 2 혹은 -2가 없는 경우 예외처리를 위해 단일 수의 최대값을 정답의 초기값으로 지정해준다.
#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

vector<int> v;
long long answer;
int cntTwo, cntMinus, ansTwo;

void solve(int idx)
{
    if (v[idx] == 0)
    {
        cntTwo = 0; cntMinus = 0;
        return;
    }
    if (v[idx] < 0)
        cntMinus += 1;

    if (v[idx] == 2 || v[idx] == -2)
        cntTwo += 1;

    if (cntMinus % 2 == 0)
    {
        ansTwo = max(ansTwo, cntTwo);
        answer = 1;
    }
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int T, N;
    cin >> T;
    while (T--)
    {
        cin >> N;
        answer = -2;
        ansTwo = 0;
        v = vector<int>(N);
        for (int i = 0; i < N; ++i)
        {
            cin >> v[i];
            answer = answer < v[i] ? v[i] : answer;
        }
        cntTwo = 0; cntMinus = 0;
        for (int i = 0; i < N; ++i)
            solve(i);

        cntTwo = 0; cntMinus = 0;
        for (int i = N - 1; i >= 0; --i)
            solve(i);

        while (ansTwo--)
            answer = (answer << 1) % 1000000007;

        cout << answer << "\n";
    }
}
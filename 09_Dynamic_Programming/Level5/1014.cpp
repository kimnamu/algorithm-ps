// 컨닝
// https://www.acmicpc.net/problem/1014
// 힌트
// 1. 다이나믹 프로그래밍을 이용하여 이전 행의 학생 배치에 따라 현재 행에서의 학생 배치값이 최대값인지 memoization해준다.
// 2. 상태에 대한 memoization은 최대 10개의 위치에 대해서 bitmask를 활용해준다.
#include <iostream>
#include <math.h>
#include <algorithm>
#include <queue>
#include <memory.h>
using namespace std;

int N, M;
char table[12][12];
int curr[11];
int dp[12][1 << 10];
vector<string> combinations;

void dfs(int index)
{
    if (index == M)
    {
        string str = "";
        for (int i = M - 1; i >= 0; i--)
        {
            if (curr[i])
                str += "1";
            else
                str += "0";
        }
        combinations.push_back(str);
        return;
    }
    curr[index] = 0;
    dfs(index + 1);
    if (!index || !curr[index - 1])
    {
        curr[index] = 1;
        dfs(index + 1);
    }
}
int solve(int line, int state)
{
    if (line == N)
        return 0;

    int &ret = dp[line][state];
    if (~ret)
        return ret;
    ret = 0;

    for (string s : combinations)
    {
        int state_curr = 0;
        bool FLAG = true;
        int cnt = 0;
        for (int i = 0; i < M; i++)
        {
            if (s[i] == '1')
            {
                cnt += 1;
                if (table[line][i] == 'x')
                {
                    FLAG = false;
                    break;
                }
                state_curr |= (1 << i);
                if (i > 0 && state & (1 << (i - 1)))
                {
                    FLAG = false;
                    break;
                }
                if (i < M && state & (1 << (i + 1)))
                {
                    FLAG = false;
                    break;
                }
            }
        }
        if (FLAG)
        {
            ret = max(ret, solve(line + 1, state_curr) + cnt);
        }
    }
    return ret;
}

int main()
{
    int C;
    cin >> C;
    while (C--)
    {
        memset(dp, -1, sizeof(dp));
        memset(curr, 0, sizeof(curr));
        memset(table, 'x', sizeof(table));
        cin >> N >> M;
        combinations.clear();
        dfs(0);
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < M; j++)
            {
                cin >> table[i][j];
            }
        }
        cout << solve(0, 0) << '\n';
    }
}